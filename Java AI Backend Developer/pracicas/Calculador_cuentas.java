import java.util.Scanner;

public class Calculador_cuentas {
    public static void main(String[] args) { 
        String nombre = "";
        Double factura = 0.0;
        Integer personas = 0;
        Integer propina = 0;
        Integer total = 0;
        Integer individual = 0;
        
        System.out.println("Bienvenido al calculador de cuentas");
        
        Scanner captura = new Scanner(System.in);
        System.out.print("Ingrese su nombre: ");
        nombre = captura.nextLine();
        System.out.print("Ingrese el monto de la factura: ");
        factura = captura.nextDouble();
        System.out.print("Ingrese el número de personas: ");
        personas = captura.nextInt();
        System.out.print("Ingrese el porcentaje de propina: ");
        propina = captura.nextInt();

        total = (int) (factura + (factura * propina / 100));
        individual = (int)(total / personas);

        if (total >= 100000) {
            System.out.println("Cuenta alta: $" + total);
            System.out.println("El total a pagar por persona es: $" + individual);
            System.out.println("Valor de la propina: $" + (total - factura));
            captura.close();
        } else {
            System.out.println("Cuenta baja: " + total);
            System.out.println("El total a pagar por persona es: $" + individual);
            System.out.println("Valor de la propina: $" + (total - factura));
            captura.close();
        }
    
    }
}

