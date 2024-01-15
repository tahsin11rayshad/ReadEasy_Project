package report;

import readEasy.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class allBookByPublisherReport implements iReport{
    public void printReport() throws IOException {
        System.out.println("All Books By Publisher Report");
        List<String> distinctPublishers = new ArrayList<String>();
        int i=0;
        for (Book b : BookShelf.getInstance().books) {
            if (!distinctPublishers.contains(b.Publisher.Name)) {
                distinctPublishers.add(b.Publisher.Name);
                i++;
            }
        }
        int j=1;
        for(String s : distinctPublishers){
            for(Book b : BookShelf.getInstance().books){
                if(b.Publisher.Name.equals(s)){
                    String Line = j + ". " + b.Publisher.Name + "-" + b.Title + "-" + " (" + b.Author.Name + ")" + " (" + b.ISBN + ")" + " (" + b.Genre + ")";
                    System.out.println(Line);
                    j++;
                }
            }
        }
    }
}
