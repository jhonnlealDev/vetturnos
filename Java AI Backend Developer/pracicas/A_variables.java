import java.util.Scanner;

public class A_variables {
    public static void main(String[] args){
        int edad = 0;
        double nota = 0.0;
        byte diasMes = 31; //Aproximadamente
        short diasLustro = 5;
        long añoLuz = 365;
        String nombre = "";

        
        Scanner captura = new Scanner(System.in);
        
        System.out.print("Ingrese su nombre: ");
        nombre = captura.nextLine();
        
        System.out.println("Ingrese su edad: ");
        edad = captura.nextInt();

        System.out.println("Ingrese su nota: ");
        nota = captura.nextDouble();

        System.out.println("Su nombre es: " + nombre);
        System.out.println("Su edad es: " + edad);
        System.out.println("Su nota es: " + nota);
        captura.close();
    }
}
