package archivos.crudBasico;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

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

    public static void main(String[] args) {
        FileManager manager = new FileManager("ejemplo.txt");
        
        String contenido = "Primera línea de texto\n" +
                         "Segunda línea de texto\n" +
                         "Tercera línea de texto";
        
        boolean resultado = manager.createFile(contenido);
        if (resultado) {
            System.out.println("Archivo creado exitosamente");
        } else {
            System.out.println("Error al crear el archivo");
        }
    }
}