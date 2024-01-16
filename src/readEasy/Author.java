package readEasy;

import java.io.IOException;
import java.util.Scanner;

/**
 * Represents an author of a book
 * @author Tahsin Islam
 */
public class Author {
    public String Name;
    public String Email;

    /**
     * Constructor for Author class
     * @param name Name of the author
     * @param email Email of the author
     */
    public Author(String name, String email) {
        this.Name = name;
        this.Email = email;
    }

    /**
     * Returns a string representation of the author
     * @return String representation of the author
     */
    public String toString() {
        return this.Name + " (" + this.Email + ")";
    }

    /**
     * Adds a new author to the list of authors
     * @throws IOException
     */
    public static void addAuthor() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Add new Author");
        System.out.println("Name:");
        String name = sc.nextLine();
        System.out.println("Email:");
        String email = sc.nextLine();
        Author author = new Author(name, email);
        BookShelf.getInstance().addAuthor(author);
        System.out.println("Author added successfully");
    }
}
