

package TestCase;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import Pages.P3_HomePage;

import java.time.Duration;
//////////////////////////////////////////////////////////////////////////////

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

import static Pages.P3_HomePage.ClickIconSatisfied;

///////////////////////////////////////////////////////////////////////////////


public class TC1_Satisfied extends BaseTest {

    @Test(priority =2)
    public void testSatisfiedSurvey2() throws IOException {
        String excelFilePath = "D:\\12\\Automation\\Surveys-main\\Survaies\\Survaies\\src\\Book1.xlsx";

        // حساب عدد الصفوف في ملف Excel
        int rowCount = TEST2.ExcelReader.getRowCount(excelFilePath);

        // حلقة for للمرور على جميع الصفوف
        for (int i = 1; i < rowCount; i++) { // بدءًا من الصف 1 (لأن الصف 0 عادة يحتوي على العناوين)
            System.out.println("Executing test for row: " + i);

            // قراءة بيانات الصف الحالي
            String[] credentials = TEST2.ExcelReader.readRowData(excelFilePath, i);
            String email = credentials[0];
            String password = credentials[1];

            // فتح صفحة تسجيل الدخول
            driver.get("https://d-line-iis.alqemam.com/Mogab_build_v1.5.02/");

            // استخدام WebDriverWait للانتظار
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlContains("https://d-line-iis.alqemam.com/Mogab_build_v1.5.02/"));

            // تسجيل الدخول
            Pages.P1_LoginPage loginPage = new Pages.P1_LoginPage(driver);
            loginPage.loginAccount(email, password);

            // التأكد من تسجيل الدخول بنجاح
            P3_HomePage homePage = P1_LoginPage.clickLoginButton();
            System.out.println("Login successful for email: " + email);


            Pages.P3_HomePage homedPage0 = new P3_HomePage(driver);
            P5_SatisfiedPage satisfiedPage = ClickIconSatisfied();
            P6_StartSatisfiedpage StartSatisfiedpage = P5_SatisfiedPage.SatisfcationTab();
            driver.findElement(By.cssSelector("div[class='survey-intro flex-column gap-3 pb-3 active'] button:nth-child(2)")).click();

            P6_StartSatisfiedpage satisfiedPage0 = new P6_StartSatisfiedpage(driver);
            int totalQuestions = 9; // Number of questions in the survey
            for (int j = 0; j < totalQuestions; j++) {
                satisfiedPage0.answerRandomOption(j); // Answer the question randomly
                if (j < totalQuestions - 1) {
                    satisfiedPage0.clickNext(); // Navigate to the next question
                }
            }
            // Submit the survey after the last question
            satisfiedPage0.submitSurvey();

            driver.findElement(By.xpath("//button[contains(text(),'العودة للرئيسية')]") ).click();
            driver.findElement(By.cssSelector("button[id='button-basic'] img[alt='image']") ).click();
            driver.findElement(By.cssSelector("body > app-root:nth-child(1) > app-home-panel:nth-child(2) > div:nth-child(1) > app-header:nth-child(1) > header:nth-child(1) > div:nth-child(1) > nav:nth-child(1) > div:nth-child(3) > ul:nth-child(1) > li:nth-child(3) > div:nth-child(1) > ul:nth-child(2) > li:nth-child(5) > a:nth-child(1)") ).click();
        }

        // التأكد من تسجيل الخروج بنجاح

        driver.findElement(By.className("personal-image")).click();
      /*  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@class='personal-image']")));
        element.click();*/
        driver.findElement(By.cssSelector("body > app-root:nth-child(1) > app-home-panel:nth-child(2) > div:nth-child(1) > app-header:nth-child(1) > header:nth-child(1) > div:nth-child(1) > nav:nth-child(1) > div:nth-child(3) > ul:nth-child(1) > li:nth-child(3) > div:nth-child(1) > ul:nth-child(2) > li:nth-child(5) > a:nth-child(1)")).click();


    }
}



/*
        // Loop through the rows in the sheet (starting from row 1 to skip header)
        for (int j = 1; j <= sheet.getPhysicalNumberOfRows(); j++) {
            Row row = sheet.getRow(j);

            // Read mail and password from Excel columns
            String mail = row.getCell(0).getStringCellValue();  // Column A (mail)
            String password = row.getCell(1).getStringCellValue();  // Column B (password)

            // Pages and WebDriver setup for login

            Pages.P1_LoginPage loginPage = new Pages.P1_LoginPage(driver);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlContains("https://d-line-iis.alqemam.com/Mogab_build_v1.5.02/"));

            loginPage.loginAccount(mail, password);  // Use the email and password from Excel

            P3_HomePage homedPage = P1_LoginPage.clickLoginButton();
            Pages.P3_HomePage homedPage0 = new P3_HomePage(driver);

            P5_SatisfiedPage satisfiedPage = ClickIconSatisfied();
            P6_StartSatisfiedpage StartSatisfiedpage = P5_SatisfiedPage.SatisfcationTab();
            driver.findElement(By.cssSelector("div[class='survey-intro flex-column gap-3 pb-3 active'] button:nth-child(2)")).click();
            P6_StartSatisfiedpage satisfiedPage0 = new P6_StartSatisfiedpage(driver);
            int totalQuestions = 9; // Number of questions in the survey
            for (int i = 0; i < totalQuestions; i++) {
                satisfiedPage0.answerRandomOption(i); // Answer the question randomly
                if (i < totalQuestions - 1) {
                    satisfiedPage0.clickNext(); // Navigate to the next question
                }
            }
            // Submit the survey after the last question
            satisfiedPage0.submitSurvey();

            driver.findElement(By.xpath("//button[contains(text(),'العودة للرئيسية')]")).click();
            driver.findElement(By.cssSelector("button[id='button-basic'] img[alt='image']")).click();
            driver.findElement(By.cssSelector("body > app-root:nth-child(1) > app-home-panel:nth-child(2) > div:nth-child(1) > app-header:nth-child(1) > header:nth-child(1) > div:nth-child(1) > nav:nth-child(1) > div:nth-child(3) > ul:nth-child(1) > li:nth-child(3) > div:nth-child(1) > ul:nth-child(2) > li:nth-child(5) > a:nth-child(1)")).click();
        }
    }
    }
*/


/*
    @Test (priority = 2)
    public void testSatisfiedSurvey6() {

        Pages.P1_LoginPage loginPage = new Pages.P1_LoginPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("https://d-line-iis.alqemam.com/Mogab_build_v1.5.02/"));

        loginPage.loginAccount("503588006", "NNN&&&nnn123");
        P3_HomePage homedPage = P1_LoginPage.clickLoginButton();
        //Assert.assertEquals(homedPage.HomePageIcon(),"مرحبا بك في مجاب نتمنى لكم تجربة ممتعة مع الموقع");
        Pages.P3_HomePage homedPage0 = new P3_HomePage(driver);
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        P5_SatisfiedPage satisfiedPage = ClickIconSatisfied();
    //    driver.findElement(By.cssSelector("body > app-root:nth-child(1) > app-home-panel:nth-child(2) > div:nth-child(1) > app-header:nth-child(1) > header:nth-child(1) > div:nth-child(1) > nav:nth-child(1) > ul:nth-child(2) > li:nth-child(4) > a:nth-child(1) > span:nth-child(2)") ).click();

        P6_StartSatisfiedpage StartSatisfiedpage = P5_SatisfiedPage.SatisfcationTab();
        driver.findElement(By.cssSelector("div[class='survey-intro flex-column gap-3 pb-3 active'] button:nth-child(2)") ).click();

        P6_StartSatisfiedpage satisfiedPage0 = new P6_StartSatisfiedpage(driver);
        int totalQuestions =9; // Number of questions in the survey
        for (int i = 0; i < totalQuestions; i++) {
            satisfiedPage0.answerRandomOption(i); // Answer the question randomly
            if (i < totalQuestions - 1) {
                satisfiedPage0.clickNext(); // Navigate to the next question
            }
        }
        // Submit the survey after the last question
        satisfiedPage0.submitSurvey();

        driver.findElement(By.xpath("//button[contains(text(),'العودة للرئيسية')]") ).click();
        driver.findElement(By.cssSelector("button[id='button-basic'] img[alt='image']") ).click();
        driver.findElement(By.cssSelector("body > app-root:nth-child(1) > app-home-panel:nth-child(2) > div:nth-child(1) > app-header:nth-child(1) > header:nth-child(1) > div:nth-child(1) > nav:nth-child(1) > div:nth-child(3) > ul:nth-child(1) > li:nth-child(3) > div:nth-child(1) > ul:nth-child(2) > li:nth-child(5) > a:nth-child(1)") ).click();


    }

    @Test (priority = 3)
    public void testSatisfiedSurvey8() {

        Pages.P1_LoginPage loginPage = new Pages.P1_LoginPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("https://d-line-iis.alqemam.com/Mogab_build_v1.5.02/"));

        loginPage.loginAccount("503588008", "NNN&&&nnn123");
        P3_HomePage homedPage = P1_LoginPage.clickLoginButton();
        //Assert.assertEquals(homedPage.HomePageIcon(),"مرحبا بك في مجاب نتمنى لكم تجربة ممتعة مع الموقع");
        Pages.P3_HomePage homedPage0 = new P3_HomePage(driver);
        P5_SatisfiedPage satisfiedPage = ClickIconSatisfied();
      //  driver.findElement(By.cssSelector("body > app-root:nth-child(1) > app-home-panel:nth-child(2) > div:nth-child(1) > app-header:nth-child(1) > header:nth-child(1) > div:nth-child(1) > nav:nth-child(1) > ul:nth-child(2) > li:nth-child(4) > a:nth-child(1) > span:nth-child(2)") ).click();

        P6_StartSatisfiedpage StartSatisfiedpage = P5_SatisfiedPage.SatisfcationTab();
        driver.findElement(By.cssSelector("div[class='survey-intro flex-column gap-3 pb-3 active'] button:nth-child(2)") ).click();


        P6_StartSatisfiedpage satisfiedPage0 = new P6_StartSatisfiedpage(driver);

        int totalQuestions = 9; // Number of questions in the survey

        for (int i = 0; i < totalQuestions; i++) {
            satisfiedPage0.answerRandomOption(i); // Answer the question randomly

            if (i < totalQuestions - 1) {
                satisfiedPage0.clickNext(); // Navigate to the next question
            }
        }

        // Submit the survey after the last question
        satisfiedPage0.submitSurvey();

        driver.findElement(By.xpath("//button[contains(text(),'العودة للرئيسية')]") ).click();
        driver.findElement(By.cssSelector("button[id='button-basic'] img[alt='image']") ).click();
        driver.findElement(By.cssSelector("body > app-root:nth-child(1) > app-home-panel:nth-child(2) > div:nth-child(1) > app-header:nth-child(1) > header:nth-child(1) > div:nth-child(1) > nav:nth-child(1) > div:nth-child(3) > ul:nth-child(1) > li:nth-child(3) > div:nth-child(1) > ul:nth-child(2) > li:nth-child(5) > a:nth-child(1)") ).click();

    }

    @Test (priority = 4)
    public void testSatisfiedSurvey9() {

        Pages.P1_LoginPage loginPage4 = new Pages.P1_LoginPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("https://d-line-iis.alqemam.com/Mogab_build_v1.5.02/"));

        loginPage4.loginAccount("503588009", "NNN&&&nnn1/2");
        P3_HomePage homedPage = P1_LoginPage.clickLoginButton();
        //Assert.assertEquals(homedPage.HomePageIcon(),"مرحبا بك في مجاب نتمنى لكم تجربة ممتعة مع الموقع");
        Pages.P3_HomePage homedPage0 = new P3_HomePage(driver);
        P5_SatisfiedPage satisfiedPage = ClickIconSatisfied();
        //driver.findElement(By.cssSelector("body > app-root:nth-child(1) > app-home-panel:nth-child(2) > div:nth-child(1) > app-header:nth-child(1) > header:nth-child(1) > div:nth-child(1) > nav:nth-child(1) > ul:nth-child(2) > li:nth-child(4) > a:nth-child(1) > span:nth-child(2)") ).click();

        P6_StartSatisfiedpage StartSatisfiedpage = P5_SatisfiedPage.SatisfcationTab();
        driver.findElement(By.cssSelector("div[class='survey-intro flex-column gap-3 pb-3 active'] button:nth-child(2)") ).click();

        P6_StartSatisfiedpage satisfiedPage0 = new P6_StartSatisfiedpage(driver);
        int totalQuestions = 9; // Number of questions in the survey
        for (int i = 0; i < totalQuestions; i++) {
            satisfiedPage0.answerRandomOption(i); // Answer the question randomly
            if (i < totalQuestions - 1) {
                satisfiedPage0.clickNext(); // Navigate to the next question
            }
        }
        // Submit the survey after the last question
        satisfiedPage0.submitSurvey();

        driver.findElement(By.xpath("//button[contains(text(),'العودة للرئيسية')]") ).click();
        driver.findElement(By.cssSelector("button[id='button-basic'] img[alt='image']") ).click();
        driver.findElement(By.cssSelector("body > app-root:nth-child(1) > app-home-panel:nth-child(2) > div:nth-child(1) > app-header:nth-child(1) > header:nth-child(1) > div:nth-child(1) > nav:nth-child(1) > div:nth-child(3) > ul:nth-child(1) > li:nth-child(3) > div:nth-child(1) > ul:nth-child(2) > li:nth-child(5) > a:nth-child(1)") ).click();
    }


    @Test (priority = 5)
    public void testSatisfiedSurvey11() {

        Pages.P1_LoginPage loginPage5 = new Pages.P1_LoginPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("https://d-line-iis.alqemam.com/Mogab_build_v1.5.02/"));

        loginPage5.loginAccount("503588011", "NNN&&&nnn123");
        P3_HomePage homedPage = P1_LoginPage.clickLoginButton();
       // Assert.assertEquals(homedPage.HomePageIcon(),"مرحبا بك في مجاب نتمنى لكم تجربة ممتعة مع الموقع");
        Pages.P3_HomePage homedPage0 = new P3_HomePage(driver);
        P5_SatisfiedPage satisfiedPage = ClickIconSatisfied();
     //   driver.findElement(By.cssSelector("body > app-root:nth-child(1) > app-home-panel:nth-child(2) > div:nth-child(1) > app-header:nth-child(1) > header:nth-child(1) > div:nth-child(1) > nav:nth-child(1) > ul:nth-child(2) > li:nth-child(4) > a:nth-child(1) > span:nth-child(2)") ).click();

        P6_StartSatisfiedpage StartSatisfiedpage = P5_SatisfiedPage.SatisfcationTab();
        driver.findElement(By.cssSelector("div[class='survey-intro flex-column gap-3 pb-3 active'] button:nth-child(2)") ).click();

        P6_StartSatisfiedpage satisfiedPage0 = new P6_StartSatisfiedpage(driver);
        int totalQuestions = 9; // Number of questions in the survey
        for (int i = 0; i < totalQuestions; i++) {
            satisfiedPage0.answerRandomOption(i); // Answer the question randomly
            if (i < totalQuestions - 1) {
                satisfiedPage0.clickNext(); // Navigate to the next question
            }
        }
        // Submit the survey after the last question
        satisfiedPage0.submitSurvey();

        driver.findElement(By.xpath("//button[contains(text(),'العودة للرئيسية')]") ).click();
        driver.findElement(By.cssSelector("button[id='button-basic'] img[alt='image']") ).click();
        driver.findElement(By.cssSelector("body > app-root:nth-child(1) > app-home-panel:nth-child(2) > div:nth-child(1) > app-header:nth-child(1) > header:nth-child(1) > div:nth-child(1) > nav:nth-child(1) > div:nth-child(3) > ul:nth-child(1) > li:nth-child(3) > div:nth-child(1) > ul:nth-child(2) > li:nth-child(5) > a:nth-child(1)") ).click();
    }


    @Test (priority = 6)
    public void testSatisfiedSurvey13() {

        Pages.P1_LoginPage loginPage6 = new Pages.P1_LoginPage(driver);


        loginPage6.loginAccount("503588013", "NNN&&&nnn123");
        P3_HomePage homedPage = P1_LoginPage.clickLoginButton();
        //Assert.assertEquals(homedPage.HomePageIcon(),"مرحبا بك في مجاب نتمنى لكم تجربة ممتعة مع الموقع");
        Pages.P3_HomePage homedPage0 = new P3_HomePage(driver);
        P5_SatisfiedPage satisfiedPage = ClickIconSatisfied();
        P6_StartSatisfiedpage StartSatisfiedpage = P5_SatisfiedPage.SatisfcationTab();
        driver.findElement(By.cssSelector("div[class='survey-intro flex-column gap-3 pb-3 active'] button:nth-child(2)") ).click();

        P6_StartSatisfiedpage satisfiedPage0 = new P6_StartSatisfiedpage(driver);
        int totalQuestions = 9; // Number of questions in the survey
        for (int i = 0; i < totalQuestions; i++) {
            satisfiedPage0.answerRandomOption(i); // Answer the question randomly
            if (i < totalQuestions - 1) {
                satisfiedPage0.clickNext(); // Navigate to the next question
            }
        }
        // Submit the survey after the last question
        satisfiedPage0.submitSurvey();

        driver.findElement(By.xpath("//button[contains(text(),'العودة للرئيسية')]") ).click();
        driver.findElement(By.cssSelector("button[id='button-basic'] img[alt='image']") ).click();
        driver.findElement(By.cssSelector("body > app-root:nth-child(1) > app-home-panel:nth-child(2) > div:nth-child(1) > app-header:nth-child(1) > header:nth-child(1) > div:nth-child(1) > nav:nth-child(1) > div:nth-child(3) > ul:nth-child(1) > li:nth-child(3) > div:nth-child(1) > ul:nth-child(2) > li:nth-child(5) > a:nth-child(1)") ).click();
    }


    @Test (priority = 7)
    public void testSatisfiedSurvey15() {

        Pages.P1_LoginPage loginPage7 = new Pages.P1_LoginPage(driver);


        loginPage7.loginAccount("503588015", "NNN&&&nnn123");
        P3_HomePage homedPage = P1_LoginPage.clickLoginButton();
        //Assert.assertEquals(homedPage.HomePageIcon(),"مرحبا بك في مجاب نتمنى لكم تجربة ممتعة مع الموقع");
        Pages.P3_HomePage homedPage0 = new P3_HomePage(driver);
        P5_SatisfiedPage satisfiedPage = ClickIconSatisfied();
        P6_StartSatisfiedpage StartSatisfiedpage = P5_SatisfiedPage.SatisfcationTab();
        driver.findElement(By.cssSelector("div[class='survey-intro flex-column gap-3 pb-3 active'] button:nth-child(2)") ).click();

        P6_StartSatisfiedpage satisfiedPage0 = new P6_StartSatisfiedpage(driver);
        int totalQuestions = 9; // Number of questions in the survey
        for (int i = 0; i < totalQuestions; i++) {
            satisfiedPage0.answerRandomOption(i); // Answer the question randomly
            if (i < totalQuestions - 1) {
                satisfiedPage0.clickNext(); // Navigate to the next question
            }
        }
        // Submit the survey after the last question
        satisfiedPage0.submitSurvey();

        driver.findElement(By.xpath("//button[contains(text(),'العودة للرئيسية')]") ).click();
        driver.findElement(By.cssSelector("button[id='button-basic'] img[alt='image']") ).click();
        driver.findElement(By.cssSelector("body > app-root:nth-child(1) > app-home-panel:nth-child(2) > div:nth-child(1) > app-header:nth-child(1) > header:nth-child(1) > div:nth-child(1) > nav:nth-child(1) > div:nth-child(3) > ul:nth-child(1) > li:nth-child(3) > div:nth-child(1) > ul:nth-child(2) > li:nth-child(5) > a:nth-child(1)") ).click();
    }





    @Test (priority = 8)
    public void testSatisfiedSurvey16() {

        Pages.P1_LoginPage loginPage8 = new Pages.P1_LoginPage(driver);


        loginPage8.loginAccount("503588016", "NNN&&&nnn123");
        P3_HomePage homedPage = P1_LoginPage.clickLoginButton();
      //  Assert.assertEquals(homedPage.HomePageIcon(),"مرحبا بك في مجاب نتمنى لكم تجربة ممتعة مع الموقع");
        Pages.P3_HomePage homedPage0 = new P3_HomePage(driver);
        P5_SatisfiedPage satisfiedPage = ClickIconSatisfied();
        P6_StartSatisfiedpage StartSatisfiedpage = P5_SatisfiedPage.SatisfcationTab();
        driver.findElement(By.cssSelector("div[class='survey-intro flex-column gap-3 pb-3 active'] button:nth-child(2)") ).click();

        P6_StartSatisfiedpage satisfiedPage0 = new P6_StartSatisfiedpage(driver);
        int totalQuestions = 9; // Number of questions in the survey
        for (int i = 0; i < totalQuestions; i++) {
            satisfiedPage0.answerRandomOption(i); // Answer the question randomly
            if (i < totalQuestions - 1) {
                satisfiedPage0.clickNext(); // Navigate to the next question
            }
        }
        // Submit the survey after the last question
        satisfiedPage0.submitSurvey();

        driver.findElement(By.xpath("//button[contains(text(),'العودة للرئيسية')]") ).click();
        driver.findElement(By.cssSelector("button[id='button-basic'] img[alt='image']") ).click();
        driver.findElement(By.cssSelector("body > app-root:nth-child(1) > app-home-panel:nth-child(2) > div:nth-child(1) > app-header:nth-child(1) > header:nth-child(1) > div:nth-child(1) > nav:nth-child(1) > div:nth-child(3) > ul:nth-child(1) > li:nth-child(3) > div:nth-child(1) > ul:nth-child(2) > li:nth-child(5) > a:nth-child(1)") ).click();
    }



    @Test (priority =9)
    public void testSatisfiedSurvey17() {

        Pages.P1_LoginPage loginPage9 = new Pages.P1_LoginPage(driver);


        loginPage9.loginAccount("503588017", "NNN&&&nnn123");
        P3_HomePage homedPage = P1_LoginPage.clickLoginButton();
       // Assert.assertEquals(homedPage.HomePageIcon(),"مرحبا بك في مجاب نتمنى لكم تجربة ممتعة مع الموقع");
        Pages.P3_HomePage homedPage0 = new P3_HomePage(driver);
        P5_SatisfiedPage satisfiedPage = ClickIconSatisfied();
        P6_StartSatisfiedpage StartSatisfiedpage = P5_SatisfiedPage.SatisfcationTab();
        driver.findElement(By.cssSelector("div[class='survey-intro flex-column gap-3 pb-3 active'] button:nth-child(2)") ).click();

        P6_StartSatisfiedpage satisfiedPage0 = new P6_StartSatisfiedpage(driver);
        int totalQuestions = 9; // Number of questions in the survey
        for (int i = 0; i < totalQuestions; i++) {
            satisfiedPage0.answerRandomOption(i); // Answer the question randomly
            if (i < totalQuestions - 1) {
                satisfiedPage0.clickNext(); // Navigate to the next question
            }
        }
        // Submit the survey after the last question
        satisfiedPage0.submitSurvey();

        driver.findElement(By.xpath("//button[contains(text(),'العودة للرئيسية')]") ).click();
        driver.findElement(By.cssSelector("button[id='button-basic'] img[alt='image']") ).click();
        driver.findElement(By.cssSelector("body > app-root:nth-child(1) > app-home-panel:nth-child(2) > div:nth-child(1) > app-header:nth-child(1) > header:nth-child(1) > div:nth-child(1) > nav:nth-child(1) > div:nth-child(3) > ul:nth-child(1) > li:nth-child(3) > div:nth-child(1) > ul:nth-child(2) > li:nth-child(5) > a:nth-child(1)") ).click();
    }

    @Test (priority = 10)
    public void testSatisfiedSurvey20() {

        Pages.P1_LoginPage loginPage10 = new Pages.P1_LoginPage(driver);


        loginPage10.loginAccount("503588020", "NNN&&&nnn123");
        P3_HomePage homedPage = P1_LoginPage.clickLoginButton();
       // Assert.assertEquals(homedPage.HomePageIcon(), "مرحبا بك في مجاب نتمنى لكم تجربة ممتعة مع الموقع");
        Pages.P3_HomePage homedPage0 = new P3_HomePage(driver);
        P5_SatisfiedPage satisfiedPage = ClickIconSatisfied();
        P6_StartSatisfiedpage StartSatisfiedpage = P5_SatisfiedPage.SatisfcationTab();
        driver.findElement(By.cssSelector("div[class='survey-intro flex-column gap-3 pb-3 active'] button:nth-child(2)")).click();

        P6_StartSatisfiedpage satisfiedPage0 = new P6_StartSatisfiedpage(driver);
        int totalQuestions = 9; // Number of questions in the survey
        for (int i = 0; i < totalQuestions; i++) {
            satisfiedPage0.answerRandomOption(i); // Answer the question randomly
            if (i < totalQuestions - 1) {
                satisfiedPage0.clickNext(); // Navigate to the next question
            }
        }
        // Submit the survey after the last question
        satisfiedPage0.submitSurvey();

        driver.findElement(By.xpath("//button[contains(text(),'العودة للرئيسية')]") ).click();
        driver.findElement(By.cssSelector("button[id='button-basic'] img[alt='image']") ).click();
        driver.findElement(By.cssSelector("body > app-root:nth-child(1) > app-home-panel:nth-child(2) > div:nth-child(1) > app-header:nth-child(1) > header:nth-child(1) > div:nth-child(1) > nav:nth-child(1) > div:nth-child(3) > ul:nth-child(1) > li:nth-child(3) > div:nth-child(1) > ul:nth-child(2) > li:nth-child(5) > a:nth-child(1)") ).click();
    }

    }*/


