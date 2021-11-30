package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pageObjects.BasePageObject;

import java.lang.reflect.Method;

import static java.lang.Thread.sleep;

public class BaseTest {
    protected WebDriver driver;
    protected Logger log;
    protected  String testSuiteName;
    protected  String testName;
    protected  String testMethodName;

    @Parameters({ "browser","url" })
    @BeforeMethod(alwaysRun = true)
    public void setupApplication(Method method, @Optional("chrome") String browser, ITestContext ctx, String url){
        String testName = ctx.getCurrentXmlTest().getName();
        log = LogManager.getLogger(testName);
        //Here the browser is passed to BrowserDriverFactor class
        BrowserDriverFactory factory = new BrowserDriverFactory("chrome");
        //Create driver
        driver = factory.createDriver();
        driver.manage().window().maximize();
        BasePageObject base=new BasePageObject(driver,log);
        base.openUrl(url);

        //This information will be used to set more information in the log message
        this.testSuiteName = ctx.getSuite().getName();
        this.testName = testName;
        this.testMethodName = method.getName();
    }

    @AfterMethod
    public void closeApplication() throws InterruptedException {
        sleep(5000);
        log.info("close driver");
        driver.quit();
    }
}
