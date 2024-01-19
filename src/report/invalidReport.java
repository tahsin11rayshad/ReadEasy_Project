package report;
import readEasy.*;

import java.io.IOException;

/**
 * A class that prints invalid report message when invalid report type is selected by the user.
 * This class implements the iReport interface.
 * @author Tahsin Islam
 */
public class invalidReport implements iReport{
    /**
     * Prints invalid report message when invalid report type is selected by the user.
     * @throws IOException
     */
    public void printReport() throws IOException {
        System.out.println("No such report exists.");
    }
}
