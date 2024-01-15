package report;
import readEasy.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class genreReport implements iReport{
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
