package vista;

import logica.Album;
import logica.Cancion;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Album> albumes = new ArrayList();

    public static void main(String[] args) {
        boolean continuar = true;
        do {
            mostrarMenu();
            Scanner scanner = new Scanner(System.in);

            System.out.print("Ingrese la opción que desee:");
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 0:
                    continuar = false;
                    break;
                case 1:
                    Album albumCreado = crearAlbum(scanner);

                    albumes.add(albumCreado);

                    System.out.println("Álbum creado exitosamente!");
                    break;
                case 2:
                    mostrarAlbumes();

                    System.out.println("Elija el album en que va a agregar la música:");
                    int numeroAlbum = Integer.parseInt(scanner.nextLine());

                    Cancion cancionCreada = crearCancion(scanner);

                    Cancion cancion = new Cancion(cancionCreada.titulo(), cancionCreada.duracion());

                    albumes.get(numeroAlbum).agregarCancion(cancion);
                    break;
                case 3:
                    mostrarAlbumes();

                    System.out.println("Elija el album que desea ver sus musicas:");
                    Album albumAuxiliar = albumes.get(scanner.nextInt());

                    albumAuxiliar.obtenerListaDeMusicas();
                    albumAuxiliar.obtenerDuracionTotal();

                    break;
                case 4:
                    System.out.println("Por favor, introduce el año del álbum:");
                    String año = scanner.nextLine();

                    Album albumAux = null;

                    for (int i = 0; i < albumes.size(); i++) {
                        if (año.equals(albumes.get(i).getAño())) {
                            albumAux = albumes.get(i);
                            break;
                        }
                    }

                    if (albumAux == null) {
                        System.out.println("El album no existe");
                        break;
                    }

                    System.out.println(albumAux);

                    break;
            }
        } while (continuar);

    }

    private static Cancion crearCancion(Scanner scanner) {
        System.out.println("Por favor, introduce el título de la canción:");
        String titulo = scanner.nextLine();

        System.out.println("Por favor, introduce la duración de la canción en minutos y segundos (separados por un espacio):");
        String[] duracionStr = scanner.nextLine().split(" ");
        int[] duracion = {Integer.parseInt(duracionStr[0]), Integer.parseInt(duracionStr[1])};
        Cancion cancionCreada = new Cancion(titulo, duracion);
        return cancionCreada;
    }

    private record Cancion(String titulo, int[] duracion) {
    }

    private static void mostrarAlbumes() {
        for (int i = 0; i < albumes.size(); i++) {
            System.out.println(albumes.get(i).toString());
        }
    }

    private static Album crearAlbum(Scanner scanner) {
        System.out.println("Por favor, introduce el nombre del álbum:");
        String nombre = scanner.nextLine();

        System.out.println("Por favor, introduce los artistas del álbum (separados por comas):");
        String[] artistas = scanner.nextLine().split(",");

        System.out.println("Por favor, introduce el año de lanzamiento del álbum:");
        String añoLanzamiento = scanner.nextLine();

        System.out.println("Por favor, introduce la disquera del álbum:");
        String disquera = scanner.nextLine();
        Album albumCreado = new Album(nombre, artistas, añoLanzamiento, disquera);
        return albumCreado;
    }

    private record Album(String nombre, String[] artistas, String añoLanzamiento, String disquera) {
    }

    private static void mostrarMenu() {
        System.out.println("""
                Opciones:
                    1. Agregar album
                    2. Agregar musica
                    3. Listar musicas de un album
                    4. Buscar album por año
                    0. Salir
                """);
    }
}