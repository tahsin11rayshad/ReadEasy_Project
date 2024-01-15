package report;

import readEasy.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class allBookByAuthorReport implements iReport{
    public void printReport() throws IOException {
        System.out.println("All Books By Author Report");
        List<String> distinctAuthors = new ArrayList<String>();
        int i = 1;
        for (Book b : BookShelf.getInstance().books) {
            if (!distinctAuthors.contains(b.Author.Name)) {
                distinctAuthors.add(b.Author.Name);
                i++;
            }
        }
        int j=1;
        for(String s : distinctAuthors){
            for(Book b : BookShelf.getInstance().books){
                if(b.Author.Name.equals(s)){
                    String Line = j + ". " + b.Author.Name + "-" + b.Title + "-" + " (" + b.Publisher.Name + ")" + " (" + b.ISBN + ")" + " (" + b.Genre + ")";
                    System.out.println(Line);
                    j++;
                }
            }
        }
    }
}
