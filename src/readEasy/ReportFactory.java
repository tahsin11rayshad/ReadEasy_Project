package readEasy;
import report.iReport;

import java.io.IOException;
import java.util.Scanner;

public class ReportFactory {
    private static ReportFactory instance;
    private ReportFactory() {
    }
    public static ReportFactory getInstance() {
        if (instance == null) {
            instance = new ReportFactory();
        }
        return instance;
    }

    public int getType(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose report type: ___________________________");
        String[] types = {
                "Show All Authors",
                "Show All Publishers",
                "Show All Genre",
                "Show All Books",
                "Show All BookMarks",
                "Show All Books By Author",
                "Show All Books By Publisher",
                "Show All Books By Genre",
                "Show All Books By Author And Genre",
                "Show All Books By Publisher And Genre"};
        for (int i = 0; i < types.length; i++) {
            System.out.println((i + 1) + ". " + types[i]);
        }

        int type = sc.nextInt();
        return type;
    }

    public void showReport() throws IOException {
        int type = getType();
        report.iReport report = getReport(type);
        report.printReport();
    }

    public report.iReport getReport(int type) {
        switch (type) {
            case 1:
                return new report.allAuthorReport();
            case 2:
                return new report.allPublisherReport();
            case 3:
                return new report.genreReport();
            case 4:
                return new report.allBookReport();
//            case 5:
//                return new report.allBookMarkReport();
            case 6:
                return new report.allBookByAuthorReport();
            case 7:
                return new report.allBookByPublisherReport();
            case 8:
                return new report.allBookByGenreReport();
            case 9:
                return new report.allBookByAuthorAndGenreReport();
            case 10:
                return new report.allBookByPublisherAndGenreReport();
            default:
                return null;
        }
    }
}
