package logica;

import java.util.Scanner;

public class Usuario {
    private String nombre;
    private Biblioteca biblioteca;
    public Usuario(String nombre) {
        this.nombre = nombre;
        this.biblioteca = new Biblioteca();
    }

   public void registrarAlbum(Scanner scanner){
        this.biblioteca.registrarAlbum(scanner);
   }
   public void registrarCancion(Scanner scanner){
        this.biblioteca.agregarCanciones(scanner);
   }
    public void verListaCanciones(Scanner scanner){
        this.biblioteca.listarCancionesDeAlbum(scanner);
    }
    public void listarAlbumsPorAnio(Scanner scanner){
        System.out.println("Ingresa el año para buscar los albums: ");
        String anio = scanner.nextLine();
        this.biblioteca.listarAlbumsPorAnio(anio);
    }

}
