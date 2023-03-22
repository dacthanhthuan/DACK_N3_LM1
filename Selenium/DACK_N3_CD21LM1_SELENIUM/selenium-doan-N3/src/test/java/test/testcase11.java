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

//Test case 11: Verify the address of a store near you
//Step 1. Go to https://www.160store.com/
//Step 2. Click on  Cửa hàng gần bạn
//Step 3. Click on chon tinh/thanhpho ->Choose Ho Chi Minh
//Step 4. Click on chon quan/huyen ->Choose Quan Phu Nhuan
//Step 5. Verify the address of a store near you
public class testcase11 {
    @Test
    public static void testVerifyStoresNearYou () {
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //Step 1. Go to https://www.160store.com/
            driver.get("https://www.160store.com/");
            //Step 2. Click on  Cửa hàng gần bạn
            driver.findElement(By.xpath("//*[@id=\"site-header-center\"]/div/div/div[3]/div/ul/li[2]/div/a/span[1]/img")).click();
            //Step 3. Click on chon tinh/thanhpho ->Choose Ho Chi Minh
            driver.findElement(By.xpath("//*[@id=\"site-header-center\"]/div/div/div[3]/div/ul/li[2]/div/div/div/div/div[2]/div[1]/div[1]/select")).click();
            driver.findElement( By.xpath("//*[@id=\"site-header-center\"]/div/div/div[3]/div/ul/li[2]/div/div/div/div/div[2]/div[1]/div[1]/select/option[2]")).click();
            Thread.sleep(2000);
            //Step 4. Click on chon quan/huyen ->Choose Quan Phu Nhuan
            driver.findElement(By.xpath("//*[@id=\"site-header-center\"]/div/div/div[3]/div/ul/li[2]/div/div/div/div/div[2]/div[1]/div[2]/select")).click();
            driver.findElement( By.xpath("//*[@id=\"site-header-center\"]/div/div/div[3]/div/ul/li[2]/div/div/div/div/div[2]/div[1]/div[2]/select/option[5]")).click();
            Thread.sleep(2000);
            //Step 5. Verify the address of a store near you
            String storeaddress = driver.findElement(By.xpath("//*[@id=\"site-header-center\"]/div/div/div[3]/div/ul/li[2]/div/div/div/div/div[2]/div[2]/div/ul/li[4]/a[1]/b")).getText();
            AssertJUnit.assertEquals(storeaddress,"Hồ Chí Minh - 160STORE CN PHAN XÍCH LONG");
            if (storeaddress.equals("Hồ Chí Minh - 160STORE CN PHAN XÍCH LONG")){
                File scrFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                String png1 = ("D:\\HK2-2022-2023\\Kiemthu\\DACK_N3_CD21LM1_SELENIUM\\selenium-doan-N3\\img\\StoreNearYou.png");
                FileUtils.copyFile(scrFile1, new File(png1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Quit browser session
        driver.quit();
    }
}