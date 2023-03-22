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

//Test case 12: verify if product price is same when add to cart
//Step 1. Go to https://www.160store.com/
//Step 2. Click on  ao somi cuban ICONDEIM Sphynx Cat Printed
//Step 3. Click on size S add to cart
//Step 4. Click on gio hang -> xem gio hang
//Step 5. verify if product price is same when add to cart
public class testcase12{
    @Test
    public static void testVerifyStoresNearYou () {
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //Step 1. Go to https://www.160store.com/
            driver.get("https://www.160store.com/");
            //Step 2. Click on  ao somi cuban ICONDEIM Sphynx Cat Printed
            driver.findElement(By.xpath("//*[@id=\"tab-new-arrivals\"]/div[1]/div[2]/div/div[2]/h3/a")).click();
            Thread.sleep(2000);
            //Step 3. Click on size S -> add to cart
            driver.findElement(By.xpath("//*[@id=\"variant-swatch-1\"]/div[2]/div[1]/label/span")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\"add-to-cart\"]/span")).click();
            Thread.sleep(2000);
            //Step 4. Click on gio hang -> xem gio hang
            driver.findElement(By.xpath("//*[@id=\"site-header-center\"]/div/div/div[3]/div/ul/li[4]/div/a/span[2]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\"cart-mini-wanda\"]/div/table/tbody/tr[4]/td[1]/a")).click();
            Thread.sleep(2000);
            //Step 5. verify if product price is same when add to cart
            String cart = driver.findElement(By.xpath("//*[@id=\"cart-page-result\"]/ul/li[3]/span/span")).getText();
            AssertJUnit.assertEquals(cart,"350,000₫");
            if(cart.equals("350,000₫")){
                System.out.println("Cost equal verified");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Quit browser session
        driver.quit();
    }
}
