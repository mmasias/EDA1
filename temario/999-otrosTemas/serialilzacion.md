# Serialización en Java: Una Guía Completa

## ¿Por qué?

La serialización en Java es fundamental por varias razones:

|Persistencia de objetos|Comunicación entre sistemas|Cache|Estado de sesión
|-|-|-|-|
|Permite guardar el estado de los objetos para su posterior recuperación|Posibilita el intercambio de objetos entre diferentes JVMs|Permite almacenar objetos en caché para mejorar el rendimiento|Facilita el mantenimiento del estado
|Facilita el almacenamiento de datos estructurados|Fundamental en aplicaciones distribuidas|Útil para reducir la carga en bases de datos|Permite la transferencia de datos entre diferentes capas de la aplicación

## ¿Qué?

La serialización es un mecanismo que permite:

- Convertir objetos en una secuencia de bytes
- Reconstruir objetos a partir de bytes (deserialización)
- Mantener las relaciones entre objetos durante el proceso

## ¿Para qué?

1. Almacenamiento de datos
1. Comunicación en red
1. Frameworks y bibliotecas
1. Desarrollo de aplicaciones

## ¿Cómo?

### Clase serializable básica

```java
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String nombre;
    private int edad;
    private transient String passwordTemporal;
    
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
}
```

### Serialización básica

```java
// Serialización
try (ObjectOutputStream oos = new ObjectOutputStream(
        new FileOutputStream("persona.ser"))) {
    Persona persona = new Persona("Juan", 30);
    oos.writeObject(persona);
} catch (IOException e) {
    e.printStackTrace();
}

// Deserialización
try (ObjectInputStream ois = new ObjectInputStream(
        new FileInputStream("persona.ser"))) {
    Persona persona = (Persona) ois.readObject();
    System.out.println(persona.getNombre());
} catch (IOException | ClassNotFoundException e) {
    e.printStackTrace();
}
```

### Serialización personalizada

```java
public class PersonaCustom implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private String passwordEncriptado;

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        // Serialización personalizada adicional
        out.writeObject(encriptarPassword(passwordEncriptado));
    }

    private void readObject(ObjectInputStream in) 
            throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        // Deserialización personalizada adicional
        this.passwordEncriptado = desencriptarPassword((String)in.readObject());
    }
}
```

### Implementación de Externalizable

```java
public class PersonaExt implements Externalizable {
    private String nombre;
    private int edad;

    public PersonaExt() {
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(nombre);
        out.writeInt(edad);
    }

    @Override
    public void readExternal(ObjectInput in) 
            throws IOException, ClassNotFoundException {
        nombre = (String) in.readObject();
        edad = in.readInt();
    }
}
```
