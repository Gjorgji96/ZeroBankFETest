package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage{

    public LogInPage(WebDriver driver){
        super(driver);

    }
    @FindBy(className = "page-header")
    private WebElement logInHeader;

    @FindBy(css = "input[name=\"user_login\"]")
    private WebElement usernameLoginInput;

    @FindBy(css = "input[name =\"user_password\"]")
    private WebElement passwordLoginInput;

    @FindBy(css = "input[name=\"submit\"]")
    private WebElement signInButton;

    @FindBy(css = "div[class=\"alert alert-error\"] ")
    private WebElement wrongUsernameDisplayMessage;


    public boolean isHeaderDisplayed(){
      return  logInHeader.isDisplayed();
    }
    public String headerText(){
       return logInHeader.getText();
    }
    public void usernameInput(){
        usernameLoginInput.sendKeys("username");
    }
    public void incorrectUsername(){
        usernameLoginInput.sendKeys("HorhePapito");
    }
    public void passwordInput(){
        passwordLoginInput.sendKeys("password");
    }
    public void signInButton(){
        signInButton.click();
    }
    public String getWrongUsernameMessage(){
        return wrongUsernameDisplayMessage.getText();
    }


}
