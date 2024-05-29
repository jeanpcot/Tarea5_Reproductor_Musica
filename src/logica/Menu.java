import logica.Album;
import logica.Cancion;
import logica.Usuario;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private Usuario usuario;
    private Scanner scanner;

    public Menu(Usuario usuario, Scanner scanner) {
        this.usuario = usuario;
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
                        Album albumCreado = usuario.crearAlbum(scanner);
                        usuario.agregarAlbum(albumCreado);
                        System.out.println("Álbum creado exitosamente!");
                        break;
                    case 2:
                        ArrayList<Album> albumes = usuario.getAlbums();
                        Album.mostrarAlbumes(albumes);
                        System.out.println("Elija el álbum en que va a agregar la música (ingrese el número del álbum):");
                        int numeroAlbum = scanner.nextInt();
                        scanner.nextLine();
                        if (numeroAlbum > 0 && numeroAlbum <= albumes.size()) {
                            Album albumSeleccionado = albumes.get(numeroAlbum - 1);
                            albumSeleccionado.registrarCancion();
                        } else {
                            System.out.println("Número de álbum inválido.");
                        }
                        break;
                    case 3:
                        albumes = usuario.getAlbums();
                        Album.mostrarAlbumes(albumes);
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
                        usuario.listarAlbumsPorAnio(año);
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
}
