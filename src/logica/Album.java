package logica;

import java.util.ArrayList;

public class Album {
    private String nombre;
    private String[] artistas;
    private String añoLanzamiento;
    private String disquera;
    private ArrayList<Cancion> canciones;

    public Album(String nombre, String[] artistas, String añoLanzamiento, String disquera) {
        this.nombre = nombre;
        this.artistas = artistas;
        this.añoLanzamiento = añoLanzamiento;
        this.disquera = disquera;
        canciones = new ArrayList<>();
    }

    public Album(){}


    @Override
    public String toString() {
        return "Album{" +
                "disquera='" + disquera + '\'' +
                ", añoLanzamiento='" + añoLanzamiento + '\'' +
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

        return añoLanzamiento;
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

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }
}
