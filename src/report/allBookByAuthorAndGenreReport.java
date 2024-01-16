package report;

import readEasy.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A class that prints a report of all the books in the bookshelf by author and genre.
 * @Author Tahsin Islam
 */
public class allBookByAuthorAndGenreReport implements iReport{

    /**
     * Prints a report of all the books in the bookshelf by author and genre.
     * @throws IOException
     */
    public void printReport() throws IOException {
        System.out.println("Author and Genre Report");
        Map<String, Map<String, List<Book>>> booksByAuthorAndGenre = new HashMap<String, Map<String, List<Book>>>();
        for (Book b : BookShelf.getInstance().books) {
            if (!booksByAuthorAndGenre.containsKey(b.Author.Name)) {
                booksByAuthorAndGenre.put(b.Author.Name, new HashMap<String, List<Book>>());
            }
            if (!booksByAuthorAndGenre.get(b.Author.Name).containsKey(b.Genre)) {
                booksByAuthorAndGenre.get(b.Author.Name).put(b.Genre, new ArrayList<Book>());
            }
            booksByAuthorAndGenre.get(b.Author.Name).get(b.Genre).add(b);
        }

        int i = 1;
        for (Map.Entry<String, Map<String, List<Book>>> authorEntry : booksByAuthorAndGenre.entrySet()) {
            System.out.println("Author: " + authorEntry.getKey());
            for (Map.Entry<String, List<Book>> genreEntry : authorEntry.getValue().entrySet()) {
                System.out.println("  Genre: " + genreEntry.getKey());
                for (Book b : genreEntry.getValue()) {
                    String line = i + ". " + b.Title + " (" + b.Publisher.Name + ")" + " (" + b.ISBN + ")";
                    System.out.println("    " + line);
                    i++;
                }
            }
        }
    }
}
