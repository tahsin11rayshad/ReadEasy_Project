package report;

import readEasy.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A class that prints a report of all the books in the bookshelf by author.
 * @Author Tahsin Islam
 */
public class allBookByAuthorReport implements iReport{

    /**
     * Prints a report of all the books in the bookshelf by author.
     * @throws IOException
     */
    public void printReport() throws IOException {
        System.out.println("All Books By Author Report");
        Map<String, List<Book>> booksByAuthor = new HashMap<String, List<Book>>();
        for (Book b : BookShelf.getInstance().books) {
            if (!booksByAuthor.containsKey(b.Author.Name)) {
                booksByAuthor.put(b.Author.Name, new ArrayList<Book>());
            }
            booksByAuthor.get(b.Author.Name).add(b);
        }

        int i = 1;
        for (Map.Entry<String, List<Book>> entry : booksByAuthor.entrySet()) {
            System.out.println("Author: " + entry.getKey());
            for (Book b : entry.getValue()) {
                String line = i + ". " + b.Title + " (" + b.Publisher.Name + ")" + " (" + b.ISBN + ")" + " (" + b.Genre + ")";
                System.out.println("  " + line);
                i++;
            }
        }
    }
}
