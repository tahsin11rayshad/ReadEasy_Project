package readEasy;

public class BookFactory {
    private static BookFactory Instance;
    private BookFactory() {}

    public static BookFactory getInstance() {
        if (Instance == null) {
            Instance = new BookFactory();
        }
        return Instance;
    }

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
