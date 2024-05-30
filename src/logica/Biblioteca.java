package logica;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Esta clase representa una Biblioteca en el sistema.
 * Una Biblioteca tiene una lista de Álbumes.
 */
public class Biblioteca {
    private ArrayList<Album> albums; // La lista de Álbumes en la Biblioteca

    /**
     * Constructor para la clase Biblioteca.
     * Inicializa la lista de Álbumes.
     */
    public Biblioteca() {
        this.albums = new ArrayList<>();
    }

    /**
     * Método para agregar un Álbum a la Biblioteca.
     *
     * @param album El Álbum a agregar.
     */
    public void agregarAlbum(Album album) {
        this.albums.add(album);
    }

    /**
     * Método para crear un Álbum.
     * Pide al usuario que introduzca el nombre, los artistas, el año de lanzamiento y la disquera del Álbum.
     *
     * @param scanner Objeto Scanner para la entrada del usuario.
     * @return El Álbum creado.
     */
    public Album crearAlbum(Scanner scanner) {
        System.out.println("Por favor, introduce el nombre del álbum:");
        String nombre = scanner.nextLine();
        System.out.println("Por favor, introduce los artistas del álbum (separados por comas):");
        String artistas = scanner.nextLine();
        System.out.println("Por favor, introduce el año de lanzamiento del álbum:");
        String añoLanzamiento = scanner.nextLine();
        System.out.println("Por favor, introduce la disquera del álbum:");
        String disquera = scanner.nextLine();
        return new Album(nombre, artistas, añoLanzamiento, disquera);
    }

    /**
     * Método para registrar un Álbum en la Biblioteca.
     * Crea un Álbum y lo agrega a la Biblioteca.
     *
     * @param scanner Objeto Scanner para la entrada del usuario.
     */
    public void registrarAlbum(Scanner scanner) {
        Album album = this.crearAlbum(scanner);
        this.agregarAlbum(album);
    }

    /**
     * Método para listar todos los Álbumes en la Biblioteca de un año específico.
     * Recorre la lista de Álbumes y muestra los que coinciden con el año solicitado.
     * Si no se encuentran Álbumes para el año solicitado, muestra un mensaje.
     *
     * @param anioSolicitado El año solicitado.
     */
    public void listarAlbumsPorAnio(String anioSolicitado) {
        boolean encontrado = false;
        for (Album album : albums) {
            if (album.getAnio().equalsIgnoreCase(anioSolicitado)) {
                System.out.println(album);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron álbumes para el año " + anioSolicitado);
        }
    }

    /**
     * Método para listar las Canciones de un Álbum específico en la Biblioteca.
     * Muestra la lista de Álbumes y pide al usuario que seleccione uno.
     * Luego, muestra la lista de Canciones del Álbum seleccionado y su duración total.
     *
     * @param scanner Objeto Scanner para la entrada del usuario.
     */
    public void listarCancionesDeAlbum(Scanner scanner) {
        mostrarAlbum();
        int index = scanner.nextInt();
        scanner.nextLine();
        this.albums.get(index).obtenerListaDeMusicas();
        this.albums.get(index).obtenerDuracionTotal();
    }

    /**
     * Método para agregar Canciones a un Álbum específico en la Biblioteca.
     * Muestra la lista de Álbumes y pide al usuario que seleccione uno.
     * Luego, registra una Canción en el Álbum seleccionado.
     *
     * @param scanner Objeto Scanner para la entrada del usuario.
     */
    public void agregarCanciones(Scanner scanner) {
        mostrarAlbum();
        int index = scanner.nextInt();
        scanner.nextLine();
        Album album = this.albums.get(index);
        album.registrarCancion(scanner);
    }

    /**
     * Método para mostrar la lista de Álbumes en la Biblioteca.
     * Recorre la lista de Álbumes y los muestra uno por uno.
     */
    public void mostrarAlbum() {
        int i = 0;
        for (Album album : albums) {
            System.out.println(i + ". " + album);
            i++;
        }
    }
}
