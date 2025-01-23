package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;
import java.time.Duration;

public class LoginSteps extends CommonMethods {

    LoginPage loginPage = new LoginPage();

    @Given("user is able to access hrms website")
    public void user_is_able_to_access_hrms_website() {
        driver = new ChromeDriver();    // opening the website
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/admin/viewAdminModule");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @When("user enters valid login and password information")
    public void user_enters_valid_login_and_password_information() {
        sendText(ConfigReader.read("userName"), loginPage.username); // login details for website
        sendText(ConfigReader.read("password"), loginPage.password);
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        click(loginPage.loginBtn);
    }

    @Then("user is able to see dashboard page")
    public void user_is_able_to_see_dashboard_page() {
        WebElement dashboard = driver.findElement(By.xpath("//a[@id='welcome']"));
        String welcome = dashboard.getText();
        if (welcome.equals("Welcome Admin")) {
            System.out.println("passed dashboard: TRUE");
        } else {
            System.out.println("passed dashboard: FALSE!!!");
        }
    }

    @When("user clicks on pim option")
    public void user_clicks_on_pim_option() {
        click(loginPage.pimButton);
    }

    @When("user enters invalid login and password information")
    public void user_enters_invalid_login_and_password_information() {
        sendText("",loginPage.username);
        sendText("admin",loginPage.username);
        sendText("",loginPage.password);
        sendText("Hum@",loginPage.password);


    }
    @Then("user is not able to see dashboard page")
    public void user_is_not_able_to_see_dashboard_page() {
        WebElement errorMsg = driver.findElement(By.id("spanMessage"));
        String errorMessage = errorMsg.getText();

        if (errorMessage.equals("Username cannot be empty")){
            System.out.println("Username cannot be empty.");
        } else if (errorMessage.equals("Password is Empty")) {
            System.out.println("Password is empty.");
        } else {
            System.out.println("All Login errors: WORKING");
        }
    }
}
