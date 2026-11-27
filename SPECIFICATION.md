# Especificacion

\# PRO PRESETS — ESPECIFICACIÓN MAESTRA DE DESARROLLO



\## 1. Rol y objetivo



Actúa como arquitecto de software, desarrollador Android senior, especialista en Kotlin, Jetpack Compose, Camera2, Android AccessibilityService, automatización de interfaces, fotografía profesional, diseño UX/UI, seguridad, pruebas y optimización de recursos.



Desarrolla una aplicación Android completa, funcional, mantenible, modular y extensible llamada Pro Presets.



No te limites a generar ejemplos de código, prototipos estáticos o explicaciones. Implementa el proyecto, crea los archivos necesarios, ejecuta compilaciones, realiza pruebas, corrige errores y genera un APK instalable cuando el entorno lo permita.



Trabaja de manera autónoma dentro del alcance autorizado. Solicita intervención del usuario únicamente cuando sea indispensable, especialmente para permisos, instalación física, calibración o decisiones que no puedan resolverse razonablemente.



\---



\# 2. Identidad del proyecto



\- Nombre: Pro Presets.

\- Identificador inicial: com.propresets.camera.

\- Eslogan: Tu cámara. Tus ajustes. Tus perfiles.

\- Plataforma: Android.

\- Idioma predeterminado: español.

\- Idioma secundario: inglés.

\- Funcionamiento: local y sin conexión.

\- Presupuesto adicional objetivo: cero.

\- Sin suscripciones.

\- Sin publicidad.

\- Sin servicios de inteligencia artificial externos.

\- Sin API de pago.

\- Sin cuentas obligatorias.

\- Sin root.

\- Sin dependencias obligatorias de Tasker, AutoInput, MacroDroid o Shizuku.



La aplicación debe funcionar como una extensión profesional de las cámaras nativas de Android.



\---



\# 3. Objetivo funcional principal



Permitir al usuario crear, almacenar, modificar, compartir, adaptar y aplicar perfiles fotográficos profesionales directamente sobre la aplicación de cámara original de su dispositivo.



La aplicación debe:



\- Conservar la cámara original del fabricante.

\- Conservar el procesamiento fotográfico original.

\- Permitir utilizar Leica, Hasselblad, Zeiss u otros estilos propios del fabricante cuando estén disponibles.

\- Evitar sustituir la cámara nativa.

\- Evitar modificar archivos internos o preferencias privadas de la cámara.

\- Permitir aplicar perfiles mediante automatización de los controles nativos.

\- Permitir modificar parámetros manualmente.

\- Permitir visualizar los resultados mientras la cámara está abierta.

\- Permitir guardar los ajustes actuales como perfiles.

\- Permitir restablecer configuraciones.

\- Adaptarse a diferentes fabricantes y modelos Android.



No implementar un sistema de importación directa de configuraciones a la cámara nativa salvo que exista una API pública, documentada y compatible.



La estrategia principal será automatizar la interfaz de la cámara original mediante mecanismos autorizados de Android.



\---



\# 4. Dispositivo inicial de desarrollo



Utilizar como primer dispositivo objetivo:



\- Fabricante: Xiaomi.

\- Modelo: Xiaomi 13T Pro.

\- Sistema: HyperOS 3 o posterior.

\- Procesamiento fotográfico: Leica.

\- Cámara principal: 50 MP.

\- Teleobjetivo: 50 MP.

\- Ultra gran angular: 12 MP.



Estos datos son referencias iniciales. Detectar y verificar las características reales mediante el dispositivo.



No codificar permanentemente la aplicación para este único modelo.



El Xiaomi 13T Pro será el primer adaptador específico que deberá validarse físicamente.



\---



\# 5. Tecnologías



Utilizar preferentemente:



\- Kotlin.

\- Gradle Kotlin DSL.

\- Jetpack Compose.

\- Material 3 personalizado.

\- AndroidX.

\- Kotlin Coroutines.

\- StateFlow.

\- ViewModel.

\- Navigation Compose.

\- Room.

\- DataStore.

\- Kotlin Serialization.

\- Android AccessibilityService.

\- Android Camera2.

\- Storage Access Framework.

\- ShortcutManager.

\- Android SDK.

\- ADB.

\- JUnit.

\- Pruebas instrumentadas.

\- Git.



Utilizar versiones estables, compatibles y verificadas.



Configurar inicialmente minSdk 31, salvo que exista una razón técnica documentada para modificarlo.



Utilizar un targetSdk actualizado y compatible con las herramientas disponibles.



Evitar dependencias innecesarias y bibliotecas abandonadas.



No utilizar frameworks multiplataforma si dificultan la integración con AccessibilityService.



\---



\# 6. Arquitectura del software



Implementar una arquitectura modular con separación clara de responsabilidades.



Considerar módulos o paquetes equivalentes a:



\- app

\- core

\- core-model

\- core-database

\- core-ui

\- core-device

\- core-camera

\- core-accessibility

\- core-automation

\- core-calibration

\- core-profiles

\- core-adaptation

\- core-security

\- feature-home

\- feature-profiles

\- feature-editor

\- feature-overlay

\- feature-device

\- feature-calibration

\- feature-history

\- feature-settings

\- feature-import-export

\- feature-diagnostics

\- feature-onboarding



No crear módulos Gradle excesivos si aumentan innecesariamente la complejidad o los tiempos de compilación. Se permite organizar inicialmente algunas responsabilidades mediante paquetes internos.



Aplicar:



\- Separación entre interfaz, dominio y datos.

\- Repositorios.

\- Interfaces desacopladas.

\- Inyección de dependencias cuando resulte útil.

\- Estados inmutables.

\- Manejo centralizado de errores.

\- Persistencia local.

\- Pruebas unitarias de la lógica crítica.

\- Adaptadores independientes por fabricante.



Evitar sobreingeniería.



\---



\# 7. Prueba de viabilidad obligatoria



Antes de desarrollar todas las interfaces, construir una prueba de concepto funcional.



Verificar:



1\. Detección del dispositivo.

2\. Detección de la cámara original.

3\. Apertura de la cámara.

4\. Identificación del modo Pro.

5\. Lectura del árbol de accesibilidad.

6\. Identificación de controles fotográficos.

7\. Modificación de al menos un parámetro.

8\. Verificación del valor aplicado.

9\. Creación de una superposición flotante.

10\. Modificación de un parámetro con la cámara abierta.

11\. Ocultación de la superposición durante la automatización.

12\. Recuperación segura ante errores.



Priorizar ISO, obturación y balance de blancos como parámetros iniciales.



No dedicar recursos excesivos a construir la aplicación completa antes de evaluar la viabilidad del mecanismo principal.



Si no existe un dispositivo conectado, implementar la prueba de concepto, compilarla y preparar instrucciones concretas para su validación física.



No afirmar que una función ha sido validada físicamente si únicamente se ha probado mediante simulaciones, emuladores o análisis de código.



\---



\# 8. Detección automática del dispositivo



Implementar un sistema de detección de hardware y software.



Obtener cuando esté disponible:



\- Fabricante.

\- Marca.

\- Modelo.

\- Identificador de dispositivo.

\- Versión de Android.

\- Versión del sistema del fabricante.

\- Resolución de pantalla.

\- Densidad.

\- Orientación.

\- Aplicaciones de cámara disponibles.

\- Paquete de la cámara seleccionada.

\- Versión de la aplicación de cámara.

\- Identificadores de cámaras Camera2.

\- Sensores disponibles.

\- Cámaras físicas y lógicas.

\- Distancias focales.

\- Aperturas.

\- Rangos ISO.

\- Rangos de exposición.

\- Enfoque manual.

\- Compatibilidad RAW.

\- Resoluciones.

\- Capacidades de estabilización expuestas públicamente.



Distinguir siempre entre:



1\. Capacidades físicas del dispositivo.

2\. Capacidades expuestas por Camera2.

3\. Controles disponibles en la cámara nativa.

4\. Controles realmente automatizables.

5\. Controles cuya aplicación puede verificarse.



No asumir que las capacidades Camera2 coinciden con las opciones de la cámara original.



No abrir ni ocupar el sensor mediante Camera2 mientras la cámara nativa lo está utilizando.



\---



\# 9. Compatibilidad multidispositivo



Diseñar un sistema de adaptadores independientes.



Fabricantes previstos:



\- Xiaomi.

\- Redmi.

\- POCO.

\- Samsung.

\- Google.

\- OnePlus.

\- OPPO.

\- Vivo.

\- Motorola.

\- Honor.

\- Huawei con Android compatible.

\- Realme.

\- Sony.

\- ASUS.

\- Otros fabricantes Android.



Implementar inicialmente:



\- XiaomiCameraAdapter.

\- GenericCameraAdapter.

\- MockCameraAdapter para pruebas.



Preparar contratos para incorporar otros adaptadores sin modificar el motor central.



No crear adaptadores ficticios que aparenten ofrecer compatibilidad real.



Cada adaptador debe poder definir:



\- Paquetes compatibles.

\- Versiones compatibles.

\- Identificación del modo profesional.

\- Controles disponibles.

\- Selectores de accesibilidad.

\- Estrategias de navegación.

\- Métodos de lectura.

\- Métodos de escritura.

\- Métodos de verificación.

\- Procedimientos de restablecimiento.

\- Restricciones.

\- Estrategias de recuperación.



Establecer niveles de compatibilidad:



\- Nativa validada: dispositivo y versión probados físicamente.

\- Universal calibrada: controles configurados mediante calibración.

\- Parcial: únicamente algunos parámetros automatizables.

\- Manual: gestor de perfiles sin automatización.

\- No compatible: funciones no disponibles.



Mostrar claramente el nivel real de compatibilidad.



No garantizar compatibilidad universal con todos los celulares.



\---



\# 10. Motor de automatización



Implementar un AccessibilityService especializado y limitado a la cámara autorizada.



Prioridad de estrategias:



1\. Identificadores de recursos.

2\. Nodos de accesibilidad.

3\. Descripciones de contenido.

4\. Texto visible.

5\. Jerarquía de controles.

6\. Acciones de accesibilidad.

7\. Gestos calibrados.

8\. Coordenadas normalizadas.

9\. Reconocimiento visual local opcional, cuando sea compatible.



No utilizar coordenadas absolutas como estrategia principal.



Adaptar las coordenadas a:



\- Resolución.

\- Densidad.

\- Orientación.

\- Insets.

\- Barras del sistema.

\- Cambios de tamaño.

\- Posición de controles.

\- Versión de cámara.



Implementar una máquina de estados con estados equivalentes a:



\- IDLE

\- CHECKING\_PERMISSIONS

\- DETECTING\_CAMERA

\- OPENING\_CAMERA

\- WAITING\_CAMERA

\- ENTERING\_PRO\_MODE

\- SELECTING\_LENS

\- APPLYING\_PARAMETER

\- VERIFYING\_PARAMETER

\- COMPLETED

\- PARTIALLY\_COMPLETED

\- CANCELLED

\- FAILED



Incluir:



\- Tiempo máximo por operación.

\- Reintentos limitados.

\- Cancelación inmediata.

\- Cola de operaciones.

\- Protección contra ejecuciones simultáneas.

\- Recuperación ante cambios de pantalla.

\- Registro de errores.

\- Verificación posterior.

\- Detección de pérdida de permisos.

\- Detección de cierre de cámara.

\- Detección de bloqueo del dispositivo.



No interactuar con otras aplicaciones.



No ejecutar acciones sobre pantallas de autenticación, aplicaciones financieras o contenido ajeno a la cámara.



Nunca pulsar automáticamente el disparador.



El usuario debe conservar el control de la captura fotográfica.



\---



\# 11. Parámetros fotográficos



Crear un modelo de datos extensible para los siguientes parámetros.



\## Exposición



\- ISO.

\- Velocidad de obturación.

\- Compensación de exposición EV.

\- Medición de exposición.

\- Bloqueo de exposición.

\- Apertura, únicamente si el dispositivo permite modificarla.



\## Color



\- Balance de blancos automático.

\- Temperatura en Kelvin.

\- Modos de balance de blancos.

\- Matiz.

\- Saturación.

\- Contraste.

\- Estilos fotográficos.

\- Perfiles de color.

\- Estilos Leica u otros fabricantes.



\## Enfoque



\- Enfoque automático.

\- Enfoque manual.

\- Distancia de enfoque.

\- Enfoque a infinito.

\- Bloqueo de enfoque.

\- Focus peaking, si está disponible.



\## Óptica



\- Cámara principal.

\- Teleobjetivo.

\- Ultra gran angular.

\- Macro.

\- Lentes adicionales.

\- Zoom óptico o selección de focal.

\- Zoom digital, cuando corresponda.



\## Captura



\- JPEG.

\- HEIF.

\- RAW.

\- RAW + JPEG.

\- Resolución.

\- Relación de aspecto.

\- Temporizador.

\- HDR.

\- Flash.

\- Estabilización.

\- Reducción de ruido.

\- Nitidez.

\- Histograma.

\- Zebra.

\- Cuadrícula.

\- Nivel electrónico.



Cada parámetro debe admitir estados equivalentes a:



\- AUTO.

\- MANUAL.

\- UNCHANGED.

\- UNSUPPORTED.

\- UNKNOWN.



UNCHANGED significa que la aplicación no debe modificar ese parámetro.



UNKNOWN significa que no puede determinarse su valor actual.



No mostrar como disponibles parámetros que el dispositivo no admita.



Utilizar unidades normalizadas y representaciones independientes del idioma.



\---



\# 12. Biblioteca inicial de perfiles



Incluir como mínimo 24 perfiles fotográficos originales.



\## Astrofotografía



1\. Luna llena.

2\. Luna creciente.

3\. Luna en cuarto.

4\. Eclipse lunar.

5\. Planetas.

6\. Estrellas.

7\. Vía Láctea.

8\. Estelas de estrellas.



\## Naturaleza



9\. Paisaje diurno.

10\. Paisaje nocturno.

11\. Amanecer.

12\. Atardecer.

13\. Montañas.

14\. Cascadas.

15\. Macro.

16\. Fauna.



\## Fotografía general



17\. Retrato diurno.

18\. Retrato nocturno.

19\. Fotografía urbana.

20\. Arquitectura.

21\. Interiores.

22\. Deportes y movimiento.

23\. Estelas de luz.

24\. Larga exposición.



Para cada perfil incluir:



\- Nombre.

\- Icono.

\- Categoría.

\- Descripción.

\- Parámetros iniciales.

\- Intención fotográfica.

\- Condiciones recomendadas.

\- Advertencias.

\- Recomendación de trípode cuando corresponda.

\- Recomendación de lente.

\- Reglas de adaptación.

\- Identificador estable.

\- Versión de fábrica.



Los valores iniciales deben ser técnicamente razonables, pero nunca presentarse como configuraciones perfectas para todas las condiciones.



Por ejemplo, el perfil lunar puede comenzar con ISO bajo, obturación rápida, enfoque lejano y teleobjetivo, sujeto a las capacidades reales y condiciones de iluminación.



Mantener los perfiles originales inmutables.



Permitir crear versiones personalizadas independientes.



\---



\# 13. Gestión de perfiles



Implementar:



\- Creación.

\- Edición.

\- Eliminación con confirmación.

\- Duplicación.

\- Renombrado.

\- Favoritos.

\- Búsqueda.

\- Categorías.

\- Ordenamiento.

\- Reorganización.

\- Aplicación inmediata.

\- Historial.

\- Restauración.

\- Importación.

\- Exportación.

\- Accesos directos en pantalla de inicio.



Permitir perfiles personalizados ilimitados dentro de los límites razonables de almacenamiento del dispositivo.



Mostrar una vista previa de los parámetros antes de aplicar un perfil cuando el usuario lo solicite.



Permitir editar parámetros de manera independiente.



Permitir configurar cada parámetro como automático, manual o sin cambios.



\---



\# 14. Adaptación inteligente de perfiles



Implementar un motor independiente de adaptación fotográfica.



Los perfiles deben representar una intención fotográfica, no únicamente una colección rígida de valores.



Implementar tres modos:



\## Modo estricto



\- Aplicar valores exactos compatibles.

\- Omitir valores no disponibles.

\- Informar las incompatibilidades.

\- No realizar aproximaciones automáticas.



\## Modo adaptativo



\- Buscar el valor compatible más próximo.

\- Adaptar rangos ISO.

\- Adaptar velocidades de obturación.

\- Adaptar balance de blancos.

\- Seleccionar lentes equivalentes.

\- Informar los cambios realizados.



\## Modo inteligente



Utilizar reglas fotográficas locales y cálculos deterministas.



Considerar:



\- Relación entre ISO y obturación.

\- Apertura cuando esté disponible.

\- Distancia focal equivalente.

\- Límites del dispositivo.

\- Riesgo de movimiento.

\- Intención fotográfica.

\- Uso de trípode.

\- Preferencia de lente.

\- Prioridad de calidad o luminosidad.



No utilizar servicios de IA externos.



No afirmar que puede obtenerse una exposición idéntica entre sensores diferentes.



Mostrar:



\- Valor original.

\- Valor adaptado.

\- Motivo de adaptación.

\- Estado de compatibilidad.

\- Advertencias relevantes.



Permitir que el usuario apruebe o rechace las aproximaciones.



\---



\# 15. Calibración universal



Implementar un asistente automático y semiautomático.



Flujo:



1\. Detectar dispositivo.

2\. Detectar cámara nativa.

3\. Identificar modo Pro.

4\. Identificar controles de lentes.

5\. Calibrar ISO.

6\. Calibrar obturación.

7\. Calibrar balance de blancos.

8\. Calibrar enfoque.

9\. Calibrar exposición.

10\. Calibrar parámetros adicionales.

11\. Identificar valores predeterminados.

12\. Verificar funcionamiento.

13\. Guardar calibración.



Permitir que el usuario indique manualmente la posición de un control si no puede identificarse automáticamente.



Implementar una superposición temporal de calibración cuando sea técnicamente posible.



Guardar:



\- Fabricante.

\- Modelo.

\- Paquete de cámara.

\- Versión de cámara.

\- Orientación.

\- Resolución de referencia.

\- Selectores.

\- Coordenadas normalizadas.

\- Rangos.

\- Valores disponibles.

\- Procedimientos de navegación.

\- Métodos de verificación.

\- Fecha de calibración.

\- Versión del esquema.



Detectar cambios en la versión de la cámara.



Invalidar o solicitar verificación de las calibraciones potencialmente incompatibles.



No reutilizar automáticamente calibraciones de dispositivos diferentes sin comprobar su compatibilidad.



\---



\# 16. Menú flotante sobre la cámara



Implementar una superposición mediante AccessibilityService y TYPE\_ACCESSIBILITY\_OVERLAY cuando sea compatible.



No solicitar permisos adicionales de superposición si el mecanismo autorizado de accesibilidad es suficiente.



El menú debe aparecer únicamente sobre la cámara nativa autorizada.



Debe desaparecer cuando:



\- Se abandone la cámara.

\- Se bloquee el dispositivo.

\- Se pierdan los permisos.

\- Se desactive la función.

\- Aparezca una pantalla no autorizada.



Implementar tres tamaños:



\## Minimizado



\- Icono flotante pequeño.

\- Desplazable.

\- Posición memorizada.

\- Acceso inmediato al menú.



\## Compacto



\- Nombre del perfil activo.

\- Selector rápido.

\- Indicador de modificaciones.

\- Restablecimiento.

\- Guardado.

\- Expansión del panel.



\## Expandido



\- Perfil activo.

\- Selector de perfiles.

\- Parámetros fotográficos.

\- Deslizadores.

\- Controles automáticos y manuales.

\- Restablecimiento individual.

\- Restablecimiento general.

\- Guardado.

\- Guardar como nuevo.

\- Deshacer.

\- Rehacer.

\- Minimizar.

\- Cancelar automatización.



Permitir configurar:



\- Tamaño.

\- Opacidad.

\- Posición.

\- Orientación.

\- Vibración.

\- Comportamiento de apertura.

\- Controles visibles.



No bloquear innecesariamente el encuadre.



No cubrir permanentemente el disparador ni los controles nativos.



Ocultar temporalmente el panel cuando interfiera con los gestos de automatización.



Restaurarlo después de completar la operación, si continúa abierta la cámara.



\---



\# 17. Modificaciones en tiempo real



Permitir modificar parámetros mientras la cámara nativa permanece abierta.



El usuario debe poder observar la vista previa real proporcionada por la cámara original.



No implementar una vista previa fotográfica simulada como sustituto de la cámara real.



Permitir dos mecanismos:



1\. Modificación desde los controles nativos.

2\. Modificación desde el panel flotante de Pro Presets.



Desde el panel flotante permitir modificar, según compatibilidad:



\- ISO.

\- Obturación.

\- Balance de blancos.

\- Enfoque.

\- EV.

\- Lente.

\- Saturación.

\- Contraste.

\- Estilos fotográficos.

\- Otros parámetros disponibles.



Utilizar deslizadores, selectores y controles adecuados para cada parámetro.



Evitar ejecutar una automatización completa por cada evento de movimiento del deslizador.



Implementar:



\- Debounce.

\- Agrupación de eventos.

\- Cancelación de valores obsoletos.

\- Aplicación del último valor solicitado.

\- Aplicación al finalizar el gesto cuando resulte necesario.

\- Cola de operaciones.

\- Verificación de resultados.

\- Indicadores de aplicación pendiente.



Priorizar la estabilidad frente a una falsa sensación de respuesta instantánea.



La cámara original determina qué cambios son visibles en la vista previa y cuáles únicamente afectan la fotografía final.



No prometer latencia cero.



\---



\# 18. Detección de cambios manuales



Permitir que el usuario modifique libremente los parámetros directamente en la cámara original.



No bloquear sus controles.



No reaplicar automáticamente el perfil cuando se detecten modificaciones manuales.



Distinguir entre:



1\. Perfil original de fábrica.

2\. Perfil guardado por el usuario.

3\. Configuración temporal actual.

4\. Última configuración enviada.

5\. Última configuración realmente verificada.



Detectar cambios mediante:



\- Eventos de accesibilidad.

\- Lectura de nodos.

\- Lectura de valores visibles.

\- Reconocimiento visual local opcional.



Mostrar indicadores de cambios sin guardar únicamente cuando puedan determinarse razonablemente.



No confundir los valores enviados con los valores realmente presentes en la cámara.



No sobrescribir perfiles automáticamente.



\---



\# 19. Captura de configuraciones actuales



Implementar una función para leer los parámetros actuales de la cámara.



Permitir:



\- Actualizar el perfil activo.

\- Crear un perfil nuevo.

\- Duplicar un perfil con los ajustes actuales.

\- Comparar cambios.

\- Seleccionar qué parámetros guardar.



Intentar leer todos los parámetros compatibles.



Si un parámetro no puede verificarse:



\- Marcarlo como desconocido.

\- Informar al usuario.

\- Permitir introducirlo manualmente.

\- Permitir excluirlo del perfil.



No inventar valores.



No utilizar reconocimiento visual remoto.



Cualquier captura de pantalla necesaria para reconocimiento local debe procesarse temporalmente, respetar las restricciones del sistema y no almacenarse de manera permanente sin autorización.



\---



\# 20. Sistema de restablecimiento



Implementar cuatro mecanismos independientes.



\## Restablecer perfil guardado



Recuperar los últimos valores guardados del perfil activo.



\## Restablecer cámara



Recuperar los valores predeterminados reales del modo Pro de la cámara original.



Priorizar un control nativo de restablecimiento si existe y ha sido validado.



En caso contrario, utilizar una configuración predeterminada previamente verificada durante la calibración.



No asumir que todos los valores predeterminados son automáticos.



No borrar datos de la cámara.



\## Restaurar perfil de fábrica



Recuperar los valores originales incluidos en Pro Presets.



Solicitar confirmación antes de sobrescribir permanentemente una versión personalizada.



\## Restablecer parámetro individual



Restaurar únicamente el parámetro seleccionado.



Evitar modificar otros parámetros.



Mostrar cuando exista una dependencia entre controles, por ejemplo entre exposición automática y compensación EV.



\---



\# 21. Historial y control de versiones de perfiles



Implementar:



\- Historial local de modificaciones.

\- Versiones de perfiles.

\- Fecha de modificación.

\- Comparación entre versiones.

\- Deshacer.

\- Rehacer.

\- Recuperación de versiones.

\- Copia inmutable de perfiles de fábrica.



Diferenciar el historial persistente de perfiles del historial temporal de una sesión de cámara.



Limitar razonablemente el tamaño del historial.



Permitir configurar su retención.



No guardar información fotográfica privada innecesaria.



\---



\# 22. Métodos de acceso



Implementar tres formas principales de utilizar Pro Presets.



\## Desde la aplicación



Seleccionar un perfil, abrir la cámara nativa y aplicar sus parámetros.



\## Desde accesos directos de Android



Crear accesos directos individuales para perfiles favoritos.



Permitir aplicar un perfil desde la pantalla de inicio.



\## Desde la cámara original



Utilizar el menú flotante para cambiar, modificar, guardar y restablecer perfiles sin abandonar la cámara.



Cuando la cámara ya esté abierta, evitar reiniciarla innecesariamente.



Conservar el encuadre y la sesión actual cuando sea técnicamente posible.



\---



\# 23. Diseño gráfico e identidad visual



Crear una identidad profesional inspirada en cámaras fotográficas de gama alta.



No copiar directamente interfaces, marcas o logotipos de fabricantes.



\## Paleta principal



\- Negro AMOLED: #000000.

\- Fondo principal: #080808.

\- Fondo secundario: #121212.

\- Superficies: #1C1C1C.

\- Controles: #252525.

\- Bordes: #383838.

\- Texto secundario: #A0A0A0.

\- Texto principal: #F5F5F5.



Utilizar colores adicionales exclusivamente para estados funcionales:



\- Verde: operación verificada.

\- Amarillo o ámbar: advertencia.

\- Rojo: error.

\- Gris: estado desconocido o no disponible.



No depender exclusivamente del color para transmitir información.



\## Tipografía



\- Roboto o tipografía Android equivalente para la interfaz.

\- Tipografía monoespaciada para valores fotográficos.

\- Jerarquía visual clara.

\- Valores ISO, obturación, WB y enfoque fácilmente legibles.



\## Logotipo



Crear un icono original inspirado en un diafragma fotográfico.



Diseño monocromático.



Preparar icono adaptativo de Android.



\## Estilo



\- Minimalista.

\- Profesional.

\- Elegante.

\- Sin elementos innecesarios.

\- Espaciado consistente.

\- Tarjetas discretas.

\- Iconos lineales.

\- Bordes suaves.

\- Animaciones breves.

\- Modo oscuro predeterminado.



\---



\# 24. Interfaces gráficas obligatorias



Implementar las siguientes 16 interfaces principales y sus estados secundarios.



\## 01. Inicio



Mostrar:



\- Nombre y logotipo.

\- Dispositivo detectado.

\- Estado de compatibilidad.

\- Perfiles favoritos.

\- Perfiles recientes.

\- Categorías.

\- Crear perfil.

\- Abrir cámara.

\- Acceso a configuración.



\## 02. Biblioteca de perfiles



Mostrar:



\- Buscador.

\- Categorías.

\- Favoritos.

\- Ordenamiento.

\- Perfiles originales.

\- Perfiles personalizados.

\- Iconos.

\- Resumen de parámetros.

\- Acciones rápidas.



\## 03. Detalle del perfil



Mostrar:



\- Nombre.

\- Descripción.

\- Intención fotográfica.

\- Parámetros.

\- Compatibilidad.

\- Adaptaciones necesarias.

\- Aplicar.

\- Editar.

\- Duplicar.

\- Favorito.

\- Compartir.

\- Crear acceso directo.

\- Historial.



\## 04. Editor de perfiles



Organizar los controles por:



\- Información general.

\- Exposición.

\- Color.

\- Enfoque.

\- Óptica.

\- Formato.

\- Procesamiento.

\- Herramientas adicionales.



Permitir AUTO, MANUAL y UNCHANGED.



Mostrar validaciones de rangos.



\## 05. Cámara en directo



Esta interfaz corresponde a la cámara nativa con la superposición de Pro Presets.



Mostrar únicamente los elementos propios del panel flotante.



No reconstruir innecesariamente toda la interfaz de cámara.



Incluir:



\- Perfil activo.

\- Parámetros rápidos.

\- Deslizadores.

\- Selector de lentes.

\- Restablecimiento.

\- Guardado.

\- Estado de aplicación.

\- Minimización.



\## 06. Selector flotante



Mostrar:



\- Perfiles favoritos.

\- Perfiles recientes.

\- Búsqueda.

\- Categorías.

\- Perfil activo.

\- Selección rápida.



Aplicar el perfil sin abandonar la cámara.



\## 07. Restablecimiento



Mostrar las cuatro opciones de restablecimiento.



Explicar sus diferencias.



Solicitar confirmación cuando corresponda.



\## 08. Guardar configuración actual



Mostrar:



\- Valores actuales.

\- Valores verificados.

\- Valores desconocidos.

\- Diferencias respecto al perfil guardado.

\- Actualizar perfil.

\- Guardar como nuevo.

\- Seleccionar parámetros.



\## 09. Dispositivo



Mostrar:



\- Fabricante.

\- Modelo.

\- Sistema.

\- Versión de cámara.

\- Sensores.

\- Lentes.

\- Capacidades.

\- Estado de calibración.

\- Nivel de compatibilidad.



\## 10. Compatibilidad



Mostrar cada parámetro y su estado:



\- Compatible.

\- Parcial.

\- No compatible.

\- Pendiente de validación.

\- Desconocido.



Permitir seleccionar modo estricto, adaptativo o inteligente.



\## 11. Calibración



Implementar:



\- Asistente paso a paso.

\- Barra de progreso.

\- Instrucciones claras.

\- Calibración automática.

\- Calibración manual.

\- Repetir paso.

\- Omitir parámetro.

\- Validar.

\- Guardar.



\## 12. Historial



Mostrar:



\- Versiones.

\- Fechas.

\- Parámetros modificados.

\- Comparación.

\- Restauración.

\- Deshacer y rehacer.



\## 13. Importación y exportación



Mostrar:



\- Importar perfiles.

\- Exportar perfiles.

\- Importar calibraciones.

\- Exportar calibraciones.

\- Copia de seguridad.

\- Restauración.



\## 14. Ajustes



Incluir:



\- Idioma.

\- Tema.

\- Modo AMOLED.

\- Menú flotante.

\- Tamaño del panel.

\- Opacidad.

\- Vibración.

\- Posición.

\- Cambios en directo.

\- Confirmaciones.

\- Adaptación.

\- Historial.

\- Permisos.

\- Privacidad.

\- Diagnóstico.

\- Información de la aplicación.



\## 15. Diagnóstico



Mostrar:



\- Estado del servicio.

\- Permisos.

\- Cámara detectada.

\- Paquete.

\- Versión.

\- Adaptador.

\- Calibración.

\- Controles detectados.

\- Últimas operaciones.

\- Errores.

\- Resultados de pruebas.

\- Exportación de diagnóstico sanitizado.



\## 16. Bienvenida y configuración inicial



Mostrar:



\- Presentación de Pro Presets.

\- Explicación de funcionamiento.

\- Privacidad.

\- Permisos necesarios.

\- Detección del dispositivo.

\- Configuración inicial.

\- Calibración.



Explicar claramente el uso de accesibilidad antes de solicitar su activación.



No intentar activar permisos restringidos sin intervención del usuario.



\---



\# 25. Navegación y experiencia de usuario



Implementar navegación principal mediante cinco secciones:



\- Inicio.

\- Perfiles.

\- Cámara.

\- Calibración.

\- Ajustes.



Utilizar pantallas secundarias para el resto de funcionalidades.



Adaptar la interfaz a:



\- Orientación vertical.

\- Orientación horizontal.

\- Diferentes resoluciones.

\- Diferentes densidades.

\- Pantallas grandes.

\- Tamaños de fuente del sistema.



Implementar:



\- Animaciones suaves de aproximadamente 150 a 250 ms.

\- Respuesta háptica opcional.

\- Estados de carga.

\- Estados vacíos.

\- Estados de error.

\- Confirmaciones.

\- Indicadores de cambios pendientes.

\- Acciones accesibles.

\- Áreas táctiles adecuadas.

\- Descripciones para lectores de pantalla.



Respetar las preferencias de reducción de animaciones del sistema.



No incluir botones decorativos que aparenten funcionar.



\---



\# 26. Persistencia local



Utilizar Room para:



\- Perfiles.

\- Categorías.

\- Favoritos.

\- Historial.

\- Calibraciones.

\- Dispositivos.

\- Capacidades verificadas.

\- Versiones.



Utilizar DataStore para:



\- Preferencias.

\- Idioma.

\- Tema.

\- Opacidad.

\- Posición del menú flotante.

\- Comportamiento.

\- Configuración de automatización.



Implementar migraciones de base de datos.



Evitar pérdida de perfiles durante actualizaciones.



No almacenar credenciales ni información sensible innecesaria.



\---



\# 27. Importación y exportación



Crear formatos JSON versionados.



Extensiones propuestas:



\- .ppprofile: perfiles fotográficos.

\- .ppcalibration: calibraciones.

\- .ppbackup: copia de seguridad.



Utilizar Storage Access Framework.



No solicitar acceso completo al almacenamiento.



Validar:



\- Esquema.

\- Versión.

\- Tipos.

\- Rangos.

\- Tamaño.

\- Integridad.

\- Compatibilidad.

\- Identificadores duplicados.



Mostrar una vista previa antes de importar.



Permitir conservar, reemplazar o duplicar perfiles existentes.



Las calibraciones importadas deben tratarse como datos no confiables.



No permitir scripts ejecutables, comandos arbitrarios, paquetes no autorizados ni acciones fuera de la cámara.



Preparar la arquitectura para una futura biblioteca comunitaria, pero no implementar servidores ni servicios de pago en esta versión.



\---



\# 28. Seguridad y privacidad



Aplicar el principio de mínimo privilegio.



No solicitar permiso de Internet salvo que una futura funcionalidad explícitamente autorizada lo requiera.



No incluir:



\- Telemetría.

\- Publicidad.

\- Rastreadores.

\- Analítica remota.

\- Subida automática de archivos.

\- Servicios externos de reconocimiento.

\- Acceso innecesario a fotografías.



Limitar AccessibilityService al alcance funcional de la cámara autorizada.



No capturar información de otras aplicaciones.



No eludir restricciones de Android o HyperOS.



No utilizar exploits.



No modificar aplicaciones del fabricante.



No desactivar mecanismos de seguridad.



Documentar las restricciones de distribución relacionadas con servicios de accesibilidad y las políticas aplicables de Google Play.



\---



\# 29. Manejo de errores



Implementar mensajes claros en español e inglés.



Contemplar:



\- Cámara no encontrada.

\- Modo Pro no disponible.

\- Permiso de accesibilidad desactivado.

\- Control no encontrado.

\- Valor no compatible.

\- Valor no verificable.

\- Calibración desactualizada.

\- Cámara cerrada.

\- Cambio de orientación.

\- Tiempo de espera agotado.

\- Operación cancelada.

\- Superposición bloqueada.

\- Perfil parcialmente aplicado.

\- Fallo de importación.

\- Archivo incompatible.



Distinguir:



\- Aplicado y verificado.

\- Aplicado sin verificación.

\- Aproximado.

\- Omitido.

\- No compatible.

\- Desconocido.

\- Fallido.



Nunca informar éxito completo cuando únicamente se aplicaron algunos parámetros.



\---



\# 30. Pruebas



Implementar pruebas para:



\- Modelos de perfiles.

\- Validación de parámetros.

\- Adaptación de rangos.

\- Conversión de obturación.

\- Cálculos de exposición.

\- Selección de lentes.

\- Persistencia.

\- Migraciones.

\- Importación y exportación.

\- Historial.

\- Restablecimiento.

\- Máquina de estados.

\- Cancelación.

\- Debounce.

\- Cola de operaciones.

\- Adaptadores simulados.

\- Cambios de orientación.

\- Pérdida de permisos.

\- Seguridad de calibraciones importadas.



Realizar pruebas de interfaz para los flujos críticos.



Utilizar pruebas específicas durante cada modificación.



Ejecutar pruebas completas en puntos de integración y antes de generar una versión final.



Distinguir entre pruebas unitarias, instrumentadas, simuladas y realizadas en dispositivos físicos.



\---



\# 31. Estrategia de desarrollo por fases



\## Fase 0 — Preparación



\- Inspeccionar el entorno.

\- Comprobar SDK, JDK y Gradle.

\- Inicializar Git.

\- Crear documentación.

\- Definir arquitectura.

\- Establecer criterios de aceptación.



\## Fase 1 — Viabilidad técnica



\- AccessibilityService.

\- Detección de cámara.

\- Apertura del modo Pro.

\- Lectura de controles.

\- Modificación de parámetros.

\- Superposición básica.

\- Validación física cuando sea posible.



\## Fase 2 — Motor principal



\- Modelos de datos.

\- Persistencia.

\- Motor de perfiles.

\- Adaptadores.

\- Automatización.

\- Máquina de estados.

\- Verificación.



\## Fase 3 — Compatibilidad universal



\- Detección de dispositivos.

\- Camera2.

\- Capacidades.

\- Calibración.

\- Adaptación fotográfica.



\## Fase 4 — Interfaces principales



\- Identidad visual.

\- Inicio.

\- Biblioteca.

\- Detalle.

\- Editor.

\- Navegación.

\- Ajustes.



\## Fase 5 — Cámara en directo



\- Menú flotante.

\- Selector rápido.

\- Deslizadores.

\- Modificaciones manuales.

\- Cambios temporales.

\- Restablecimiento.

\- Captura de configuraciones.



\## Fase 6 — Funciones complementarias



\- Historial.

\- Importación.

\- Exportación.

\- Copias de seguridad.

\- Accesos directos.

\- Diagnóstico.

\- Traducciones.



\## Fase 7 — Optimización



\- Rendimiento.

\- Consumo de batería.

\- Estabilidad.

\- Seguridad.

\- Accesibilidad.

\- Corrección de errores.



\## Fase 8 — Entrega



\- Pruebas completas.

\- Compilación.

\- APK.

\- Documentación.

\- Informe de compatibilidad.

\- Limitaciones conocidas.



No intentar implementar todas las fases simultáneamente.



Mantener cada fase verificable e independiente.



\---



\# 32. ADMINISTRACIÓN DE CUOTA DE CODEX



La optimización de cuota es un requisito importante del proyecto.



El usuario utiliza Codex con una cuota limitada y desea maximizar la relación entre calidad, consumo y productividad.



No sacrificar la seguridad o estabilidad de las funciones críticas únicamente para reducir consumo.



\## Modelo recomendado



Utilizar como referencia, si está disponible en el selector del usuario:



\- GPT-6.2 Sol Medium para desarrollo habitual.

\- GPT-6.2 Sol High para arquitectura y lógica compleja.

\- GPT-6.2 Sol Ultra para bloqueos técnicos especialmente difíciles.

\- GPT-6 Luna o un modelo ligero equivalente para tareas sencillas.



Los nombres y modelos disponibles pueden variar.



No asumir que puedes cambiar automáticamente el modelo o el nivel de razonamiento.



Cuando resulte conveniente cambiar de modelo, indicar brevemente al usuario qué modelo recomienda la siguiente tarea y por qué.



No detener innecesariamente el desarrollo para solicitar un cambio de modelo.



\## Distribución orientativa



\- 60 % de tareas: Sol Medium.

\- 20 % de tareas: modelo ligero.

\- 15 % de tareas: Sol High.

\- 5 % de tareas: Sol Ultra.



Estos porcentajes representan una estrategia orientativa de distribución de tareas, no una equivalencia garantizada de consumo de cuota.



\## Asignación por tipo de trabajo



Utilizar razonamiento alto para:



\- Arquitectura.

\- AccessibilityService.

\- Adaptadores.

\- Calibración.

\- Automatización.

\- Concurrencia.

\- Seguridad.

\- Verificación de controles.

\- Problemas complejos de compatibilidad.



Reservar razonamiento ultra para:



\- Errores difíciles que persistan después de intentos razonables.

\- Bloqueos de automatización.

\- Problemas complejos de HyperOS.

\- Fallos de concurrencia especialmente difíciles.

\- Diagnóstico técnico que requiera análisis profundo.



Utilizar razonamiento medio para:



\- Jetpack Compose.

\- Room.

\- Repositorios.

\- Navegación.

\- Gestión de perfiles.

\- Historial.

\- Importación y exportación.

\- Pruebas convencionales.



Utilizar modelos ligeros para:



\- Traducciones.

\- Textos.

\- Iconos.

\- Colores.

\- Ajustes visuales sencillos.

\- Documentación.

\- Cambios repetitivos.

\- Compilaciones rutinarias.

\- Correcciones menores.



\---



\# 33. Optimización del contexto



Crear y mantener los siguientes archivos:



\## AGENTS.md



Contendrá:



\- Reglas permanentes.

\- Arquitectura.

\- Convenciones.

\- Restricciones.

\- Comandos habituales.

\- Estrategia de pruebas.

\- Seguridad.

\- Optimización de cuota.

\- Referencias a la documentación detallada.



Mantenerlo conciso.



No duplicar toda la especificación maestra dentro de AGENTS.md.



\## SPECIFICATION.md



Contendrá la especificación funcional completa del proyecto.



Organizarla por secciones para permitir consultar únicamente las partes relevantes.



\## PROGRESS.md



Contendrá:



\- Fase actual.

\- Funciones completadas.

\- Funciones pendientes.

\- Últimos cambios.

\- Pruebas realizadas.

\- Errores pendientes.

\- Próxima tarea.

\- Estado de compilación.

\- Último commit relevante.



Mantener un resumen actualizado y compacto.



\## ARCHITECTURE.md



Contendrá:



\- Arquitectura.

\- Módulos.

\- Contratos.

\- Flujos de datos.

\- Adaptadores.

\- Dependencias.

\- Decisiones técnicas.



\## TASKS.md



Contendrá:



\- Identificador de cada tarea.

\- Prioridad.

\- Estado.

\- Dependencias.

\- Criterios de aceptación.

\- Complejidad.

\- Modelo recomendado.



\## DECISIONS.md



Contendrá decisiones técnicas importantes y sus justificaciones.



\## COMPATIBILITY.md



Contendrá:



\- Dispositivos.

\- Versiones.

\- Parámetros.

\- Resultados de pruebas.

\- Limitaciones.

\- Calibraciones verificadas.



\## TESTING.md



Contendrá:



\- Estrategia de pruebas.

\- Comandos.

\- Resultados relevantes.

\- Pruebas físicas pendientes.



\## HANDOFF.md



Contendrá un resumen breve para continuar el proyecto en otra conversación o modelo.



Incluir:



\- Estado actual.

\- Objetivo inmediato.

\- Archivos relevantes.

\- Problemas conocidos.

\- Comando de compilación.

\- Último resultado de pruebas.

\- Próxima acción concreta.



\## README.md



Contendrá:



\- Descripción.

\- Instalación.

\- Compilación.

\- Configuración.

\- Uso.

\- Permisos.

\- Limitaciones.



\---



\# 34. Reglas de ahorro de contexto y herramientas



Aplicar estas reglas durante todo el desarrollo:



1\. No releer el proyecto completo en cada tarea.

2\. Consultar únicamente los archivos relevantes.

3\. Utilizar búsquedas específicas.

4\. Evitar imprimir archivos completos innecesariamente.

5\. Evitar mostrar registros de compilación excesivamente largos.

6\. Extraer únicamente errores y advertencias relevantes.

7\. No repetir explicaciones de arquitectura ya documentadas.

8\. No generar múltiples alternativas cuando una solución razonable sea suficiente.

9\. No reescribir módulos completos para realizar cambios pequeños.

10\. No ejecutar pruebas completas después de cada cambio trivial.

11\. Ejecutar pruebas específicas y verificaciones incrementales.

12\. No repetir comandos que ya hayan fallado sin modificar la causa.

13\. Evitar dependencias innecesarias.

14\. Reutilizar componentes.

15\. Mantener documentación compacta.

16\. No incluir código fuente completo en las respuestas si ya está guardado en archivos.

17\. No generar informes excesivamente largos.

18\. Evitar análisis redundantes.

19\. No iniciar agentes paralelos innecesariamente.

20\. Utilizar ejecución paralela únicamente cuando aporte una ventaja clara.

21\. Evitar búsquedas web repetitivas.

22\. Consultar documentación oficial cuando exista una incertidumbre técnica relevante.

23\. No realizar llamadas a APIs de pago.

24\. No utilizar Work si Codex local puede completar la tarea.

25\. No solicitar revisión integral del proyecto para cada modificación.

26\. No reconstruir toda la aplicación cuando exista una implementación reutilizable.

27\. Evitar generar imágenes mediante servicios externos para elementos que puedan resolverse con iconos vectoriales.

28\. Utilizar herramientas locales de compilación y pruebas.



No confundir ahorro de contexto con omisión de verificaciones necesarias.



\---



\# 35. Administración de sesiones



Organizar el trabajo en unidades pequeñas y recuperables.



Cada unidad debe tener:



\- Objetivo.

\- Archivos afectados.

\- Implementación.

\- Pruebas.

\- Resultado.

\- Siguiente paso.



Al completar una unidad:



1\. Actualizar PROGRESS.md.

2\. Actualizar TASKS.md.

3\. Actualizar HANDOFF.md.

4\. Registrar decisiones importantes.

5\. Crear un commit cuando corresponda.



Mantener puntos de recuperación frecuentes.



Si el entorno informa que la sesión está próxima a finalizar o el usuario indica que queda poca cuota:



\- No iniciar una tarea extensa.

\- Completar o dejar en estado recuperable la tarea actual.

\- Guardar el progreso.

\- Registrar archivos modificados.

\- Registrar errores pendientes.

\- Actualizar HANDOFF.md.

\- Indicar la próxima acción concreta.



No afirmar que puedes consultar la cuota restante si el entorno no proporciona esa información.



No intentar eludir límites de uso.



No consumir recursos intentando estimar cuotas que no pueden medirse.



\---



\# 36. Continuidad entre modelos y conversaciones



La aplicación debe poder desarrollarse utilizando diferentes conversaciones de Codex.



Al iniciar una nueva sesión:



1\. Leer AGENTS.md.

2\. Leer HANDOFF.md.

3\. Consultar PROGRESS.md si es necesario.

4\. Revisar la tarea pendiente en TASKS.md.

5\. Consultar únicamente los archivos relevantes.

6\. Continuar desde el último estado.



No reiniciar el proyecto.



No repetir la planificación completa.



No reconstruir funcionalidades terminadas sin una razón técnica.



No solicitar nuevamente información que ya esté documentada.



Mantener contratos y convenciones existentes.



\---



\# 37. Uso de Git



Inicializar un repositorio local si no existe.



Crear un .gitignore adecuado para Android.



No incluir:



\- Claves.

\- Credenciales.

\- Archivos privados.

\- Keystores privados.

\- Datos personales.

\- Archivos de compilación innecesarios.



Realizar commits por funcionalidades coherentes.



Ejemplos:



\- feat: add device detection

\- feat: implement camera accessibility adapter

\- feat: add profile persistence

\- feat: implement floating controls

\- fix: handle camera orientation changes

\- test: verify profile adaptation

\- docs: update development handoff



No publicar el repositorio en servicios externos sin autorización.



No eliminar cambios del usuario.



No ejecutar operaciones destructivas sin confirmación.



\---



\# 38. Optimización de rendimiento de la aplicación



La aplicación debe consumir pocos recursos.



Implementar:



\- Servicio activo únicamente cuando corresponda.

\- Filtrado de eventos.

\- Debounce.

\- Cancelación de tareas obsoletas.

\- Procesamiento asíncrono.

\- Caché razonable.

\- Lectura bajo demanda.

\- Liberación de recursos.

\- Ausencia de sondeos continuos innecesarios.

\- Minimización del trabajo en segundo plano.



No utilizar OCR continuamente.



No capturar la pantalla repetidamente si los nodos de accesibilidad son suficientes.



No mantener procesos de reconocimiento visual cuando la cámara esté cerrada.



Priorizar estabilidad y consumo reducido de batería.



\---



\# 39. Criterios de aceptación



Considerar una funcionalidad terminada únicamente cuando:



\- Está implementada.

\- Compila.

\- Tiene manejo de errores.

\- Respeta permisos.

\- Tiene pruebas apropiadas.

\- Está documentada.

\- No presenta regresiones conocidas.

\- Sus limitaciones están identificadas.



Para funciones dependientes del hardware, distinguir:



\- Implementada.

\- Compilada.

\- Probada mediante simulación.

\- Pendiente de prueba física.

\- Validada físicamente.



No marcar una función como validada si no se dispone de evidencia.



\---



\# 40. Entregables



Generar:



\- Proyecto Android completo.

\- Código fuente.

\- Configuración Gradle.

\- Recursos gráficos.

\- Icono adaptativo.

\- Perfiles iniciales.

\- Base de datos.

\- Adaptador Xiaomi inicial.

\- Adaptador genérico.

\- Motor de calibración.

\- Motor de automatización.

\- Interfaces gráficas.

\- Menú flotante.

\- Pruebas.

\- Documentación.

\- Historial Git.

\- APK debug instalable cuando sea posible.

\- APK release únicamente si existe una configuración de firma apropiada.



Crear una carpeta dist para los entregables finales.



Incluir instrucciones para:



\- Instalar el APK.

\- Activar accesibilidad.

\- Configurar HyperOS.

\- Detectar la cámara.

\- Calibrar.

\- Aplicar perfiles.

\- Utilizar el menú flotante.

\- Modificar parámetros.

\- Guardar perfiles.

\- Restablecer.

\- Importar y exportar.

\- Resolver errores.



No generar ni publicar claves privadas de firma.



\---



\# 41. Formato de comunicación durante el desarrollo



Mantener las respuestas breves y orientadas a resultados.



Al finalizar una tarea, informar únicamente:



\- Qué se implementó.

\- Qué pruebas se ejecutaron.

\- Resultado.

\- Limitaciones o bloqueos.

\- Próxima tarea.

\- Modelo recomendado para continuar, si procede.



No mostrar grandes bloques de código que ya se encuentren en el proyecto.



No repetir la especificación maestra.



No generar informes de progreso extensos salvo que el usuario los solicite.



\---



\# 42. Instrucción de inicio



Comienza ahora.



Primero inspecciona el entorno disponible y la carpeta del proyecto.



Si la carpeta está vacía, inicializa el proyecto.



Si existen archivos, revísalos de forma selectiva y conserva el trabajo previo.



Crea los archivos de documentación y continuidad.



Define las tareas por fases.



Implementa la prueba de viabilidad del mecanismo de automatización y superposición antes de invertir recursos en las interfaces completas.



Ejecuta las verificaciones disponibles.



Si necesitas un dispositivo físico, prepara el APK de prueba y las instrucciones necesarias para que el usuario pueda validar los controles en su Xiaomi 13T Pro.



Continúa con las tareas que puedan desarrollarse sin depender de resultados físicos, pero no presentes como validada ninguna función que dependa de pruebas pendientes.



Avanza de forma incremental, autónoma, segura y eficiente.



Prioriza una aplicación realmente funcional, mantenible y gratuita sobre una implementación excesivamente compleja.



Mantén siempre actualizados los archivos de continuidad para permitir cambiar de modelo, conversación o sesión sin perder el progreso.



El objetivo final es entregar Pro Presets como una extensión profesional, universal y gratuita de las cámaras nativas de Android.

