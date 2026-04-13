import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.Thread.sleep;

public class DropDownExample {

    WebDriver driver;

    @BeforeMethod
    public void OpenTestPage(){
        driver =  new ChromeDriver();
        Dimension newSize =new Dimension(800,900);
        driver.manage().window().setSize(newSize);
        driver.get("https://www.leafground.com/select.xhtml");
    }

    @Test
    public  void DropDownTest(){
        WebElement dropDown= driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select select= new Select(dropDown);
        select.selectByIndex(1);
        select.selectByVisibleText("Playwright");

        List<WebElement> OptionList=select.getOptions();
        int size=OptionList.size();
        System.out.println("Option List "+size);

        for (WebElement element:OptionList){
            System.out.println(element.getText());
        }

        dropDown.sendKeys("Puppeteer");

        WebElement dropDown2= driver.findElement(By.xpath("//div[@id='j_idt87:country']"));
        dropDown2.click();
        List<WebElement> ListOfDorpDown2Values=driver.findElements(By.xpath("//ul[@id='j_idt87:country_items']/li"));
        for (WebElement element:ListOfDorpDown2Values){
            String dropDownValue=element.getText();
            if(dropDownValue.equals("USA")){
                element.click();
                break;
            }
        }


    }
    @Test
    public void googleSearchDown() throws InterruptedException {
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("palitha");

        Thread.sleep(2000);

        List<WebElement> googlesearchList =
                driver.findElements(By.xpath("//ul[@role='listbox']/li//div[@class='wM6W7d']"));

        System.out.println(googlesearchList.size());

        for (WebElement element : googlesearchList) {
            System.out.println(element.getText());
        }
    }



}
