package report;
import readEasy.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A class that prints a report of all the books genre in the bookshelf.
 * @author Tahsin Islam
 */
public class genreReport implements iReport{

    /**
     * Prints a report of all the books genre in the bookshelf.
     * @throws IOException
     */
    public void printReport() throws IOException {
        System.out.println("Genre Report");
        List<String> genres = new ArrayList<String>();
        int i = 1;
        for (Book b : BookShelf.getInstance().books) {
            if (!genres.contains(b.getGenre())) {
                genres.add(b.getGenre());
                System.out.println(i + ". " + b.getGenre());
                i++;
            }
        }

    }

}
