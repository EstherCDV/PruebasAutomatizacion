package test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Persona;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CP_001 {

    @Test
    public void test() throws IOException {
        File file = new File("C:\\Users\\MRROPEJM\\Downloads\\datos_personas.csv");
        List<Persona> personas = new ArrayList<>();
        String[] colums = {"Nombre", "Edad", "Ciudad", "Ocupaci�n"};
        int numeroColumnas = 4;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            line = reader.readLine();
            if (line != null) {
                String[] columnas = line.split(",");
                for (int i = 0; i < columnas.length; i++) {
                    assertEquals(colums[i], columnas[i]);
                    assertEquals(numeroColumnas, columnas.length);
                }
            }
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String nombre = parts[0];
                String edad = parts[1];
                String ciudad = parts[2];
                String ocupacion = parts[3];
                personas.add(new Persona(nombre, edad, ciudad, ocupacion));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(personas);
        System.out.println(json);
    }
}
