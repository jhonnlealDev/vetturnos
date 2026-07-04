import java.util.Scanner;

public class App {
    // Scanner compartido y estático
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            Menu.mostrarMenu(); 
            opcion = Menu.leerOpcion(scanner); 

            switch (opcion) {
                case 1:
                    Operaciones.agendar(); // Conectado
                    break;
                case 2:
                    Operaciones.listar();  // Conectado
                    break;
                case 3:
                    Operaciones.editarReserva(); // Conectado
                    break;
                case 4:
                    Operaciones.cancelar(); // Conectado
                    break;
                case 5:
                    Operaciones.reporte(); // Conectado
                    break;
                case 6:
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6); 
        
        scanner.close();
    }
}