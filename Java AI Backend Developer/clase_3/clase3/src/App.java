import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        /*String nombre = "";*/
        System.out.print("cuantas personas en al mesa? ");
        int personas = scanner.nextInt();

        scanner.nextLine(); // Limpiar el buffer del scanner

        System.out.print("Nombre del cliente: ");
        String nombre = scanner.nextLine();

        double subtotal = 120000;
        boolean tieneCupon = true;

        boolean aplicaDescuento = subtotal > 100000 && tieneCupon;

        System.out.print("Su nombre es: " + nombre);
        System.out.print(" Aplica descuento: " + aplicaDescuento);
    }
}
