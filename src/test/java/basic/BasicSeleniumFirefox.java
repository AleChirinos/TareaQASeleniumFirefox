package basic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasicSeleniumFirefox {

    FirefoxDriver firefoxDriver;

    @BeforeEach
    public void openBrowser(){
        System.setProperty("webdriver.gecko.driver","src/test/resources/driver/geckodriver.exe");
        firefoxDriver = new FirefoxDriver();
        firefoxDriver.manage().window().maximize();
        firefoxDriver.get("https://www.selenium.dev/");
    }


    @Test
    public void goToGoogle() throws InterruptedException {
        Thread.sleep(5000);
    }

    @AfterEach
    public void closeBrowser(){
        firefoxDriver.quit();
    }
}
