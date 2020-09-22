package helpers;

import driver.manager.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import waits.WaitForElement;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Methods {
    public static List<String> getBackgroundColorOfElements(List<WebElement> webElementList) {
        WaitForElement.waitUntilElementIsVisible(webElementList.get(0));
        List<String> coloursList = new ArrayList<>();
        for (WebElement element : webElementList) {
            String rgb = element.getCssValue("background-color");
            String bgc = Color.fromString(rgb).asHex();
            coloursList.add(bgc);
        }
        return coloursList;
    }

    public static List<String> getBorderBottomColorOfElements(List<WebElement> webElementList) {
        WaitForElement.waitUntilElementIsVisible(webElementList.get(0));
        List<String> coloursList = new ArrayList<>();
        for (WebElement element : webElementList) {
            String rgb = element.getCssValue("border-color");
            String bgc = Color.fromString(rgb).asHex();
            coloursList.add(bgc);
        }
        return coloursList;
    }

    public static void takeScreenShot(String className, WebElement element) {
        WaitForElement.waitUntilElementIsVisible(element);
        File srcFile = ((TakesScreenshot) DriverManager.getWebDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File("src/test/java/artifacts/" + className + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
