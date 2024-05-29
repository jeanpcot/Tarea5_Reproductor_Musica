package logica;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
    private String nombre;
    private static ArrayList<Album> albums;
    public Usuario(String nombre) {
        this.nombre = nombre;
        this.albums = new ArrayList<>();
    }

    public void agregarAlbum(Album album) {
        this.albums.add(album);
    }

    public static Album crearAlbum(Scanner scanner) {
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

    public static void listarAlbumsPorAnio(String anioSolicitado){
        boolean encontrado = false;
        for (Album album : albums) {
            if (album.getAño().equalsIgnoreCase(anioSolicitado)) {
                System.out.println(album);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron álbumes para el año " + anioSolicitado);
        }
    }
}
