# Pro Presets

Pro Presets busca aplicar perfiles fotográficos en la cámara original de Android y conservar el procesamiento del fabricante. El proyecto funciona localmente y el primer dispositivo objetivo es el Xiaomi 13T Pro.

El primer prototipo identifica el dispositivo y la cámara Xiaomi del sistema, ofrece un botón para abrirla y añade una superposición de diagnóstico. Con el modo Pro abierto manualmente, **Inspeccionar** busca candidatos de ISO, obturación y balance de blancos. Esta versión es de solo lectura.

## Compilación local

1. Configura `JAVA_HOME` con un JDK 17 y `ANDROID_HOME` con un Android SDK que incluya la plataforma 36, Build Tools 36.0.0 y Platform Tools.
2. Desde la raíz, ejecuta `.\gradlew.bat :app:assembleDebug` en Windows o `./gradlew :app:assembleDebug` en macOS o Linux. El Wrapper verifica el SHA-256 de la distribución. La primera compilación necesita red para resolver las dependencias.
3. El APK de depuración se genera en `app/build/outputs/apk/debug/app-debug.apk`.

## Instalación y diagnóstico

Sigue el [procedimiento de prueba física](TESTING.md) para instalar el APK mediante ADB y registrar el resultado. La pantalla inicial explica el uso del servicio. Actívalo desde los ajustes de accesibilidad para habilitar la inspección y la superposición sobre la cámara Xiaomi.

El prototipo usa `AccessibilityService` y `TYPE_ACCESSIBILITY_OVERLAY`. Su manifiesto carece de permisos de Internet, cámara, almacenamiento y superposición general. La compilación de depuración escribe al registro local únicamente metadatos de candidatos de la cámara.

Consulta [compatibilidad](COMPATIBILITY.md) para el estado del Xiaomi y [continuidad](HANDOFF.md) para retomar el desarrollo.
