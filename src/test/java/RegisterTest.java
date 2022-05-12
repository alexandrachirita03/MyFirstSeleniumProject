import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {

    public void validRegisterTest(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.id("firstname")).sendKeys("Chirita");
        driver.findElement(By.id("middlename")).sendKeys("Georgiana");
        driver.findElement(By.id("lastname")).sendKeys("Alexandra");
        driver.findElement(By.id("email_address")).sendKeys("alexandra.rusitoru95@gmail.com");
        driver.findElement(By.id("password")).sendKeys("pass123");
        driver.findElement(By.id("confirmation")).sendKeys("pass123");
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click();
        driver.close();


    }

    public void registerWithInvalidEmail(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.id("firstname")).sendKeys("Chirita");
        driver.findElement(By.id("middlename")).sendKeys("Georgiana");
        driver.findElement(By.id("lastname")).sendKeys("Alexandra");
        driver.findElement(By.id("email_address")).sendKeys("alexandra.rusitoru95gmail.com");
        driver.findElement(By.id("password")).sendKeys("pass123");
        driver.findElement(By.id("confirmation")).sendKeys("pass123");
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click();
        driver.close();
    }

    public void registerWithBlankSpacesOnMandatoryFields(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.id("firstname")).sendKeys(" ");
        driver.findElement(By.id("middlename")).sendKeys("Georgiana ");
        driver.findElement(By.id("lastname")).sendKeys(" ");
        driver.findElement(By.id("email_address")).sendKeys(" ");
        driver.findElement(By.id("password")).sendKeys(" ");
        driver.findElement(By.id("confirmation")).sendKeys(" ");
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click();
        driver.close();
    }
}
