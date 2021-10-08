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
    private WebElement amount;

    @FindBy(id="tf_description")
    private WebElement description;

    @FindBy(id = "btn_submit")
    private WebElement continueButton;

    @FindBy(id = "btn_submit")
    private WebElement submitButton;

    public void clickAccountDropdown(){
        toAccountDropdown.click();
    }
    public void clickSecondOptionAmount(){
        thirdOptionAmount.click();
    }
    public void sendKeysAmount(){
        amount.sendKeys("300");
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

}
