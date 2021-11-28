package actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.BasePageObject;
import pageObjects.PokedexPageSection;

public class SearchPokemon extends BasePageObject {
    public SearchPokemon(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void execute(){
        PokedexPageSection pokedexPageSection = new PokedexPageSection(driver,log);
        pokedexPageSection.searchPokemon("pikachu");
        Assert.assertTrue(pokedexPageSection.firstPokemon());
        log.info("Pokemon was found");

    }

}
