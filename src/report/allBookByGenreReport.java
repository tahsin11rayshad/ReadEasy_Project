package report;

import readEasy.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A class that prints a report of all the books in the bookshelf by genre.
 * @Author Tahsin Islam
 */
public class allBookByGenreReport implements iReport{

    /**
     * Prints a report of all the books in the bookshelf by genre.
     * @throws IOException
     */
    public void printReport() throws IOException {
        System.out.println("Genre Report");
        Map<String, List<Book>> booksByGenre = new HashMap<String, List<Book>>();
        for (Book b : BookShelf.getInstance().books) {
            if (!booksByGenre.containsKey(b.getGenre())) {
                booksByGenre.put(b.getGenre(), new ArrayList<Book>());
            }
            booksByGenre.get(b.getGenre()).add(b);
        }

        int i = 1;
        for (Map.Entry<String, List<Book>> entry : booksByGenre.entrySet()) {
            for (Book b : entry.getValue()) {
                String line = i + ". " + b.Genre + "- "+ b.Title + " (" + b.Author.Name + ")" + " (" + b.Publisher.Name + ")" + " (" + b.ISBN + ")";
                System.out.println(line);
                i++;
            }
        }
    }


}
