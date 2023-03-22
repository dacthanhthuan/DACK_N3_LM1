package test;

import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;
//Testcase8
//Step1. Go to https://www.160store.com/
//Step2. Click on Đăng nhập/Đăng ký -> Fill all required information -> Đăng nhập
//Step3. Nhấn vào đơn hàng của tôi
//Step4. Kiểm tra đơn hàng
public class testcase8 {
    @Test
    public static void testcase8() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //Step1. Go to https://www.160store.com/
            driver.get("https://www.160store.com/");

            //Step2. Click on Đăng nhập/Đăng ký -> Fill all required information -> Đăng nhập
            driver.findElement(By.cssSelector("span[class='box-text hidden-xs'] span[class='small-text']")).click();
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("input[placeholder='Nhập email hoặc số điện thoại']")).sendKeys("kiemthu1@gmail.com");

            driver.findElement(By.cssSelector("input[placeholder='Mật khẩu']")).sendKeys("abc123");
            driver.findElement(By.cssSelector("#form_submit-login")).click();
            Thread.sleep(4000);

            //Step3. Nhấn vào đơn hàng của tôi
            driver.findElement(By.xpath("//*[@id=\"wd-shoes-scofiled\"]/main/div[2]/div[2]/div/div[1]/div[1]/div[2]/div/ul/li[2]/a")).click();
            Thread.sleep(4000);

            //Step4. Kiểm tra đơn hàng
            File scrFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String png1 = ("C:\\Users\\dacth\\Documents\\Zalo Received Files\\DACK_N3_CD21LM1_SELENIUM\\selenium-doan-N3\\KiemtraDH.png");
            FileUtils.copyFile(scrFile1, new File(png1));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
