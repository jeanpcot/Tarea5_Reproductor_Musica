package logica;

import java.util.Arrays;

/**
 * Esta clase representa una Canción en el sistema.
 * Una Canción tiene un título y una duración (en minutos y segundos).
 */
public class Cancion {
    private String titulo; // El título de la Canción
    private int[] duracion; // La duración de la Canción en {minutos, segundos}

    /**
     * Constructor para la clase Cancion.
     *
     * @param titulo   El título de la Canción.
     * @param duracion La duración de la Canción en {minutos, segundos}.
     */
    public Cancion(String titulo, int[] duracion) {
        this.titulo = titulo;
        this.duracion = duracion;
    }

    /**
     * Método para establecer el título de la Canción.
     *
     * @param titulo El nuevo título de la Canción.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Método para establecer los minutos de duración de la Canción.
     *
     * @param duracionMinutos Los nuevos minutos de duración de la Canción.
     */
    public void setDuracionMinutos(int duracionMinutos) {
        this.duracion[0] = duracionMinutos;
    }

    /**
     * Método para establecer los segundos de duración de la Canción.
     *
     * @param duracionSegundos Los nuevos segundos de duración de la Canción.
     */
    public void setDuracionSegundos(int duracionSegundos) {
        this.duracion[1] = duracionSegundos;
    }

    /**
     * Constructor vacío para la clase Cancion.
     */
    public Cancion() {
    }

    /**
     * Método para obtener el título de la Canción.
     *
     * @return El título de la Canción.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Método para obtener los minutos de duración de la Canción.
     *
     * @return Los minutos de duración de la Canción.
     */
    public int obtenerMinutos() {
        return duracion[0];
    }

    /**
     * Método para obtener los segundos de duración de la Canción.
     *
     * @return Los segundos de duración de la Canción.
     */
    public int obtenerSegundos() {
        return duracion[1];
    }

    /**
     * Método para representar la Canción como una cadena de texto.
     *
     * @return Una representación en cadena de texto de la Canción.
     */
    @Override
    public String toString() {
        return "Cancion{" +
                "titulo='" + titulo + '\'' +
                ", duracion {minutos,segundos}=" + Arrays.toString(duracion) +
                '}';
    }
}
