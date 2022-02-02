import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageQuestionnaire {
    private static final String URL = "http://10.15.1.204:3000/questionaire";
    protected WebDriver driver;

    public PageQuestionnaire(WebDriver driver) {
        this.driver = driver;
        this.driver.get(URL);

        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "radioExample1")
    private WebElement radioExample1;

    @FindBy(xpath = "//button[contains(text(), 'Did you Like the Food?')]")
    private WebElement subQuestionnaireButton;

    @FindBy(id = "radio4Example1")
    private WebElement radio4Example1;

    @FindBy(id = "hwofTA")
    private WebElement menuItemSuggestion;

    @FindBy(css = "#exampleModal > div > div > div.modal-footer > button")
    private WebElement subQuestionnaireSubmit;

    @FindBy(xpath = "//button[contains(text(), '8')]")
    private WebElement rateStaffButton8;

    @FindBy(id = "submitQuestionaire")
    private WebElement submitQuestionnaire;

    public void clickRadioExample1() {
        radioExample1.click();
    }

    public void openSubQuestionnaire() {
        subQuestionnaireButton.click();
    }

    public void radio4Example1Click() {
        radio4Example1.click();
    }

    public void enterMenuItemSuggestion(String val) {
        menuItemSuggestion.sendKeys(val);
    }

    public void submitSubQuestionare() {
        subQuestionnaireSubmit.click();
    }

    public void clickTryOption() {
        driver.switchTo().frame("first");
        driver.findElement(By.id("cb1")).click();
        driver.switchTo().defaultContent();
    }

    public void interiorDesignSliderClick() {
        driver.switchTo().frame("third");
        driver.findElement(By.id("rng")).click();
        driver.findElement(By.id("rng")).sendKeys(Keys.RIGHT);
        driver.switchTo().defaultContent();
    }

    public void rateStaffButton8Click() {
        rateStaffButton8.click();
    }

    public void enterFeedback(String feedback) {
        driver.switchTo().frame("second");
        driver.findElement(By.id("frta")).sendKeys(feedback);
        driver.switchTo().defaultContent();
    }

    public void submitQuestionaire() {
        submitQuestionnaire.click();
    }
}
