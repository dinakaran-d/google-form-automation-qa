package demo.wrappers;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedCondition;

public class Wrappers {
    /*
     * Write your selenium wrappers here
     */
    private ChromeDriver driver;
    private WebDriverWait wait;

    public Wrappers(ChromeDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public WebElement waitForElementClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public  WebElement waitForElementVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void sendKeys(By locator, String text) {
        waitForElementClickable(locator).sendKeys(text);
        System.out.println("Entered text in element: " + text);
    }

    public void click(By locator) {
        waitForElementClickable(locator).click();
    }

    public void sendDate(By locator, String date) {
        waitForElementClickable(locator).sendKeys(date);
        System.out.println("Entered date: " + date);
    }

    public long getCurrentEpochTime() {
        return Instant.now().getEpochSecond();
    }

    public void waitAndPrintText(By locator) {
        WebElement element = waitForElementVisible(locator);
        System.out.println(element.getText());
    }
}
