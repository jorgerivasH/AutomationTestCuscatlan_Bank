package retodosMortgageCalculator;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import retodosproject.actions.CalculateMortgage;
import retounoproject.base.TestUtilities;

public class MortgageTest extends TestUtilities {

    @Test
    @Parameters({"homePrice","downPayment","interestRate","expectedResult"})
    public void calculateMortgageTest(String homePrice, String downPayment, String interestRate, String expectedResult){
        CalculateMortgage calculateMortgage = new CalculateMortgage(driver,log);
        calculateMortgage.execute(homePrice,downPayment,interestRate,expectedResult);
    }
}
