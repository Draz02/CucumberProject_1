package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.CommonMethods;

public class hooks extends CommonMethods {

    @Before
    public void start() {

        openBrowserAndLaunchApplication();
    }

    @After
    public void end() {
        closeBrowser();
    }
}
