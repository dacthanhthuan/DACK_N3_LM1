package test;

import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.io.File;

//Test case 2: Verify Change Information
//Step 1. Go to https://www.160store.com/
//Step2. Click on Đăng nhập/Đăng ký -> Fill all required information -> Đăng nhập
//Step3 . Verify information equal
//Step4. Change information
//Step5. Verify change information success
public class testcase2 {
    @Test
    public static void testChangeInformation() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //Step 1. Go to https://www.160store.com/
            driver.get("https://www.160store.com/");
            //Step2. Click on Đăng nhập/Đăng ký -> Fill all required information -> Đăng nhập
            driver.findElement(By.cssSelector("span[class='box-text hidden-xs'] span[class='small-text']")).click();
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("input[placeholder='Nhập email hoặc số điện thoại']")).sendKeys("kiemthu1@gmail.com");;
            driver.findElement(By.cssSelector("input[placeholder='Mật khẩu']")).sendKeys("abc123");
            driver.findElement(By.cssSelector("#form_submit-login")).click();
            Thread.sleep(4000);
            //Step3 . Verify information equal
            driver.findElement(By.xpath("/html/body/header/div[2]/div/div/div[3]/div/ul/li[3]/div/a/span[2]")).click();
            Thread.sleep(2000);
            String EmailWindow = driver.findElement(By.cssSelector("#header-login-toggle > div > p:nth-child(3) > strong")).getText();
            String PhoneWindow = driver.findElement(By.cssSelector("#header-login-toggle > div > p:nth-child(4) > strong")).getText();
            driver.findElement(By.cssSelector("#header-login-toggle > div > div.account-bottom.d-flex > div:nth-child(1) > a")).click();
            Thread.sleep(2000);
            AssertJUnit.assertEquals(EmailWindow,"kiemthu1@gmail.com");
            AssertJUnit.assertEquals(PhoneWindow,"0901234567");
            if(EmailWindow.equals("kiemthu1.@gmail.com")&& PhoneWindow.equals("0901234567")){
                System.out.println("Information equal!!");
            }
            Thread.sleep(2000);
            //Step4. Change information
            driver.findElement(By.cssSelector("#last_name")).clear();
            driver.findElement(By.cssSelector("#last_name")).sendKeys("Kiem");
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("#first_name")).clear();
            driver.findElement(By.cssSelector("#first_name")).sendKeys("Thu");
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("#update_customer > div:nth-child(6) > div > input")).clear();
            driver.findElement(By.cssSelector("#update_customer > div:nth-child(6) > div > input")).sendKeys("0901234567");
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("label[for='gender_m'] span[class='sp_input']")).click();
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("button[id='submit_info'] span")).click();
            Thread.sleep(2000);
            //Step5. Verify change information success
            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            AssertJUnit.assertEquals(alert.getText(),"Cập nhật thông tin thành công");
            if (alert.getText().equals("Cập nhật thông tin thành công")){
                alert.accept();
                File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                String png = ("C:\\Users\\Admin\\Desktop\\Kiemthu\\selenium-doan-N3\\img\\ChangeInformation.png");
                FileUtils.copyFile(scrFile, new File(png));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        //Quit browser session
        driver.quit();
    }
}
