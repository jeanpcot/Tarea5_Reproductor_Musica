package logica;

import logica.Album;
import logica.Usuario;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private Usuario usuario;
    public Menu() {
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
    public void registrarse(Scanner scanner){
        System.out.println("Ingresa tu nombre: ");
        String nombre = scanner.nextLine();
        usuario = new Usuario(nombre);

    }
    public void ejecutarMenu() {
        Scanner scanner = new Scanner(System.in);
        registrarse(scanner);
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
                        scanner.close();
                        break;
                    case 1:
                        usuario.registrarAlbum(scanner);
                        break;
                    case 2:
                        usuario.registrarCancion(scanner);
                        break;
                    case 3:
                        usuario.verListaCanciones(scanner);
                        break;
                    case 4:
                        usuario.listarAlbumsPorAnio(scanner);
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, ingrese un número válido del menú.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Opción no válida. Por favor, ingrese un número válido del menú.");
                scanner.next();
            }
        }
    }
}
