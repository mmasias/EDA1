package archivos.crudBasico;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileManager {
    private final String filePath;

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

    public static void main(String[] args) {
        FileManager manager = new FileManager("ejemplo.txt");
        
        String contenido = "Primera línea de texto\n" +
                         "Segunda línea de texto\n" +
                         "Tercera línea de texto";
        
        System.out.println("Creando archivo...");
        boolean resultado = manager.createFile(contenido);
        
        new Scanner(System.in).nextLine();

        if (resultado) {
            System.out.println("Archivo creado exitosamente");
            
            System.out.println("Leyendo archivo...");
            String contenidoLeido = manager.readFile();
            if (contenidoLeido != null) {
                System.out.println("Contenido del archivo:");
                System.out.println(contenidoLeido);
            }
        } else {
            System.out.println("Error al crear el archivo");
        }
    }
}