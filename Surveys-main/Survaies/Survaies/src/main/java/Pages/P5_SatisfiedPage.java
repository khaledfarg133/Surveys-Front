/*package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P5_SatisfiedPage {
    static WebDriver driver ;
    public P5_SatisfiedPage(WebDriver driver) {
        this.driver = driver;
    }

    //Web Elements

    By SurvayName = By.cssSelector(".mb-2");

//Methods

}*/
// Package: Pages
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Random;

public class P5_SatisfiedPage {
    static WebDriver driver ;
    public P5_SatisfiedPage(WebDriver driver) {
        this.driver = driver;
    }

    static By Satisfcation = By.xpath("//div[@class='surveys-list-item']");
    public static P6_StartSatisfiedpage SatisfcationTab(){
        driver.findElement(Satisfcation).click();
        return new P6_StartSatisfiedpage(driver);
    }



}




