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

//Test case 10: Verify store address
//Step 1. Go to https://www.160store.com/
//Step 2. Click on  Địa chỉ cửa hàng
//Step 3. Click on chon tinh/thanhpho ->Choose Ho Chi Minh
//Step 4. Click on chon quan/huyen ->Choose Quan 1
//Step 5. Verify store address
public class testcase10 {
    @Test
    public static void testVerifystoreaddress () {
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //Step 1. Go to https://www.160store.com/
            driver.get("https://www.160store.com/");
            //Step 2. Click on  Địa chỉ cửa hàng
            driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/nav/ul/li[6]/a")).click();
            //Step 3. Click on chon tinh/thanhpho ->Choose Ho Chi Minh
            driver.findElement(By.xpath("//*[@id=\"tabaddress1\"]/select[1]")).click();
            driver.findElement( By.cssSelector("#tabaddress1 > select.change-tinh")).click();
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("#tabaddress1 > select.change-tinh > option:nth-child(2)")).click();
            Thread.sleep(2000);
            //Step 4. Click on chon quan/huyen ->Choose Quan 1
            driver.findElement( By.cssSelector("#tabaddress1 > select.select-quan")).click();
            driver.findElement(By.cssSelector("#tabaddress1 > select.select-quan > option:nth-child(2)")).click();
            Thread.sleep(2000);
            //Step 5. Verify store address
            String storeaddress = driver.findElement(By.xpath("//*[@id=\"address-link\"]/li[1]/a[1]/b")).getText();
            AssertJUnit.assertEquals(storeaddress,"Hồ Chí Minh - 160STORE CN TRẦN HƯNG ĐẠO");
            if (storeaddress.equals("Hồ Chí Minh - 160STORE CN TRẦN HƯNG ĐẠO")){
                File scrFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                String png1 = ("D:\\HK2-2022-2023\\Kiemthu\\DACK_N3_CD21LM1_SELENIUM\\selenium-doan-N3\\img\\StoreAddress.png");
                FileUtils.copyFile(scrFile1, new File(png1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Quit browser session
        driver.quit();
    }
}
