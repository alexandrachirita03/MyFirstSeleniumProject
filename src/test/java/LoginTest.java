import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    private WebDriver driver;

    @Before
    public void openDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void loginWithValidCredentialsTest() {

        driver.findElement(By.cssSelector(".skip-account .label")).click();
       WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
       accountLink.click();
        driver.findElement(By.cssSelector("a[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("alexandra.rusitoru95@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("pass123");
        driver.findElement(By.id("send2")).click();
       WebElement dashboardTextElement = driver.findElement(By.cssSelector(".page-title h1"));
       String textFromElement = driver.findElement(By.cssSelector(".hello strong")).getText();
        driver.findElement(By.id("send2")).click();
        Assert.assertTrue(dashboardTextElement.isDisplayed());
        Assert.assertEquals("Hello, C Alexandra!",textFromElement);
    }
    @Test
    public void loginWithInvalidPasswordTest() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
//        WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
//        accountLink.click();
        driver.findElement(By.cssSelector("a[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("alexandra.rusitoru95@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("121233456");
        driver.findElement(By.id("send2")).click();
        String textFromElement = driver.findElement(By.cssSelector(".error-msg span")).getText();
        Assert.assertEquals("Invalid login or password.", textFromElement);
    }
    @Test
    public void loginWithInvalidEmail() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
//        WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
//        accountLink.click();
        driver.findElement(By.cssSelector("a[title='Log In")).click();
        driver.findElement(By.id("email")).sendKeys("alexandra.rusitoru95gmail.com");
        driver.findElement(By.id("pass")).sendKeys("121233456");
        driver.findElement(By.id("send2")).click();
    }
    @Test
    public void loginWithoutCredentialsTest() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
//        WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
//        accountLink.click();
        driver.findElement(By.cssSelector("a[title='Log In")).click();
        driver.findElement(By.id("send2")).click();
        String textFromElement = driver.findElement(By.id("advice-required-entry-email")).getText();
        Assert.assertEquals( "This is a required field.", textFromElement);
    }
    @Test
    public void loginWithBlankEmailTest() {
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.id("pass")).sendKeys("121233456");
        driver.findElement(By.cssSelector("#send2 > span > span")).click();
       // String textFromElement = driver.findElement(By.id("advice-required-entry-email")).getText();
        Assert.assertTrue(driver.findElement(By.cssSelector("#.validation-advice")).isDisplayed());
    }




    @After
    public void close() {
        driver.close();
    }



}













