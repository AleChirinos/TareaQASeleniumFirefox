package pages;

import control.Button;
import control.Label;
import control.TextBox;
import org.openqa.selenium.By;

public class Central {
    public Label projectNameLabel= new Label(By.xpath("//div[@id='CurrentProjectTitle']"));
    public Button opciones = new Button(By.xpath("//*[@id=\"ctl00_HeaderTopControl1_PanelHeaderButtons\"]/a[1]"));
    public TextBox fullName = new TextBox(By.xpath("//*[@id=\"FullNameInput\"]"));
    public Button okButton = new Button(By.xpath("/html/body/div[9]/div[2]/div/button[1]/span"));
}
