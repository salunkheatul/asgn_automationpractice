package main.java;

import com.sun.javafx.util.Utils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Init {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Properties prop;
    protected static Logger log;


    protected Init() {
        //Default Constructor
    }

    protected static void browserSetup() throws IOException {
        InputStream input = new FileInputStream("src/main/resources/env.properties");
        prop = new Properties();
        prop.load(input);
        switch (prop.getProperty("BROWSER")) {
            case "chrome":
                String chromeBrowserPath = "";
                if (Utils.isMac())
                    chromeBrowserPath = "src/main/resources/drivers/chrome/mac/chromedriver";
                else if (Utils.isWindows())
                    chromeBrowserPath = "src/main/resources/drivers/chrome/win32/chromedriver.exe";
                else if (Utils.isUnix())
                    chromeBrowserPath = "src/main/resources/drivers/chrome/linux64/chromedriver";
                System.setProperty("webdriver.chrome.driver", chromeBrowserPath);

                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-fullscreen");
                options.setHeadless(false);
                driver = new ChromeDriver(options);

                break;

            case "firefox":
                String firefoxBrowserPath = "";
                if (Utils.isMac())
                    firefoxBrowserPath = "src/main/resources/drivers/firefox/mac/geckodriver";
                else if (Utils.isWindows())
                    firefoxBrowserPath = "src/main/resources/drivers/firefox/win32/geckodriver.exe";
                else if (Utils.isUnix())
                    firefoxBrowserPath = "src/main/resources/drivers/firefox/linux/geckodriver";
                System.setProperty("webdriver.gecko.driver", firefoxBrowserPath);
                driver = new FirefoxDriver();
                break;

            default:
                log.info("load default browser");
                break;
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        setExplicitWait(driver);
    }

    protected static void initLogger() {
        log = Logger.getRootLogger();

        String log4JPropertyFile = "src/main/resources/log4j.properties";
        Properties p = new Properties();

        try {
            p.load(new FileInputStream(log4JPropertyFile));
        } catch (IOException e) {
            log.trace("init logger failed", e);
        }
        PropertyConfigurator.configure(p);
    }

    private static void setExplicitWait(WebDriver driver) {
        wait = new WebDriverWait(driver, 2000);
    }

}
