package TestCase;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.By;
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

public class TEST2 extends BaseTest {

    // كلاس ExcelReader المسؤول عن قراءة البيانات من ملف Excel
    public static class ExcelReader {

        public static int getRowCount(String filePath) throws IOException {
            FileInputStream fis = new FileInputStream(filePath);
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheetAt(0); // قراءة البيانات من الورقة الأولى
            int rowCount = sheet.getPhysicalNumberOfRows(); // الحصول على عدد الصفوف الفعلية
            workbook.close();
            return rowCount;
        }

        public static String[] readRowData(String filePath, int rowIndex) throws IOException {
            FileInputStream fis = new FileInputStream(filePath);
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheetAt(0);

            Row row = sheet.getRow(rowIndex);
            DataFormatter formatter = new DataFormatter();

            String email = formatter.formatCellValue(row.getCell(0)); // قراءة البريد الإلكتروني
            String password = formatter.formatCellValue(row.getCell(1)); // قراءة كلمة المرور

            workbook.close();
            return new String[]{email, password};
        }
    }

    @Test(priority = 1)
    public void testSatisfiedSurvey1() throws IOException {
        String excelFilePath = "D:\\12\\Automation\\Surveys-main\\Survaies\\Survaies\\src\\Book1.xlsx";

        // حساب عدد الصفوف في ملف Excel
        int rowCount = ExcelReader.getRowCount(excelFilePath);

        // حلقة for للمرور على جميع الصفوف
        for (int i = 1; i < rowCount; i++) { // بدءًا من الصف 1 (لأن الصف 0 عادة يحتوي على العناوين)
            System.out.println("Executing test for row: " + i);

            // قراءة بيانات الصف الحالي
            String[] credentials = ExcelReader.readRowData(excelFilePath, i);
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


            // التأكد من تسجيل الخروج بنجاح

            driver.findElement(By.cssSelector("button[id='button-basic'] img[alt='image']")).click();
            driver.findElement(By.cssSelector("body > app-root:nth-child(1) > app-home-panel:nth-child(2) > div:nth-child(1) > app-header:nth-child(1) > header:nth-child(1) > div:nth-child(1) > nav:nth-child(1) > div:nth-child(3) > ul:nth-child(1) > li:nth-child(3) > div:nth-child(1) > ul:nth-child(2) > li:nth-child(5) > a:nth-child(1)")).click();


        }
    }


    @Test(priority =2)
    public void testSatisfiedSurvey2() throws IOException {
        String excelFilePath = "D:\\12\\Automation\\Surveys-main\\Survaies\\Survaies\\src\\Book1.xlsx";

        // حساب عدد الصفوف في ملف Excel
        int rowCount = ExcelReader.getRowCount(excelFilePath);

        // حلقة for للمرور على جميع الصفوف
        for (int i = 1; i < rowCount; i++) { // بدءًا من الصف 1 (لأن الصف 0 عادة يحتوي على العناوين)
            System.out.println("Executing test for row: " + i);

            // قراءة بيانات الصف الحالي
            String[] credentials = ExcelReader.readRowData(excelFilePath, i);
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

            driver.findElement(By.xpath("//img[@class='personal-image']")).click();
            driver.findElement(By.cssSelector("body > app-root:nth-child(1) > app-home-panel:nth-child(2) > div:nth-child(1) > app-header:nth-child(1) > header:nth-child(1) > div:nth-child(1) > nav:nth-child(1) > div:nth-child(3) > ul:nth-child(1) > li:nth-child(3) > div:nth-child(1) > ul:nth-child(2) > li:nth-child(5) > a:nth-child(1)")).click();


        }
    }

