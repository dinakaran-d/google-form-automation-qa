package demo;

import java.util.List;
import java.util.logging.Level;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import demo.wrappers.Wrappers;

public class TestCases {
    ChromeDriver driver;
    Wrappers wrapper;

    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */
   

    @Test
    public void testCase01() throws InterruptedException {
      
       
        System.out.println("Test case start : TestCase01");
        System.out.println("Step: 1-Navigated to google Form");
        Thread.sleep(2000);


        WebElement nameInputBox = driver.findElement(By.xpath("//div[contains(@class, 'k3kHxc')]//input"));
        wrapper.enterText(nameInputBox, "Crio Learner");
        System.out.println("Step: 2-text filled on name input box");
        Thread.sleep(2000);

        String epochTime = wrapper.getCurrentEpochTime();
        WebElement practicingAutomationTextArea = driver.findElement(By.xpath("//textarea[contains(@class, 'tL9Q4c')]"));
        String practicingAutomationText = "I want to be the best QA Engineer! ";
        wrapper.enterText(practicingAutomationTextArea, practicingAutomationText  +" " +epochTime);
        System.out.println("Step: 3-Practicing Automation text box filled");
        Thread.sleep(2000);

        List<WebElement> radioButtons = driver.findElements(By.xpath("   //div[@class='SG0AAe']//div[@class='nWQGrd zwllIb']//span[@dir='auto']"));
        wrapper.radioButtonLoop(radioButtons, "0 - 2");
        System.out.println("Step: 4-radio button selected");
        Thread.sleep(2000);

        List<WebElement> checkBoxes = driver.findElements(By.xpath("   //div[@aria-labelledby='i28 i31']//span[contains(@dir, 'auto')]"));
        
        wrapper.checkBox(checkBoxes, "Java" ); //java
        wrapper.checkBox(checkBoxes, "Selenium" ); //selenium
        wrapper.checkBox(checkBoxes, "TestNg" ); //TestNg
        System.out.println("Step: 5-Check boxes java, selenium, testNg selected");
        Thread.sleep(2000);


        WebElement dropDownButton = driver.findElement(By.xpath("(//span[@class='vRMGwf oJeWuf'])[1]"));
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='vRMGwf oJeWuf'])[1]")));

        wrapper.clickOnElement(dropDownButton);
        Thread.sleep(2000);
        
        
       List<WebElement> dropdownOptions = driver.findElements(By.xpath("//div[contains(@class,'ncFHed')]//span[not(contains(text(),'Choose'))]"));
       Thread.sleep(2000); 
       wrapper.dropDownClickLoop(dropdownOptions, "Mr"); //Mr
       Thread.sleep(2000);

       
        System.out.println("Step: 6-dropdown clicked & option selected");
        Thread.sleep(2000);

        WebElement dateInputBox = driver.findElement(By.xpath("//div[@jscontroller='lLliLe']//input"));
        String sevenDaysGoDate = wrapper.getdateSevenDaysAgo(7);
        wrapper.enterText(dateInputBox, sevenDaysGoDate);
        System.out.println("Step: 7-Date selected before 7 days");
        Thread.sleep(2000);


        WebElement hourElement = driver.findElement(By.xpath("//input[@aria-label='Hour']"));
        WebElement minuteElement = driver.findElement(By.xpath("//input[@aria-label='Minute']"));
        WebElement submitButton = driver.findElement(By.xpath("//*[@id='mG61Hd']/div[2]/div/div[3]/div[1]/div[1]/div/span"));
        wrapper.enterText(hourElement, "07");
        wrapper.enterText(minuteElement, "30");
        System.out.println("Step: 8-Time Selected");
        Thread.sleep(2000);
        wrapper.clickOnElement(submitButton);
        System.out.println("Step: 9-Submit button clicked");
        Thread.sleep(2000);

        WebElement successMessageElement  = driver.findElement(By.xpath("//div[@class='vHW8K']"));
        Thread.sleep(3000);
        System.out.println(successMessageElement.getText());
        System.out.println("Test case end-Step: 10-Success message printed");
        Thread.sleep(2000);

        System.out.println("Test case end : TestCase01");
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
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
        
    }
   

    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }
}