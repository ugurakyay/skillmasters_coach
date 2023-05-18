package pageObject;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WriteMessage {
    protected WebDriver driver;
    public WriteMessage(WebDriver driver){
        this.driver = driver;
    }

    public void gotomessageBox(){
        //click on message button on team
        By css = By.cssSelector("a[href='/coach_teams/3/messagebox']");
        WebElement element = driver.findElement(css);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();" , element);
    }

    public void validateMessages(){
        //validate header of the page
        WebElement messages = driver.findElement(By.xpath("//h3[@class='section-title' and text()='\n" +
                "            Messages\n" +
                "            ']"));
        Assert.assertEquals(true, messages.isDisplayed());
        System.out.println("messages page is displayed – Assert passed");
    }
    public void writeMessage(){
        //put 10 random letters on message box
        String strMessage = RandomStringUtils.randomAlphabetic(10);
        driver.findElement(By.id("message")).sendKeys(strMessage);
    }

    public void sendMessage(){
        //click on send button
        By css = By.cssSelector("a[href='javascript:sendMessage()']");
        WebElement element = driver.findElement(css);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();" , element);
    }
}
