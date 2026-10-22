public class Library {
    private String name;
    static boolean archived = false;
    private LinkedList<Book> books;
    private Stack<Book> loanedBooksStack;
    
    public Library(String name) {
        this.name = name;
        this.books = new LinkedList<>();
        this.loanedBooksStack = new Stack<>();
    }
    
    public String getName() { return name; }
    public LinkedList<Book> getBooks() { return books; }
    public void setName(String name) { this.name = name; }
    
    public boolean addBook(Book book) {
        if (book != null) {
            books.add(book); // Llama a tu método add() con punteros
            return true;
        }
        return false;
    }
    
    public boolean removeBook(Book book) {
        if (book != null) {
            // Evaluamos el retorno de tu propio método remove()
            Book removed = books.remove(book);
            return removed != null; // Si no es null, se borró con éxito
        }
        return false;
    }
    
    public Book findBookByIsbn(String isbn) {
        for (int i = 0; i < books.getSize(); i++) {
            Book b = books.get(i); // Llama a tu get() que recorre nodos
            if (b.getIsbn().equals(isbn)) {
                return b;
            }
        }
        return null;
    }
    
    public LinkedList<Book> findBookByDescription(String title) {
        return null; // Omitido, tal como decía el comentario
    }
    
    public LinkedList<Book> findBooksByTitle(String title) {
        LinkedList<Book> foundBooks = new LinkedList<>();
        for (int i = 0; i < books.getSize(); i++) {
            Book b = books.get(i);
            if (b.getTitle().toLowerCase().contains(title.toLowerCase())) {
                foundBooks.add(b);
            }
        }
        return foundBooks;
    }
    
    public LinkedList<Book> findBooksByAuthor(String authorName) {
        LinkedList<Book> foundBooks = new LinkedList<>();
        for (int i = 0; i < books.getSize(); i++) {
            Book b = books.get(i);
            if (b.getAuthor().toLowerCase().contains(authorName.toLowerCase())) {
                foundBooks.add(b);
            }
        }
        return foundBooks;
    }
    
    public LinkedList<Book> getAvailableBooks() {
        LinkedList<Book> availableBooks = new LinkedList<>();
        for (int i = 0; i < books.getSize(); i++) {
            Book b = books.get(i);
            if (b.isAvailable()) {
                availableBooks.add(b);
            }
        }
        return availableBooks;
    }
    
    public LinkedList<Book> getLoanedBooks() {
        LinkedList<Book> loanedBooks = new LinkedList<>();
        for (int i = 0; i < books.getSize(); i++) {
            Book b = books.get(i);
            if (!b.isAvailable()) {
                loanedBooks.add(b);
            }
        }
        return loanedBooks;
    }

    //Tarea 2

    public boolean lendBook(String isbn) {
        Book bookToLend = findBookByIsbn(isbn);
        if (bookToLend != null && bookToLend.isAvailable()) {
            bookToLend.setAvailable(false);
            loanedBooksStack.push(bookToLend);
            return true;
        }
        return false;
    }

    public boolean returnBook(String isbn) {
        Book bookToReturn = findBookByIsbn(isbn);
        if (bookToReturn != null && !bookToReturn.isAvailable()) {
            bookToReturn.setAvailable(true);
            loanedBooksStack.pop(); // Asumimos que el libro devuelto es el último prestado
            return true;
        }
        return false;
    }

    public Book peekLastLoan() {
        return loanedBooksStack.peek();
    }

    public boolean undoLastLoan() {
        Book lastLoanedBook = loanedBooksStack.pop();
        if (lastLoanedBook != null) {
            lastLoanedBook.setAvailable(true);
            return true;
        }
        return false;
    }

    //Fin Tarea 2

    
    public String getStatistics() {
        int totalBooks = books.getSize();
        int availableBooks = getAvailableBooks().getSize();
        int loanedBooks = getLoanedBooks().getSize();
        
        return String.format(
            "Estadísticas de la Biblioteca:\n" +
            "- Total de Libros: %d\n" +
            "- Libros Disponibles: %d\n" +
            "- Libros Prestados: %d\n",
            totalBooks, availableBooks, loanedBooks
        );
    }
    
    @Override
    public String toString() {
        return String.format(
            "Biblioteca: %s\n" +
            "Total de Libros: %d\n",
            name, books.getSize()
        );
    }
}