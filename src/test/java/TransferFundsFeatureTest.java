import Pages.AccountSummaryPage;
import Pages.LogInPage;
import Pages.TransferFundsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TransferFundsFeatureTest {
    public LogInPage logInPage;
    public ChromeOptions chromeOptions = new ChromeOptions();
    public WebDriver driver;
    private AccountSummaryPage accountSummaryPage ;
    private TransferFundsPage transferFundsPage;


    @BeforeClass
    public void beforeClass(){
        chromeOptions.addArguments("--allow-insecure-localhost");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--ignore-certificate-errors");

        driver = new ChromeDriver(chromeOptions);
        logInPage = new LogInPage(driver);
        accountSummaryPage = new AccountSummaryPage(driver);

        driver.get("http://zero.webappsecurity.com/login.html");

        logInPage.usernameInput();
        logInPage.passwordInput();
        logInPage.signInButton();

        accountSummaryPage.clickTransferFunds();

    }

    @Test
    public void successfullTransferMoney(){
        transferFundsPage = new TransferFundsPage(driver);
        transferFundsPage.clickAccountDropdown();
        transferFundsPage.clickSecondOptionAmount();
        transferFundsPage.sendKeysAmount();
        transferFundsPage.setDescription();
        transferFundsPage.clickContinue();
        transferFundsPage.clickSubmitButton();





    }
}
