package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import library.BaseSteps;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class Hooks extends BaseSteps {

    private BaseSteps base;

    public Hooks(BaseSteps base) {
        this.base = base;
    }

    @Before()
    public void initializeTest() throws MalformedURLException {
        switch (config.getPlatform()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                base.driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                base.driver = new FirefoxDriver();
                break;
        }

    }

   @After
    public void after(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            File scrFile = ((TakesScreenshot)base.driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("target/Distributor.jpg"));
        }

        for (String winHandle : base.driver.getWindowHandles()) {
            try {
                base.driver.switchTo().window(winHandle);
                base.driver.close();
                base.driver.quit();
            } catch (Exception e) {
            }
        }
    }

}
