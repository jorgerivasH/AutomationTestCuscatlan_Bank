package dexpokemon;

import actions.SearchPokemon;
import base.BaseTest;
import base.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestPokemonApp extends TestUtilities {

    @Test
    public void newTest(){
        SearchPokemon searchPokemon = new SearchPokemon(driver,log);
        searchPokemon.execute();
    }

    @Test
    public void SearchPokemonTest(){
        SearchPokemon searchPokemon = new SearchPokemon(driver,log);
        searchPokemon.execute();
        sleep(5000);
        log.info("Pokemon was found");
    }


}
