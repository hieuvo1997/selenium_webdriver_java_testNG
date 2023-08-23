package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class Topic_02_Selenium_Locator {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/register");

    }

    @Test
    public void TC_01_ID() {
        // nếu ID là duy nhất
        // Tìm element có ID là Firstname
        driver.findElement(By.id("FirstName"));



    }
    @Test
    public void TC_02_Class() {
        driver.findElement(By.className("header-logo"));
    }

    @Test
    public void TC_03_Css() {
        // Css vs ID
        driver.findElement(By.cssSelector("input[id='FirstName']"));
        //driver.findElement(By.cssSelector("input#FirstName"));
        //driver.findElement(By.cssSelector("#FistName"));

        // Css vs Class
        driver.findElement(By.cssSelector("div[class='page-title']"));
        driver.findElement(By.cssSelector("div#page-title"));
        driver.findElement(By.cssSelector(".page-title"));

        // Css vs Name
        driver.findElement(By.cssSelector("input[Name='FirstName']"));

        // Css vs Tagname
        driver.findElement(By.cssSelector("input"));

        // Css vs link
        driver.findElement(By.cssSelector("a[[href='/customer/address']"));

        // Css vs partial link
        driver.findElement(By.cssSelector("a[[href='address']"));
        driver.findElement(By.cssSelector("a[[href='customer']"));

    }


    @Test
    public void TC_04_Xpath() {
        // Xpath vs ID
        driver.findElement(By.xpath("//input[@id='FirstName']"));
        //driver.findElement(By.cssSelector("input#FirstName"));
        //driver.findElement(By.cssSelector("#FistName"));

        // Xpath vs Class
        driver.findElement(By.xpath("//div[@class='page-title']"));
        //driver.findElement(By.cssSelector("div#page-title"));
        //driver.findElement(By.cssSelector(".page-title"));

        // Xpath vs Name
        driver.findElement(By.xpath("//input[@Name='FirstName']"));

        // Xpath vs Tagname
        driver.findElement(By.xpath("//input"));

        // Xpath vs link
        driver.findElement(By.xpath("//a[[@href='/customer/address']"));

        // Xpath vs partial link
        driver.findElement(By.xpath("//a[constains(@href ,'address')]"));
        driver.findElement(By.xpath("//a[constains(text() ,'address')]"));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
