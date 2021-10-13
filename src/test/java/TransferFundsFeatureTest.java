import Pages.AccountSummaryPage;
import Pages.LogInPage;
import Pages.TransferFundsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
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
    public void successfulTransferMoney(){
        transferFundsPage = new TransferFundsPage(driver);
        transferFundsPage.clickAccountDropdown();
        transferFundsPage.clickSecondOptionAmount();
        transferFundsPage.sendKeysAmount();
        transferFundsPage.setDescription();
        transferFundsPage.clickContinue();
        transferFundsPage.clickSubmitButton();


        String expected  = "You successfully submitted your transaction.";
        String expected1 = "From Account\n" +
                "Savings";
        String expected2 = "To Account\n" +
                "Savings";
        String expected3 = "Amount\n" +
                "$ 300";
        String expectedHeaderText = "Transfer Money & Make Payments - Confirm";

        Assert.assertEquals(transferFundsPage.confirmMessage(),expected);
        Assert.assertEquals(transferFundsPage.fromAccountSavingsMessage(),expected1);
        Assert.assertEquals(transferFundsPage.toAccountsMessage(),expected2);
        Assert.assertEquals(transferFundsPage.amountMessage(),expected3);
        Assert.assertEquals(transferFundsPage.headerText(),expectedHeaderText);

        transferFundsPage.clickViewButton();

        String expectedUrl="/bank/transfer-funds.html";
        String actualUrl = driver.getCurrentUrl();
        boolean url = actualUrl.contains(expectedUrl);
        Assert.assertTrue(url);


    }
    @AfterClass
    public void afterClass(){
        driver.close();
        driver.quit();
    }
}
