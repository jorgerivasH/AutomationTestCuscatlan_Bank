package actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pageObjects.BasePageObject;

public class SearchPokemon extends BasePageObject {
    public SearchPokemon(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void execute(){
        driver.get("https://dex.pokemonshowdown.com/");
        log.info("Starting the test");
    }

}
