import readEasy.*;
import report.*;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] options = {"1. Add new Author\n" +
                "2. Add new Publisher\n" +
                "3. Add new Book\n" +
                "4. Add new BookMark\n" +
                "5. Remove BookMark\n" +
                "6. Show Reports\n" +
                "7. Exit\n" };
        int option = 0;
        while (option != 7) {
            System.out.println("\n\n\nSelect an option:");
            for (String s : options) {
                System.out.println(s);
            }
            option = sc.nextInt();
            switch (option) {
                case 1:
                    Author.addAuthor();
                    break;
                case 2:
                    Publisher.addPublisher();
                    break;
                case 3:
                    Book.addBook();
                    break;
                case 4:
                    BookMark.addBookMark();
                    break;
                case 5:
                    BookMark.removeBookMark();
                    break;
                case 6:
                    ReportFactory.getInstance().showReport();
                    break;
                case 7:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }

    }


}