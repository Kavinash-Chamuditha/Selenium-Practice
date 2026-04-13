import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestBoxExample {

    WebDriver driver;

    @BeforeMethod
    public void OpenTestPage(){
        driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/input.xhtml");
    }


    @Test
    public void textBoxTest(){
        WebElement name=driver.findElement(By.id("j_idt88:name"));
        name.sendKeys("Kavinash");


        WebElement appendText=driver.findElement(By.id("j_idt88:j_idt91"));
        appendText.sendKeys("Sri lanka");

        boolean enabled=driver.findElement(By.id("j_idt88:j_idt93")).isEnabled();
        System.out.println("Is Text Box Enabaled" +enabled);

        WebElement clearText= driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt95\"]"));
        clearText.clear();

        WebElement TEXTelement = driver.findElement(By.id("j_idt88:j_idt97"));
        String value=TEXTelement.getAttribute("value");
        System.out.println(value);

        driver.findElement(By.id("j_idt88:j_idt99")).sendKeys("oshanachamuditha@gmail.com" + Keys.TAB +"Confirm control moved to next element");

    }



}
