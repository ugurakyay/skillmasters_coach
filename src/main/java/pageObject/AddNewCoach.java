package pageObject;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddNewCoach {
    protected WebDriver driver;

    public AddNewCoach(WebDriver driver){
        this.driver = driver;
    }

    public void open_team_Detail(){
        By css = By.xpath("//*[@id=\"datatable\"]/tbody/tr[1]/td[5]/div/a[3]"); //By.cssSelector("a[href='/coach_teams/3/detail']"); //#datatable > tbody > tr:nth-child(1) > td:nth-child(5) > div > a:nth-child(3)
        WebElement element = driver.findElement(css);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();" , element);
    }
    public void addnewCoachtoClub() {
        By css = By.xpath("//a[text()='ADD A COACH FOR CLUB']");
        WebElement element = driver.findElement(css);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();" , element);
    }
    public void entercoachInfo() throws InterruptedException {
        Thread.sleep(3000);
        String name = RandomStringUtils.randomAlphabetic(8);
        String lastname = RandomStringUtils.randomAlphabetic(5);
        String email = RandomStringUtils.randomAlphabetic(6);
        driver.findElement(By.id("name")).sendKeys(name); // put random 8 letters for name
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys(lastname); // put random 5 letters for lastname
        driver.findElement(By.id("email")).sendKeys(email+"@abc.com"); // put random 6 letters and @abc.com for email
        Select coachType = new Select(driver.findElement(By.name("coach_type")));
        coachType.selectByValue("club_coach");
        Select skillMap = new Select(driver.findElement(By.name("skill_map_id")));
        skillMap.selectByValue("6"); // select soccer

    }
    public void addcoach(){
        // click on add button
        By css = By.xpath("//*[text()='\n" +
                "            ADD\n" +
                "        ']");
        WebElement element3 = driver.findElement(css);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element3);
    }

}

