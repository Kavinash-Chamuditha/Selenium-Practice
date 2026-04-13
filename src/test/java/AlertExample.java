import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertExample {

    WebDriver driver;

    @BeforeMethod
    public void OpenTestPage(){
        driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/alert.xhtml");
    }

    @Test
    public  void AlertTest() throws InterruptedException{
        driver.findElement(By.id("j_idt88:j_idt91")).click();
        driver.switchTo().alert().accept();

        driver.findElement(By.id("j_idt88:j_idt93")).click();
        driver.switchTo().alert().dismiss();

        WebElement promtBox=driver.findElement(By.id("j_idt88:j_idt104"));
        promtBox.click();
        Alert alert=driver.switchTo().alert();
        Thread.sleep(3000);
        String alertText=alert.getText();
        System.out.println("Alert text is" +alertText);
        alert.sendKeys("Im Kavinash");
        alert.accept();




    }






}
