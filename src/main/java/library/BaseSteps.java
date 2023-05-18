package library;

import org.openqa.selenium.WebDriver;

public class BaseSteps {

    protected Config config;
    public WebDriver driver;

    public BaseSteps() { config = Config.getInstance(); }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception var3) {

        }

    }

}
