import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class BrokenImageExample {

    WebDriver driver;

    @BeforeMethod
    public void OpenTestPage(){
        driver =  new ChromeDriver();
        Dimension newSize =new Dimension(800,900);
        driver.manage().window().setSize(newSize);

    }


    @Test
    public void findBrokenImageTest(){

        driver.get("https://the-internet.herokuapp.com/broken_images");
        List<WebElement> images=driver.findElements(By.xpath("//div[@class='example']/img"));

        for(WebElement image:images) {
            if(image.getAttribute("naturalWidth").equals("0")){
                System.out.println("Image is broken");
            }
            else{
                System.out.println("Image is not broken");
            }

        }

    }


    @Test
    public void calenderTest(){



        driver.get("https://jqueryui.com/datepicker/");

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
        driver.findElement(By.id("datepicker")).sendKeys("4/17/2026");


    }
}
