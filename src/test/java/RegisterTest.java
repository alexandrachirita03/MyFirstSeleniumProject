import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {

    private WebDriver driver;

    @Before
    public void openDriver(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

 @Test
    public void validRegisterTest(){

        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("a[title='Register']")).click();
        driver.findElement(By.id("firstname")).sendKeys("Alexandra");
        driver.findElement(By.id("middlename")).sendKeys("G");
        driver.findElement(By.id("lastname")).sendKeys("Chirita");
        driver.findElement(By.id("email_address")).sendKeys("alexandra.r@yahoo.com");
        driver.findElement(By.id("password")).sendKeys("pass123");
        driver.findElement(By.id("confirmation")).sendKeys("pass123");
        driver.findElement(By.cssSelector(".buttons-set .button")).click();
        //WebElement dashboardTextElement = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col2-left-layout > div > div.col-main > div.my-account > div.my-wishlist > div > h1"));
        String textFromElement =  driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.std > ul.messages > li > ul > li > span")).getText();
        Assert.assertEquals("Thank you for registering with Madison Island.", textFromElement);

    }

    @Test
    public void registerWithInvalidEmail(){

        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("a[title='Register']")).click();
        driver.findElement(By.id("firstname")).sendKeys("Chirita");
        driver.findElement(By.id("middlename")).sendKeys("Georgiana");
        driver.findElement(By.id("lastname")).sendKeys("Alexandra");
        driver.findElement(By.id("email_address")).sendKeys("alexandra.rusitoru95.com");
        driver.findElement(By.id("password")).sendKeys("pass123");
        driver.findElement(By.id("confirmation")).sendKeys("pass123");
        driver.findElement(By.cssSelector(".buttons-set .button")).click();
        String textFromElement = driver.findElement(By.cssSelector("#email_address")).getText();
        Assert.assertEquals("Please include an '@' in the email address. 'alexandra.rusitoru95.com' is missing an '@'.", textFromElement);
    }


    @Test
    public void registerWithBlankSpacesOnMandatoryFields(){

        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("a[title='Register']")).click();
        driver.findElement(By.id("firstname")).sendKeys(" ");
        driver.findElement(By.id("middlename")).sendKeys("Georgiana ");
        driver.findElement(By.id("lastname")).sendKeys(" ");
        driver.findElement(By.id("email_address")).sendKeys(" ");
        driver.findElement(By.id("password")).sendKeys(" ");
        driver.findElement(By.id("confirmation")).sendKeys(" ");
        driver.findElement(By.cssSelector(".buttons-set .button")).click();
        String textFromElement =  driver.findElement(By.id("advice-required-entry-firstname")).getText();
        Assert.assertEquals("This is a required field.", textFromElement);
    }

    @After
    public void close() {
        driver.close();
    }
}
