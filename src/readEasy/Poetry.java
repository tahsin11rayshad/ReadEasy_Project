package readEasy;

/**
 * Represents a poetry book
 * Inherits from Book class
 * @author Tahsin Islam
 */
public class Poetry extends Book{
        /**
         * Constructor for the Poetry class
         * @param title Title of the poetry book
         * @param author Author of the poetry book
         * @param publisher Publisher of the poetry book
         * @param isbn ISBN of the poetry book
         */
        public Poetry(String title, Author author, Publisher publisher, String isbn) {
            super(title, author, publisher, isbn, "Poetry");
        }

        /**
         * Returns the genre of the poetry book
         * @return Genre of the poetry book
         */
        @Override
        public String getGenre() {
            return "Poetry";
        }
}
