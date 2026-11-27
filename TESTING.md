# Pruebas

## Verificación local del 27 de noviembre de 2026

- Windows 11 x64, Git 2.56.1, Temurin 17.0.21.1+2 y Gradle Wrapper 9.3.1. Se verificaron los hashes publicados del JDK, las herramientas de línea de comandos del SDK y el Wrapper.
- Android SDK Platform 36 rev. 2, Build Tools 36.0.0 y Platform Tools 37.0.3. `adb devices -l` devolvió una lista vacía.
- `.\gradlew.bat :app:assembleDebug :app:lintDebug --offline --max-workers=2` completó correctamente. Lint informó cero errores y cuatro advertencias sobre versiones más recientes de Gradle y AGP, reglas de copia de seguridad e icono definitivo.
- `apksigner verify` validó la firma de depuración. `aapt dump permissions` confirmó que el APK no solicita permisos. El artefacto local está en `dist/pro-presets-diagnostico-debug.apk`.
- Sin ejecución en emulador o dispositivo físico. Para los próximos cambios, ejecutar primero solo las tareas afectadas y repetir compilación y lint al integrar.

## Primera prueba física del Xiaomi 13T Pro

1. Conecta el Xiaomi desbloqueado por USB, activa la depuración USB en Opciones de desarrollador y autoriza el equipo desde el teléfono. Si ADB muestra `unauthorized`, confirma la autorización antes de instalar.
2. Ejecuta los siguientes comandos desde la raíz. Con el entorno portátil de [continuidad](HANDOFF.md), usa `& "$env:ANDROID_HOME\platform-tools\adb.exe"` en lugar de `adb` si el comando no está en PATH.

   ```powershell
   adb devices -l
   adb install -r .\dist\pro-presets-diagnostico-debug.apk
   ```

3. Abre Pro Presets, registra modelo, Android y versión de la cámara mostrada en la pantalla inicial. Registra también HyperOS e idioma desde Ajustes. Activa **Pro Presets · diagnóstico** en los ajustes de accesibilidad. Si HyperOS bloquea esa activación, registra el mensaje exacto y la versión del sistema.
4. Pulsa **Abrir cámara Xiaomi**. En modo Foto, pulsa **Inspeccionar** como referencia. Entra manualmente en Pro y repite. Inspecciona cada panel por separado (ISO, obturación y balance de blancos). Si ISO permite un cambio manual, toma una lectura antes y otra después, y restaura el valor inicial.
5. Comprueba que el botón desaparece momentáneamente al inspeccionar y vuelve mientras la cámara sigue activa. Sal a Inicio, abre otra app, bloquea el teléfono y desactiva el servicio. Registra cualquier caso donde el botón permanezca visible o la cámara deje de responder.
6. Recupera los candidatos del registro de depuración. Conserva solo las líneas de la sesión y anota qué pantalla correspondía a cada inspección.

   ```powershell
   adb logcat -d -s 'ProPresetsProbe:I'
   ```

Registra en [compatibilidad](COMPATIBILITY.md) las versiones, orientación, número de nodos, selectores candidatos, acciones expuestas, valores observados y resultado del panel. Si faltan nodos, anota si el diagnóstico llegó al límite de recorrido y qué mostraba la cámara.

## Criterio para cerrar la fase 1

En el Xiaomi físico, Pro Presets debe identificar y abrir la cámara nativa, reconocer y abrir Pro, leer sus controles y cambiar al menos un parámetro desde el panel sin cerrar la cámara. Debe releer y confirmar un valor distinto al inicial, ocultar el panel durante la operación y restaurarlo si la ventana autorizada sigue activa. Verificar el resultado también en los controles nativos, probar salida, bloqueo y pérdida de permiso, y registrar la recuperación. ISO es el primer intento, seguido de obturación y balance de blancos.

Si un parámetro carece de selector estable, acción segura o lectura independiente, documentar qué faltó y evaluar calibración acotada o continuidad manual. El éxito de una llamada de accesibilidad por sí solo deja el valor sin verificar.
