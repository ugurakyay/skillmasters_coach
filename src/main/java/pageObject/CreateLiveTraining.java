package pageObject;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreateLiveTraining {
    protected WebDriver driver;
    public CreateLiveTraining(WebDriver driver){
        this.driver = driver;
    }
    public void viewTrainingPlans() {
        //click on training plans button
        By css = By.cssSelector("a[href='/training_plans']");
        WebElement element = driver.findElement(css);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();" , element);
    }

    public void validate_trainings_page(){
        //validate header of the page
        WebElement training = driver.findElement(By.xpath("//h1[@class='content-title' and text()='Training Plans']"));
        Assert.assertEquals(true, training.isDisplayed());
        System.out.println("trainings page is displayed – Assert passed");
    }
    public void addnewTraining() {
        //click on add new training button
        By css1 = By.xpath("//a[text()='ADD NEW TRAINING']");
        WebElement element = driver.findElement(css1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    public void entertrainingInfo() throws InterruptedException {
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

        //click on add teams button
        By css2 = By.xpath("//a[text()='\n" +
                "                    Add Teams\n" +
                "                ']");
        WebElement element3 = driver.findElement(css2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element3);

        //select team
        Thread.sleep(5000);
        By css5 = By.xpath("//i[@id='check-172']");
        WebElement element = driver.findElement(css5);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

        //click on select teams button
        By css3 = By.xpath("//*[text()='\n" +
                "            SELECT TEAMS\n" +
                "        ']");
        WebElement element2 = driver.findElement(css3);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element2);
    }

}
