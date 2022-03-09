package basic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BasicSeleniumClases {
    ChromeDriver chromeDriver;
    @BeforeEach
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver = new ChromeDriver();
        // implicit wait
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        chromeDriver.manage().window().maximize();
        chromeDriver.get("http://todo.ly/");
    }


    @Test
    public void goToGoogle() throws InterruptedException {

        // click img login
        chromeDriver.findElement(By.xpath("//img[@src='/Images/design/pagelogin.png']")).click();
        // set text email
        chromeDriver.findElement(By.xpath("//input[@name='ctl00$MainContent$LoginControl1$TextBoxEmail']")).sendKeys("ale@gmail.com");
        // set test pwd
        chromeDriver.findElement(By.xpath("//input[contains(@name,'LoginControl1$TextBoxPassword')]")).sendKeys("1234567");
        // click boton login
        chromeDriver.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();
        Thread.sleep(3000);

        ////*[@id="MainTable"]/tbody/tr/td[1]/div[6]/div
        chromeDriver.findElement(By.id("Div2")).click();
        Thread.sleep(1000);
        chromeDriver.findElement(By.id("NewProjNameInput")).sendKeys("AleProject");
        chromeDriver.findElement(By.id("NewProjNameButton")).click();
        Thread.sleep(3000);

        //Assertions.assertEquals( chromeDriver.findElement(By.id("CurrentProjectTitle")).getText(), "AleProject", "ERROR! no se pudo crear el proecto");

        //*[@id="ItemId_3982511"]
        chromeDriver.findElement(By.xpath("//*[@id=\"ItemId_3982511\"]")).click();
        chromeDriver.findElement(By.xpath("//*[@id=\"ItemId_3982511\"]/table/tbody/tr/td[4]/div[2]")).click();
        Thread.sleep(1000);
        chromeDriver.findElement(By.xpath("//*[@id=\"projectContextMenu\"]/li[1]")).click();
        Thread.sleep(1000);
        chromeDriver.findElement(By.id("ItemEditTextbox")).clear();
        chromeDriver.findElement(By.id("ItemEditTextbox")).sendKeys("update123");
        chromeDriver.findElement(By.id("ItemEditSubmit")).click();
        Thread.sleep(3000);

        Assertions.assertEquals( chromeDriver.findElement(By.id("CurrentProjectTitle")).getText(), "update123", "ERROR! no se pudo crear el proecto");
    }

    @AfterEach
    public void closeBrowser(){
        chromeDriver.quit();
    }
}
