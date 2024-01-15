package report;
import readEasy.*;

import java.io.IOException;

public class allBookReport implements iReport{
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
