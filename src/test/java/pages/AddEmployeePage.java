package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {
    @FindBy(id = "firstName")
    public WebElement firstname;

    @FindBy(id = "lastName")
    public WebElement lastname;

    @FindBy(id = "btnSave")
    public WebElement saveButton;

    @FindBy(id = "btnAdd")
    public WebElement addEmployeeButton;

    @FindBy(id = "employeeId")
    public WebElement employeeId;

    @FindBy(id = "menu_pim_addEmployee")
    public WebElement addEmployeePimTab;


    public AddEmployeePage() {
        PageFactory.initElements(driver, this);
    }
}
