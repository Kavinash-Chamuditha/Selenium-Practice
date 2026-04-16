import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FrameExample {

    WebDriver driver;

    @BeforeMethod
    public void OpenTestPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/frame.xhtml");
    }

    @Test
    public  void frameTest(){

        driver.switchTo().frame(0);
        WebElement  button1= driver.findElement(By.xpath("//button[@id='Click']"));
        button1.click();
        String afterclick =button1.getText();
        System.out.println("After click" +afterclick);


        driver.switchTo().defaultContent();

        driver.switchTo().frame(2);
        driver.switchTo().frame("frame2");

        WebElement button3=driver.findElement(By.id("Click"));
        button3.click();
        String afterclick1 = button3.getText();
        System.out.println("After click" +afterclick1);

        driver.switchTo().defaultContent();
        List<WebElement> count=driver.findElements(By.tagName("iframe"));
        count.size();
        System.out.println("iframe count" +count.size());



    }


}
