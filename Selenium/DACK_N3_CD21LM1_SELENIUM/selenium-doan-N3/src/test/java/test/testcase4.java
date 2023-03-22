package test;

import driver.driverFactory;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

//Test case 4: Verify Quantity Available
//Step 1. Go to https://www.160store.com/
//Step 2. Click on Áo Khoác ICONDENIM Bumblebee Windbreaker
//Step 3. Change quantity to 1000 and click "Thêm vào giỏ"
//Step 4. Verify alert window with error message
public class testcase4 {
    @Test
    public static void testQuantityAvailable() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //Step 1. Go to https://www.160store.com/
            driver.get("https://www.160store.com/");
            //Step 2. Click on Áo Khoác ICONDENIM Bumblebee Windbreaker
            driver.findElement(By.cssSelector
                    ("#tab-new-arrivals > div.d-flex.d-flex-wrap.row-left-list > div:nth-child(1) > div > div.product-detail > h3 > a")).click();
            Thread.sleep(2000);
            //Step 3. Change quantity to 1000 and click "Thêm vào giỏ"
            driver.findElement(By.cssSelector("#quantity")).clear();
            driver.findElement(By.cssSelector("#quantity")).sendKeys("1000");
            driver.findElement(By.cssSelector(" #add-to-cart")).click();
            Thread.sleep(2000);
            //Step 4. Verify alert window with error message
            try {
                Alert alert = driver.switchTo().alert();
                String message = alert.getText();
                System.out.println(alert.getText());
                AssertJUnit.assertEquals
                        (message,"Cart Error(422): You can only add 77 Áo Khoác ICONDENIM Bumblebee Windbreaker to the cart");
                if (message.equals("Cart Error(422): You can only add 77 Áo Khoác ICONDENIM Bumblebee Windbreaker to the cart")){
                    System.out.println("Alert window with error message verified!!");
                }
                alert.accept();
            } catch (NoAlertPresentException e) {
                // handle the exception
                System.out.println("No alert present on the page");
            }

            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        //Quit browser session
        driver.quit();
    }
}
