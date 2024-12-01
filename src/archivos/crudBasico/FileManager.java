package archivos.crudBasico;

import java.io.*;
import java.util.Scanner;

public class FileManager {
    private final String filePath;
    private static final int MAX_LINES = 1000;

    public FileManager(String filePath) {
        this.filePath = filePath;
    }

    public boolean createFile(String content) {
        File archivo = new File(filePath);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            writer.write(content);
            return true;
        } catch (IOException e) {
            System.err.println("Error al crear/escribir el archivo: " + e.getMessage());
            return false;
        }
    }

    public String readFile() {
        File archivo = new File(filePath);
        StringBuilder contenido = new StringBuilder();

        if (!archivo.exists()) {
            System.err.println("El archivo no existe");
            return null;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                contenido.append(linea);
                contenido.append(System.lineSeparator());
            }
            return contenido.toString();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return null;
        }
    }

    private int countLines() {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.readLine() != null) {
                count++;
            }
        } catch (IOException e) {
            System.err.println("Error al contar líneas: " + e.getMessage());
        }
        return count;
    }

    public boolean updateLine(int lineNumber, String newLine) {
        int totalLines = countLines();
        if (lineNumber < 1 || lineNumber > totalLines) {
            System.err.println("Número de línea fuera de rango");
            return false;
        }

        String[] lines = new String[totalLines];

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            for (int i = 0; i < totalLines; i++) {
                lines[i] = reader.readLine();
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return false;
        }

        lines[lineNumber - 1] = newLine;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 0; i < lines.length; i++) {
                writer.write(lines[i]);
                if (i < lines.length - 1) {
                    writer.newLine();
                }
            }
            return true;
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteFile() {
        File archivo = new File(filePath);
        if (!archivo.exists()) {
            System.err.println("El archivo no existe");
            return false;
        }
        return archivo.delete();
    }

    public boolean deleteLine(int lineNumber) {
        int totalLines = countLines();
        if (lineNumber < 1 || lineNumber > totalLines) {
            System.err.println("Número de línea fuera de rango");
            return false;
        }

        String[] lines = new String[totalLines];

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            for (int i = 0; i < totalLines; i++) {
                lines[i] = reader.readLine();
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return false;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 0; i < lines.length; i++) {
                if (i + 1 != lineNumber) {
                    writer.write(lines[i]);
                    if (i < lines.length - 1) {
                        writer.newLine();
                    }
                }
            }
            return true;
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
            return false;
        }
    }

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
    }
}