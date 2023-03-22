package test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

//-----------------------------------------------------------Test 15------------------------
//Step 1. Go to https://www.160store.com/
//Step 2. Click on Đăng nhập/Đăng ký -> Fill all required information -> Đăng nhập
//Step 3. Click yêu cầu hỗ trợ
//Step 4. Click Tạo Phiếu
//Step 5. Điền nội dung yêu cầu và click Gửi
//Step 6 . Xác nhận trong alert thông báo
//Step 7. Xác nhận tạo phiếu hỗ trợ

public class testcase15 {
    @Test
    public static void testcase15() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        try {
            //Step 1. Go to https://www.160store.com/
            driver.get("https://www.160store.com/");

            //Step 2. Click on Đăng nhập/Đăng ký -> Fill all required information -> Đăng nhập
            driver.findElement(By.cssSelector("span[class='box-text hidden-xs'] span[class='small-text']")).click();
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("input[placeholder='Nhập email hoặc số điện thoại']")).sendKeys("kiemthu111@gmail.com");

            driver.findElement(By.cssSelector("input[placeholder='Mật khẩu']")).sendKeys("abc123");
            Thread.sleep(2000);

            driver.findElement(By.cssSelector("#form_submit-login")).click();
            Thread.sleep(2000);

//            Step 3. Click yêu cầu hỗ trợ
            for (String windowHandle : driver.getWindowHandles()) {
                driver.switchTo().window(windowHandle);
            }
            driver.findElement(By.xpath("//*[@id=\"wd-shoes-scofiled\"]/main/div[2]/div[2]/div/div[1]/div[1]/div[2]/div/ul/li[3]/a/span[2]")).click();
            Thread.sleep(2000);

//            Step 4. Click Tạo Phiếu
            driver.findElement(By.xpath("//*[@id=\"customer-tickets\"]/div[1]/span")).click();
            Thread.sleep(2000);

//            Step 5. Điền nội dung yêu cầu và click Gửi
            driver.findElement(By.cssSelector("#customer-tickets > div.new-ticket-wrap > textarea")).sendKeys("Test kiem thu");
            Thread.sleep(3000);

            driver.findElement(By.cssSelector("#customer-tickets > div.new-ticket-wrap > div.action > button.btn-submit")).click();
            Thread.sleep(6000);

//            Step 6 . Xác nhận trong alert thông báo
            Alert alert = driver.switchTo().alert();
            alert.accept();
            Thread.sleep(3000);

//            Step 7. Xác nhận tạo phiếu hỗ trợ
            driver.navigate().refresh();
            Thread.sleep(2000);

            String dateString = "3/22/2023";
            //split và format ngày
            String getDate = driver.findElement(By.cssSelector("#customer-tickets > div.wrap-content > table > tbody > tr:nth-child(1) > td:nth-child(2)")).getText();
            SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
            Date date = dateFormat.parse(getDate);
            String formattedDate = dateFormat.format(date);
            System.out.println("Ngày sau khi cắt và format:" + formattedDate);

            if (formattedDate.equals(dateString)) {
                System.out.println("Tạo phiếu thành công");
                File screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File destFile1 = new File("D:\\ProjectNEW\\ProjectCNKT\\ChromeDriver\\imgSelenium\\SupportOrder.png");
                FileHandler.copy(screenshot1, destFile1);
            } else {
                System.out.println("Tạo phiếu không thành công");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
