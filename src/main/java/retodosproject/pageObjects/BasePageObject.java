package retodosproject.pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/** This Class contains common methods that we are going to use in pages object*/
public class BasePageObject {

    protected WebDriver driver;
    protected Logger log;

    public BasePageObject(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log =log;
    }

    //open page with given URL
    public void openUrl(String url){
        driver.get(url);
        log.info("The "+url+" URL was opened");
    }

    //find element using given locator
    protected WebElement find(By locator){
        return driver.findElement(locator);
    }

    //find all elements using given locator
    protected List<WebElement> findAll(By locator){
        return driver.findElements(locator);
    }

    //Click on element with given locator when is visible
    public void click(By locator){
        waitForVisibilityOf(locator, 5);
        find(locator).click();
    }

    //Type given test into element with given locator
    public void type(String text , By locator){
        waitForVisibilityOf(locator, 5);
        find(locator).sendKeys(text);
    }

    //Wait for specific Expected condition for the given amount of time in seconds
    private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds){
        timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
        WebDriverWait wait =new WebDriverWait(driver, timeOutInSeconds);
        wait.until(condition);
    }

    //Wait for given number of seconds for element with given locator to be visible on the page
    protected void waitForVisibilityOf(By locator, Integer... timeOutInSeconds){
        int attempts = 0;
        while(attempts < 2){
            try{
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                        (timeOutInSeconds.length > 0 ? timeOutInSeconds[0]: null));
                break;
            }catch (StaleElementReferenceException e){
            }
            attempts++;
        }
    }

    //get Text
    protected String getText(By locator) {
        return find(locator).getText();
    }
}
