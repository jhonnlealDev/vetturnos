import java.util.Scanner;

public class Ciclos {
    public static void main(String[] args) {
            for (int i = 0; i < 5; i++) {
                System.out.println("Valor de i: " + " Vuelta " + (i+1));
            }

            int ciclosPendientes = 3;
            while (ciclosPendientes > 0) {
                System.out.println("Ciclos pendientes: " + ciclosPendientes);
                
                // frenar ciclo -- crtl + c para frenar el ciclo en caso de que se vuelva infinito
                ciclosPendientes--;
            }
            System.out.println("¡Ciclos completados!");

            Scanner scanner = new Scanner(System.in);
            int numero;
            do {
                System.out.print("Ingrese un número positivo (o 10 para salir): ");
                numero = scanner.nextInt();
                
                System.out.println("Número ingresado: " + numero);
                System.out.println("¡Sigue ingresando números positivos!"); 
                numero = scanner.nextInt();
            } while (numero >= 10);

            System.out.println("¡Programa terminado!");

        }
}
