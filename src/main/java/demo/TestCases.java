package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://leetcode.com/");
        String url=driver.getCurrentUrl();
        if(url.contains("leetcode")){
            System.out.println("The URL of the Leetcode homepage contains leetcode");
        }
        else{
            System.out.println("Url Not conatins Leetcode");
        }
        System.out.println("end Test case: testCase01");
    }
    public void testCase02() throws InterruptedException{
        driver.get("https://leetcode.com/");
        driver.findElement(By.xpath("//p[contains(text(),'View Questions ')]")).click();
        Thread.sleep(3000);
        String problemSet=driver.getCurrentUrl();
        if(problemSet.contains("problemset")){
            System.out.println("URL contains problem set");
        }else{
            System.out.println("URL doesn't contains problem set");

        }
        List<WebElement> questions=driver.findElements(By.xpath("//a[contains(@href,'/problems/')]"));
        for(WebElement problem:questions){
            int count=0;
            if(count<5){
                String text=problem.getText();
                if(text.contains("Two Sum")||text.contains("Add Two Numbers")||text.contains("Longest Substring")||text.contains("Median of Two Sorted Arrays")||text.contains("Longest Palindromic Substring")){
                System.out.println(text);
                
                }
                count++;
            }else{
                break;
            }
        }
        
    }
    public void testCase03() throws InterruptedException{
        driver.get("https://leetcode.com/");
        driver.findElement(By.xpath("//p[contains(text(),'View Questions ')]")).click();
        Thread.sleep(3000);
        WebElement twoSum=driver.findElement(By.xpath("//a[@href='/problems/two-sum']"));
        twoSum.click();
        Thread.sleep(3000);
        String url=driver.getCurrentUrl();
        if(url.contains("two-sum")){
            System.out.println("The URL of the problem contains two-sum");
        }else{
            System.out.println("The URL of the problem not contains two-sum");

        }

    }
    public void testCase04() throws InterruptedException{
        driver.get("https://leetcode.com/");
        driver.findElement(By.xpath("//p[contains(text(),'View Questions ')]")).click();
        Thread.sleep(3000);
        WebElement twoSum=driver.findElement(By.xpath("//a[@href='/problems/two-sum']"));
        twoSum.click();
        Thread.sleep(3000);
        driver.findElement(By.id("submissions_tab")).click();
        WebElement regorSign=driver.findElement(By.xpath("//a[contains(@class,'dark:hover:bg-dark-green')]"));
        String text=regorSign.getText();
        if(text.contains("Register or Sign In")){
            System.out.println("The message Register or Sign In is displayed when you click on the submissions tab.");
        }
        else{
            System.out.println("The message Register or Sign In is not displayed when you click on the submissions tab.");
        }

    }


}
