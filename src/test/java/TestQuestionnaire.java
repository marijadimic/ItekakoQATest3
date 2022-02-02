import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;

public class TestQuestionnaire {

    public static final String CHROME_DRIVER_LOCATION = "chromedriver.exe";
    public static WebDriver driver;
    public static WebDriverWait wdWait;

    @BeforeClass
    public void testSetUp() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_LOCATION);
        driver = new ChromeDriver();
        wdWait = new WebDriverWait(driver,30);
    }

    @Test
    public void submitQuestionnaire() {
        PageQuestionnaire pageReserve = new PageQuestionnaire(driver);

        String result = "food,vg,Pizza,Sarma,Everything's fine,4,8";

        pageReserve.clickRadioExample1();
        pageReserve.clickTryOption();
        pageReserve.openSubQuestionnaire();

        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("exampleModal")));

        pageReserve.radio4Example1Click();
        pageReserve.enterMenuItemSuggestion("Pizza");
        pageReserve.submitSubQuestionare();

        pageReserve.interiorDesignSliderClick();
        pageReserve.rateStaffButton8Click();
        pageReserve.enterFeedback("Everything's fine");

        pageReserve.submitQuestionaire();

        Set<Cookie> cookies = driver.manage().getCookies();
        Assert.assertEquals(cookies.iterator().next().getValue(), result);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
