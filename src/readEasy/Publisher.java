package readEasy;

import java.io.IOException;
import java.util.Scanner;

/**
 * Represents a publisher of a book
 * A publisher can be added to the bookshelf
 * @author Tahsin Islam
 */
public class Publisher {
    public String Name;
    public String Address;
    public String Email;

    /**
     * Constructor for the Publisher class
     * @param name Name of the publisher
     * @param address Address of the publisher
     * @param email Email of the publisher
     */
    public Publisher(String name, String address, String email) {
        this.Name = name;
        this.Address = address;
        this.Email = email;
    }

    /**
     * Returns a string representation of the publisher
     * @return String representation of the publisher
     */
    public String toString() {
        return this.Name + " (" + this.Address + ", " + this.Email + ")";
    }

    /**
     * Adds a publisher to the bookshelf
     * @throws IOException
     */
    public static void addPublisher() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Add new Publisher");
        System.out.println("Name:");
        String name = sc.nextLine();
        System.out.println("Address:");
        String address = sc.nextLine();
        System.out.println("Email:");
        String email = sc.nextLine();
        Publisher publisher = new Publisher(name, address, email);
        BookShelf.getInstance().addPublisher(publisher);
        System.out.println("Publisher added successfully");
    }
}
