
package Base;

import Pages.P3_HomePage;
import Pages.P5_SatisfiedPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver; // متغير عام لتمثيل المتصفح



    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver(); // إنشاء متصفح Chrome

        driver.get("https://d-line-iis.alqemam.com/Mogab_build_v1.5.02/");

        driver.manage().window().maximize(); // تكبير نافذة المتصفح
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }




    @AfterMethod

    public void tearDown(){

        if (driver != null) {
            driver.quit();
        }
    }



}
