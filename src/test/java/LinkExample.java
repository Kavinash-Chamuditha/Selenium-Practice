import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.List;

public class LinkExample {


    WebDriver driver;

    @BeforeMethod
    public void OpenTestPage(){
        driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/link.xhtml");
    }

    @Test
    public void LinkTest(){

        WebElement homeLink = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink.click();
        driver.navigate().back();

        WebElement wheretogo =driver.findElement(By.partialLinkText("Find the URL"));
        String path =wheretogo.getAttribute("href");
        System.out.println("This link is going to "+path);

        WebElement brokenLink=driver.findElement(By.linkText("Broken?"));
        brokenLink.click();

        String title=driver.getTitle();
            if(title.contains("404")){
                System.out.println("The link is broken");
            }
            else {
                System.out.println("Not broken");
            }

            driver.navigate().back();

        WebElement homeLink1 = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink1.click();
        driver.navigate().back();

        List<WebElement> countfullpagelinks= driver.findElements(By.tagName("a"));
        int pageLinkCount=countfullpagelinks.size();
        System.out.println("Count of full page link" +pageLinkCount);

        WebElement layoutElement=driver.findElement(By.className("layout-main-content"));
        List<WebElement> countoflayoutlinks=layoutElement.findElements(By.tagName("a"));
        System.out.println("Cont of layout links" +countoflayoutlinks.size());

    }


}
