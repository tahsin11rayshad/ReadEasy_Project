package readEasy;

public class Historic extends Book{
        public Historic(String title, Author author, Publisher publisher, String isbn) {
            super(title, author, publisher, isbn, "Historic");
        }

        @Override
        public String getGenre() {
            return "Historic";
        }
}
