//package ExtentReports;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//// This class listens to everything TestNG does during test execution
//public class Listener implements ITestListener {
//
//    // Main report object (shared for the whole suite)
//    private static ExtentReports extent;
//
//    // Represents one individual test in the report
//    private static ExtentTest extentTest;
//
//    // Runs BEFORE every single test method starts
//    @Override
//    public void onTestStart(ITestResult result) {
//
//        extentTest = extent.createTest(result.getMethod().getMethodName());
//    }
//
//    // Runs when a test FAILS
//    @Override
//    public void onTestFailure(ITestResult result) {
//
//        extentTest.log(Status.FAIL, "Test Case " + result.getMethod().getMethodName() + " Has failed");
//    }
//
//    // Runs when a test PASSES
//    @Override
//    public void onTestSuccess(ITestResult result) {
//
//        extentTest.log(Status.PASS, "Test Case " + result.getMethod().getMethodName() + " Has passed");
//    }
//
//    // Runs when a test is SKIPPED (e.g., due to dependency failure)
//    @Override
//    public void onTestSkipped(ITestResult result) {
//
//        extentTest.log(Status.SKIP, "Test Case " + result.getMethod().getMethodName() + " Has been skipped");
//    }
//
//    @Override
//    public void onFinish(ITestContext result) {
//        // VERY IMPORTANT: Writes everything to the HTML file
//        // Without flush(), the report will be empty or incomplete
//        extent.flush();
//    }
//
//    // Runs ONCE before any test in the suite starts
//    @Override
//    public void onStart(ITestContext result) {
//        // Initialize the report using our manager class
//        extent = ExtentReportManager.extentReports();
//
//    }
//
//}

package ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext result) {
        System.out.println(">>> Listener.onStart fired");
        extent = ExtentReportManager.extentReports();
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(">>> Listener.onTestStart: " + result.getMethod().getMethodName());
        extentTest.set(extent.createTest(result.getMethod().getMethodName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(">>> Listener.onTestSuccess: " + result.getMethod().getMethodName());
        extentTest.get().log(Status.PASS, "Test Case " + result.getMethod().getMethodName() + " Has passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(">>> Listener.onTestFailure: " + result.getMethod().getMethodName());
        extentTest.get().log(Status.FAIL, "Test Case " + result.getMethod().getMethodName() + " Has failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(">>> Listener.onTestSkipped: " + result.getMethod().getMethodName());
        extentTest.get().log(Status.SKIP, "Test Case " + result.getMethod().getMethodName() + " Has been skipped");
    }

    @Override
    public void onFinish(ITestContext result) {
        System.out.println(">>> Listener.onFinish fired - flushing now");
        extent.flush();
        System.out.println(">>> Flush complete");
    }
}