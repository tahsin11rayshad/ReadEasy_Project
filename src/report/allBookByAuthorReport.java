package report;

import readEasy.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A class that prints a report of all the books in the bookshelf by author.
 * @author Tahsin Islam
 */
public class allBookByAuthorReport implements iReport{

    /**
     * Prints a report of all the books in the bookshelf by author.
     * @throws IOException
     */
    public void printReport() throws IOException {
        System.out.println("All Books By Author Report");
        System.out.println("\n");
        try{
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
                int j = 1;
                for (Book b : entry.getValue()) {
                    String line = j + ". " + b.Title + " (" + b.Publisher.Name + ")" + " (" + b.ISBN + ")" + " (" + b.Genre + ")";
                    System.out.println("  " + line);
                    i++;
                    j++;
                }
                System.out.println("\n");
            }
        }
        catch (Exception e){
            System.out.println("No books in the bookshelf.");
        }
    }
}
