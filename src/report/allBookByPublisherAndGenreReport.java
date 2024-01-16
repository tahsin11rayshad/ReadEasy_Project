package report;
import readEasy.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class allBookByPublisherAndGenreReport implements iReport {
    public void printReport() throws IOException {
        System.out.println("Publisher and Genre Report");
        Map<String, Map<String, List<Book>>> booksByPublisherAndGenre = new HashMap<String, Map<String, List<Book>>>();
        for (Book b : BookShelf.getInstance().books) {
            if (!booksByPublisherAndGenre.containsKey(b.Publisher.Name)) {
                booksByPublisherAndGenre.put(b.Publisher.Name, new HashMap<String, List<Book>>());
            }
            if (!booksByPublisherAndGenre.get(b.Publisher.Name).containsKey(b.Genre)) {
                booksByPublisherAndGenre.get(b.Publisher.Name).put(b.Genre, new ArrayList<Book>());
            }
            booksByPublisherAndGenre.get(b.Publisher.Name).get(b.Genre).add(b);
        }

        int i = 1;
        for (Map.Entry<String, Map<String, List<Book>>> publisherEntry : booksByPublisherAndGenre.entrySet()) {
            System.out.println("Publisher: " + publisherEntry.getKey());
            for (Map.Entry<String, List<Book>> genreEntry : publisherEntry.getValue().entrySet()) {
                System.out.println("  Genre: " + genreEntry.getKey());
                for (Book b : genreEntry.getValue()) {
                    String line = i + ". " + b.Title + " (" + b.Author.Name + ")" + " (" + b.ISBN + ")";
                    System.out.println("    " + line);
                    i++;
                }
            }
        }
    }

}
