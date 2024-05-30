package logica;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    private ArrayList<Album> albums;
    public Biblioteca() {
        this.albums = new ArrayList<>();
    }
    public void agregarAlbum(Album album) {
        this.albums.add(album);
    }
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
    public void registrarAlbum(Scanner scanner) {
        Album album = this.crearAlbum(scanner);
        this.agregarAlbum(album);
    }
    public void listarAlbumsPorAnio(String anioSolicitado){
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

    public void listarCancionesDeAlbum(Scanner scanner) {
        mostrarAlbum();
        int index = scanner.nextInt();
        scanner.nextLine();
        this.albums.get(index).obtenerListaDeMusicas();
        this.albums.get(index).obtenerDuracionTotal();
    }
    public void agregarCanciones(Scanner scanner){
        mostrarAlbum();
        int index = scanner.nextInt();
        scanner.nextLine();
        Album album = this.albums.get(index);
        album.registrarCancion(scanner);
    }
    public void mostrarAlbum(){
        int i = 0;
        for (Album album : albums) {
            System.out.println(i+". "+album);
            i++;
        }
    }
}
