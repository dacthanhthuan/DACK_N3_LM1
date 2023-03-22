package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
//Testcase7:
//Step1. Go to https://www.160store.com/
//Step2. Click on Đăng nhập/Đăng ký -> Fill all required information -> Đăng nhập
//Step3. Quay trở về Trang chủ
//Step4. CHọn sản phẩm và tăng số lượng thành 10
//Step5. Nhấn thêm vào giỏ hàng
//Step6. Nhấn vào giỏ hàng (Lưu lại tổng tiền)
//Step7. Ghi chú và Nhấn Thanh toán ngay
//Step8. Điền thông tin trang thanh toán
//Step9. Nhấn hoàn tất đơn hàng và kiểm tra tổng tiền từ giỏ hàng với trang hoàn tất thanh toán
public class testcase7 {
        @Test
        public static void testcase7() {
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

                //Step4. CHọn sản phẩm và tăng số lượng thành 10
                driver.findElement(By.xpath("//*[@id=\"tab-new-arrivals\"]/div[1]/div[2]/div/div[1]/a/picture[1]/img")).click();
                Thread.sleep(4000);

                driver.findElement(By.cssSelector(" #quantity")).clear();
                driver.findElement(By.cssSelector(" #quantity")).sendKeys("10");
                Thread.sleep(4000);

                //Step5. Nhấn thêm vào giỏ hàng
                driver.findElement(By.cssSelector("#add-to-cart > span")).click();
                driver.findElement(By.cssSelector
                        ("#site-header-center > div > div > div.col-md-4.group-icon-header.col-xs-3.col-sm-4.pd-right-0.pd-0-mb > div > ul > li.list-inline-item.mr-0.header-cart > div > a > span.box-text.hidden-xs")).click();

                Thread.sleep(4000);

                //Step6. Nhấn vào giỏ hàng (Lưu lại tổng tiền)
                String totalcostcart = driver.findElement(By.cssSelector("#total-view-cart")).getText();
                driver.findElement(By.xpath("//*[@id=\"cart-mini-wanda\"]/div/table/tbody/tr[4]/td[1]/a")).click();
                Thread.sleep(4000);

                //Step7. Ghi chú và Nhấn Thanh toán ngay
                //driver.findElement(By.cssSelector("#note")).sendKeys("Giao vào buổi sáng");
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

                //Step9. Nhấn hoàn tất đơn hàng và kiểm tra tổng tiền từ giỏ hàng với trang hoàn tất thanh toán
                driver.findElement(By.cssSelector("#checkout_complete > button")).click();
                Thread.sleep(4000);
                String totalcostfinal = driver.findElement
                        (By.xpath("/html/body/div[3]/div/div[1]/div/div/div/div[2]/table/tfoot/tr/td[2]/span[2]")).getText();
                AssertJUnit.assertEquals(totalcostcart,totalcostfinal);
                if (totalcostcart.equals(totalcostfinal)){
                    System.out.println("Tổng tiền đã được kiểm tra giống nhau!");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

