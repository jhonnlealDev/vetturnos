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
        miLibro.setTitulo("1984");
        miLibro.setAutor("George Orwell");
        miLibro.setAño(1948);
        miLibro.mostrarInformacion();
    }
}
