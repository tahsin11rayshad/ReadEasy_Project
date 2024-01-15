package report;
import readEasy.*;

import java.io.IOException;

public class allPublisherReport implements iReport{
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
