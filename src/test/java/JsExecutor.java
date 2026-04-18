import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JsExecutor {

    WebDriver driver;
    JavascriptExecutor jsExecutor;

    @BeforeMethod
    public void OpenTestPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
        jsExecutor = (JavascriptExecutor) driver;
    }

    //get alert box
    @Test
    public void jsexecutorTest() throws InterruptedException {


//    jsExecutor.executeScript("alert('Welcome');");

        //set a input value in a textbox
        WebElement inputNameTextBox = driver.findElement(By.xpath("//*[@id=\"name\"]"));
        jsExecutor.executeScript("arguments[0].value='Kavinash';", inputNameTextBox);

        Thread.sleep(3000);

        //Highlight element
        jsExecutor.executeScript("arguments[0].style.border='3px solid red'", inputNameTextBox);
        jsExecutor.executeScript("arguments[0].style.background='yellow'", inputNameTextBox);

        Thread.sleep(3000);
        //click Element
        WebElement malecheckBox = driver.findElement(By.xpath("(//input[@id='male'])"));
        jsExecutor.executeScript("arguments[0].click()", malecheckBox);

        Thread.sleep(3000);


    }

    @Test
    //scrolling page
    public void scrollPage() throws InterruptedException {
        jsExecutor.executeScript("window.scrollTo(0,1000)");

        Thread.sleep(3000);
        jsExecutor.executeScript("window.scrollTo(0,0)");

        Thread.sleep(3000);
        WebElement scrollElement=driver.findElement(By.xpath("//*[@id=\"post-body-1307673142697428135\"]/div[3]/label"));
        jsExecutor.executeScript("arguments[0].scrollIntoView(true)", scrollElement);
    }
}







