import javax.swing.JOptionPane;

public class B_capturaVentanas {
    public static void main(String[] args) {
        String nombre = "";
        String apellido = "";
        String pais = "";
        String ciudad = "";
        String direccion = "";
        String telefono = "";

        JOptionPane.showMessageDialog(null, "Bienvenido al programa de captura de ventanas");
        nombre = JOptionPane.showInputDialog("Ingrese su nombre: ");
        apellido = JOptionPane.showInputDialog("Ingrese su apellido: ");
        pais = JOptionPane.showInputDialog("Ingrese su país: ");
        ciudad = JOptionPane.showInputDialog("Ingrese su ciudad: ");
        direccion = JOptionPane.showInputDialog("Ingrese su dirección: ");
        telefono = JOptionPane.showInputDialog("Ingrese su número de teléfono: ");
        
        JOptionPane.showMessageDialog(null, "Su nombre es: " + nombre + " " + apellido + "\n" +
                "Su país es: " + pais + "\n" +
                "Su ciudad es: " + ciudad + "\n" +
                "Su dirección es: " + direccion + "\n" +
                "Su número de teléfono es: " + telefono + "\n" +
                "Gracias por utilizar el programa de captura de ventanas");

    }
}
