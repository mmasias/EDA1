# Tests de Evaluación - EDA1

Colección de tests tipo ABCD para evaluación de conceptos fundamentales de Estructuras de Datos y Algoritmos I.

## 📋 Tests Disponibles

### Fundamentos

| Test | Tema | Preguntas | Dificultad |
|------|------|-----------|------------|
| [000-encapsulacion-test.md](000-encapsulacion-test.md) | Encapsulamiento y Diseño | 10 | ⭐⭐⭐ |
| [001-intro-test.md](001-intro-test.md) | Introducción y Fundamentos | 10 | ⭐⭐ |

**Encapsulamiento cubre:** Perspectiva interna vs externa, atributos públicos vs privados, diseño de interfaces, errores de encapsulamiento, principios de diseño OOP, independencia de implementación.

**Introducción cubre:** Primitivos vs referencias, String vs StringBuilder, Integer pool, operaciones CRUD, paso de parámetros, importancia de estructuras de datos.

---

### Estructuras Lineales - Conceptos

| Test | Tema | Preguntas | Dificultad |
|------|------|-----------|------------|
| [002-00-listas-test.md](002-00-listas-test.md) | Listas Enlazadas | 10 | ⭐⭐ |
| [002-01-pilas-test.md](002-01-pilas-test.md) | Pilas (Stacks) | 10 | ⭐⭐ |
| [002-02-colas-test.md](002-02-colas-test.md) | Colas (Queues) | 10 | ⭐⭐ |

**Listas cubre:** Definición, operaciones de inserción, nodos, identificación del último nodo, tipos de listas, comparación con arrays, validaciones.

**Pilas cubre:** Principio LIFO, operaciones push/pop/peek, aplicaciones, estados vacío/lleno, implementación con array vs lista enlazada.

**Colas cubre:** Principio FIFO, operaciones enqueue/dequeue/peek, dos referencias, aplicaciones, diferencias con pilas, actualización de referencias.

### Estructuras Lineales - Implementación (Avanzado)

| Test | Tema | Preguntas | Dificultad |
|------|------|-----------|------------|
| [002-00-listas-test-avanzado.md](002-00-listas-test-avanzado.md) | Listas - Técnico | 10 | ⭐⭐⭐ |
| [002-01-pilas-test-avanzado.md](002-01-pilas-test-avanzado.md) | Pilas - Técnico | 10 | ⭐⭐⭐ |
| [002-02-colas-test-avanzado.md](002-02-colas-test-avanzado.md) | Colas - Técnico | 10 | ⭐⭐⭐ |

**Enfoque técnico:** Casos específicos de implementación, estados de estructuras, errores comunes, análisis de código paso a paso, validaciones, bugs típicos.

**Listas avanzado:** Estados `cabeza==null`, seguimiento de operaciones, NullPointerException, errores en inserción, ciclos, método buscar.

**Pilas avanzado:** Estados `tope==null/==-1`, overflow/underflow, pre-incremento vs post-incremento, peek vs pop, implementación con lista.

**Colas avanzado:** Estados `frente==null`, actualización de dos referencias, bugs al vaciar, enqueue en cola vacía, FIFO vs LIFO.

---

### Estructuras No Lineales

| Test | Tema | Preguntas | Dificultad |
|------|------|-----------|------------|
| [003-arboles-test.md](003-arboles-test.md) | Árboles | 10 | ⭐⭐⭐ |
| [004-grafos-test.md](004-grafos-test.md) | Grafos | 10 | ⭐⭐⭐ |

**Árboles cubre:** Estructura jerárquica, nodo raíz/hojas, árboles binarios, altura, recorridos (inorden), BST, aplicaciones, limitaciones, diferencias con grafos.

**Grafos cubre:** Vértices y aristas, ciclos, grafos dirigidos/ponderados, aplicaciones (redes sociales, mapas), diferencias con árboles, almacenamiento de conexiones.

---

### Persistencia

| Test | Tema | Preguntas | Dificultad |
|------|------|-----------|------------|
| [005-ficheros-test.md](005-ficheros-test.md) | Ficheros | 10 | ⭐⭐ |

**Cubre:** Persistencia de datos, definición de fichero, tipos (texto/binario), acceso (secuencial/directo), operaciones CRUD, limitaciones de RAM, logs, comunicación entre programas.

---

## 🎯 Características de los Tests

### Formato
- **10 preguntas** por test
- **4 opciones** de respuesta (A, B, C, D)
- **Respuestas incluidas** en bloques desplegables
- **Explicaciones detalladas** con ejemplos de código
- **Tiempo estimado:** 15-20 minutos por test

### Contenido
- ✅ Enfocados en **conceptos fundamentales**
- ✅ Sin preguntas sobre **complejidad temporal** (reservado para EDA2)
- ✅ Ejemplos prácticos en Java
- ✅ Casos de uso reales
- ✅ Comparaciones entre estructuras

### Nivel de Dificultad
- ⭐ Básico: Conceptos fundamentales
- ⭐⭐ Intermedio: Aplicación de conceptos
- ⭐⭐⭐ Avanzado: Análisis y comprensión profunda

---

## 📊 Criterios de Evaluación

Para cada test:

| Respuestas Correctas | Evaluación |
|---------------------|------------|
| 10 | Excelente comprensión |
| 7-9 | Buen entendimiento |
| 5-6 | Comprensión básica, repasar |
| < 5 | Necesario revisar el tema |

---

## 🚀 Cómo Usar los Tests

### Secuencia Recomendada

1. **Tests Conceptuales** (⭐⭐)
   - Empezar con los tests básicos de cada tema
   - Enfocarse en comprender conceptos fundamentales
   - Ideal para primera aproximación al tema

2. **Tests Avanzados** (⭐⭐⭐)
   - Solo después de dominar los conceptos
   - Enfocados en implementación y casos técnicos
   - Requieren escribir/analizar código

### Durante el Test

- **Antes de empezar:** Lee la documentación del tema correspondiente en `/temario/`
- **Durante el test:**
  - Lee cada pregunta cuidadosamente
  - Intenta responder sin mirar las respuestas
  - Usa papel para anotar tus respuestas
  - En tests avanzados: traza el código paso a paso
- **Después del test:**
  - Revisa las explicaciones de las respuestas incorrectas
  - Consulta la documentación para aclarar dudas
  - Repite el test si obtienes menos de 7 correctas
  - En tests avanzados: implementa el código y pruébalo

---

## 📁 Estructura del Repositorio

```
/test/
├── README.md                           (este archivo)
│
├── 000-encapsulacion-test.md           (Encapsulamiento y diseño OOP)
├── 001-intro-test.md                   (Introducción y fundamentos)
│
├── 002-00-listas-test.md               (Listas - Conceptos)
├── 002-00-listas-test-avanzado.md      (Listas - Implementación)
│
├── 002-01-pilas-test.md                (Pilas - Conceptos)
├── 002-01-pilas-test-avanzado.md       (Pilas - Implementación)
│
├── 002-02-colas-test.md                (Colas - Conceptos)
├── 002-02-colas-test-avanzado.md       (Colas - Implementación)
│
├── 003-arboles-test.md                 (Árboles)
├── 004-grafos-test.md                  (Grafos)
└── 005-ficheros-test.md                (Ficheros)
```

**Total:** 110 preguntas tipo test (70 conceptuales + 30 técnicas + 10 diseño)

---

## 📖 Recursos Relacionados

- [Temario completo](/temario/)
- [Código fuente](/src/)
- [Documentación adicional](/temario/999-otrosTemas/)

---

## 📝 Notas

- Estos tests evalúan **comprensión conceptual**, no velocidad de ejecución
- Las preguntas evitan temas de **complejidad algorítmica** (Big O), que se profundizarán en EDA2
- Se recomienda hacer los tests en orden (001 → 005)
- Los tests son **autoevaluación**: para aprender, no para calificar

---

**Licencia:** Unlicense (dominio público)
**Autor:** Material educativo EDA1
**Última actualización:** 2025-11-08
