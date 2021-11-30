package retodosproject.actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import retodosproject.pageObjects.MortgageCalculatorPageSection;
import retodosproject.pageObjects.BasePageObject;

public class CalculateMortgage extends BasePageObject {
    public CalculateMortgage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void execute(String homePrice, String downPayment, String interestRate, String expectedResult){
        MortgageCalculatorPageSection mortgageCalculatorPageSection = new MortgageCalculatorPageSection(driver,log);
        mortgageCalculatorPageSection.calculateMortgage(homePrice,downPayment,interestRate);
        //Verifying the monthly Payment
        Assert.assertEquals(mortgageCalculatorPageSection.getMonthlyPayment(), expectedResult,"Actual result is different");
    }
}
