package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;

public class TestCases {
    ChromeDriver driver;
    Wrappers wrapper;

    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */
   

    @Test
    public void testCase01() {
      
        wrapper.navigateTo("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
        System.out.println("Test case start-Step: 1-Navigation success");

        wrapper.sendKeys(By.xpath("//div[@class='Xb9hP']//child::input[@aria-describedby='i2 i3']"), "Crio Learner");
        System.out.println("Step: 2-text filled");

        long epochTime = wrapper.getCurrentEpochTime();
        wrapper.sendKeys(By.xpath("//textarea[@aria-describedby='i7 i8']"), "I want to be the best QA Engineer! " + epochTime);
        System.out.println("Step: 3-aim filled");

        wrapper.click(By.xpath("//*[@id='i16']/div[3]/div"));
        System.out.println("Step: 4-radio button selected");

        wrapper.click(By.xpath("//*[@id='i34']/child::div[2]")); //java
        wrapper.click(By.xpath("//*[@id='i37']/child::div[2]")); //selenium
        wrapper.click(By.xpath("//*[@id='i43']/child::div[2]")); //TestNg
        System.out.println("Step: 5-Check boxes java, selenium, testNg selected");

        wrapper.click(By.xpath("(//span[@class='vRMGwf oJeWuf'])[1]")); //dropdown
        wrapper.click(By.xpath("(//div[@jsname='wQNmvb']//span[text()='Mr'])[2]")); //option Mr
        System.out.println("Step: 6-dropdown selected");

        wrapper.sendDate(By.xpath("//div[@jscontroller='lLliLe']//input"), "27-01-2025");
        System.out.println("Step: 7-Date selected");

        wrapper.sendKeys(By.xpath("//input[@aria-label='Hour']"), "07");
        wrapper.sendKeys(By.xpath("//input[@aria-label='Minute']"), "30");
        System.out.println("Step: 8-Time Selected");

        wrapper.click(By.xpath("//*[@id='mG61Hd']/div[2]/div/div[3]/div[1]/div[1]/div/span"));
        System.out.println("Step: 9-Submit button clicked");

        wrapper.waitAndPrintText(By.xpath("//div[@class='idZHHb']//div[text()='Thanks for your response, Automation Wizard!']"));
        System.out.println("Test case end-Step: 10-Success message printed");


    }


     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);
        wrapper = new Wrappers(driver);
        driver.manage().window().maximize();
    }
   

    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }
}