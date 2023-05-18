package library;

import org.openqa.selenium.WebDriver;

public class Compare {
    public static boolean ValidateTextOnPage(WebDriver driver, String expURL){

        boolean result = false;
        if(driver.getCurrentUrl().equalsIgnoreCase(expURL)){
            result = true;

        }
        return result;
    }


}
