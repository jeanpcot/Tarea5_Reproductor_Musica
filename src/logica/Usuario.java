package logica;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
    private String nombre;
    private ArrayList<Album> albums;
    public Usuario(String nombre) {
        this.nombre = nombre;
        this.albums = new ArrayList<>();
    }
    public void agregarAlbum(Album album) {
        this.albums.add(album);
    }
    public Album llenarAlbum(){
        Scanner scanner = new Scanner(System.in);
        Album album = new Album();
        System.out.println("Ingresa el nombre: ");
        album.setNombre(scanner.nextLine());
        System.out.println("Ingresa el artista/as: ");
        album.setArtistas(scanner.nextLine());
        System.out.println("Ingresa el año de lanzamiento: ");
        album.setAnioLanzamiento(scanner.nextLine());
        System.out.println("Ingresa la disquera: ");
        album.setDisquera(scanner.nextLine());
        scanner.close();
        return album;
    }
    public void registrarAlbum()
    {
        Album album = llenarAlbum();
        agregarAlbum(album);

    }

    public void listarAlbumsPorAnio(String anioSolicitado){
        for (Album album : albums) {
            if(album.getAño().equalsIgnoreCase(anioSolicitado)){
                System.out.println(album);
            }
        }
    }
}
