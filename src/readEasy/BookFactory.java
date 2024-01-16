package readEasy;

/**
 * Represents a book factory that creates books of different genres
 * Singleton class
 */
public class BookFactory {
    private static BookFactory Instance;
    private BookFactory() {}

    /**
     * Returns the instance of the BookFactory class
     * @return Instance of the BookFactory class
     */
    public static BookFactory getInstance() {
        if (Instance == null) {
            Instance = new BookFactory();
        }
        return Instance;
    }

    /**
     * Creates a book of the given genre
     * @param title Title of the book
     * @param author Author of the book
     * @param publisher Publisher of the book
     * @param isbn ISBN of the book
     * @param genre Genre of the book
     * @return Book of the given genre
     */
    public Book createBook(String title, Author author, Publisher publisher, String isbn, String genre) {
        if (genre.equals("Comic")) {
            return new Comic(title, author, publisher, isbn);
        }
        else if (genre.equals("Novel")) {
            return new Novel(title, author, publisher, isbn);
        }
        else if (genre.equals("Poetry")) {
            return new Poetry(title, author, publisher, isbn);
        }
        else if (genre.equals("Historic")) {
            return new Historic(title, author, publisher, isbn);
        }
        else {
            return null;
        }
    }

}
