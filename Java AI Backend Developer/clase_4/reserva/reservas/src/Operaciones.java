
public class Operaciones {
    public static final int CUPO_MAXIMO = 10; 

    public static String[] clientes = new String[CUPO_MAXIMO];
    public static int[] horas = new int[CUPO_MAXIMO];
    public static int[] servicios = new int[CUPO_MAXIMO];

    public static int contadorReservas = 0;

    public static void agendar() {
        if (contadorReservas >= CUPO_MAXIMO) {
            System.out.println("Lo siento, ya no quedan cupos por hoy.");
            return; 
        }

        System.out.print("Nombre del cliente: ");
        String nombre = App.scanner.next(); 
        if (!Validador.nombreValido(nombre)) {
            System.out.println("Error: El nombre no puede estar vacío.");
            return;
        }

        System.out.print("Hora (8-17): ");
        int hora = App.scanner.nextInt();
        if (!Validador.horaValida(hora)) {
            System.out.println("Error: Hora fuera de rango.");
            return;
        }

        if (Validador.esHoraOcupada(hora)) {
            System.out.println("Error: Esa hora ya está ocupada.");
            return;
        }

        System.out.println("Servicios: 1. Corte ($25.000), 2. Tinte ($60.000), 3. Manicure ($30.000)");
        System.out.print("Elige una opción: ");
        int servicio = App.scanner.nextInt();
        if (!Validador.servicioValido(servicio)) {
            System.out.println("Error: Servicio inválido.");
            return;
        }

        clientes[contadorReservas] = nombre;
        horas[contadorReservas] = hora;
        servicios[contadorReservas] = servicio;

        contadorReservas++;
        
        System.out.println("¡Reserva agendada con éxito!");
    }

    public static void listar() {
    if (contadorReservas == 0) {
        System.out.println("\nNo hay reservas registradas por el momento.");
        return;
    }

        System.out.println("\n--- LISTADO DE RESERVAS ---");
        for (int i = 0; i < contadorReservas; i++) {
            // Obtenemos el nombre del servicio basándonos en el número guardado
            String nombreServicio = obtenerNombreServicio(servicios[i]);
            
            System.out.println((i + 1) + ". Cliente: " + clientes[i] + 
                            " | Hora: " + horas[i] + ":00" + 
                            " | Servicio: " + nombreServicio);
        }
    }


    private static String obtenerNombreServicio(int id) {
        switch (id) {
            case 1: return "Corte";
            case 2: return "Tinte";
            case 3: return "Manicure";
            default: return "Desconocido";
        }
    }

    public static void cancelar() {
            if (contadorReservas == 0) {
                System.out.println("No hay reservas para cancelar.");
                return;
            }

            listar();
            System.out.print("\nNúmero de reserva a cancelar: ");
            int num = App.scanner.nextInt();

            if (num < 1 || num > contadorReservas) {
                System.out.println("Número de reserva inválido.");
                return;
            }

            int indiceACancelar = num - 1;

            for (int i = indiceACancelar; i < contadorReservas - 1; i++) {
                clientes[i] = clientes[i + 1];
                horas[i] = horas[i + 1];
                servicios[i] = servicios[i + 1];
            }

            contadorReservas--;
            System.out.println("Reserva cancelada con éxito.");
        }

    public static void reporte() {
        if (contadorReservas == 0) {
            System.out.println("\nNo hay reservas registradas. Total facturado: $0");
            return;
        }

        double total = 0;
        System.out.println("\n--- REPORTE DEL DÍA ---");
        
        for (int i = 0; i < contadorReservas; i++) {
            double precio = obtenerPrecio(servicios[i]);
            total += precio;
            System.out.println("Reserva " + (i + 1) + ": $" + precio);
        }
        
        System.out.println("-------------------------");
        System.out.println("Total facturado: $" + total);
    }

    private static double obtenerPrecio(int idServicio) {
        switch (idServicio) {
            case 1: return 25000;
            case 2: return 60000;
            case 3: return 30000;
            default: return 0;
        }
    }

    public static void editarReserva() {
        if (contadorReservas == 0) {
            System.out.println("No hay reservas para editar.");
            return;
        }

    listar();
        System.out.print("\nNúmero de reserva a modificar: ");
        int num = App.scanner.nextInt();

        if (num < 1 || num > contadorReservas) {
            System.out.println("Reserva no encontrada.");
            return;
        }

        int indice = num - 1;

        System.out.print("Nueva hora (8-17): ");
        int nuevaHora = App.scanner.nextInt();

        if (!Validador.horaValida(nuevaHora)) {
            System.out.println("Hora no permitida.");
        } else if (Validador.esHoraOcupada(nuevaHora)) {
            System.out.println("¡Error! Esa hora ya está ocupada por otro cliente.");
        } else {
            horas[indice] = nuevaHora;
            System.out.println("Hora actualizada con éxito.");
        }
    }



}


