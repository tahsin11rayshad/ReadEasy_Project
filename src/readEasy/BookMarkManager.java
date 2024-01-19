package readEasy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a manager for bookmarks
 * Singleton class
 * @author Tahsin Islam
 */
public class BookMarkManager {
    private static BookMarkManager Instance;

    /**
     * Constructor for the BookMarkManager class
     * @throws IOException
     */
    private BookMarkManager() throws IOException {
        bookMarks = new ArrayList<BookMark>();
        loadBookMarks();
    }

    /**
     * Returns the instance of the BookMarkManager class
     * @return Instance of the BookMarkManager class
     * @throws IOException
     */
    public static BookMarkManager getInstance() throws IOException {
        if (Instance == null) {
            Instance = new BookMarkManager();
        }
        return Instance;
    }

    public List<BookMark> bookMarks;


    /**
     * Loads the bookmarks from the file
     * @throws IOException
     */
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

    /**
     * Checks if the file exists
     * If not, creates the file
     * @throws IOException
     */
    public void check() throws IOException {
        BookShelf b = BookShelf.getInstance();
        String folderPath = "C:\\readeasy";
        String fileName = "mark.txt";

        Path filePath = Paths.get(folderPath, fileName);
        if (!Files.exists(filePath)) {
            Files.createFile(filePath);
        }
    }

    /**
     * Saves the bookmark to the file
     * @param book Book of the bookmark
     * @param page Page of the bookmark
     * @throws IOException
     */
    private void saveBookMark(Book book, int page) throws IOException {
        check();
        Path filePath = Paths.get("C:\\readeasy\\mark.txt");
        String line = "\n" + book.Title + "," + page;
        Files.write(filePath, line.getBytes(), StandardOpenOption.APPEND);
    }

    /**
     * Adds a new bookmark to the list of bookmarks and saves it to the file
     * @param book Book of the bookmark
     * @param page Page of the bookmark
     * @throws IOException
     */
    public void addBookMark(Book book, int page) throws IOException {
        BookMark bm = new BookMark(book, page);
        for(BookMark b : bookMarks){
            if(b.book.Title.equals(book.Title)){
                removeBookMark(b);
            }
        }
        bookMarks.add(bm);
        saveBookMark(book, page);
    }

    /**
     * Removes a bookmark from the list of bookmarks and saves it to the file
     * @param bm Bookmark to be removed
     * @throws IOException
     */
    public void removeBookMark(BookMark bm) throws IOException {

        bookMarks.remove(bm);
        saveBookMarks();
    }

    /**
     * Saves the bookmarks to the file
     * @throws IOException
     */
    private void saveBookMarks() throws IOException {
        Path filePath = Paths.get("C:\\readeasy\\mark.txt");
        Files.write(filePath, new byte[0]);
        for (BookMark bm : bookMarks) {
            String line = bm.book.Title + "," + bm.page + "\n";
            Files.write(filePath, line.getBytes(), StandardOpenOption.APPEND);
        }
    }
}
