package steps;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AddEmployeePage;
import utils.CommonMethods;
import utils.excelReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class addEmployeeSteps extends CommonMethods {

    AddEmployeePage addEmployeePage = new AddEmployeePage();

    @When("user clicks add employee option")
    public void user_clicks_add_employee_option() {
        click(addEmployeePage.addEmployeeButton);
    }

    @When("user enters first name and last name")
    public void user_enters_first_name_and_last_name() throws IOException {
        List<Map<String,String>> employeeNames = excelReader.read();

        for (Map<String,String> employees: employeeNames) {
            addEmployeePage.firstname.sendKeys(employees.get("firstName"));
            addEmployeePage.lastname.sendKeys(employees.get("lastName"));

            addEmployeePage.saveButton.click();
            addEmployeePage.addEmployeePimTab.click();
        }
    }


    @When("user enters first name, last name, and employee ID")
    public void user_enters_first_name_last_name_and_employee_id() throws IOException {
        List<Map<String,String>> newEmployees = excelReader.read();

        for (Map<String,String> employee: newEmployees) {
            addEmployeePage.employeeId.clear();

            addEmployeePage.firstname.sendKeys(employee.get("firstName"));
            addEmployeePage.lastname.sendKeys(employee.get("lastName"));
            addEmployeePage.employeeId.sendKeys(employee.get("employeeId"));

            addEmployeePage.saveButton.click();
            addEmployeePage.addEmployeePimTab.click();
        }
    }


    @When("user enters incorrect first name and last name error pops up")
    public void user_enters_incorrect_first_name_and_last_name_error_pops_up() {

        // Clear and test empty fields
        addEmployeePage.firstname.clear();
        addEmployeePage.lastname.clear();
        addEmployeePage.saveButton.click();

        // Simple locator for validation messages
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Check first name validation
        WebElement firstNameError = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//span[@for='firstName' and @class='validation-error']")
        ));

        // Check last name validation
        WebElement lastNameError = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//span[@for='lastName' and @class='validation-error']")
        ));

        if (firstNameError.isDisplayed() && lastNameError.isDisplayed())
            System.out.println("Validation errors displayed successfully");

    }
}
