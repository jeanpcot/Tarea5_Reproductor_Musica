import logica.Album;
import logica.Usuario;

import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Usuario usuario = new Usuario("Jose");
        Menu menu = new Menu(usuario, scanner);
        menu.ejecutarMenu();
    }
}
