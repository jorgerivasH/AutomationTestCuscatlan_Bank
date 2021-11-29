package actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pageObjects.BasePageObject;
import pageObjects.PokedexPageSection;

public class SearchPokemon extends BasePageObject {
    public SearchPokemon(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void execute(){
        PokedexPageSection pokedexPageSection = new PokedexPageSection(driver,log);
        log.info("Finding pokemon ...");
        pokedexPageSection.searchPokemon("pikachu");
        //Verifying the search
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(pokedexPageSection.firstPokemon("Pikachu"));
        log.info("Search was performed");
    }
}
