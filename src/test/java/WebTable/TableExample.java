package WebTable;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TableExample {

    WebDriver driver;

    @BeforeMethod
    public void OpenTestPage(){
        driver =  new ChromeDriver();
        Dimension newSize =new Dimension(800,900);
        driver.manage().window().setSize(newSize);
        driver.get("https://testautomationpractice.blogspot.com/");
    }

    @Test
    public void webTableTest() throws InterruptedException {
//row count
        int rowCount = driver.findElements(
                By.xpath("//table[@id='productTable']/tbody/tr")
        ).size();
        System.out.println("Rows count is: " + rowCount);
//column count
        int columnCount = driver.findElements(
                By.xpath("//table[@id='productTable']/thead/tr/th")
        ).size();
        System.out.println("Column count is: " + columnCount);
//Get specific row or column data
        String value=driver.findElement(By.xpath("//*[@id=\"productTable\"]/tbody/tr[3]/td[3]")).getText();
        System.out.println("Specified row/column data" +value);

//get all the data
        for(int i=1; i<=rowCount; i++){
            for(int j=1; j<columnCount; j++){
                String tdata=driver.findElement(By.xpath("//*[@id=\"productTable\"]/tbody/tr["+i+"]/td["+j+"]")).getText();
                System.out.print(tdata + " ");
            }
            System.out.println();
        }
//print id and name
        for(int i=1; i<=rowCount; i++){

            String tbid=driver.findElement(By.xpath("//*[@id=\"productTable\"]/tbody/tr["+i+"]/td[1]")).getText();
            String tbproductName=driver.findElement(By.xpath("//*[@id=\"productTable\"]/tbody/tr["+i+"]/td[2]")).getText();

            System.out.println("Table Id"+tbid+ "Product is" +tbproductName );
        }

//select all check boxes
        int pagecount= driver.findElements(By.xpath("//ul[@id='pagination']/li")).size();
        List<WebElement> pages=driver.findElements(By.xpath("//ul[@id='pagination']/li"));

        for(int k=0; k<pagecount; k++){
            pages.get(k).click();
            Thread.sleep(1000);
            for(int i=1; i<=rowCount; i++){
                boolean attribute=driver.findElement(By.xpath("//*[@id=\"productTable\"]/tbody/tr["+i+"]/td[4]/input")).isSelected();
                if(!attribute){
                    driver.findElement(By.xpath("//*[@id=\"productTable\"]/tbody/tr["+i+"]/td[4]/input")).click();
                    Thread.sleep(300);
                }
//select one check box
                int tblRow=1;
                driver.findElement(By.xpath("//*[@id=\"productTable\"]/tbody/tr["+tblRow+"]/td[4]/input")).click();

            }

        }
    }






}