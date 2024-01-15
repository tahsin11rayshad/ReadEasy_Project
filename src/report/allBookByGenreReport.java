package report;

import readEasy.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class allBookByGenreReport implements iReport{
    public void printReport() throws IOException {
        System.out.println("All Books By Genre Report");
        List<String> distinctGenres = new ArrayList<String>();
        int i = 1;
        for (Book b : BookShelf.getInstance().books) {
            if (!distinctGenres.contains(b.Genre)) {
                distinctGenres.add(b.Genre);
                i++;
            }
        }
        int j=1;
        for(String s : distinctGenres){
            for(Book b : BookShelf.getInstance().books){
                if(b.Genre.equals(s)){
                    String Line = j + ". " + b.Genre + "-" + b.Title + "-" + " (" + b.Author.Name + ")" + " (" + b.Publisher.Name + ")" + " (" + b.ISBN + ")";
                    System.out.println(Line);
                    j++;
                }
            }
        }
    }

//    public void printReport() throws IOException {
//        System.out.println("Genre Report");
//        Map<String, List<Book>> booksByGenre = new HashMap<String, List<Book>>();
//        for (Book b : BookShelf.getInstance().books) {
//            if (!booksByGenre.containsKey(b.getGenre())) {
//                booksByGenre.put(b.getGenre(), new ArrayList<Book>());
//            }
//            booksByGenre.get(b.getGenre()).add(b);
//        }
//
//        int i = 1;
//        for (Map.Entry<String, List<Book>> entry : booksByGenre.entrySet()) {
//            for (Book b : entry.getValue()) {
//                String line = i + ". " + b.Title + " (" + b.Author.Name + ")" + " (" + b.Publisher.Name + ")" + " (" + b.ISBN + ")" + " (" + b.Genre + ")";
//                System.out.println(line);
//                i++;
//            }
//        }
//    }


}
