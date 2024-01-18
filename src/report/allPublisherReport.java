package report;
import readEasy.*;

import java.io.IOException;

/**
 * A class that prints a report of all the publishers in the bookshelf.
 * @author Tahsin Islam
 */
public class allPublisherReport implements iReport{
    /**
     * Prints a report of all the publishers in the bookshelf.
     * @throws IOException
     */
    public void printReport()throws IOException {
        System.out.println("All Publishers Report");
        int i = 1;
        for (Publisher p : BookShelf.getInstance().publishers) {
            String Line = i + ". " + p.Name + " (" + p.Email + ")";
            System.out.println(Line);
            i++;
        }
    }
}
