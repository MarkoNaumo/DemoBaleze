import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NaviTest extends BaseTest {
    NaviPage naviPage;
    IndexPage indexPage;
    LoginPage loginPage;


    @BeforeMethod
    public void SetUp()
    {
        driver = openBrowser();
        loginPage = new LoginPage(driver);
        naviPage = new NaviPage(driver);
        indexPage = new IndexPage(driver);
    }

    @Test
    public void LoginOnTestPage()  {

        loginPage.LoginOnPage("MarkoCode","Marko123");
        Assert.assertEquals(loginPage.getWelcome(),"Welcome MarkoCode");
    }

    @Test
    public void NavigationTest()
    {
        naviPage.clickHome();
        naviPage.clickContact();
        naviPage.clickAboutAs();
        naviPage.clickOnCart();
    }

    @Test
    public void BuyTowProduct()
    {
        loginPage.LoginOnPage("MarkoCode","Marko123");
        indexPage.addToCartSamsungS6();
        naviPage.clickHome();
        indexPage.addToCartNexus6();

    }

    @AfterMethod
    public void after()
    {
        driver.quit();
    }
}
