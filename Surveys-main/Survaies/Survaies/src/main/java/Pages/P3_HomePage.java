package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Pages.P5_SatisfiedPage;


import java.time.Duration;

public class P3_HomePage {
    public static WebDriver driver ;
    public P3_HomePage(WebDriver driver) {
        P3_HomePage.driver = driver;
    }

    //Web Elements

    By HomePageAssertion = By.cssSelector(".title-page");
    static By  SatisfiectionBage = By.cssSelector("body > app-root:nth-child(1) > app-home-panel:nth-child(2) > div:nth-child(1) > app-header:nth-child(1) > header:nth-child(1) > div:nth-child(1) > nav:nth-child(1) > ul:nth-child(2) > li:nth-child(5) > a:nth-child(1) > span:nth-child(2)");

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
