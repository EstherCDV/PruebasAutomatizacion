package model;

import lombok.Data;

@Data
public class Persona {
    private String nombre;
    private String edad;
    private String ciudad;
    private String ocupacion;

    public Persona(String nombre, String edad, String ciudad, String ocupacion) {
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
        this.ocupacion = ocupacion;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad='" + edad + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", ocupacion='" + ocupacion + '\'' +
                '}';
    }
}

