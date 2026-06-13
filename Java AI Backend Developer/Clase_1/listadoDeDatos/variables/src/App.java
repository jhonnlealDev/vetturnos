import java.util.Scanner;
import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        
        String nombres;

        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese sus nombres: ");
        nombres = entrada.nextLine();
        System.out.println("Hola " + nombres + ", bienvenido a Java");
        entrada.close();
        JOptionPane.showMessageDialog(null, "Hola " + nombres + ", bienvenido a Java");
    }
}
