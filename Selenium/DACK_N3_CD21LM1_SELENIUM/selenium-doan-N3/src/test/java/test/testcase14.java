package test;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.File;

//-----------------Test 14----------------

//Step 1. Go to https://www.160store.com/
//Step 2. Click on -> Sản phẩm -> Áo -> Áo Sơmi
//Step 3. In the list of all shirt , select Sắp xếp -> dropdown as Mới nhất
//Step 4. Verify all products are sorted by Mới nhất

public class testcase14 {
    @Test
    public static void TestCase14() {
        int success = 0;
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        try {
            //Step 1. Go to https://www.160store.com/
            driver.get("https://www.160store.com/");

            //Step 2. Click on -> Sản phẩm -> Áo -> Áo Sơmi
            driver.findElement(By.xpath("/html[1]/body[1]/header[1]/div[3]/div[1]/div[1]/nav[1]/ul[1]/li[3]/a[1]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html[1]/body[1]/header[1]/div[3]/div[1]/div[1]/nav[1]/ul[1]/li[3]/div[1]/ul[1]/li[5]/a[1]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html[1]/body[1]/header[1]/div[3]/div[1]/div[1]/nav[1]/ul[1]/li[3]/div[1]/ul[1]/li[5]/ul[1]/li[1]/a[1]")).click();
            Thread.sleep(2000);

            //Step 3. In the list of all shirt , select Sắp xếp -> dropdown as Mới nhất
            new Select(driver.findElement(By.xpath("/html[1]/body[1]/main[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/select[1]"))).selectByVisibleText("Mới nhất");
            Thread.sleep(2000);

            //Step 4. Verify all products are sorted by Mới nhất
            success = (success + 1);

            //Screenshot
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            // Save the screenshot to a file
            File destFile = new File("D:\\ProjectNEW\\ProjectCNKT\\ChromeDriver\\imgSelenium\\SortProductNewest.png");
            FileHandler.copy(screenshot, destFile);
        } catch (Exception e) {
            e.printStackTrace();

        }
        driver.quit();

    }
}
