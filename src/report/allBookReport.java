package report;
import readEasy.*;

import java.io.IOException;

/**
 * A class that prints a report of all the books in the bookshelf.
 * @Author Tahsin Islam
 */
public class allBookReport implements iReport{
    /**
     * Prints a report of all the books in the bookshelf.
     * @throws IOException
     */
    public void printReport() throws IOException {
        System.out.println("All Books Report");
        int i = 1;
        for (Book b : BookShelf.getInstance().books) {
            String Line = i + ". " + b.Title + " (" + b.Author.Name + ")";
            System.out.println(Line);
            i++;
        }
    }
}
