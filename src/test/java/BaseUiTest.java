package test.java;

import main.java.Init;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class BaseUiTest extends Init {
    @BeforeSuite(alwaysRun = true)
    public void setup() throws IOException {
        browserSetup();
        initLogger();
    }

    @AfterSuite(alwaysRun = true)
    public void cleanUp() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.close();
        }
    }
}
