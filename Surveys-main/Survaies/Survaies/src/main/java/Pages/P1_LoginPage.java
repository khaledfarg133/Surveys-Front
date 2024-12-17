package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class P1_LoginPage {
    static WebDriver driver ;
    public P1_LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    //Web Elements

    By userNameFiled = By.cssSelector("#phone");
    By passwordFiled = By.cssSelector("#passwordInput");
    static By loginButton = By.cssSelector(".btn.btn-primary.text-center.w-100");


    static By EyeIcon = By.cssSelector(".input-group-text.ps-2']");
    By invalidErrorMessage = By.cssSelector("p[class='error-msg d-flex align-items-center justify-content-center gap-2 mb-2'] span");
    By requiredErrorMessage = By.cssSelector("p[class='error-msg d-flex align-items-center justify-content-center gap-2 mb-2'] span");
    By LoginTittle = By.cssSelector(".title.fw-bold");

    static By ForgetPasswordAssertion = By.cssSelector(".btn.btn-forget.p-0");


    //Methods
    public void loginAccount(String username,String Password){
       /* WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(userNameFiled));
        usernameField.clear();
        usernameField.sendKeys(username);

        WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(passwordFiled));
        passwordField.clear();
        passwordField.sendKeys(Password);*/

        driver.findElement(userNameFiled).sendKeys(username);
        driver.findElement(passwordFiled).sendKeys(Password);
        //driver.findElement(loginButton).click();
    }

    public static P1_LoginPage Click_EyeIcon(){
        driver.findElement(EyeIcon).click();
        return new P1_LoginPage(driver);
    }

    public static P2_ForgetPassword ClickForgetPassword(){
        driver.findElement(ForgetPasswordAssertion).click();
        return new P2_ForgetPassword(driver);
    }

    public static P3_HomePage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new P3_HomePage(driver);
    }


    public String invalidErrorMessageVisible(){
        //  return driver.findElement(invalidErrorMessage).isDisplayed();
        return driver.findElement(invalidErrorMessage).getText().trim();

    }
    public String isRequiredErrorMessageVisible(){
        //  wait.until(ExpectedConditions.visibilityOfElementLocated(requiredErrorMessage));
        // return driver.findElement(requiredErrorMessage).isDisplayed();
        return driver.findElement(requiredErrorMessage).getText().trim();

    }

    public String Login_Tittle(){
        //  wait.until(ExpectedConditions.visibilityOfElementLocated(requiredErrorMessage));
        // return driver.findElement(requiredErrorMessage).isDisplayed();
        return driver.findElement(LoginTittle).getText().trim();

    }
}
