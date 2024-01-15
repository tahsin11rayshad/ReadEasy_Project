package readEasy;

public class Comic extends Book{

    public Comic(String title, Author author, Publisher publisher, String isbn) {
        super(title, author, publisher, isbn, "Comic");
    }

    @Override
    public String getGenre() {
        return "Comic";
    }

}
