package logica;

import java.util.ArrayList;
import java.util.Scanner;

public class Album {
    private String nombre;
    private String artistas;
    private String anioLanzamiento;
    private String disquera;
    private ArrayList<Cancion> canciones;

    public Album(String nombre, String artistas, String anioLanzamiento, String disquera) {
        this.nombre = nombre;
        this.artistas = artistas;
        this.anioLanzamiento = anioLanzamiento;
        this.disquera = disquera;
        this.canciones = new ArrayList<>();
    }

    public Album() {}

    @Override
    public String toString() {
        return "Album { " +
                "disquera='" + disquera + '\'' +
                ", añoLanzamiento='" + anioLanzamiento + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    public void obtenerListaDeMusicas() {
        for (Cancion cancion : canciones) {
            System.out.println(cancion);
        }
    }

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

    public String getAño() {
        return anioLanzamiento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setArtistas(String artistas) {
        this.artistas = artistas;
    }

    public void setAnioLanzamiento(String anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }

    public void setDisquera(String disquera) {
        this.disquera = disquera;
    }

    public boolean existeCancionEnElAlbum(Cancion cancion) {
        for (Cancion c : this.getCanciones()) {
            if (c.getTitulo().equalsIgnoreCase(cancion.getTitulo())) {
                return true; // Si existe no se agrega
            }
        }
        return false; // La canción no existe en el album
    }

    public void agregarCancion(Cancion cancion) {
        if (existeCancionEnElAlbum(cancion)) {
            return;
        }
        canciones.add(cancion);
    }

    public Cancion crearCancion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, introduce el título de la canción:");
        String titulo = scanner.nextLine();
        System.out.println("Por favor, introduce la duración de la canción en minutos y segundos (separados por un espacio):");
        String[] duracionStr = scanner.nextLine().split(" ");
        int[] duracion = {Integer.parseInt(duracionStr[0]), Integer.parseInt(duracionStr[1])};
        return new Cancion(titulo, duracion);
    }

    public void registrarCancion() {
        Cancion cancion = crearCancion();

        if (existeCancionEnElAlbum(cancion)) {
            System.out.println("La canción: " + cancion.getTitulo() + " ya existe en el álbum");
            return;
        }

        agregarCancion(cancion);
        System.out.println("Canción agregada exitosamente!");
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public static void mostrarAlbumes(ArrayList<Album> albumes) {
        for (int i = 0; i < albumes.size(); i++) {
            System.out.println((i + 1) + ". " + albumes.get(i).toString());
        }
    }
}
