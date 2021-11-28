package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserDriverFactory {
    //driver variables will be available in any class
    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private String browser;

    //constructor
    public BrowserDriverFactory(String browser) {
        this.browser = browser.toLowerCase();
    }

    //Set the driver
    //This method sets the driver
    public WebDriver createDriver() {
        //Create browser
        //set Chrome Driver
        if ("chrome".equals(browser)) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            driver.set(new ChromeDriver());
        } else if ("firefox".equals(browser)) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
            driver.set(new FirefoxDriver());
        } else {
            System.out.println("Do not know how to start:" + browser + ", starting Chrome.");
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            driver.set(new ChromeDriver());
        }
        return driver.get();
    }
}
