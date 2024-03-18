package co.edu.uptc;

import java.nio.file.Files;
import java.nio.file.Paths;
import co.edu.uptc.model.JMArray;
import co.edu.uptc.controller.JMFileReader;
import co.edu.uptc.model.JMObject;

public class Main {
    public static void main(String[] args) {
        try {
            String jsonString = new String(Files.readAllBytes(Paths.get("maigad.json")));
            JMFileReader fr = new JMFileReader();
            JMArray<JMObject> array = fr.getJMArrayfromString(jsonString);

            JMObject firstObj = array.get(1);
            JMObject adress = firstObj.getInnerJMObject("address");
            System.out.println(adress);
            
        } catch (Exception e) {
            // Maneja cualquier excepción que pueda ocurrir durante la ejecución
            e.printStackTrace();
        }
    }
}
