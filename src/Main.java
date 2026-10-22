public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE GESTION DE BIBLIOTECA ===");
        System.out.println("Aplicacion Java de consola iniciada.\n");

        // Crear una biblioteca
        Library library = new Library("Biblioteca Central");

        // Crear algunos libros (Tildes omitidas para compatibilidad de consola)
        Book book1 = new Book("El Quijote", "978-84-376-0494-7", "Miguel de Cervantes", 1605);
        Book book2 = new Book("Cien anios de soledad", "978-84-376-0495-4", "Gabriel Garcia Marquez", 1967);
        Book book3 = new Book("1984", "978-84-376-0496-1", "George Orwell", 1949);
        Book book4 = new Book("El amor en los tiempos del colera", "978-84-376-0497-8", "Gabriel Garcia Marquez", 1985);

        // Agregar libros a la biblioteca
        System.out.println("📚 AGREGANDO LIBROS A LA BIBLIOTECA:");
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        System.out.println("✅ Libros agregados exitosamente");

        // Mostrar informacion de la biblioteca
        System.out.println("\n📊 INFORMACION DE LA BIBLIOTECA:");
        System.out.println(library);
        System.out.println("\n" + library.getStatistics());

        // Buscar libros por titulo
        System.out.println("\n🔍 BUSQUEDA POR TITULO ('amor'):");
        LinkedList<Book> searchResults = library.findBooksByTitle("amor");
        for (int i = 0; i < searchResults.getSize(); i++) {
            System.out.println("  - " + searchResults.get(i));
        }

        // Buscar libros por autor
        System.out.println("\n🔍 BUSQUEDA POR AUTOR ('Garcia Marquez'):");
        LinkedList<Book> authorBooks = library.findBooksByAuthor("Garcia Marquez");
        for (int i = 0; i < authorBooks.getSize(); i++) {
            System.out.println("  - " + authorBooks.get(i));
        }

        // Prestar algunos libros usando el nuevo metodo con Stack
        System.out.println("\n📖 SIMULANDO PRESTAMOS:");
        Book foundBook = library.findBookByIsbn("978-84-376-0494-7");
        if (foundBook != null && library.lendBook("978-84-376-0494-7")) {
            System.out.println("✅ Se presto: " + foundBook.getTitle());
        }

        foundBook = library.findBookByIsbn("978-84-376-0495-4");
        if (foundBook != null && library.lendBook("978-84-376-0495-4")) {
            System.out.println("✅ Se presto: " + foundBook.getTitle());
        }

        // Tarea N2: Deshacer usando la Pila (Stack)
        System.out.println("\n⏪ PROBANDO HISTORIAL (DESHACER PRESTAMO):");
        Book lastLoan = library.peekLastLoan();
        if (lastLoan != null) {
            System.out.println("Ultimo prestamo registrado: " + lastLoan.getTitle());
            System.out.println("Deshaciendo accion...");
            library.undoLastLoan();
            System.out.println("✅ Prestamo deshecho. Estado del libro: " + (lastLoan.isAvailable() ? "Disponible" : "Prestado"));
        }

        // Tarea N3: Cola de espera (Queue)
        System.out.println("\n👥 PROBANDO COLA DE ESPERA:");
        Book quijote = library.findBookByIsbn("978-84-376-0494-7");
        if (quijote != null) {
            System.out.println("Usuarios 'Lucas' y 'Juan' se anotan en espera para El Quijote...");
            quijote.addToWaitingList("Lucas");
            quijote.addToWaitingList("Juan");
            
            System.out.println("Siguiente en la fila: " + quijote.getNextInWaitingList());
            
            System.out.println("Simulando devolucion del libro...");
            quijote.returnBook();
            
            String asignadoA = quijote.lendToNextInWaitingList();
            System.out.println("✅ El libro se libero y se presto automaticamente a: " + asignadoA);
        }

        // Mostrar libros disponibles y prestados
        System.out.println("\n📚 LIBROS DISPONIBLES ACTUALMENTE:");
        LinkedList<Book> available = library.getAvailableBooks();
        for (int i = 0; i < available.getSize(); i++) {
            System.out.println("  - " + available.get(i));
        }

        System.out.println("\n📤 LIBROS PRESTADOS ACTUALMENTE:");
        LinkedList<Book> loaned = library.getLoanedBooks();
        for (int i = 0; i < loaned.getSize(); i++) {
            System.out.println("  - " + loaned.get(i));
        }

        // Mostrar estadisticas finales
        System.out.println("\n📊 ESTADISTICAS FINALES:");
        System.out.println(library.getStatistics());

        // Procesar argumentos si se proporcionan
        if (args.length > 0) {
            System.out.println("\n💻 ARGUMENTOS RECIBIDOS:");
            for (int i = 0; i < args.length; i++) {
                System.out.println("  " + (i + 1) + ": " + args[i]);
            }
        }

        System.out.println("\n🎉 Demostracion completada.");
    }
}