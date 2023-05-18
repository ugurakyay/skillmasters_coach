package pageObject;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreateLivePrivateWorkout {
    protected WebDriver driver;
    public CreateLivePrivateWorkout(WebDriver driver){
        this.driver = driver;
    }
    public void openPrivateWorkout() {
        //click on private workouts button
        By css = By.cssSelector("a[href='/private_workouts']");
        WebElement element = driver.findElement(css);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();" , element);
    }

    public void validate_private_workouts_page(){
        //validate header of the page
        WebElement privateworkouts = driver.findElement(By.xpath("//h1[@class='content-title' and text()='Private Workouts']"));
        Assert.assertEquals(true, privateworkouts.isDisplayed());
        System.out.println("private workouts page is displayed – Assert passed");
    }
    public void addnewPrivateWorkout() {
        //click on create new private workout button
        By css1 = By.xpath("//a[text()='CREATE NEW PRIVATE WORKOUT']");
        WebElement element = driver.findElement(css1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    public void enterPrivateWorkoutInfo() throws InterruptedException {
        Thread.sleep(3000);
        //put 5 random letters on name
        String name = RandomStringUtils.randomAlphabetic(5);
        driver.findElement(By.id("name")).sendKeys(name);

        //select live for publish type
        Select publish_type = new Select(driver.findElement(By.id("publish_type")));
        publish_type.selectByValue("LIVE");

        // put random 20 letter to description box
        String desc = RandomStringUtils.randomAlphabetic(20);
        driver.findElement(By.id("description_ifr")).sendKeys(desc);

        //click on edit players button
        By css2 = By.xpath("//a[text()='\n" +
                "                    Edit Players\n" +
                "                ']");
        WebElement element3 = driver.findElement(css2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element3);

        //select player
        Thread.sleep(3000);
        By css5 = By.xpath("//i[@id='check-2']");
        WebElement element = driver.findElement(css5);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

        //click on select players button
        By css3 = By.xpath("//*[text()='\n" +
                "            SELECT PLAYERS\n" +
                "        ']");
        WebElement element2 = driver.findElement(css3);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element2);

    }

    public void continuePrvtWrk(){
        //click on continue button
        By css1 = By.xpath("//*[text()='\n" +
                "                CONTINUE\n" +
                "            ']");
        WebElement element = driver.findElement(css1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

}
