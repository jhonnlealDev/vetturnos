public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");

        Perro miPerro = new Perro();
        miPerro.nombre = "Yesca";
        miPerro.raza = "Stanford sharier bullterrier";
        System.out.println("Mi perro se llama " + miPerro.nombre + " y es de raza " + miPerro.raza);
        miPerro.ladrar();

        System.out.println("-------------------------------------------------");

        Libro miLibro = new Libro();
        miLibro.titulo = "1984";
        miLibro.autor = "George Orwell";
        miLibro.año = 1948;
        miLibro.mostrarInformacion();
    }
}
