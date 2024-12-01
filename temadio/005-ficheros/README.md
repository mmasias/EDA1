# Ficheros

## ¿Por qué?

No es solo una alternativa de almacenamiento, sino de una necesidad fundamental en la arquitectura de cualquier sistema informático robusto que surge de varias limitaciones y requerimientos fundamentales en el desarrollo de software.

|La memoria principal|Requisitos de persistencia en aplicaciones reales|Necesidades de intercambio y comunicación|Aspectos legales y de cumplimiento|Gestión de recursos del sistema
|-|-|-|-|-
|La memoria RAM es volátil y limitada en capacidad|Los sistemas necesitan mantener su estado entre ejecuciones|Los programas necesitan compartir información entre sí|Muchas industrias tienen requisitos regulatorios de conservación de datos|No todos los datos pueden mantenerse en memoria simultáneamente
|Los datos se pierden al interrumpirse la energía|Las transacciones y operaciones críticas deben sobrevivir a fallos del sistema|Diferentes sistemas y plataformas deben poder intercambiar datos|Se necesita mantener registros históricos por períodos específicos|Se requiere una jerarquía de almacenamiento para optimizar costes y rendimiento
|El coste por byte de la RAM es significativamente mayor que el almacenamiento secundario|Se requiere trazabilidad y capacidad de auditoría en muchas aplicaciones empresariales|Los usuarios necesitan poder transferir información entre dispositivos|La integridad y autenticidad de los datos debe poder verificarse|El acceso concurrente a datos necesita ser gestionado de manera eficiente

|Recuperación ante fallos|Escalabilidad y crecimiento|Optimización de recursos|Seguridad y control de acceso|Evolución tecnológica
|-|-|-|-|-
|Los sistemas deben poder recuperarse de interrupciones inesperadas|Los sistemas deben poder manejar volúmenes crecientes de datos|El acceso a datos debe ser eficiente en términos de tiempo y recursos|Los datos sensibles deben protegerse adecuadamente|Los formatos de datos deben poder adaptarse a cambios tecnológicos
|Se necesitan mecanismos de backup y restauración|El almacenamiento debe poder expandirse sin afectar la funcionalidad|Los costes de almacenamiento deben minimizarse|El acceso a la información debe poder controlarse y auditarse|La migración entre sistemas debe ser posible
|La consistencia de los datos debe mantenerse incluso en caso de errores|La estructura de datos debe adaptarse a diferentes tamaños y necesidades|El rendimiento del sistema debe mantenerse incluso con grandes volúmenes de datos|Se necesitan diferentes niveles de permisos y protección|Los datos históricos deben permanecer accesibles con nuevas tecnologías

## ¿Qué?

Un fichero es una **abstracción** que representa una colección organizada y persistente de información, identificable mediante un nombre y almacenada como una unidad en un dispositivo de almacenamiento.

- Persistencia (sobrevive a la finalización del programa)
- Identificación única en su contexto
- Tamaño variable
- Independencia del programa que lo crea
- Unidad de almacenamiento lógica

### Propiedades

- Nombre y ubicación
- Tamaño
- Tipo o formato
- Temporalidad (fechas de creación, modificación)
- Permisos básicos de acceso

### Tipos

- Según su contenido
  - Ficheros de texto
    - Contienen información legible como texto
    - Organizados en secuencias de caracteres
    - Interpretables directamente por humanos
  - Ficheros binarios
    - Contienen información en formato no textual
    - Requieren programas específicos para su interpretación
    - Optimizados para procesamiento por ordenador
- Según su forma de acceso
  - Secuenciales
    - Los datos se leen/escriben en orden
    - Cada elemento se accede atravesando los anteriores
  - De acceso directo
    - Permiten acceder a cualquier parte sin recorrer el resto
    - Basados en posiciones o índices
  - Indexados
    - Combinan acceso directo con estructuras de búsqueda
    - Permiten localizar información por contenido

## ¿Para qué?

|Almacenamiento|Comunicación|Registro|Estado|
|-|-|-|-|
|Datos persistentes|Entre programas|Logs|Puntos de control
|Configuraciones|Entre usuarios|Auditoría|Sesiones
|Copias de seguridad|Entre sistemas|Monitorización|Recuperación

Y también:

- Organización de información.
- Distribución de software.
- Procesos de negocio.
- Soporte educativo.
- Investigación y análisis.
- Preservación cultural.

## ¿Cómo?

- [CRUD!](/src/archivos/crudBasico/)