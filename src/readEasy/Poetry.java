package readEasy;

public class Poetry extends Book{
        public Poetry(String title, Author author, Publisher publisher, String isbn) {
            super(title, author, publisher, isbn, "Poetry");
        }

        @Override
        public String getGenre() {
            return "Poetry";
        }
}
