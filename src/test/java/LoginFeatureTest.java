import Pages.HomePage;
import Pages.LogInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LoginFeatureTest {
    private static final WebDriver driver = new ChromeDriver();
    static HomePage homePage = new HomePage(driver);
    static LogInPage logInPage = new LogInPage(driver);
    public static String expectedResult = "Log in to ZeroBank";

    @BeforeClass
    public void beforeClass(){
        driver.get("http://zero.webappsecurity.com/index.html");
        homePage.clickElement();

    }

    @Test
    public void successfulLoginTest(){
        driver.get("http://zero.webappsecurity.com/index.html");
        homePage.clickElement();


        String actualResult = logInPage.headerText();
        Assert.assertEquals(expectedResult,actualResult);

        logInPage.usernameInput();
        logInPage.passwordInput();
        logInPage.signInButton();

    }

    @Test
    public void incorrectUsernameInputTest (){
        logInPage.incorrectUsername();
        logInPage.passwordInput();
        logInPage.signInButton();

        String expected  = "Login and/or password are wrong.";
        Assert.assertEquals(logInPage.getWrongUsernameMessage(),expected);
    }
    @AfterClass
            public void afterClass(){
        driver.close();
        driver.quit();

    }


    }

