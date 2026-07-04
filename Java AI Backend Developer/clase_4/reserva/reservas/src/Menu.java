public class Menu {
    public static int leerOpcion() {
        System.out.print("Elige una opción: ");
        return App.scanner.nextInt(); 
    }

    public static void mostrarMenu() {
        System.out.println("\n--- MARTA PELUQUERÍA ---");
        System.out.println("1. Agendar una reserva");
        System.out.println("2. Listar todas las reservas");
        System.out.println("3. Editar una reserva");
        System.out.println("4. Cancelar una reserva");
        System.out.println("5. Ver reporte del día");
        System.out.println("6. Salir");
        System.out.print("Elige una opción: ");
    }

    // Método para leer la opción del usuario
    public static int leerOpcion(java.util.Scanner sc) {
        return sc.nextInt();
    }
}
