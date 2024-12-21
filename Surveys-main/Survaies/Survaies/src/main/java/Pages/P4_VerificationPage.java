package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class P4_VerificationPage {
    static WebDriver driver ;
    public P4_VerificationPage(WebDriver driver) {
        this.driver = driver;
    }

    //Web Elements

    By verification_code_Titel = By.xpath("//h2[contains(text(),'تأكيد رمز التحقق')]");
    static By BackButton = By.cssSelector(".fw-bold");
    static By ResendButton = By.cssSelector(".btn.btn-resend.p-0");





    //Methods
    public static P2_ForgetPassword ClickBack(){
        driver.findElement(BackButton).click();
        return new P2_ForgetPassword(driver);
    }

    public String Assert_Verification_Page(){
        return driver.findElement(verification_code_Titel).getText().trim();
    }



    public void ClickResend(WebDriver driver) {

        /*try {
            // الانتظار لمدة 30 ثانية
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        WebElement ResendButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-resend.p-0")));
        ResendButton.click();

    }


}
