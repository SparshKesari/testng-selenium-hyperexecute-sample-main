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

    // add a test to verify the title of the page   
    @Test
    public void verifyTitle()
    {
        driver.get(testURL);
        if (driver.getTitle().equals(testURLTitle))
        {
            status = "passed";
        }
        else
        {
            status = "failed";
        }
    }

        
}