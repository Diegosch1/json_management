package co.edu.uptc.controller;

import java.io.FileWriter;
import java.io.IOException;

import co.edu.uptc.model.JMArray;

public class JMFileWriter {
    public static void writeToFile(String directory, String fileName, JMArray<?> jsonArray) {
        String filePath = directory + "/" + fileName + ".json";
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(jsonArray.toString());
            System.out.println("Archivo JSON creado exitosamente en: " + filePath);
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo JSON: " + e.getMessage());
        }
    }    
}
