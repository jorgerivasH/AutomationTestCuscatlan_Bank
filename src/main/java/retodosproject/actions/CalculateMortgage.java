package retodosproject.actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import retodosproject.pageObjects.MortgageCalculatorPageSection;
import retodosproject.pageObjects.BasePageObject;

public class CalculateMortgage extends BasePageObject {
    public CalculateMortgage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void execute(String homeprice, String downpayment, String interestrate){
        MortgageCalculatorPageSection mortgageCalculatorPageSection = new MortgageCalculatorPageSection(driver,log);
        mortgageCalculatorPageSection.calculateMortgage(homeprice,downpayment,interestrate);
    }

}
