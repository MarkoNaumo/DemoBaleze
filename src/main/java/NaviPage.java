import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NaviPage extends BasePage{

    @FindBy(css = "li[class='nav-item active'] a[class='nav-link']")
    WebElement home;

    @FindBy(xpath = "//a[normalize-space()='Contact']")
    WebElement contact;

    @FindBy(css = "a[data-target='#videoModal']")
    WebElement aboutUs;

    @FindBy(id = "cartur")
    WebElement cart;


    public NaviPage(ChromeDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickHome()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(home)).click();
    }

    public void clickContact()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(contact)).click();
        wait.until(ExpectedConditions.visibilityOf
                (driver.findElement(By.cssSelector("div[id='exampleModal'] span[aria-hidden='true']")))).click();
    }

    public void clickAboutAs()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(aboutUs)).click();
        wait.until(ExpectedConditions.visibilityOf
                (driver.findElement(By.cssSelector("div[id='videoModal'] div[class='modal-footer'] button[type='button']")))).click();
    }

    public void clickOnCart()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(cart)).click();
    }

}
