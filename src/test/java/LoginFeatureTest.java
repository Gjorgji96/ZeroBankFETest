import Pages.HomePage;
import Pages.LogInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LoginFeatureTest {
    public static String expectedResult = "Log in to ZeroBank";
    public ChromeOptions chromeOptions = new ChromeOptions();
    public WebDriver driver;
    public HomePage homePage;
    public LogInPage logInPage;

    @BeforeClass
    public void beforeClass() {
        chromeOptions.addArguments("--allow-insecure-localhost");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--ignore-certificate-errors");

        driver = new ChromeDriver(chromeOptions);
        homePage = new HomePage(driver);
        logInPage = new LogInPage(driver);

        driver.get("http://zero.webappsecurity.com/index.html");
        homePage.clickElement();

    }

    @Test
    public void incorrectUsernameInputTest() {
        logInPage.incorrectUsername();
        logInPage.passwordInput();
        logInPage.signInButton();

        String expected = "Login and/or password are wrong.";
        Assert.assertEquals(logInPage.getWrongUsernameMessage(), expected);
    }

    @Test
    public void successfulLoginTest() {

        logInPage.usernameInput();
        logInPage.passwordInput();
        logInPage.signInButton();

        String expectedUrl = "account-summary.html";
        String currentUrl = driver.getCurrentUrl();
        boolean isCorrectUrl = currentUrl.contains(expectedUrl);
        Assert.assertTrue(isCorrectUrl);

    }


    @AfterClass
    public void afterClass() {
        driver.close();
        driver.quit();

    }


}

