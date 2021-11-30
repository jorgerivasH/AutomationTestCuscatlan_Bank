package retounoproject.actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import retounoproject.pageObjects.BasePageObject;
import retounoproject.pageObjects.PokedexPageSection;

/**
 * This class implements the Search pokemon action
 */
public class SearchPokemon extends BasePageObject {
    public SearchPokemon(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void execute(String pokemon){
        PokedexPageSection pokedexPageSection = new PokedexPageSection(driver,log);
        log.info("Finding pokemon ...");
        pokedexPageSection.searchPokemon(pokemon);
        //Verifying the search
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(pokedexPageSection.firstPokemon(pokemon));
        log.info("Search was performed");
    }
}
