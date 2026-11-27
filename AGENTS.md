# ProPresets - AGENTS

## Proyecto
Android, Kotlin, Compose, Room, Camera2 y AccessibilityService.
Dispositivo inicial: Xiaomi 13T Pro.
Consultar SPECIFICATION.md para los requisitos completos.

## Reglas
- Trabajar por fases.
- Priorizar la prueba de viabilidad.
- Funcionamiento local y gratuito.
- No usar root ni servicios de pago.
- No inventar resultados de pruebas.
- No publicar cambios sin autorizacion.
- No ejecutar operaciones destructivas.

## Cuota
- Medium para desarrollo habitual.
- High para arquitectura y automatizacion.
- Ultra solo para bloqueos complejos.
- Modelos ligeros para tareas sencillas.
- Evitar Work si Codex local es suficiente.
- Leer solo archivos relevantes.
- Evitar analisis y compilaciones redundantes.
- Ejecutar pruebas incrementales.
- Mantener respuestas concisas.

## Desarrollo
- `:app` usa Kotlin y Gradle Kotlin DSL. Consultar ARCHITECTURE.md para los límites y DECISIONS.md para las versiones.
- Windows: `.\gradlew.bat :app:assembleDebug`. Para integración: `.\gradlew.bat :app:lintDebug`.
- Consultar TESTING.md para alcance y resultados. Distinguir compilación, simulación y prueba física.
- Restringir la automatización a la cámara autorizada. El disparador queda siempre bajo control del usuario.

## Continuidad
Al iniciar: leer HANDOFF.md y consultar TASKS.md.
Al finalizar: actualizar PROGRESS.md, TASKS.md y HANDOFF.md.
Registrar decisiones y resultados de pruebas.
Crear commits locales por tareas coherentes.
