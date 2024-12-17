package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P3_HomePage {
    public static WebDriver driver ;
    public P3_HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Web Elements

    By HomePageAssertion = By.cssSelector(".title-page");
    static By  SatisfiectionBage = By.xpath("//span[contains(text(),'راض')]");

    //Methods

    public String HomePageIcon(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        return driver.findElement(HomePageAssertion).getText().trim();
    }


    public static P5_SatisfiedPage ClickIconSatisfied(){
        driver.findElement(SatisfiectionBage).click();
        return new P5_SatisfiedPage(driver);
    }


}
