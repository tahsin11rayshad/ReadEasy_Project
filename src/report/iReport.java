package report;

import java.io.IOException;

/**
 * A functional interface that prints a report.
 * @author Tahsin Islam
 */
@FunctionalInterface
public interface iReport {
    /**
     * Prints a report.
     * @throws IOException
     */
    public void printReport() throws IOException;
}
