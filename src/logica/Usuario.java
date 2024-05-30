package logica;

import java.util.Scanner;

/**
 * Esta clase representa un Usuario en el sistema.
 * Un Usuario tiene un nombre y una Biblioteca de Álbumes y Canciones.
 */
public class Usuario {
    private String nombre; // El nombre del Usuario
    private Biblioteca biblioteca; // La Biblioteca del Usuario de Álbumes y Canciones

    /**
     * Constructor para la clase Usuario.
     *
     * @param nombre El nombre del Usuario.
     */
    public Usuario(String nombre) {
        this.nombre = nombre;
        this.biblioteca = new Biblioteca();
    }

    /**
     * Método para registrar un Álbum en la Biblioteca del Usuario.
     *
     * @param scanner Objeto Scanner para la entrada del usuario.
     */
    public void registrarAlbum(Scanner scanner) {
        this.biblioteca.registrarAlbum(scanner);
    }

    /**
     * Método para registrar una Canción en la Biblioteca del Usuario.
     *
     * @param scanner Objeto Scanner para la entrada del usuario.
     */
    public void registrarCancion(Scanner scanner) {
        this.biblioteca.agregarCanciones(scanner);
    }

    /**
     * Método para ver la lista de Canciones en un Álbum en la Biblioteca del Usuario.
     *
     * @param scanner Objeto Scanner para la entrada del usuario.
     */
    public void verListaCanciones(Scanner scanner) {
        this.biblioteca.listarCancionesDeAlbum(scanner);
    }

    /**
     * Método para listar todos los Álbumes en la Biblioteca del Usuario de un año específico.
     *
     * @param scanner Objeto Scanner para la entrada del usuario.
     */
    public void listarAlbumsPorAnio(Scanner scanner) {
        System.out.println("Ingresa el año para buscar los albums: ");
        String anio = scanner.nextLine();
        this.biblioteca.listarAlbumsPorAnio(anio);
    }
}
