package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TransferFundsPage extends BasePage {

    public TransferFundsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "tf_toAccountId")
    private WebElement toAccountDropdown;

    @FindBy(xpath ="/html/body/div[1]/div[2]/div/div[2]/form/div/div/div[1]/div/article/fieldset/div[2]/div/select/option[3]")
    private WebElement thirdOptionAmount;

    @FindBy(id="tf_amount")
    private WebElement amountSet;

    @FindBy(id="tf_description")
    private WebElement description;

    @FindBy(id = "btn_submit")
    private WebElement continueButton;

    @FindBy(id = "btn_submit")
    private WebElement submitButton;

    @FindBy(css  = "div[id=\"transfer_funds_content\"]>div[class=\"offset2 span8\"]>div>div[class=" +
            "\"alert alert-success\"]")
    private WebElement confirmMessage;

    @FindBy(css = "div[class=\"board\"]>div[class=\"board-content\"]>div[class=\"row\"]")
    private WebElement fromAccountSavings;

    @FindBy(css="#transfer_funds_content > div > div > div.board > div > div:nth-child(2)")
    private WebElement toAccountSavings;

    @FindBy(css="#transfer_funds_content > div > div > div.board > div > div:nth-child(3)")
    private WebElement amount;

    @FindBy(css="#transfer_funds_content > div > div > h2")
    private WebElement transferFundHeader;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/div/a")
    private WebElement viewAnotherTransfersLink;

    public void clickAccountDropdown(){
        toAccountDropdown.click();
    }
    public void clickSecondOptionAmount(){
        thirdOptionAmount.click();
    }
    public void sendKeysAmount(){
        amountSet.sendKeys("300");
    }
    public void setDescription(){
        description.sendKeys("prefrlam");
    }
    public void clickContinue(){
        continueButton.click();
    }
    public void clickSubmitButton(){
        submitButton.click();
    }

    public  String confirmMessage (){
        return confirmMessage.getText();
        }
    public String fromAccountSavingsMessage(){
        return fromAccountSavings.getText();
    }
    public String toAccountsMessage(){
        return toAccountSavings.getText();
    }
    public String amountMessage() {
       return amount.getText();
    }
    public String headerText(){
        return transferFundHeader.getText();
    }
    public void clickViewButton(){
        viewAnotherTransfersLink.click();
    }
}


