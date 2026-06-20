public class condicional {
    //psvm
    public static void main(String[] args) {
        double cuenta = 120000;

        /*if (cuenta > 100000) {
            System.out.println("Aplica descuento");
        }else {
            System.out.println("No aplica descuento");
        }*/

        if (cuenta >= 200000) {
            System.out.println("Aplica descuento VIP");
        } else if (cuenta > 100000) {
            System.out.println("Aplica descuento 10%");
        } else {
            System.out.println("No aplica descuento");
        }
    }
}
