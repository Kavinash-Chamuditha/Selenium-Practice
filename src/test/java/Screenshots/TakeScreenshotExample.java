package Screenshots;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

public class TakeScreenshotExample {
    WebDriver driver;

    @BeforeMethod
    public void OpenTestPage(){
        driver =  new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/alert.xhtml");
    }

    @Test
    public void takeScreenshotTest() throws IOException {

        TakesScreenshot ts = (TakesScreenshot) driver;
        File fullPage = ts.getScreenshotAs(OutputType.FILE);

        File folder = new File("C:\\Users\\oshan\\IdeaProjects\\seleniumpractice\\screenshots");
        if (!folder.exists()) {
            folder.mkdirs();
        }

        File fullDest = new File(folder, "full.png");
        Files.copy(fullPage.toPath(), fullDest.toPath());

        System.out.println("Full page screenshot saved");

        // ELEMENT SCREENSHOT
        WebElement section = driver.findElement(By.xpath("//*[@id=\"j_idt88\"]/div/div[1]"));
        File sectionFile = section.getScreenshotAs(OutputType.FILE);

        File sectionDest = new File(folder, "section.png");
        Files.copy(sectionFile.toPath(), sectionDest.toPath());

        System.out.println("Section screenshot saved");



    }

}
