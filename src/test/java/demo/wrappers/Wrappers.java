package demo.wrappers;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public void enterText(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void radioButtonLoop(List<WebElement> elements, String radioButtonText) {
        try {
            for (WebElement element : elements) {
                if (element.getText().equalsIgnoreCase(radioButtonText)) {
                    element.click();
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkBox(List<WebElement> elements, String checkBoxText) {
        try {
            for (WebElement element : elements) {
                if (element.getText().equalsIgnoreCase(checkBoxText)) {
                    element.click();
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dropDownClick(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dropDownClickLoop(List<WebElement> elements, String dropDownText) {
        try {
            for (WebElement element : elements) {
                if (element.getText().equals(dropDownText)) {
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("arguments[0].click();", element);
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickOnElement(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getdateSevenDaysAgo(int days) {
        LocalDate currentDate = LocalDate.now();
        LocalDate dateMinus7Days = currentDate.minusDays(days);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dateMinus7Days.format(formatter);
    }

    public String getCurrentEpochTime() {
        long epochTime = System.currentTimeMillis() / 1000;
        return String.valueOf(epochTime);
    }

}
