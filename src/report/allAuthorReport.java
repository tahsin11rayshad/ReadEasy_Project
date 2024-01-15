package report;
import readEasy.*;

import java.io.IOException;

public class allAuthorReport implements iReport{
    public void printReport() throws IOException {
        System.out.println("All readEasy.Author Report___________________________");
        int i = 1;
        for (Author a : BookShelf.getInstance().authors) {
            String Line = i + ". " +  a.Name + " (" + a.Email + ")";
            System.out.println(Line);
            i++;
        }
    }
}
