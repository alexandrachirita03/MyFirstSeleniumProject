import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class SearchTest {
    private WebDriver driver;

    @Before
    public void openDriver(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void verifySearchButtonWithBlankInput() throws InterruptedException {
        driver.findElement(By.cssSelector(".search-button")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("#search.required-entry.validation-failed")).isDisplayed());
        sleep(1500);
        driver.close();
    }

}
