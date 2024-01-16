package report;

import readEasy.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class allBookMarkReport implements iReport{
    public void printReport() throws IOException {
        System.out.println("All BookMarks Report");
        List<BookMark> bookmarks = BookMarkManager.getInstance().bookMarks;
        int i = 1;
        for (BookMark bookmark : bookmarks) {
            String line = i + ". " + bookmark.book.Title + " by " + bookmark.book.Author.Name + " || page - " + bookmark.page;
            System.out.println(line);
            i++;
        }
    }
}
