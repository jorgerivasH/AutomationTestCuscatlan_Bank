package retodosMortgageCalculator;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import retodosproject.actions.CalculateMortgage;
import retounoproject.actions.SearchPokemon;
import retounoproject.base.TestUtilities;

public class MortgageTest extends TestUtilities {

    @Test
    public void calculateMortgageTest(){
        CalculateMortgage calculateMortgage = new CalculateMortgage(driver,log);
        calculateMortgage.execute("250000","45000","4");
    }
}
