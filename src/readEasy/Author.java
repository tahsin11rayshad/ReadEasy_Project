package readEasy;

import java.io.IOException;
import java.util.Scanner;

public class Author {
    public String Name;
    public String Email;

    public Author(String name, String email) {
        this.Name = name;
        this.Email = email;
    }

    public String toString() {
        return this.Name + " (" + this.Email + ")";
    }

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
