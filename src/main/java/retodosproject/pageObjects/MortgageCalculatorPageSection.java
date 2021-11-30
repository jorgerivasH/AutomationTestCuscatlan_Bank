package retodosproject.pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;

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
    By includeTaxedLblLocator = By.xpath("#includeTaxesNLabel");
    By monthlyPaymentLocator = By.xpath("//body/main[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/p[2]");


    public void calculateMortgage(String homeprice, String downpayment, String interestrate) {
        log.info("Typing home price: " + homeprice);
        click(By.cssSelector("body > div.campaignBanner > div > button.close"));
        find(homePriceTxtLocator).clear();
        type(homeprice, homePriceTxtLocator);
        log.info("Click on down Payment Dollar button ");
        click(downPaymentDollarBtnLocator);
        log.info("Typing" + downpayment);
        find(downPaymentTxtLocator).clear();
        type(downpayment, downPaymentTxtLocator);
        log.info("Typing " + interestrate);
        find(interestRateTxtLocator).clear();
        type(interestrate, interestRateTxtLocator);
        log.info("Click on The calculate button");

        WebElement webElement = find(By.cssSelector("#insurance"));
        webElement.sendKeys(Keys.TAB);
        webElement.sendKeys(Keys.ENTER);
        log.info("Calculate was perform successfully");
        log.info(getText(monthlyPaymentLocator));
    }

    public String getMonthlyPayment(){
        String monthlyPayment = getText(monthlyPaymentLocator);
        return monthlyPayment;
    }


}
