package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P2_ForgetPassword {

    static WebDriver driver ;
    public P2_ForgetPassword(WebDriver driver) {
        this.driver = driver;
    }

    //Web Elements
    By forgetpassword = By.cssSelector(".btn.btn-forget.p-0");
    By ForgetPassword_Titel = By.cssSelector(".title");
    static By BackButton = By.cssSelector("div[class='d-flex authorized-wrapper'] span:nth-child(2)");
    By requiredErrorMessage = By.cssSelector("p[class='error-msg d-flex align-items-center justify-content-center gap-2 mb-3'] span");
    By invalidErrorMessage = By.cssSelector("p[class='error-msg d-flex align-items-center justify-content-center gap-2 mb-3'] span");
    By userEmail = By.cssSelector("#user_email");
    static By SendButton = By.cssSelector(".btn.btn-primary.text-center.w-100");

    //Methods

    public String ClickForgetPassword(){
        return driver.findElement(forgetpassword).getText().trim();
    }
    public String Assert_Forgetpassword_Page(){
        return driver.findElement(ForgetPassword_Titel).getText().trim();
    }

    public static P1_LoginPage ClickBack(){
        driver.findElement(BackButton).click();
        return new P1_LoginPage(driver);
    }
    public String isRequiredErrorMessageVisible(){

        return driver.findElement(requiredErrorMessage).getText().trim();

    }
    public String invalidErrorMessageVisible(){
        return driver.findElement(invalidErrorMessage).getText().trim();

    }

    public void MailEntery(String userMail){
        driver.findElement(userEmail).sendKeys(userMail);
        //driver.findElement(loginButton).click();
    }

    public static P4_VerificationPage clickSendButton(){
        driver.findElement(SendButton).click();
        return new P4_VerificationPage(driver);
    }


}
