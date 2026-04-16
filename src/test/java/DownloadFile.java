import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    public  void fileDUploadTest(){
        driver.get("https://www.leafground.com/file.xhtml");

    }
}
