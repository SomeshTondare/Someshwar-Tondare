package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExtentReportManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            try {
                Path reportDir = Paths.get("reports").toAbsolutePath();
                Files.createDirectories(reportDir);

                String reportPath = reportDir.resolve("ExtentReport.html").toString();
                ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
                sparkReporter.config().setDocumentTitle("Automation Report");
                sparkReporter.config().setReportName("Swag Labs Test Execution");
                sparkReporter.config().setTheme(Theme.STANDARD);

                extent = new ExtentReports();
                extent.attachReporter(sparkReporter);
                extent.setSystemInfo("Tester", "QA Engineer");

                System.out.println("Extent Report initialized at: " + reportPath);

            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to initialize Extent Report: " + e.getMessage());
            }
        }
        return extent;
    }
}
