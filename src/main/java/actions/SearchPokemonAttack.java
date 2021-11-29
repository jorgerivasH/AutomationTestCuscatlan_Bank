package actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pageObjects.BasePageObject;
import pageObjects.PokedexPageSection;

public class SearchPokemonAttack extends BasePageObject {
    public SearchPokemonAttack(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void execute(){
        PokedexPageSection pokedexPageSection = new PokedexPageSection(driver,log);
        log.info("Finding attack ...");
        pokedexPageSection.moveButton().click();
        pokedexPageSection.searchPokemonAttack("Absorb");
        //Verifying the attach
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(pokedexPageSection.firstPokemonAttack("Absorb"));
        Assert.assertTrue(pokedexPageSection.getPp());
        log.info("Search attack was performed");
    }
}
