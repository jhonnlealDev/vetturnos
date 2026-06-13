public class App {
    public static void main(String[] args) throws Exception {
        //constante
        final double IVA = 0.16;
        final int DIAS_SEMANS = 7;

        System.out.println("El IVA es: " + IVA);
        System.out.println("Los días de la semana son: " + DIAS_SEMANS);

        //suma
        int a = 5;
        int b = 10;
        int suma = a + b;
        System.out.println("La suma de " + a + " y " + b + " es: " + suma);

        //hacerlo por teclado

        //modulo
        int modulo = a % b;
        System.out.println("El módulo de " + a + " y " + b + " es: " + modulo);

        //cast
        int entero = 10;
        double decimal = entero;
        System.out.println("El entero " + entero + " convertido a decimal es: " + decimal);

        //concatenación
        int entero1 = 5;
        int entero2 = 10;
        System.out.println("La suma de " + entero1 + " y " + entero2 + " es: " + entero1 + entero2 + " -> " + (entero1 + entero2));
    }
}
