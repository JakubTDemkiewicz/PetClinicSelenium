package waits;

import driver.manager.DriverManager;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class WaitForElement {
    private static WebDriverWait getWebDriverWait() {
        return new WebDriverWait(DriverManager.getWebDriver(), 10);
    }

    public static void waitUntilElementIsVisible(WebElement element) {
        WebDriverWait webDriverWait = getWebDriverWait();
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitUntilElementIsClickable(WebElement element) {
        WebDriverWait webDriverWait = getWebDriverWait();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForClickableFluentWait(WebElement element) {
        FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(DriverManager.getWebDriver());
        fluentWait.withTimeout(Duration.ofSeconds(10));
        fluentWait.pollingEvery(Duration.ofMillis(250));
        fluentWait.ignoring(ElementNotVisibleException.class)
                .ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForVisibleFluentWait(WebElement element) {
        FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(DriverManager.getWebDriver());
        fluentWait.withTimeout(Duration.ofSeconds(10));
        fluentWait.pollingEvery(Duration.ofMillis(250));
        fluentWait.ignoring(ElementNotVisibleException.class)
                .ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForAngular() {
        WebDriverWait webDriverWait = getWebDriverWait();
        webDriverWait.until(waitForAngularIoToFinishProcessing());
    }

    private static ExpectedCondition<Boolean> waitForAngularIoToFinishProcessing() {
        return driver -> {
            String result = ((JavascriptExecutor) DriverManager.getWebDriver()).executeScript(
                    "try {\n" +
                            "var angular = window.getAllAngularTestabilities();\n" + // Sprawdzamy czy Angular jest dostępny, jeśli Angular nie był by gotowy, zostanie rzucony wyjątek i kod zwróci fałsz
                            "var isStableIndex = window.getAllAngularTestabilities().findIndex(x=>x.isStable());" + // Ponieważ obiekt Teststabilies jest tablicą, szukamy w nim indeksu metody isStable()
                            "return angular[isStableIndex].isStable()" + // Pobieramy wartość z metody isStable()
                            "} catch (err){\n" +
                            "return false\n" + // Jeśli aplikacja nie jest gotowa, zostanie rzucony wyjątek, co jest równoznaczne z fałszem i brakiem gotowości / stabilności
                            "}"
            ).toString();
            return Boolean.valueOf((result));
        };
    }
}
