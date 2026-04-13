import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class RadioCheckBoxExample {


    WebDriver driver;

    @BeforeMethod
    public void OpenTestPage(){
        driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/input.xhtml");
    }

    @Test
    public  void  radioTests(){

        driver.get("https://www.leafground.com/radio.xhtml");
        boolean chromeRadioOption=driver.findElement(By.id("j_idt87:console2:0")).isSelected();
        boolean firefoxRadioOption=driver.findElement(By.id("j_idt87:console2:1")).isSelected();
        boolean safariRadioOption=driver.findElement(By.id("j_idt87:console2:2")).isSelected();
        boolean edgeRadioOption=driver.findElement(By.id("j_idt87:console2:3")).isSelected();

        if (chromeRadioOption) {
            String chromeText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:0']")).getText();
            System.out.println("default select radio button is: " + chromeText);

        } else if (firefoxRadioOption) {
            String firefoxText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:1']")).getText();
            System.out.println("default select radio button is: " + firefoxText);

        } else if (safariRadioOption) {
            String safariText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:2']")).getText();
            System.out.println("default select radio button is: " + safariText);

        } else if (edgeRadioOption) {
            String edgeText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:3']")).getText();
            System.out.println("default select radio button is: " + edgeText);
        }

        WebElement myAgeGroup= driver.findElement(By.id("j_idt87:age:0"));
        boolean isChecked=myAgeGroup.isSelected();
        if(!isChecked)
        {
            driver.findElement(By.xpath("//label[@for='j_idt87:age:0']")).click();
        }




    }

    @Test
    public void checkBoxTest() {

        driver.get("https://www.leafground.com/checkbox.xhtml");

        List<WebElement> checkBoxList =
                driver.findElements(By.xpath("//table[@id='j_idt87:basic']//label"));

        for (WebElement element : checkBoxList) {
            if (!element.getText().equals("Others")) {
                element.click();
            }
        }

        for (int i = 1; i <= checkBoxList.size(); i++) {
            boolean selected = driver.findElement(
                    By.xpath("(//table[@id='j_idt87:basic']//input)[" + i + "]")
            ).isSelected();

            System.out.println("CheckBox " + i + " selected status: " + selected);
        }
    }}