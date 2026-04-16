import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KeyboardActions {
    WebDriver driver;

    @BeforeMethod
    public void OpenTestPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test
    public  void KeyBoardTest() throws InterruptedException {
        driver.get("https://www.google.com/");
        WebElement googlesearchtestBox=driver.findElement(By.name("q"));
        googlesearchtestBox.sendKeys("Welcome");
        Actions actions=new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        Thread.sleep(5000);

        actions.keyDown(Keys.SHIFT).
                sendKeys("Capital Letters").perform();
        Thread.sleep(5000);


                actions.keyUp(Keys.SHIFT).keyDown(Keys.CONTROL).
                sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.CONTROL).sendKeys("X").perform();
    }


//@Test
//    public void KeyboardTest2(){
//        driver.get("https://www.leafground.com/list.xhtml");
//
//    }

}
