package test;

import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.io.File;

//Test case 13: Verify Product Search does not find the product
//Step 1. Go to https://www.160store.com/
//Step 2. Read product name at home page
//Step 3. Search Product name at search Field
//Step 4. Read Product name at search page
//Step 5. Verify Product Search does not find the product
public class testcase13 {
    @Test
    public static void testSearchProduct() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //Step 1. Go to https://www.160store.com/
            driver.get("https://www.160store.com/");
            Thread.sleep(2000);
            //Step 2. Read product name at home page
            String ProductHomePage = driver.findElement(By.cssSelector
                    ("#tab-new-arrivals > div.d-flex.d-flex-wrap.row-left-list > div:nth-child(1) > div > div.product-detail > h3 > a")).getText();
            Thread.sleep(2000);
            //Step 3. Search Product name at search Field
            driver.findElement(By.cssSelector("input[placeholder='Bạn đang tìm gì...']"))
                    .sendKeys("Áo phông");
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("div[class='site_search search-desktop'] img[alt='Tìm kiếm']")).click();
            Thread.sleep(2000);
            //Step 4. Read Product name at search page
            String ProductSearchPage = driver.findElement(By.xpath
                    ("//*[@id=\"site-header-center\"]/div/div/nav/div/form/div/input")).getText();
            Thread.sleep(2000);
            //Step 5. Verify Product Search does not find the product
            String productsearch = driver.findElement(By.xpath("//*[@id=\"search\"]/div/h2")).getText();
            AssertJUnit.assertEquals(productsearch,"Không tìm thấy nội dung bạn yêu cầu");
            if (productsearch.equals("Không tìm thấy nội dung bạn yêu cầu")){
                System.out.println("ko tim thay san pham");
                File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                String png = ("D:\\HK2-2022-2023\\Kiemthu\\DACK_N3_CD21LM1_SELENIUM\\selenium-doan-N3\\img\\Search.png");
                FileUtils.copyFile(scrFile, new File(png));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Quit browser session
        driver.quit();
    }
}
