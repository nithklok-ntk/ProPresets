# Continuidad

Fase 0 completada y primer APK de diagnóstico de fase 1 compilado y firmado localmente. La prueba física F1-02 está pendiente porque `adb devices -l` no detectó dispositivos. Empieza por el [procedimiento físico](TESTING.md). Registra la evidencia en [compatibilidad](COMPATIBILITY.md) antes de elegir selectores para escribir y releer ISO.

Archivos de la siguiente tarea. [TASKS.md](TASKS.md), [CameraProbeService.kt](app/src/main/java/com/propresets/camera/CameraProbeService.kt) y [CameraTreeProbe.kt](app/src/main/java/com/propresets/camera/CameraTreeProbe.kt). Para la futura implementación, usar High por el trabajo con accesibilidad y verificación.

## Entorno portátil de esta máquina

Ejecutar desde la raíz del proyecto. Las herramientas y cachés están en `.gradle/propresets-tools`, ignoradas por Git. Si se trabaja en otra máquina, configurar el entorno según [README.md](README.md).

```powershell
$proPresetsTools = Join-Path $PWD '.gradle\propresets-tools'
$env:JAVA_HOME = Join-Path $proPresetsTools 'jdk-17.0.21.1+2'
$env:ANDROID_HOME = Join-Path $proPresetsTools 'android-sdk'
$env:ANDROID_USER_HOME = Join-Path $proPresetsTools 'android-user'
$env:GRADLE_USER_HOME = Join-Path $proPresetsTools 'gradle-user'
.\gradlew.bat :app:assembleDebug :app:lintDebug --offline --max-workers=2
& "$env:ANDROID_HOME\platform-tools\adb.exe" devices -l
```

Resultado más reciente. Compilación y lint satisfactorios, firma verificada y APK en `dist/pro-presets-diagnostico-debug.apk`. Si recompilas y vas a instalar desde `dist`, actualiza esa copia con `app/build/outputs/apk/debug/app-debug.apk`.
