package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

//Test case 5: Verify Cost total in cart
//Step 1. Go to https://www.160store.com/
//Step 2. Click on Áo Khoác ICONDENIM Bumblebee Windbreaker then click "Thêm vào giỏ"
//Step 3. Click on  Áo Khoác ICONDENIM Grunge Pattern then click "Them vào giỏ"
//Step 4. Verify total cost of product in cart
public class testcase5 {
    @Test
    public static void testCostTotalInCart() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //Step 1. Go to https://www.160store.com/
            driver.get("https://www.160store.com/");
            //Step 2. Click on Áo Khoác ICONDENIM Bumblebee Windbreaker then click "Thêm vào giỏ"
            driver.findElement(By.cssSelector
                    ("#tab-new-arrivals > div.d-flex.d-flex-wrap.row-left-list > div:nth-child(1) > div > div.product-detail > h3 > a")).click();
            Thread.sleep(2000);
            driver.findElement(By.cssSelector(" #add-to-cart")).click();
            Thread.sleep(2000);
            //Step 3. Click on  Áo Khoác ICONDENIM Grunge Pattern then click "Them vào giỏ"
            driver.findElement(By.cssSelector("#slick-slide31 > div > div.product-detail > h3 > a")).click();
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("#add-to-cart")).click();
            Thread.sleep(2000);
            //Step 4. Verify total cost of product in cart
            driver.findElement(By.xpath("/html/body/header/div[2]/div/div/div[3]/div/ul/li[4]/div/a/span[2]"))
                    .click();
            Thread.sleep(2000);
            String totalcost = driver.findElement(By.cssSelector("#total-view-cart")).getText();
            AssertJUnit.assertEquals(totalcost,"960,000₫");
            if (totalcost.equals("960,000₫")){
                System.out.println("total cost is verified!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Quit browser session
        driver.quit();
    }
}