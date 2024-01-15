package readEasy;

import java.io.IOException;
import java.util.Scanner;

public abstract class Book {
    public String Title;
    public Author Author;
    public Publisher Publisher;
    public String ISBN;
    public String Genre;

    public Book(String title, Author author, Publisher publisher, String isbn, String genre) {
        this.Title = title;
        this.Author = author;
        this.Publisher = publisher;
        this.ISBN = isbn;
        this.Genre = genre;
    }

    public String toString() {
        return this.Title + " (" + this.Author + ", " + this.Publisher + ", " + this.ISBN + ")";
    }

    public abstract String getGenre();

    public static void addBook() throws IOException, IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Add new Book");
        System.out.println("Title:");
        String title = sc.nextLine();
        System.out.println("Author:");
        String authorName = sc.nextLine();
        System.out.println("Publisher:");
        String publisherName = sc.nextLine();
        System.out.println("ISBN:");
        String isbn = sc.nextLine();
        System.out.println("Genre:");
        String genre = sc.nextLine();
        Author author = null;
        Publisher publisher = null;
        for (Author a : BookShelf.getInstance().authors) {
            if (a.Name.equals(authorName)) {
                author = a;
                break;
            }
        }
        for (Publisher p : BookShelf.getInstance().publishers) {
            if (p.Name.equals(publisherName)) {
                publisher = p;
                break;
            }
        }
        Book book = BookFactory.getInstance().createBook(title, author, publisher, isbn, genre);
        BookShelf.getInstance().addBook(book);
        System.out.println("Book added successfully");
    }
}
