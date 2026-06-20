public class OPcciones {
    public static void main(String[] args) {
        int opciones = 1; // Ejemplo de valor, podría ser leído desde la entrada del usuario

        /*switch (opciones){
            case 1:
                System.out.println("Nuevo pedido");
                break;
            case 2:
                System.out.println("Aplicar descuento");
                break;
            case 3:
                System.out.println("Cerrar caja");
                break;
            default:
                System.out.println("Opción no válida");
        }*/
        //moderna
        switch (opciones){
            case 1 -> System.out.println("Nuevo pedido");
            case 2 -> System.out.println("Aplicar descuento");
            case 3 -> System.out.println("Cerrar caja");
            default -> System.out.println("Opción no válida");
        }
    }
}