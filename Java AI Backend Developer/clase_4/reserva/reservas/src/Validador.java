public class Validador {


    public static boolean horaValida(int hora){
         return hora >= 0 && hora <= 23;
    }    

    public static boolean nombreValido(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }

    public static boolean servicioValido(int servicio) {
        return servicio >= 1 && servicio <= 4;
    }

    public static boolean esHoraOcupada(int horaDeseada) {
        for (int i = 0; i < Operaciones.contadorReservas; i++) {
            if (Operaciones.horas[i] == horaDeseada) {
                return true;
            }
        }
        return false;
    }
}
