package test;

import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.io.File;
//Testcase9:
//Step1. Go to https://www.160store.com/
//Step2. Click on Đăng nhập/Đăng ký -> Fill all required information -> Đăng nhập
//Step3. Quay trở về Trang chủ
//Step4. CHọn sản phẩm
//Step5. Nhấn thêm vào giỏ hàng
//Step6. Nhấn vào giỏ hàng (Kiểm tra tổng tiền)
//Step7. Ghi chú và Nhấn Thanh toán ngay
//Step8. Điền thông tin trang thanh toán
//Step9. Nhấn hoàn tất đơn hàng
//Step10. Verify đơn hàng dưới 500K sẽ có phí vận chuyển
public class testcase9 {
        @Test
        public static void testcase9() {
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

                //Step3. Quay trở về Trang chủ
                driver.findElement(By.linkText("Trang chủ")).click();
                Thread.sleep(4000);

                //Step4. CHọn sản phẩm
                driver.findElement(By.xpath("//*[@id=\"tab-new-arrivals\"]/div[1]/div[5]/div/div[1]/a/picture[1]/img")).click();
                Thread.sleep(4000);

                //Step5. Nhấn thêm vào giỏ hàng
                driver.findElement(By.cssSelector("#add-to-cart")).click();
                driver.findElement(By.cssSelector("#site-header-center > div > div > div.col-md-4.group-icon-header.col-xs-3.col-sm-4.pd-right-0.pd-0-mb > div > ul > li.list-inline-item.mr-0.header-cart > div > a > span.box-text.hidden-xs")).click();

                Thread.sleep(4000);
                //Step6. Nhấn vào giỏ hàng (Kiểm tra tổng tiền)
                String totalcostcart = driver.findElement(By.cssSelector("#total-view-cart")).getText();
                AssertJUnit.assertEquals(totalcostcart,"480,000₫");
                if (totalcostcart.equals("480,000₫")){
                    System.out.println("Tổng tiền dưới 500,000đ");
                    driver.findElement(By.xpath("//*[@id=\"cart-mini-wanda\"]/div/table/tbody/tr[4]/td[1]/a")).click();
                }

                Thread.sleep(4000);

                //Step7. Ghi chú và Nhấn Thanh toán ngay
                driver.findElement(By.cssSelector("#note")).sendKeys("Giao vào buổi sáng");

                driver.findElement(By.xpath("//*[@id=\"cart-template\"]/div/form/div/div[2]/div/div/div[5]/button")).click();
                Thread.sleep(4000);

                //Step8. Điền thông tin trang thanh toán
                driver.findElement(By.cssSelector("#billing_address_address1")).sendKeys("115 Trịnh Đình Thảo");
                Thread.sleep(4000);
                new Select(driver.findElement(By.cssSelector("#customer_shipping_province"))).selectByVisibleText("Hồ Chí Minh");
                Thread.sleep(4000);
                new Select(driver.findElement(By.cssSelector("#customer_shipping_district"))).selectByVisibleText("Quận 7");
                Thread.sleep(4000);
                new Select(driver.findElement(By.cssSelector("#customer_shipping_ward"))).selectByVisibleText("Phường Phú Mỹ");
                Thread.sleep(2000);

                //Step9. Nhấn hoàn tất đơn hàng
                driver.findElement(By.cssSelector("#checkout_complete > button")).click();
                Thread.sleep(4000);

                //Step10. Verify đơn hàng dưới 500K sẽ có phí vận chuyển
               String shippingcost= driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/div/div[2]/table/tbody/tr[2]/td[2]/span")).getText();
                AssertJUnit.assertEquals(shippingcost,"20,000₫");
                if (shippingcost.equals("20,000₫")){
                    System.out.println("phí vận chuyển đã được xác thực!");
                    File scrFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                    String png1 = ("C:\\Users\\dacth\\Documents\\Zalo Received Files\\DACK_N3_CD21LM1_SELENIUM\\selenium-doan-N3\\Shippingcost.png");
                    FileUtils.copyFile(scrFile1, new File(png1));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

