package logica;

import java.util.ArrayList;
import java.util.Scanner;

public class Album {
    private String nombre;
    private String artistas;
    private String anioLanzamiento;
    private String disquera;
    private ArrayList<Cancion> canciones;

    public Album(String nombre, String artistas, String añoLanzamiento, String disquera) {
        this.nombre = nombre;
        this.artistas = artistas;
        this.anioLanzamiento = añoLanzamiento;
        this.disquera = disquera;
        canciones = new ArrayList<>();
    }

    public Album(){}


    @Override
    public String toString() {
        return "Album{" +
                "disquera='" + disquera + '\'' +
                ", añoLanzamiento='" + anioLanzamiento + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    public void obtenerListaDeMusicas() {
        // Quiero mostrar las canciones
        for (Cancion cancion : canciones) {
            System.out.println(cancion);
        }
    }

    public void obtenerDuracionTotal() {
        // Quiero obtener la duración total de las canciones y sumarlas
        int minutosTotales = 0;
        int segundosTotales = 0;

        for (Cancion cancion : canciones) {
            minutosTotales+=cancion.obtenerMinutos();
            segundosTotales+=cancion.obtenerSegundos();
        }

        minutosTotales += segundosTotales/60;

        segundosTotales = segundosTotales%60;

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
    public void agregarCancion(Cancion cancion){
        if(existeCancionEnElAlbum(cancion)){
            System.out.println("La cancion: "+cancion.getTitulo()+"ya existe en el album");
            return;
        }
        canciones.add(cancion);
    }
    public Cancion llenarCancion(){
        Scanner scanner = new Scanner(System.in);
        Cancion cancion = new Cancion();
        System.out.println("Ingrese el titulo: ");
        cancion.setTitulo(scanner.nextLine());
        System.out.println("Ingrese la duracion en minutos: ");
        cancion.setDuracionMinutos(scanner.nextInt());
        System.out.println("Ingrese la duracion en segundos: ");
        cancion.setDuracionSegundos(scanner.nextInt());
        return cancion;
    }
    public void registrarCancion(){
        Cancion cancion = llenarCancion();
        agregarCancion(cancion);
    }



    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }
}
