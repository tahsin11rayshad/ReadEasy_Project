package readEasy;

/**
 * Represents a comic book
 * Inherits from Book class
 * @author Tahsin Islam
 */
public class Comic extends Book{

    /**
     * Constructor for the Comic class
     * @param title Title of the comic book
     * @param author Author of the comic book
     * @param publisher Publisher of the comic book
     * @param isbn ISBN of the comic book
     */
    public Comic(String title, Author author, Publisher publisher, String isbn) {
        super(title, author, publisher, isbn, "Comic");
    }

    /**
     * Returns the genre of the comic book
     * @return Genre of the comic book
     */
    @Override
    public String getGenre() {
        return "Comic";
    }

}
