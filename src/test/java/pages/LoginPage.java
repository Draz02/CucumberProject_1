package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage extends CommonMethods {

    @FindBy(id = "txtUsername")
    public WebElement username;

    @FindBy(id = "txtPassword")
    public WebElement password;

    @FindBy(id = "btnLogin")
    public WebElement loginBtn;

    @FindBy(id = "menu_pim_viewPimModule")
    public WebElement pimButton;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }
}
