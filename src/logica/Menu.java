import logica.Album;
import logica.Cancion;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private ArrayList<Album> albumes;
    private Scanner scanner;

    public Menu(ArrayList<Album> albumes, Scanner scanner) {
        this.albumes = albumes;
        this.scanner = scanner;
    }

    public void mostrarMenu() {
        System.out.println("""
                Opciones:
                    1. Agregar álbum
                    2. Agregar música
                    3. Listar músicas de un álbum
                    4. Buscar álbum por año
                    0. Salir
                """);
    }

    public void ejecutarMenu() {
        boolean continuar = true;
        while (continuar) {
            mostrarMenu();
            try {
                System.out.print("Ingrese la opción que desee: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();
                switch (opcion) {
                    case 0:
                        continuar = false;
                        break;
                    case 1:
                        Album albumCreado = crearAlbum();
                        albumes.add(albumCreado);
                        System.out.println("Álbum creado exitosamente!");
                        break;
                    case 2:
                        mostrarAlbumes();
                        System.out.println("Elija el álbum en que va a agregar la música (ingrese el número del álbum):");
                        int numeroAlbum = scanner.nextInt();
                        scanner.nextLine();
                        if (numeroAlbum > 0 && numeroAlbum <= albumes.size()) {
                            Cancion cancionCreada = crearCancion();
                            albumes.get(numeroAlbum - 1).agregarCancion(cancionCreada);
                            System.out.println("Canción agregada exitosamente!");
                        } else {
                            System.out.println("Número de álbum inválido.");
                        }
                        break;
                    case 3:
                        mostrarAlbumes();
                        System.out.println("Elija el álbum que desea ver sus músicas (ingrese el número del álbum):");
                        int numeroAlbumConsulta = scanner.nextInt();
                        scanner.nextLine();
                        if (numeroAlbumConsulta > 0 && numeroAlbumConsulta <= albumes.size()) {
                            Album albumAuxiliar = albumes.get(numeroAlbumConsulta - 1);
                            albumAuxiliar.obtenerListaDeMusicas();
                            albumAuxiliar.obtenerDuracionTotal();
                        } else {
                            System.out.println("Número de álbum inválido.");
                        }
                        break;
                    case 4:
                        System.out.println("Por favor, introduce el año del álbum:");
                        String año = scanner.nextLine();
                        Album albumAux = null;
                        for (Album album : albumes) {
                            if (año.equals(album.getAño())) {
                                albumAux = album;
                                break;
                            }
                        }
                        if (albumAux == null) {
                            System.out.println("El álbum no existe");
                        } else {
                            System.out.println(albumAux);
                        }
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, ingrese un número válido del menú.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Opción no válida. Por favor, ingrese un número válido del menú.");
                scanner.nextLine();
            }
        }
    }

    private Cancion crearCancion() {
        System.out.println("Por favor, introduce el título de la canción:");
        String titulo = scanner.nextLine();
        System.out.println("Por favor, introduce la duración de la canción en minutos y segundos (separados por un espacio):");
        String[] duracionStr = scanner.nextLine().split(" ");
        int[] duracion = {Integer.parseInt(duracionStr[0]), Integer.parseInt(duracionStr[1])};
        return new Cancion(titulo, duracion);
    }

    private void mostrarAlbumes() {
        for (int i = 0; i < albumes.size(); i++) {
            System.out.println((i + 1) + ". " + albumes.get(i).toString());
        }
    }

    private Album crearAlbum() {
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
}
