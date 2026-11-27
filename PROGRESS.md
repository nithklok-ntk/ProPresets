# Progreso

- **Fase 0 completada.** Documentación inicial, criterios de aceptación y entorno Windows local verificados. Se conservó el historial Git existente.
- **Fase 1 iniciada.** El APK de diagnóstico detecta el dispositivo y la cámara Xiaomi candidata, ofrece apertura y permite inspección de solo lectura desde un panel flotante. La entrada en Pro es manual.
- **Verificación local.** `assembleDebug`, `lintDebug` y la firma del APK pasaron. Lint registró cuatro advertencias detalladas en [pruebas](TESTING.md). El APK está en `dist/pro-presets-diagnostico-debug.apk`.
- **Pendiente.** ADB no detectó un teléfono. Falta observar el árbol en el Xiaomi, implementar escritura de ISO con relectura y validar todo el flujo de fase 1.
- **Próxima tarea.** F1-02, seguir [la prueba física](TESTING.md) y registrar los controles observados.
- **Punto de recuperación.** Commit local `feat: bootstrap native camera viability probe`.
