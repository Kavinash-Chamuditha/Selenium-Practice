import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JsExecutor {

    WebDriver driver;

    @BeforeMethod
    public void OpenTestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
    }

    //get alert box
@Test
    public void jsexecutorTest(){
    JavascriptExecutor jsExecutor= (JavascriptExecutor) driver;

//    jsExecutor.executeScript("alert('Welcome');");

    //set a input value in a textbox
    WebElement inputNameTextBox=driver.findElement(By.xpath("//*[@id=\"name\"]"));
    jsExecutor.executeScript("arguments[0].value='Kavinash';",inputNameTextBox);

    }


}
