package pages;

import control.Label;
import org.openqa.selenium.By;

public class CentralSession {
    public Label projectNameLabel= new Label(By.xpath("//div[@id='CurrentProjectTitle']"));
}
