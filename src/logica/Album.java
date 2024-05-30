package logica;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Esta clase representa un Álbum en el sistema.
 * Un Álbum tiene un nombre, artistas, año de lanzamiento, disquera y una lista de Canciones.
 */
public class Album {
    private String nombre; // El nombre del Álbum
    private String artistas; // Los artistas del Álbum
    private String anioLanzamiento; // El año de lanzamiento del Álbum
    private String disquera; // La disquera del Álbum
    private ArrayList<Cancion> canciones; // La lista de Canciones del Álbum

    /**
     * Constructor para la clase Album.
     *
     * @param nombre          El nombre del Álbum.
     * @param artistas        Los artistas del Álbum.
     * @param anioLanzamiento El año de lanzamiento del Álbum.
     * @param disquera        La disquera del Álbum.
     */
    public Album(String nombre, String artistas, String anioLanzamiento, String disquera) {
        this.nombre = nombre;
        this.artistas = artistas;
        this.anioLanzamiento = anioLanzamiento;
        this.disquera = disquera;
        this.canciones = new ArrayList<>();
    }

    /**
     * Constructor vacío para la clase Album.
     */
    public Album() {
    }

    /**
     * Método para representar el Álbum como una cadena de texto.
     *
     * @return Una representación en cadena de texto del Álbum.
     */
    @Override
    public String toString() {
        return "Album { " +
                "disquera='" + disquera + '\'' +
                ", añoLanzamiento='" + anioLanzamiento + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    /**
     * Método para obtener la lista de Canciones del Álbum.
     * Recorre la lista de canciones y las imprime una por una.
     */
    public void obtenerListaDeMusicas() {
        for (Cancion cancion : canciones) {
            System.out.println(cancion);
        }
    }

    /**
     * Método para obtener la duración total del Álbum.
     * Recorre la lista de canciones y suma los minutos y segundos de cada canción.
     * Luego, convierte los segundos totales a minutos y segundos.
     */
    public void obtenerDuracionTotal() {
        int minutosTotales = 0;
        int segundosTotales = 0;

        for (Cancion cancion : canciones) {
            minutosTotales += cancion.obtenerMinutos();
            segundosTotales += cancion.obtenerSegundos();
        }

        minutosTotales += segundosTotales / 60;
        segundosTotales = segundosTotales % 60;

        System.out.println("Minutos: " + minutosTotales);
        System.out.println("Segundos: " + segundosTotales);
    }

    /**
     * Método para obtener el año de lanzamiento del Álbum.
     *
     * @return El año de lanzamiento del Álbum.
     */
    public String getAnio() {
        return anioLanzamiento;
    }

    /**
     * Método para establecer el nombre del Álbum.
     *
     * @param nombre El nuevo nombre del Álbum.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para establecer los artistas del Álbum.
     *
     * @param artistas Los nuevos artistas del Álbum.
     */
    public void setArtistas(String artistas) {
        this.artistas = artistas;
    }

    /**
     * Método para establecer el año de lanzamiento del Álbum.
     *
     * @param anioLanzamiento El nuevo año de lanzamiento del Álbum.
     */
    public void setAnioLanzamiento(String anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }

    /**
     * Método para establecer la disquera del Álbum.
     *
     * @param disquera La nueva disquera del Álbum.
     */
    public void setDisquera(String disquera) {
        this.disquera = disquera;
    }

    /**
     * Método para verificar si una Canción existe en el Álbum.
     * Recorre la lista de canciones y compara el título de cada canción con el título de la canción dada.
     * Utiliza el método equalsIgnoreCase de la clase String para hacer la comparación sin tener en cuenta las mayúsculas y minúsculas.
     *
     * @param cancion La Canción a verificar.
     * @return Verdadero si la Canción existe en el Álbum, falso en caso contrario.
     * @see String
     */
    public boolean existeCancionEnElAlbum(Cancion cancion) {
        for (Cancion c : this.getCanciones()) {
            if (c.getTitulo().equalsIgnoreCase(cancion.getTitulo())) {
                return true; // Si existe no se agrega
            }
        }
        return false; // La canción no existe en el album
    }

    /**
     * Método para agregar una Canción al Álbum.
     * Verifica si la Canción ya existe en el Álbum antes de agregarla.
     *
     * @param cancion La Canción a agregar.
     */
    public void agregarCancion(Cancion cancion) {
        if (existeCancionEnElAlbum(cancion)) {
            return;
        }
        canciones.add(cancion);
    }

    /**
     * Método para crear una Canción.
     * Pide al usuario que introduzca el título y la duración de la Canción.
     *
     * @param scanner Objeto Scanner para la entrada del usuario.
     * @return La Canción creada.
     */
    public Cancion crearCancion(Scanner scanner) {
        System.out.println("Por favor, introduce el título de la canción:");
        String titulo = scanner.nextLine();
        System.out.println("Por favor, introduce la duración de la canción en minutos y segundos (separados por un espacio):");
        String[] duracionStr = scanner.nextLine().split(" ");
        int[] duracion = {Integer.parseInt(duracionStr[0]), Integer.parseInt(duracionStr[1])};
        return new Cancion(titulo, duracion);
    }

    /**
     * Método para registrar una Canción en el Álbum.
     * Crea una Canción y verifica si ya existe en el Álbum antes de agregarla.
     *
     * @param scanner Objeto Scanner para la entrada del usuario.
     */
    public void registrarCancion(Scanner scanner) {
        Cancion cancion = crearCancion(scanner);

        if (existeCancionEnElAlbum(cancion)) {
            System.out.println("La canción: " + cancion.getTitulo() + " ya existe en el álbum");
            return;
        }

        agregarCancion(cancion);
        System.out.println("Canción agregada exitosamente!");
    }

    /**
     * Método para obtener la lista de Canciones del Álbum.
     *
     * @return La lista de Canciones del Álbum.
     */
    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

}
