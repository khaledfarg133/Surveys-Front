package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P1_ChangePassword {
    WebDriver driver; // المتغير الذي يمثل المتصفح المُدار بواسطة Selenium

    // Constructor: يتم استخدامه لإعطاء قيمة لـ driver عند إنشاء الكائن
    public P1_ChangePassword(WebDriver driver) {
        this.driver = driver;
    }

    // Locators: معرفات (selectors) للعناصر الموجودة في صفحة تغيير كلمة المرور
    By emailField = By.id("email"); // عنصر إدخال البريد الإلكتروني
    By submitEmailButton = By.id("submit"); // زر إرسال البريد الإلكتروني


    By otpField = By.cssSelector("body app-root input:nth-child(4)"); // عنصر إدخال رمز OTP

    By submitOTPButton = By.id("submitOtp"); // زر تأكيد إدخال OTP
    By newPasswordField = By.id("newPassword"); // عنصر إدخال كلمة المرور الجديدة
    By confirmPasswordField = By.id("confirmPassword"); // عنصر تأكيد كلمة المرور الجديدة
    By changePasswordButton = By.id("changePassword"); // زر تغيير كلمة المرور
    By successMessage = By.id("successMessage"); // عنصر يحتوي على رسالة نجاح العملية

    // Methods: وظائف تتعامل مع الصفحة
    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email); // إدخال البريد الإلكتروني
    }

    public void clickSubmitEmail() {
        driver.findElement(submitEmailButton).click(); // النقر على زر إرسال البريد الإلكتروني
    }

    public void enterOTP(String otp) {
        driver.findElement(otpField).sendKeys(otp); // إدخال رمز OTP
    }

    public void clickSubmitOTP() {
        driver.findElement(submitOTPButton).click(); // النقر على زر تأكيد OTP
    }

    public void enterNewPassword(String newPassword) {
        driver.findElement(newPasswordField).sendKeys(newPassword); // إدخال كلمة المرور الجديدة
    }

    public void enterConfirmPassword(String confirmPassword) {
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword); // تأكيد كلمة المرور
    }

    public void clickChangePassword() {
        driver.findElement(changePasswordButton).click(); // النقر على زر تغيير كلمة المرور
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText(); // الحصول على نص رسالة النجاح
    }
}
