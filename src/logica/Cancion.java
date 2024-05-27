package logica;

import java.util.Arrays;

public class Cancion {
    private String titulo;
    private int[] duracion;

    public Cancion(String titulo, int[] duracion) {
        this.titulo = titulo;
        this.duracion = duracion;
    }


    public int obtenerMinutos() {
        return duracion[0];
    }

    public int obtenerSegundos() {
        return duracion[1];
    }

    @Override
    public String toString() {
        return "Cancion{" +
                "titulo='" + titulo + '\'' +
                ", duracion=" + Arrays.toString(duracion) +
                '}';
    }
}
