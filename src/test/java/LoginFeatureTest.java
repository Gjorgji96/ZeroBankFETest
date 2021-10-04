import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class LoginFeatureTest {
    private static final WebDriver driver = new ChromeDriver();
    static HomePage homePage = new HomePage();

    @Test
    public void successfulLoginTest(){
        driver.get("http://zero.webappsecurity.com/index.htmlm");
        homePage.clickElement();



        driver.quit();

    }
    }

