package pageObject;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CreateSoccerTeam {
    protected WebDriver driver;
    public WebDriverWait wait;
    public CreateSoccerTeam(WebDriver driver){
        this.driver = driver;
    }

    public void manageTeams() {
        //click on manage teams button
        By css = By.cssSelector("a[href='/coach_teams']");
        WebElement element = driver.findElement(css);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();" , element);
    }
    public void validate_teams_page(){
        //validate header of the page
        WebElement teams = driver.findElement(By.xpath("//h1[@class='content-title' and text()='Teams']"));
        Assert.assertEquals(true, teams.isDisplayed());
        System.out.println("teams page is displayed – Assert passed");
    }

    public void addnewTeam() {
        //click on add new team button
        By css1 = By.xpath("//a[text()='ADD NEW TEAM']");
        WebElement element = driver.findElement(css1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    public void enterteamInfo() throws InterruptedException {
        Thread.sleep(3000);
        //put 5 random letters on  team name
        String team = RandomStringUtils.randomAlphabetic(5);
        driver.findElement(By.id("team_name")).sendKeys(team);

    }
    public void createteam(){
        //click on create button
        By css = By.xpath("//*[text()='\n" +
                "                CREATE\n" +
                "            ']");
        WebElement element = driver.findElement(css);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();" , element);

        //validate teams page
        WebElement teams = driver.findElement(By.xpath("//h1[@class='content-title' and text()='Teams']"));
        Assert.assertEquals(true, teams.isDisplayed());
        System.out.println("team is added – Assert passed");
    }
}