package archivos.crudBasico;

import java.util.Scanner;

public class ClientApp {
    public static void main(String[] args) {
        FileManager manager = new FileManager("ejemplo.txt");

        System.out.println("=== CREACIÓN DE ARCHIVO ===");
        String contenidoInicial = "Línea uno: introducción\n" +
                "Línea dos: desarrollo\n" +
                "Línea tres: conclusión";
        boolean creado = manager.createFile(contenidoInicial);
        if (creado) {
            System.out.println("Archivo creado con éxito");
        } else {
            System.out.println("Error al crear el archivo");
        }
        new Scanner(System.in).nextLine();

        System.out.println("=== CONTENIDO ORIGINAL ===");
        String contenido = manager.readFile();
        System.out.println(contenido);
        new Scanner(System.in).nextLine();

        System.out.println("=== MODIFICANDO LÍNEA 2 ===");
        boolean modificado = manager.updateLine(2, "Línea dos: CONTENIDO MODIFICADO");

        if (modificado) {
            System.out.println("Línea modificada con éxito");
        } else {
            System.out.println("Error al modificar la línea");
        }
        new Scanner(System.in).nextLine();

        System.out.println("=== CONTENIDO ACTUALIZADO ===");
        contenido = manager.readFile();
        System.out.println(contenido);
        new Scanner(System.in).nextLine();

        System.out.println("=== ELIMINANDO LÍNEA 3 ===");
        boolean eliminado = manager.deleteLine(3);

        if (eliminado) {
            System.out.println("Línea eliminada con éxito");
        } else {
            System.out.println("Error al eliminar la línea");
        }
        new Scanner(System.in).nextLine();

        System.out.println("=== CONTENIDO TRAS ELIMINAR LÍNEA ===");
        contenido = manager.readFile();
        System.out.println(contenido);
        new Scanner(System.in).nextLine();

        System.out.println("=== ELIMINANDO ARCHIVO COMPLETO ===");
        if (manager.deleteFile()) {
            System.out.println("Archivo eliminado con éxito");
        } else {
            System.out.println("Error al eliminar el archivo");
        }
        new Scanner(System.in).nextLine();

        System.out.println("=== INTENTO LEER ===");
        contenido = manager.readFile();
        System.out.println(contenido);
        new Scanner(System.in).nextLine();
    }    
}
