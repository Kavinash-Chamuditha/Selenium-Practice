import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonExample {

    WebDriver driver;

    @BeforeMethod
    public void OpenTestPage(){
        driver =  new ChromeDriver();
        Dimension newSize =new Dimension(800,900);
        driver.manage().window().setSize(newSize);
        driver.get("https://www.leafground.com/button.xhtml");
    }

    @Test
    public void buttonTest(){

        driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']")).click();
        String expectedTitle = "Dashboard";
        String actualTitle =driver.getTitle();
        if (expectedTitle.equals(actualTitle)) {
            System.out.println("Actual title same as expected");
        }
        else
            {
                System.out.println("Actual title not same as expected");
            }

        driver.navigate().back();
        WebElement getPosition= driver.findElement(By.id("j_idt88:j_idt94"));
        Point xypoint= getPosition.getLocation();
        int x= xypoint.getX();
        int y= xypoint.getX();
        System.out.println("x position is "+x+ "y position is "+y);

        WebElement buttonColor= driver.findElement(By.id("j_idt88:j_idt96"));
        String Color= buttonColor.getCssValue("background");
        System.out.println("Button Color is" +Color);

        WebElement size= driver.findElement(By.id("j_idt88:j_idt94"));
        int Height= size.getSize().getHeight();
        int Width= size.getSize().getWidth();
        System.out.println("Height"  +Height+ "Width" +Width);
    }



}
