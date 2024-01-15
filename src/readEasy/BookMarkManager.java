package readEasy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class BookMarkManager {
    private static BookMarkManager Instance;
    private BookMarkManager() throws IOException {
        bookMarks = new ArrayList<BookMark>();
        loadBookMarks();
    }
    public static BookMarkManager getInstance() throws IOException {
        if (Instance == null) {
            Instance = new BookMarkManager();
        }
        return Instance;
    }

    List<BookMark> bookMarks;

    private void loadBookMarks() throws IOException {
        check();
        Path filePath = Paths.get("C:\\readeasy\\mark.txt");
        List<String> lines = Files.readAllLines(filePath);
        for (String line : lines) {
            String[] parts = line.split(",");
            String title = parts[0];
            int page = Integer.parseInt(parts[1]);
            Book book = null;
            for (Book b : BookShelf.getInstance().books) {
                if (b.Title.equals(title)) {
                    book = b;
                    break;
                }
            }
            BookMark bm = new BookMark(book, page);
            bookMarks.add(bm);
        }
    }

    public void check() throws IOException {
        BookShelf b = BookShelf.getInstance();
        String folderPath = "C:\\readeasy";
        String fileName = "mark.txt";

        Path filePath = Paths.get(folderPath, fileName);
        if (!Files.exists(filePath)) {
            Files.createFile(filePath);
        }
    }

    private void saveBookMark(Book book, int page) throws IOException {
        BookMarkManager.getInstance().check();
        Path filePath = Paths.get("C:\\readeasy\\mark.txt");
        String line = "\n" + book.Title + "," + page;
        Files.write(filePath, line.getBytes(), StandardOpenOption.APPEND);
    }

    public void addBookMark(Book book, int page) throws IOException {
        BookMark bm = new BookMark(book, page);
        if(bookMarks.contains(bm)){
            removeBookMark(bm);
        }
        bookMarks.add(bm);
        saveBookMark(book, page);
    }

    public void removeBookMark(BookMark bm) throws IOException {
        bookMarks.remove(bm);
        saveBookMarks();
    }

    private void saveBookMarks() throws IOException {
        Path filePath = Paths.get("C:\\readeasy\\mark.txt");
        Files.write(filePath, new byte[0]);
        for (BookMark bm : bookMarks) {
            String line = bm.book.Title + "," + bm.page;
            Files.write(filePath, line.getBytes(), StandardOpenOption.APPEND);
        }
    }
}
