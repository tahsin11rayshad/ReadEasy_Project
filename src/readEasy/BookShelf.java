package readEasy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class BookShelf {
    public List<Book> books;
    public List<Author> authors;
    public List<Publisher> publishers;
    private static BookShelf instance;
    private BookShelf() throws IOException {
        books = new ArrayList<Book>();
        authors = new ArrayList<Author>();
        publishers = new ArrayList<Publisher>();
        loadAuthors();
        loadPublishers();
        loadBooks();
    }

    public static BookShelf getInstance() throws IOException {
        if (instance == null) {
            instance = new BookShelf();
        }
        return instance;
    }



    private void checkShalves(){
        checkAndCreateFolder();
        checkAndCreateFiles();
    }

    private void loadBooks() throws IOException {
        checkShalves();
        Path filePath = Paths.get("C:\\readeasy\\book.txt");
        List<String> lines = Files.readAllLines(filePath);
        for (String line : lines) {
            String[] parts = line.split(",");
            String title = parts[0];
            String authorName = parts[1];
            String publisherName = parts[2];
            String isbn = parts[3];
            String genre = parts[4];
            Author author = null;
            Publisher publisher = null;
            for (Author a : authors) {
                if (a.Name.equals(authorName)) {
                    author = a;
                    break;
                }
            }
            for (Publisher p : publishers) {
                if (p.Name.equals(publisherName)) {
                    publisher = p;
                    break;
                }
            }
            Book book = BookFactory.getInstance().createBook(title, author, publisher, isbn, genre);
            books.add(book);
        }
    }

    private void loadAuthors() throws IOException {
        checkShalves();
        Path filePath = Paths.get("C:\\readeasy\\auth.txt");
        List<String> lines = Files.readAllLines(filePath);
        for (String line : lines) {
            String[] parts = line.split(",");
            String name = parts[0];
            String email = parts[1];
            Author author = new Author(name, email);
            authors.add(author);
        }
    }

    private void loadPublishers() throws IOException {
        checkShalves();
        Path filePath = Paths.get("C:\\readeasy\\pub.txt");
        List<String> lines = Files.readAllLines(filePath);
        for (String line : lines) {
            String[] parts = line.split(",");
            String name = parts[0];
            String address = parts[1];
            String email = parts[2];
            Publisher publisher = new Publisher(name, address, email);
            publishers.add(publisher);
        }
    }

    private void saveBooks() throws IOException {
        checkShalves();
        Path filePath = Paths.get("C:\\readeasy\\book.txt");
        List<String> lines = new ArrayList<String>();
        for (Book book : books) {
            String line = book.Title + "," + book.Author.Name + "," + book.Publisher.Name + "," + book.ISBN + "," + book.getGenre();
            lines.add(line);
        }
        Files.write(filePath, lines);
    }

    private void appendBook(Book book) throws IOException {
        checkShalves();
        Path filePath = Paths.get("C:\\readeasy\\book.txt");
        String line = "\n" + book.Title + "," + book.Author.Name + "," + book.Publisher.Name + "," + book.ISBN + "," + book.getGenre();
        Files.write(filePath, line.getBytes(), StandardOpenOption.APPEND);
    }

    private void appendAuthor(Author author) throws IOException {
        checkShalves();
        Path filePath = Paths.get("C:\\readeasy\\auth.txt");
        String line = "\n" + author.Name + "," + author.Email;
        Files.write(filePath, line.getBytes(), StandardOpenOption.APPEND);
    }

    private void appendPublisher(Publisher publisher) throws IOException {
        checkShalves();
        Path filePath = Paths.get("C:\\readeasy\\pub.txt");
        String line = "\n" + publisher.Name + "," + publisher.Address + "," + publisher.Email;
        Files.write(filePath, line.getBytes(), StandardOpenOption.APPEND);
    }

    public void addBook(Book book) throws IOException {
        books.add(book);
        appendBook(book);
    }

    public void addAuthor(Author author) throws IOException {
        authors.add(author);
        appendAuthor(author);
    }

    public void addPublisher(Publisher publisher) throws IOException {
        publishers.add(publisher);
        appendPublisher(publisher);
    }


    private static void checkAndCreateFolder() {
        String folderPath = "C:\\readeasy";
        boolean folderExists = Files.exists(Paths.get(folderPath));

        if (!folderExists) {
            try {
                Files.createDirectory(Paths.get(folderPath));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void checkAndCreateFiles() {
        String[] fileNames = {"book.txt", "pub.txt", "auth.txt"};

        String folderPath = "C:\\readeasy";

        for (String fileName : fileNames) {
            Path filePath = Paths.get(folderPath, fileName);
            boolean fileExists = Files.exists(filePath);

            if (!fileExists) {
                try {
                    Files.createFile(filePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
