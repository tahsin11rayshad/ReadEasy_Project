package readEasy;

/**
 * Represents a historic book
 * Inherits from Book class
 * @author Tahsin Islam
 */
public class Historic extends Book{

        /**
         * Constructor for the Historic class
         * @param title Title of the historic book
         * @param author Author of the historic book
         * @param publisher Publisher of the historic book
         * @param isbn ISBN of the historic book
         */
        public Historic(String title, Author author, Publisher publisher, String isbn) {
            super(title, author, publisher, isbn, "Historic");
        }

        /**
         * Returns the genre of the historic book
         * @return Genre of the historic book
         */
        @Override
        public String getGenre() {
            return "Historic";
        }
}
