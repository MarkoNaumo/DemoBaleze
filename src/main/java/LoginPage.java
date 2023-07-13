import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{

    @FindBy(id = "login2")
    WebElement login;

    @FindBy(id = "loginusername")
    WebElement loginUsername;

    @FindBy(id = "loginpassword")
    WebElement pass;

    @FindBy(css = "button[onclick='logIn()']")
    WebElement buttonLogin;

    @FindBy(id = "nameofuser")
    WebElement welcome;

    public LoginPage(ChromeDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void LoginOnPage(String user,String password)
    {
        login.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(loginUsername)).sendKeys(user);
        wait.until(ExpectedConditions.visibilityOf(pass)).sendKeys(password);
        buttonLogin.click();
    }

    public String getWelcome()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(welcome)).getText();

    }
}
