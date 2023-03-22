package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

//Test case 3: Verify Search Product
//Step 1. Go to https://www.160store.com/
//Step 2. Read product name at home page
//Step 3. Search Product name at search Field
//Step 4. Read Product name at search page
//Step 5. Verify Product name equal between Search Page and Home Page
public class testcase3 {
    @Test
    public static void testSearchProduct() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //Step 1. Go to https://www.160store.com/
            driver.get("https://www.160store.com/");
            //Step 2. Read product name at home page
            String ProductHomePage = driver.findElement(By.cssSelector
                    ("#tab-new-arrivals > div.d-flex.d-flex-wrap.row-left-list > div:nth-child(1) > div > div.product-detail > h3 > a")).getText();
            //Step 3. Search Product name at search Field
            driver.findElement(By.cssSelector("input[placeholder='Bạn đang tìm gì...']"))
                    .sendKeys("Áo Khoác ICONDENIM Bumblebee Windbreaker ");
            driver.findElement(By.cssSelector("div[class='site_search search-desktop'] img[alt='Tìm kiếm']")).click();
            Thread.sleep(2000);
            //Step 4. Read Product name at search page
            String ProductSearchPage = driver.findElement(By.cssSelector
                    ("h3[class='pro-name'] a[title='Áo Khoác ICONDENIM Bumblebee Windbreaker']")).getText();
            //Step 5. Verify Product name equal between Search Page and Home Page
            AssertJUnit.assertEquals(ProductHomePage, ProductSearchPage);
            if (ProductHomePage.equals(ProductSearchPage)) {
                System.out.println("Product name equal!!");
            }
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Quit browser session
        driver.quit();
    }
}
