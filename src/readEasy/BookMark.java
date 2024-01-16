package readEasy;

import java.io.IOException;
import java.util.Scanner;

public class BookMark {
    public Book book;
    public int page;

    public BookMark(Book book, int page) {
        this.book = book;
        this.page = page;
    }

    public static void removeBookMark() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Remove BookMark");
        System.out.println("Book:");
        String title = sc.nextLine();
        Book book = null;
        for (Book b : BookShelf.getInstance().books) {
            if (b.Title.equals(title)) {
                book = b;
                break;
            }
        }
        boolean flag = false;
        BookMark bmm = null;
        for(BookMark bm : BookMarkManager.getInstance().bookMarks){
            if(bm.book.Title.equals(title)){
                bmm = bm;
                flag = true;
                break;
            }
        }
        if(!flag){
            throw new IOException("BookMark not found");
        }
        BookMarkManager.getInstance().removeBookMark(bmm);
        System.out.println("BookMark "+ bmm.book.Title + " ["+ bmm.page +"] " +"removed successfully");
    }

    public String toString() {
        return this.book.Title + " || page - " + this.page;
    }

    public static void addBookMark() throws IOException, IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Add new BookMark");
        System.out.println("Book:");
        String title = sc.nextLine();
        System.out.println("Page:");
        int page = sc.nextInt();
        Book book = null;
        for (Book b : BookShelf.getInstance().books) {
            if (b.Title.equals(title)) {
                book = b;
                break;
            }
        }
        BookMarkManager.getInstance().addBookMark(book, page);
        System.out.println("BookMark added successfully");
    }


}
