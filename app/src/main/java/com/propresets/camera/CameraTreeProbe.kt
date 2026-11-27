package com.propresets.camera

import android.view.accessibility.AccessibilityNodeInfo
import java.util.Locale

@Suppress("DEPRECATION") // Node pooling still applies on API 31 and 32.
internal object CameraTreeProbe {
    private const val MAX_NODES = 300
    private const val MAX_CANDIDATES = 20
    private val labels = mapOf(
        "PRO" to setOf("pro", "professional", "profesional", "modo pro", "pro mode"),
        "ISO" to setOf("iso"),
        "SHUTTER" to setOf("s", "ss", "shutter", "shutter speed", "exposure time", "obturación"),
        "WB" to setOf("wb", "white balance", "balance de blancos"),
    )
    private val idTokens = Regex("[_-]+|(?<=[a-z])(?=[A-Z])")
    private val cameraId = Regex("${Regex.escape(XiaomiCamera.PACKAGE)}:id/[A-Za-z0-9_]{1,100}")
    private val labelWithValue = Regex("^(.+?)[ :]+(auto|automático|[0-9]{1,5}([/.,][0-9]{1,5})?[ks]?)$")

    data class Report(val visited: Int, val candidates: List<String>, val truncated: Boolean)

    // The caller hands off ownership of an already package-checked root.
    fun inspect(root: AccessibilityNodeInfo): Report {
        val queue = ArrayDeque<AccessibilityNodeInfo>()
        queue.addLast(root)
        val candidates = mutableListOf<String>()
        var visited = 0
        var truncated = false

        try {
            while (queue.isNotEmpty()) {
                val node = queue.removeFirst()
                try {
                    visited++
                    if (node.packageName?.toString() != XiaomiCamera.PACKAGE) continue
                    if (node.isVisibleToUser) {
                        candidate(node)?.let {
                            if (candidates.size < MAX_CANDIDATES) candidates.add(it)
                            else truncated = true
                        }
                    }
                    val childCount = node.childCount
                    val childrenToRead = minOf(childCount, MAX_NODES - visited - queue.size)
                    if (childrenToRead < childCount) truncated = true
                    repeat(childrenToRead) { index -> node.getChild(index)?.let(queue::addLast) }
                } finally {
                    node.recycle()
                }
            }
        } finally {
            queue.forEach { it.recycle() }
        }
        return Report(visited, candidates, truncated)
    }

    private fun candidate(node: AccessibilityNodeInfo): String? {
        val id = node.viewIdResourceName?.takeIf(cameraId::matches)
        val tokens = id?.substringAfter('/')?.split(idTokens).orEmpty()
            .map { it.lowercase(Locale.ROOT) }
        val range = node.rangeInfo

        val visibleLabels = listOf(node.text, node.contentDescription)
            .mapNotNull { it?.toString()?.takeIf { value -> value.length <= 60 } }
            .map { it.trim().lowercase(Locale.ROOT) }
        val matchedLabels = visibleLabels.associateWith(labelWithValue::matchEntire)
        val idWords = tokens.joinToString(" ")
        val recognized = labels.entries.firstOrNull { (_, aliases) ->
            matchedLabels.any { (label, match) -> label in aliases || match?.groupValues?.get(1) in aliases } ||
                aliases.any { alias -> alias.length > 1 && (alias in tokens || alias == idWords) }
        }
        val kind = recognized?.key ?: if (range != null) "RANGE" else return null
        val value = matchedLabels.values.firstNotNullOfOrNull { match ->
            match?.takeIf { it.groupValues[1] in recognized?.value.orEmpty() }
                ?.groupValues?.get(2)
        }
        val actions = node.actionList.map { it.id }.filter {
            it == AccessibilityNodeInfo.ACTION_CLICK ||
                it == AccessibilityNodeInfo.ACTION_SCROLL_FORWARD ||
                it == AccessibilityNodeInfo.ACTION_SCROLL_BACKWARD ||
                it == AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS.id
        }
        return buildString {
            append("control=$kind id=${id ?: "-"} selected=${node.isSelected} actions=$actions")
            if (value != null) append(" value=$value")
            if (range != null) append(" range=${range.min}..${range.max} current=${range.current}")
        }
    }
}
