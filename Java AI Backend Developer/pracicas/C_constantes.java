public class C_constantes {
    final double PI = 3.1416; //Constante para el valor de pi
    final int MAX_EDAD = 120; //Constante para la edad máxima humana
    final int IVA = 16; //Constante para el porcentaje de IVA
    final String NOMBRE_EMPRESA = "Mi Empresa S.A."; //Constante para el

    public static void main(String[] args) {
        C_constantes constantes = new C_constantes();
        System.out.println("El valor de PI es: " + constantes.PI);
        System.out.println("La edad máxima humana es: " + constantes.MAX_EDAD);
        System.out.println("El porcentaje de IVA es: " + constantes.IVA + "%");
        System.out.println("El nombre de la empresa es: " + constantes.NOMBRE_EMPRESA);
    }
}
