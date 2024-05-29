import logica.Album;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Album> albumes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(albumes, scanner);
        menu.ejecutarMenu();
        scanner.close();
    }
}
