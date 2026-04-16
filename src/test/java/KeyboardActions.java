import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

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


@Test
    public void KeyboardTest2() throws InterruptedException {
        driver.get("https://www.leafground.com/list.xhtml");

        Thread.sleep(3000);
    List<WebElement> selectors=driver.findElements(By.xpath("(//ul[@aria-label='From'])/li"));
    int size=selectors.size();
    System.out.println("Selectoable size is" +selectors.size());
    Actions actions=new Actions(driver);
    actions.keyDown(Keys.CONTROL)
            .click(selectors.get(0)).
                    click(selectors.get(1)).
                            click(selectors.get(2)).
                                    click(selectors.get(3)).perform();


    }

}
