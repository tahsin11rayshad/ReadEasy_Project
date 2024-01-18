package report;

import readEasy.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A class that prints a report of all the books in the bookshelf by publisher.
 * @Author Tahsin Islam
 */
public class allBookByPublisherReport implements iReport{

    /**
     * Prints a report of all the books in the bookshelf by publisher.
     * @throws IOException
     */
    public void printReport() throws IOException {
        System.out.println("All Books By Publisher Report");
        Map<String, List<Book>> booksByPublisher = new HashMap<String, List<Book>>();
        for (Book b : BookShelf.getInstance().books) {
            if (!booksByPublisher.containsKey(b.Publisher.Name)) {
                booksByPublisher.put(b.Publisher.Name, new ArrayList<Book>());
            }
            booksByPublisher.get(b.Publisher.Name).add(b);
        }

        int i = 1;
        for (Map.Entry<String, List<Book>> entry : booksByPublisher.entrySet()) {
            System.out.println(i + "." + "Publisher: " + entry.getKey());
            int j=1;
            for (Book b : entry.getValue()) {
                String line = j + ". " + b.Title + " (" + b.Author.Name + ")" + " (" + b.ISBN + ")" + " (" + b.Genre + ")";
                System.out.println("  " + line);
                j++;
            }
            i++;
            System.out.println("\n");
        }
    }
}
