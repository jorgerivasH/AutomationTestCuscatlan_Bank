package actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pageObjects.BasePageObject;
import pageObjects.PokedexPageSection;

public class SearchPokemonAbility extends BasePageObject {
    public SearchPokemonAbility(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void execute(){
        PokedexPageSection pokedexPageSection = new PokedexPageSection(driver,log);
        log.info("Finding Ability ...");
        pokedexPageSection.searchPokemonAbility("Protean");
        //Verifying the search
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(pokedexPageSection.firstPokemonAbility("Protean"));
        pokedexPageSection.listPokemon();
        log.info("Search was performed");
    }
}
