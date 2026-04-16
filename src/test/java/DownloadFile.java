import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class DownloadFile {

    WebDriver driver;

    @BeforeMethod
    public void OpenTestPage(){
        driver =  new ChromeDriver();
        driver.manage().window().maximize();

    }



    @Test
    public  void fileDownloadTest() throws InterruptedException {
        driver.get("https://www.leafground.com/file.xhtml");
        driver.findElement(By.id("j_idt93:j_idt95")).click();
        Thread.sleep(3000);

        File file=new File("C:\\Users\\oshan\\Downloads");
        File[] totalFiles=file.listFiles();
        for (File findFile:totalFiles){
            if(findFile.getName().equals("TestLeaf Logo"))
            {
                System.out.println("File is downloaded");
                break;
            }

        }

    }


    @Test
    public  void fileDUploadTest() throws AWTException, InterruptedException {
        driver.get("https://www.leafground.com/file.xhtml");
        driver.findElement(By.id("j_idt88:j_idt89")).click();

        StringSelection selection = new StringSelection("C:\\Users\\oshan\\Downloads\\1.png");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);

        Thread.sleep(5000);
        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);


    }
}
