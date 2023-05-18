package library;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class CaptureScreenshot {

    static String filename = null;

    public static void takeScreenshot(WebDriver driver, String name) throws IOException {

        try {
            Calendar cl = Calendar.getInstance();
            System.out.println(cl.getTime());
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            filename = "./ScreenShots/" + name + "_  " + cl.getTime().toString().replace(":", "").replace(" ", "") + ".png";
            File f = screenshot.getScreenshotAs(OutputType.FILE);
            File fd = new File("./ScreenShots/" + name + "_  " + cl.getTime().toString().replace(":", "").replace(" ", "") + ".png");
            FileUtils.copyFile(f, fd);
        } catch (Exception e) {
            System.out.println("Not Able to take ScreenShot");


        }

       /* public static void AttachedScreenShotToReport() throws IOException {

            try {
                System.setProperty("org.uncımmmıns.reporting.escape-output","false");
                File f =new File(filename);
                //Reporter.log(
                     //   "<a title =\"snapshot\" href=\""+f.getAbsolutePath()+"\">" +
                       //         "<img width=\"418\"height=\"240\"alt=\"altaernativeName\" title=\"title\"src=\"../surefire-reports/html/screenshots/"+filename>);

            }
            catch (Exception e){
                System.out.println("Not Able to take ScreenShot");
            }

        */


    }
}

