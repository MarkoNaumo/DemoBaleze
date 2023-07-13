import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IndexPage extends BasePage{


    @FindBy(xpath = "//a[normalize-space()='Samsung galaxy s6']")
    WebElement samsungS6;

    @FindBy(xpath = "//a[normalize-space()='Nexus 6']")
    WebElement nexus6;

    @FindBy(css = ".btn.btn-success.btn-lg")
    WebElement addToCart;

    public IndexPage(ChromeDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void addToCartSamsungS6(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(samsungS6)).click();
        wait.until(ExpectedConditions.visibilityOf(addToCart)).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }
    public void addToCartNexus6()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(nexus6)).click();
        wait.until(ExpectedConditions.visibilityOf(addToCart)).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }
}
