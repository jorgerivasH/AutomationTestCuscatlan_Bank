package retodosproject.pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import retodosproject.base.TestUtilities;

public class MortgageCalculatorPageSection extends BasePageObject {

    public MortgageCalculatorPageSection(WebDriver driver, Logger log) {
        super(driver, log);
    }

    // Declare Locators in the pokedex page section
    By homePriceTxtLocator = By.cssSelector("#purchasePrice");
    By downPaymentDollarBtnLocator = By.cssSelector("#buttonAmount");
    By downPaymentPercentBtnLocator = By.cssSelector("#buttonPercent");
    By downPaymentTxtLocator = By.cssSelector("#downPayment");
    By interestRateTxtLocator = By.cssSelector("#rate");
    By zipTxtLocator = By.cssSelector("#zip");
    By includeTaxedLblLocator = By.xpath("//input[@id='includeTaxesN']");
    By calculateBtnLocator = By.cssSelector("#calculateButton");


    public void calculateMortgage(String homeprice, String downpayment, String interestrate){
        log.info("Typing home price: "+homeprice);
        find(homePriceTxtLocator).clear();
        type(homeprice,homePriceTxtLocator);
        log.info("Click on down Payment Dollar button ");
        click(downPaymentDollarBtnLocator);
        log.info("Typing"+downpayment);
        find(downPaymentTxtLocator).clear();
        type(downpayment,downPaymentTxtLocator);
        log.info("Typing "+ interestrate);
        find(interestRateTxtLocator).clear();
        type(interestrate,interestRateTxtLocator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        find(includeTaxedLblLocator).click();
        log.info("Click on The calculate button");
        click(calculateBtnLocator);
        log.info("Calculate was perform successfully");
    }

}
