import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseActions
{
    WebDriver driver;

    @BeforeMethod
    public void OpenTestPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/drag.xhtml");}

    @Test
    public void mouseOperations() throws InterruptedException {


    Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("menuform:j_idt37"))).perform();
        Thread.sleep(3000);
        actions.moveToElement(driver.findElement(By.id("menuform:j_idt38"))).perform();
        Thread.sleep(3000);
        actions.moveToElement(driver.findElement(By.id("menuform:j_idt39"))).perform();
        Thread.sleep(3000);

        WebElement from =driver.findElement(By.id("form:drag"));
        WebElement to =driver.findElement(By.id("form:drop"));

        //actions.clickAndHold(from).moveToElement(to).release(to).perform();
        actions.dragAndDrop(from,to).perform();

       WebElement sp1 =driver.findElement(By.xpath("(//div[@id='form:j_idt125'])/span[1]"));
        System.out.println("Location"+sp1.getLocation());;
        actions.dragAndDropBy(sp1,50,0).perform();
        System.out.println("After moving Location"+sp1.getLocation());;




    }




}
