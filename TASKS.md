# Tareas

| ID | Prioridad | Estado | Depende de | Criterio de aceptación | Complejidad y modelo |
| --- | --- | --- | --- | --- | --- |
| F0-01 | Alta | Hecha | — | Verificar Git, JDK, SDK, Wrapper, ADB y registrar su disponibilidad. | Baja · ligero |
| F0-02 | Alta | Hecha | F0-01 | Documentar arquitectura, criterios, compatibilidad y continuidad. | Media · Medium |
| F1-01 | Alta | Compilada y verificada localmente | F0-02 | APK de diagnóstico que detecta y abre cámara, muestra un panel y permite inspección bajo demanda. | Alta · High |
| F1-02 | Alta | Pendiente de teléfono | F1-01 | En el Xiaomi, observar el modo Pro, ISO, obturación, balance de blancos y el ciclo de vida del panel. Registrar versiones y evidencia. | Alta · High |
| F1-03 | Alta | Pendiente | F1-02 | Entrar en Pro, aplicar y volver a leer ISO desde el panel. Probar recuperación al salir de cámara o revocar el permiso. | Alta · High |
| F2 | Media | Pendiente | F1-03 | Modelo de perfiles, persistencia, adaptadores, motor y resultados verificables. | Alta · High |
| F3 | Media | Pendiente | F2 | Diagnóstico Camera2, calibración y adaptación con niveles de compatibilidad. | Alta · High |
| F4 | Media | Pendiente | F3 | Interfaces Compose, navegación, biblioteca y editor. | Media · Medium |
| F5 | Media | Pendiente | F4 | Menú flotante completo y ajustes en directo con cancelación. | Alta · High |
| F6 | Media | Pendiente | F5 | Historial, intercambio de perfiles, accesos directos y diagnóstico. | Media · Medium |
| F7 | Media | Pendiente | F6 | Medir estabilidad, rendimiento y seguridad en escenarios críticos. | Alta · High |
| F8 | Alta | Pendiente | F7 | Pruebas de integración, APK local, documentación e informe de compatibilidad. | Media · Medium |
