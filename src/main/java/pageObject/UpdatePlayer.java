package pageObject;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UpdatePlayer {
    protected WebDriver driver;
    public UpdatePlayer(WebDriver driver){
        this.driver = driver;
    }
    public void openplayers() {
        //click on players button
        By css = By.cssSelector("a[href='/coach_management/players']");
        WebElement element = driver.findElement(css);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();" , element);
    }

    public void validate_players_page(){
        //validate header of the page
        WebElement players = driver.findElement(By.xpath("//h1[@class='content-title' and text()='Players']"));
        Assert.assertEquals(true, players.isDisplayed());
        System.out.println("players page is displayed – Assert passed");
    }
    public void updatePlayer() {
        //click on edit button on player
        By css = By.xpath("//i[@class='material-symbols-outlined'and text()='edit']");
        WebElement element = driver.findElement(css);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();" , element);
    }
    public void selectandunselectTeam() throws InterruptedException {
        Thread.sleep(3000);
        //select a team for player
        By css5 = By.xpath("//i[@id='check-18']");
        WebElement element = driver.findElement(css5);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

        //unselect a team for player
        By css = By.xpath("//i[@id='check-170']");
        WebElement element1 = driver.findElement(css);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);

    }

    public void updateP(){
        //click on update button
        By css1 = By.xpath("//*[text()='\n" +
                "            UPDATE\n" +
                "        ']");
        WebElement element = driver.findElement(css1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

}
