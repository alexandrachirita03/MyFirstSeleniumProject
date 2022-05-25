import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WishListTest {
    private WebDriver driver;

    @Before
    public void openDriver(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }


    @Test
    public void addToWishListTest(){

        driver.findElement(By.cssSelector(".nav-5 .has-children")).click();
        driver.findElement(By.cssSelector("a[title='View Details']")).click();
        driver.findElement(By.cssSelector(".link-wishlist")).click();
        String textFromElement =  driver.findElement(By.cssSelector(".page-title h1")).getText();
        Assert.assertEquals("LOGIN OR CREATE AN ACCOUNT", textFromElement);


    }
    @After
    public void close() {
        driver.close();
    }

}
