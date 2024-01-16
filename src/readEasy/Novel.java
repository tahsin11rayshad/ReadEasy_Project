package readEasy;

/**
 * Represents a novel book
 * Inherits from Book class
 * @author Tahsin Islam
 */
public class Novel extends Book{
    /**
     * Constructor for the Novel class
     * @param title Title of the novel book
     * @param author Author of the novel book
     * @param publisher Publisher of the novel book
     * @param isbn ISBN of the novel book
     */
    public Novel(String title, Author author, Publisher publisher, String isbn) {
            super(title, author, publisher, isbn, "Novel");
        }

        /**
         * Returns the genre of the novel book
         * @return Genre of the novel book
         */
        @Override
        public String getGenre() {
            return "Novel";
        }
}
