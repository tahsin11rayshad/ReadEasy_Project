package readEasy;

import java.io.IOException;
import java.util.Scanner;

public class Publisher {
    public String Name;
    public String Address;
    public String Email;

    public Publisher(String name, String address, String email) {
        this.Name = name;
        this.Address = address;
        this.Email = email;
    }

    public String toString() {
        return this.Name + " (" + this.Address + ", " + this.Email + ")";
    }

    public static void addPublisher() throws IOException, IOException {
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
