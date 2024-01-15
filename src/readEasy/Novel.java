package readEasy;

public class Novel extends Book{
        public Novel(String title, Author author, Publisher publisher, String isbn) {
            super(title, author, publisher, isbn, "Novel");
        }

        @Override
        public String getGenre() {
            return "Novel";
        }
}
