package ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtentReportManager {

    private static final String reportDir = System.getProperty("user.dir") + "/Reports/ndosiAutomationReport.html";

    private static ExtentReports extentReports;
    private static ExtentSparkReporter extentSparkReporter;

    public static ExtentReports extentReports() {

        System.out.println("====================================");
        System.out.println(">>> ExtentReportManager called");
        System.out.println(">>> Report path: " + reportDir);

        // Force create the Reports folder
        File reportFile = new File(reportDir);
        reportFile.getParentFile().mkdirs();
        System.out.println(">>> Reports folder exists: " + reportFile.getParentFile().exists());
        System.out.println("====================================");

        extentReports = new ExtentReports();
        extentSparkReporter = new ExtentSparkReporter(reportFile);
        extentReports.attachReporter(extentSparkReporter);

        extentSparkReporter.config().setDocumentTitle("Extent Report");
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setReportName("Ndosi Automation");

        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
        extentReports.setSystemInfo("Execution Machine", System.getProperty("user.name"));

        return extentReports;
    }
}