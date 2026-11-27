# Decisiones técnicas

| Decisión | Motivo |
| --- | --- |
| Un módulo `:app` y vistas simples en el prototipo | Acortar el ciclo hasta observar la cámara real. Compose, Room y Camera2 se añaden cuando tengan un flujo que los necesite. |
| JDK 17, Gradle 9.3.1, AGP 9.1.1, Kotlin integrado, `minSdk 31` y `compileSdk`/`targetSdk 36` | Base compatible y fijada. El intento inicial con Gradle 8.13 falló al mover la caché de transformaciones en Windows. Gradle publicó la corrección a partir de 9.1.0. |
| Cámara Xiaomi del sistema y lectura de la raíz activa | Se comprueba fabricante, paquete y condición de app de sistema. Los eventos de cambio de ventana permiten detectar salidas. Se inspeccionan nodos de la cámara bajo demanda. |
| Primer APK de solo lectura | El árbol observado en el Xiaomi decidirá qué selector identifica el modo Pro, qué acción habilita ISO y qué valor independiente permite verificar el cambio. |
| Panel `TYPE_ACCESSIBILITY_OVERLAY` | La superposición pertenece al servicio autorizado por el usuario y puede retirarse al salir de cámara, bloquear el dispositivo o iniciar una inspección. |

Referencias de herramientas. [Compatibilidad de AGP 9.1.1](https://developer.android.com/build/releases/agp-9-1-0-release-notes), [incidencia de Gradle en Windows](https://github.com/gradle/gradle/issues/31438).

Una distribución futura en Google Play requiere revisar el uso de AccessibilityService, la declaración, la divulgación explícita y el consentimiento. El servicio se registra como `isAccessibilityTool=false` y la futura automatización se diseña para operaciones deterministas solicitadas por el usuario. [Política de AccessibilityService](https://support.google.com/googleplay/android-developer/answer/10964491).
