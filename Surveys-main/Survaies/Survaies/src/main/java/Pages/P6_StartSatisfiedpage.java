
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class P6_StartSatisfiedpage {
    static WebDriver driver;

    public P6_StartSatisfiedpage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators for multiple-choice options
    By nextButtonLocator = By.cssSelector("button[class='btn btn-primary py-2 next-btn']");
    By prevButtonLocator = By.cssSelector("button[class='btn btn-grayOpacity-4 prev-btn py-2']");
    By submitButtonLocator = By.cssSelector("div[class='survey-questions flex-column gap-3 flex-grow-1 active'] button:nth-child(2)");

    // Method to randomly select an option for a multiple-choice question
    public void answerRandomOption(int questionNumber) {
        // Dynamically generate the locators for options based on the question number (q0, q1, etc.)
        By optionLocator0 = By.cssSelector("label[for='q" + questionNumber + "-a0']");
        By optionLocator1 = By.cssSelector("label[for='q" + questionNumber + "-a1']");
        By optionLocator2 = By.cssSelector("label[for='q" + questionNumber + "-a2']");
        By optionLocator3 = By.cssSelector("label[for='q" + questionNumber + "-a3']");



        // Add all locators to a list
        List<By> optionLocators = Arrays.asList(optionLocator0, optionLocator1, optionLocator2, optionLocator3);

        // Randomly choose one locator from the list
        Random random = new Random();
        int randomIndex = random.nextInt(optionLocators.size());

        // Wait for the options to be visible and clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(optionLocators.get(randomIndex))));

        // Find the element and click it
        option.click();
    }

    // Method to navigate to the next question
    public void clickNext() {
        // Wait for the next button to be clickable before clicking
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(nextButtonLocator)));
        nextButton.click();
    }

    // Method to navigate to the previous question
    public void clickPrevious() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement prevButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(prevButtonLocator)));
        prevButton.click();
    }

    // Method to submit the survey
    public void submitSurvey() {
        // Wait for the submit button to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(submitButtonLocator)));
        submitButton.click();
    }
}

 /*
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class P6_StartSatisfiedpage {
    static WebDriver driver;

    public P6_StartSatisfiedpage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators for navigation buttons
    By nextButtonLocator = By.cssSelector("button[class='btn btn-primary py-2 next-btn']");
    By prevButtonLocator = By.cssSelector("button[class='btn btn-grayOpacity-4 prev-btn py-2']");
    By submitButtonLocator = By.cssSelector("div[class='survey-questions flex-column gap-3 flex-grow-1 active'] button:nth-child(2)");

    // XPath locators for question types (text or multiple-choice)
    By textQuestionLocator = By.xpath("(//p[@class='answer-desc mb-3'][contains(text(),'الإجابة')])[3]");
    By choiceQuestionLocator = By.xpath("((//p[@class='answer-desc mb-3'][contains(text(),'اختر الإجابة')])[3])");

    // Method to randomly select an option for a multiple-choice question
    public void answerRandomOption(int questionNumber) {
        // Dynamically generate the locators for options based on the question number (q0, q1, etc.)
        By optionLocator0 = By.cssSelector("label[for='q" + questionNumber + "-a0']");
        By optionLocator1 = By.cssSelector("label[for='q" + questionNumber + "-a1']");
        By optionLocator2 = By.cssSelector("label[for='q" + questionNumber + "-a2']");
        By optionLocator3 = By.cssSelector("label[for='q" + questionNumber + "-a3']");

        // Add all locators to a list
        List<By> optionLocators = Arrays.asList(optionLocator0, optionLocator1, optionLocator2, optionLocator3);

        // Randomly choose one locator from the list
        Random random = new Random();
        int randomIndex = random.nextInt(optionLocators.size());

        // Wait for the options to be visible and clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(optionLocators.get(randomIndex))));

        // Find the element and click it
        option.click();
    }

    // Method to handle text input questions
    public void answerTextQuestion(int questionNumber) {
        // Locate the text input field for the current question (q0, q1, etc.)
        By textInputLocator = By.cssSelector("textarea[for='q" + questionNumber + "']"); // Example for textarea
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement textInputField = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(textInputLocator)));

        // Enter random text into the text input field
        String randomText = "Random response for question " + questionNumber;
        textInputField.sendKeys(randomText);
    }

    // Method to navigate to the next question
    public void clickNext() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(nextButtonLocator)));
        nextButton.click();
    }

    // Method to navigate to the previous question
    public void clickPrevious() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement prevButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(prevButtonLocator)));
        prevButton.click();
    }

    // Method to submit the survey
    public void submitSurvey() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(submitButtonLocator)));
        submitButton.click();
    }

    // Method to answer a question (either text-based or multiple-choice)
    public void answerQuestion(int questionNumber) {
        // Check if the question is text-based or multiple-choice using the XPath locators
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Check for text question
        if (driver.findElements(textQuestionLocator).size() > 0) {
            answerTextQuestion(questionNumber);  // Answer text-based question
        } else if (driver.findElements(choiceQuestionLocator).size() > 0) {
            answerRandomOption(questionNumber);  // Answer multiple-choice question
        }
    }
}
*/