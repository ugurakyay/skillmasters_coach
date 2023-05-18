package pageObject;
import library.CaptureScreenshot;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;

public class LoginPage {
    protected WebDriver driver;


    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public void navigateTo(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void validate_signIn_page(){
        //validate header of the page
        WebElement signin = driver.findElement(By.id("new_coach"));
        Assert.assertEquals(true, signin.isDisplayed());
        System.out.println("Sign In page is displayed – Assert passed");
    }

    public void logInTheForm(String user, String password) {

        driver.findElement(By.id("email")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("password")).sendKeys(Keys.RETURN);
    }
    public void validate_dashboard_page(){
        WebElement dashboard = driver.findElement(By.xpath("//h1[@class='content-title' and text()='Dashboard']"));
        Assert.assertEquals(true, dashboard.isDisplayed());
        System.out.println("dashboard page is displayed – Assert passed");
    }
}
