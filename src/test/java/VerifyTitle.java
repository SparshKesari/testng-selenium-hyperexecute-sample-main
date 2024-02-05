import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class VerifyTitle
{
    WebDriver driver = null;
    public static String status = "passed";
    String username = Test1.username;
    String access_key = Test1.access_key;

//    String testURL = "https://todomvc.com/examples/react/#/";
    String testURL = "https://lambdatest.github.io/sample-todo-app/";
    String testURLTitle = "Sample page - lambdatest.com";

    // add a test case to verify the title of the page
    @Test(description="Verify the title of the page")  
    public void test1_verify_title() throws InterruptedException
    {
        ExtentReports extent = new ExtentReports("target/surefire-reports/html/extentReport.html");
        ExtentTest test1 = extent.startTest("demo application test 1-1", "To Do App test 1");

        try
        {
            driver = new RemoteWebDriver(new URL("https://" + username + ":" + access_key + "@hub.lambdatest.com/wd/hub"), 
                DesiredCapabilities.chrome());
        }
        catch (MalformedURLException e)
        {
            System.out.println("Invalid grid URL");
        }
        System.out.println("Started session");

        driver.get(testURL);
        System.out.println("Navigated to the URL");

        String title = driver.getTitle();
        System.out.println("Title of the page: " + title);
        if (title.equals(testURLTitle))
        {
            test1.log(LogStatus.PASS, "Navigated to the correct URL");
        }
        else
        {
            test1.log(LogStatus.FAIL, "Navigated to the incorrect URL");
            status = "failed";
        }
        extent.endTest(test1);
        extent.flush();
        driver.quit();
    }
}