# Arquitectura

## Prototipo de viabilidad

Un módulo Android `:app`, Kotlin integrado en AGP y vistas de Android para la pantalla de diagnóstico y el botón flotante. `MainActivity` muestra los datos del dispositivo, abre los ajustes de accesibilidad y lanza la cámara de sistema reconocida por `XiaomiCamera`.

`CameraProbeService` observa cambios de ventana para retirar el panel al salir de la cámara. Comprueba que el dispositivo esté desbloqueado y que la raíz activa pertenezca al paquete Xiaomi antes de mostrar el panel o iniciar la lectura. `CameraTreeProbe` recorre hasta 300 nodos y devuelve hasta 20 candidatos visibles con identificador, acciones y valor cuando se expone. El servicio lee bajo demanda y el diagnóstico de depuración conserva solo metadatos en `logcat`.

## Contratos previstos tras la observación física

- Un adaptador describe identidad y versión de cámara, selectores del modo Pro y de cada control, y métodos de lectura, escritura y verificación. Xiaomi abre el camino al adaptador genérico calibrado y a uno simulado para pruebas.
- El motor recibe una operación explícita con parámetro y valor, valida ventana y versión, oculta el panel, aplica y vuelve a leer el control. Devuelve un resultado que distingue verificado, sin verificar, no disponible, cancelado y fallido. Cada operación tendrá límite de tiempo y se cancelará al perder la ventana o el permiso.
- La prioridad de selección es ID estable, descripción o texto y jerarquía. Una acción de accesibilidad explícita tiene preferencia sobre gestos calibrados. El disparador queda fuera del contrato.
- La UI principal usará Compose. Los perfiles, calibraciones e historial se persistirán en Room y las preferencias en DataStore. Camera2 consultará características públicas por separado y mantendrá libres los sensores de la cámara nativa.

Los límites iniciales se organizan en paquetes a medida que surjan consumidores. Los criterios para pasar al motor principal están en [pruebas](TESTING.md).
