package logica;

import java.util.Arrays;

public class Cancion {
    private String titulo;
    private int[] duracion;

    public Cancion(String titulo, int[] duracion) {
        this.titulo = titulo;
        this.duracion = duracion;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setDuracionMinutos(int duracionMinutos) {
        this.duracion[0] = duracionMinutos;
    }
    public void setDuracionSegundos(int duracionSegundos) {
        this.duracion[1] = duracionSegundos;
    }
    public Cancion() {
    }

    public String getTitulo() {
        return titulo;
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
                ", duracion {minutos,segundos}=" + Arrays.toString(duracion) +
                '}';
    }
}
