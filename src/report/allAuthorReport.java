package report;
import readEasy.*;

import java.io.IOException;

/**
 * A class that prints a report of all the authors in the bookshelf.
 * @author Tahsin Islam
 */
public class allAuthorReport implements iReport{
    /**
     * Prints a report of all the authors in the bookshelf.
     * @throws IOException
     */
    public void printReport() throws IOException {
        System.out.println("All Author Report___________________________");
        int i = 1;
        for (Author a : BookShelf.getInstance().authors) {
            String Line = i + ". " +  a.Name + " (" + a.Email + ")";
            System.out.println(Line);
            i++;
        }
    }
}
