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
import java.io.StringWriter;

//Test case 1: Verify Registration
//Step 1. Go to https://www.160store.com/
//Step2. Click on Đăng nhập/Đăng ký -> Tạo tài khoản
//Step3. fill New User information
//Step4. Verify title of the page
public class testcase1 {
    @Test
    public static void testRegistration() {
        WebDriver driver = driverFactory.getChromeDriver();
        StringWriter verificationErrors = new StringWriter();
        try {
            //Step 1. Go to https://www.160store.com/
            driver.get("https://www.160store.com/");
            //Step2. Click on Đăng nhập/Đăng ký -> Tạo tài khoản
            driver.findElement(By.cssSelector("span[class='box-text hidden-xs'] span[class='small-text']")).click();
            driver.findElement(By.cssSelector("a[class='link']")).click();
            Thread.sleep(4000);
            //Step3. fill New User information
            driver.findElement(By.cssSelector("#last_name")).sendKeys("Kiem2");
            driver.findElement(By.cssSelector("#first_name")).sendKeys("Thu2");
            driver.findElement(By.cssSelector("#datepicker")).sendKeys("01/01/2001");
            driver.findElement(By.cssSelector("#phone")).sendKeys("090111111");
            driver.findElement(By.cssSelector("#email")).sendKeys("kiemthu2@gmail.com");
            driver.findElement(By.cssSelector("#password")).sendKeys("abc123");
            driver.findElement(By.cssSelector("input[value='Đăng ký']")).click();
            Thread.sleep(4000);
            //Step4. Verify title of the page
            String ProfileTitle = driver.findElement(By.cssSelector("h1")).getText();
            System.out.println(ProfileTitle);
            try{
                AssertJUnit.assertEquals("Tài khoản của bạn",ProfileTitle);
                System.out.println("Title verified!!");
                File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                String png = ("C:\\Users\\Admin\\Desktop\\Kiemthu\\selenium-doan-N3\\img\\ProfilePage.png");
                FileUtils.copyFile(scrFile, new File(png));
            }catch (Error e){

                verificationErrors.append(e.toString());
            }
            //debug purpose only
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        //Quit browser session
        driver.quit();
    }
}
