package readEasy;

import java.io.IOException;
import java.util.Scanner;

/**
 * Represents a bookmark of a book
 * A bookmark is a pointer to a page of a book
 * A bookmark can be added or removed from a book
 * @author Tahsin Islam
 */
public class BookMark {
    public Book book;
    public int page;

    /**
     * Constructor for the BookMark class
     * @param book Book
     * @param page Page number
     */
    public BookMark(Book book, int page) {
        this.book = book;
        this.page = page;
    }

    /**
     * Returns the book of the bookmark
     * @throws IOException
     */
    public static void removeBookMark() throws IOException {
        try{
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
        catch (Exception e){
            System.out.println("No such book exists!");
        }
    }

    /**
     * Returns a string representation of the bookmark
     * @return String representation of the bookmark
     */
    public String toString() {
        return this.book.Title + " || page - " + this.page;
    }

    /**
     * Adds a new bookmark to the list of bookmarks
     * @throws IOException
     */
    public static void addBookMark() throws IOException, IOException {
        try{
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
        catch (Exception e){
            System.out.println("No such book exists!");
        }
    }


}
