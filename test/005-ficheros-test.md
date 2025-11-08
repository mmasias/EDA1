# Test: Ficheros (Archivos)

**Tema:** Persistencia de Datos - Ficheros
**Número de preguntas:** 10
**Tiempo estimado:** 15-20 minutos

---

## Pregunta 1
**¿Cuál es la principal razón por la que necesitamos ficheros en programación?**

A) Son más rápidos que la memoria RAM
B) Proporcionan persistencia de datos que sobrevive al cierre del programa
C) Ocupan menos espacio
D) Son más fáciles de usar que las variables

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** La razón fundamental para usar ficheros es la **persistencia**: los datos almacenados en ficheros sobreviven cuando el programa termina o el ordenador se apaga.

**Problema con memoria RAM:**
```java
// Sin ficheros - datos se pierden
public static void main(String[] args) {
    String nombre = "Ana";
    int puntuacion = 100;
    // Al terminar el programa: datos perdidos ❌
}

// Con ficheros - datos persisten
public static void main(String[] args) {
    String nombre = "Ana";
    int puntuacion = 100;
    guardarEnFichero(nombre, puntuacion);
    // Datos guardados, disponibles en próxima ejecución ✓
}
```

**Limitaciones de RAM:**
- Volátil (se borra al apagar)
- Limitada en capacidad
- Más cara que almacenamiento secundario

</details>

---

## Pregunta 2
**¿Qué es un fichero?**

A) Una variable especial en memoria
B) Una abstracción que representa información persistente identificable por un nombre
C) Un tipo de dato primitivo
D) Una clase de Java

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** Un **fichero** es una **abstracción** que representa una colección organizada y persistente de información, identificable mediante un nombre y almacenada en un dispositivo.

**Características fundamentales:**
- **Persistencia:** Sobrevive al cierre del programa
- **Identificación única:** Tiene un nombre (ejemplo: "datos.txt")
- **Tamaño variable:** Puede crecer o reducirse
- **Independencia:** Puede usarse por diferentes programas
- **Unidad lógica:** Se trata como un todo

```
datos.txt           ← Fichero identificable
├─ Contenido: "Ana, 100"
├─ Tamaño: 9 bytes
├─ Fecha creación: 2025-11-08
└─ Ubicación: /documentos/
```

</details>

---

## Pregunta 3
**¿Cuál es la diferencia entre un fichero de texto y uno binario?**

A) Los de texto son más pequeños
B) Los de texto contienen caracteres legibles, los binarios contienen datos en formato no textual
C) Los binarios son más modernos
D) No hay diferencia real

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** La diferencia está en el **formato del contenido**:

**Fichero de texto:**
- Contiene información legible como **caracteres**
- Puedes abrirlo con un editor de texto
- Interpretable directamente por humanos
- Ejemplos: .txt, .csv, .json, .xml, .java

```
datos.txt:
Ana, 100
Luis, 95
María, 88
```

**Fichero binario:**
- Contiene información en **formato no textual**
- Requiere programa específico para interpretarlo
- Optimizado para procesamiento por ordenador
- Ejemplos: .jpg, .pdf, .exe, .zip, .class

```
imagen.jpg:
ÿØÿàJFIF... (no legible directamente)
```

**Ventajas binarios:** Más compactos, más rápidos de procesar
**Ventajas texto:** Legibles, portables, fáciles de editar

</details>

---

## Pregunta 4
**¿Qué significa que un fichero es de "acceso secuencial"?**

A) Se puede leer en cualquier orden
B) Los datos se leen/escriben en orden, de principio a fin
C) Solo permite escritura
D) Es más rápido que acceso directo

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** En acceso **secuencial**, los datos se leen o escriben **en orden**, uno tras otro, desde el principio hasta el final.

**Acceso secuencial:**
```
Fichero: [A][B][C][D][E]

Para leer E:
Paso 1: Leer A
Paso 2: Leer B
Paso 3: Leer C
Paso 4: Leer D
Paso 5: Leer E  ← Tuvimos que pasar por todos
```

**Analogía:** Como una cinta de cassette - para llegar a la canción 10, debes avanzar por las canciones 1-9.

**Contraste con acceso directo:**
```
Fichero: [A][B][C][D][E]

Para leer E:
Saltar directamente a posición 4 → Leer E ✓
```

**Cuándo usar:**
- Secuencial: logs, procesamiento de todos los registros
- Directo: bases de datos, búsqueda específica

</details>

---

## Pregunta 5
**¿Qué operaciones componen el acrónimo CRUD en el contexto de ficheros?**

A) Copy, Read, Update, Delete
B) Create, Read, Update, Delete
C) Create, Remove, Upload, Download
D) Connect, Retrieve, Update, Dispose

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** CRUD representa las operaciones básicas sobre ficheros (y datos en general):

**C**reate (Crear):
```java
File file = new File("datos.txt");
file.createNewFile();  // Crear nuevo fichero
```

**R**ead (Leer):
```java
BufferedReader reader = new BufferedReader(new FileReader("datos.txt"));
String linea = reader.readLine();  // Leer contenido
```

**U**pdate (Actualizar):
```java
// Modificar contenido existente
FileWriter writer = new FileWriter("datos.txt", true);  // append
writer.write("Nueva línea");
```

**D**elete (Eliminar):
```java
File file = new File("datos.txt");
file.delete();  // Eliminar fichero
```

Estas operaciones son fundamentales en cualquier sistema que trabaje con datos persistentes.

</details>

---

## Pregunta 6
**¿Por qué la memoria RAM no es suficiente para almacenar todos los datos de un programa?**

A) La RAM es demasiado lenta
B) La RAM es volátil (se pierde al apagar) y limitada en capacidad
C) La RAM no puede almacenar texto
D) La RAM solo funciona con números

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** La RAM tiene dos limitaciones fundamentales:

**1. Volatilidad:**
- Los datos se **pierden al apagar** el ordenador
- También se pierden al **cerrar el programa**
- No hay persistencia

**2. Capacidad limitada:**
- Tamaño finito (ej: 8 GB, 16 GB)
- Mucho más cara que almacenamiento secundario
- No todos los datos caben simultáneamente

```
Escenario: Aplicación de notas

Con solo RAM:
- Escribes nota: "Comprar pan" ✓
- Cierras aplicación ❌
- Abres aplicación: nota perdida ❌

Con RAM + Fichero:
- Escribes nota: "Comprar pan" ✓
- Se guarda en fichero ✓
- Cierras aplicación ✓
- Abres aplicación: nota recuperada ✓
```

**Jerarquía de almacenamiento:**
- RAM: rápida, volátil, cara, limitada
- Disco: lenta, persistente, barata, gran capacidad

</details>

---

## Pregunta 7
**¿Qué propiedad básica NO tiene típicamente un fichero?**

A) Nombre
B) Tamaño
C) Velocidad de procesador
D) Fecha de creación

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: C**

**Explicación:** La velocidad del procesador no es una propiedad del fichero, sino del sistema que lo procesa.

**Propiedades típicas de un fichero:**

| Propiedad | Ejemplo |
|-----------|---------|
| **Nombre** | "datos.txt" |
| **Ubicación** | "/documentos/proyecto/" |
| **Tamaño** | 1.5 MB |
| **Tipo/Formato** | .txt, .jpg, .pdf |
| **Fecha creación** | 2025-11-08 10:30 |
| **Fecha modificación** | 2025-11-08 15:45 |
| **Permisos** | lectura, escritura, ejecución |
| **Propietario** | usuario: manuel |

```java
File file = new File("datos.txt");
System.out.println(file.getName());          // "datos.txt"
System.out.println(file.length());           // tamaño en bytes
System.out.println(file.lastModified());     // timestamp
System.out.println(file.canRead());          // permisos
```

</details>

---

## Pregunta 8
**¿Para qué se usan principalmente los ficheros de log (registro)?**

A) Para hacer el programa más lento
B) Para registrar eventos, errores y auditoría del sistema
C) Para almacenar contraseñas
D) Para reemplazar la consola

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** Los **ficheros de log** se usan para **registrar eventos** que ocurren en el sistema, permitiendo:

**Propósitos principales:**

1. **Monitorización:**
```
2025-11-08 10:15:23 [INFO] Usuario Ana inició sesión
2025-11-08 10:16:45 [INFO] Ana guardó documento
2025-11-08 10:17:12 [WARNING] Batería baja (15%)
```

2. **Detección de errores:**
```
2025-11-08 14:30:01 [ERROR] No se pudo conectar a base de datos
2025-11-08 14:30:01 [ERROR] SQLException: Connection timeout
2025-11-08 14:30:02 [INFO] Reintentando conexión...
```

3. **Auditoría:**
```
2025-11-08 09:00:00 [AUDIT] Usuario admin modificó permisos
2025-11-08 09:05:23 [AUDIT] Usuario Luis accedió a datos sensibles
```

4. **Depuración:**
- Investigar qué causó un fallo
- Rastrear el flujo de ejecución
- Analizar comportamiento del sistema

**Ventaja:** Los logs persisten después del cierre, permitiendo análisis posterior.

</details>

---

## Pregunta 9
**¿Qué significa que los ficheros permiten "comunicación entre programas"?**

A) Los programas pueden chatear
B) Un programa puede escribir datos que otro programa puede leer
C) Los ficheros tienen internet integrado
D) Los programas se envían emails

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** Los ficheros actúan como **medio de intercambio de información** entre diferentes programas.

**Ejemplo práctico:**

```
Programa A (genera datos):
public class GeneradorDatos {
    public static void main(String[] args) {
        FileWriter writer = new FileWriter("datos.txt");
        writer.write("Ana,100\n");
        writer.write("Luis,95\n");
        writer.close();
    }
}

Programa B (lee datos):
public class ProcesadorDatos {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(
            new FileReader("datos.txt")
        );
        String linea = reader.readLine();  // Lee "Ana,100"
        // Procesa los datos...
    }
}
```

**Casos de uso:**
- Excel guarda .xlsx → Python lo lee para análisis
- Navegador descarga .json → Aplicación lo procesa
- Compilador genera .class → JVM lo ejecuta
- Editor guarda código → Git lo versiona

**Ventaja:** No necesitan ejecutarse simultáneamente.

</details>

---

## Pregunta 10
**¿Cuál es una aplicación real de ficheros en sistemas empresariales?**

A) Solo para guardar imágenes
B) Cumplimiento legal, backups, configuraciones, y registros de transacciones
C) Solo para hacer el sistema más lento
D) No tienen aplicación real

<details>
<summary>Ver respuesta</summary>

**Respuesta correcta: B**

**Explicación:** Los ficheros son **fundamentales** en sistemas empresariales para múltiples propósitos críticos:

**1. Cumplimiento legal y regulatorio:**
- Conservar registros por años (requisitos legales)
- Auditorías fiscales y financieras
- Trazabilidad de operaciones

**2. Copias de seguridad (backups):**
```
backup_2025-11-08.zip
├─ base_datos.sql
├─ documentos/
└─ configuraciones/
```

**3. Configuraciones del sistema:**
```properties
# config.properties
database.url=jdbc:mysql://localhost/empresa
max.connections=100
backup.frequency=daily
```

**4. Registro de transacciones:**
```
transacciones.log:
2025-11-08 14:30 | Cliente: Ana | Compra: 150€ | Estado: OK
2025-11-08 14:31 | Cliente: Luis | Compra: 75€ | Estado: OK
2025-11-08 14:32 | Cliente: María | Compra: 200€ | Estado: PENDIENTE
```

**5. Recuperación ante fallos:**
- Puntos de control (checkpoints)
- Restauración de estado
- Continuidad del negocio

</details>

---

## Criterios de Evaluación

- **10 respuestas correctas:** Excelente comprensión de ficheros
- **7-9 respuestas correctas:** Buen entendimiento, revisar conceptos específicos
- **5-6 respuestas correctas:** Comprensión básica, se recomienda repasar
- **Menos de 5 correctas:** Es necesario revisar el tema completo

## Temas Clave Evaluados

1. ✓ Necesidad de persistencia
2. ✓ Definición y abstracción de fichero
3. ✓ Ficheros de texto vs binarios
4. ✓ Acceso secuencial vs directo
5. ✓ Operaciones CRUD
6. ✓ Limitaciones de RAM
7. ✓ Propiedades de ficheros
8. ✓ Ficheros de log (auditoría)
9. ✓ Comunicación entre programas
10. ✓ Aplicaciones empresariales
