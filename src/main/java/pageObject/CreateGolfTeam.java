package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class CreateGolfTeam {
    protected WebDriver driver;

    public CreateGolfTeam(WebDriver driver){
        this.driver = driver;
    }

    public void selectGolf(){
        //select golf in skillmap list
        Select skillMap = new Select(driver.findElement(By.name("skill_map_id")));
        skillMap.selectByValue("9");
    }
}
