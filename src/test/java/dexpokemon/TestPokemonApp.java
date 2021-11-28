package dexpokemon;

import actions.SearchPokemon;
import base.BaseTest;
import org.testng.annotations.Test;


public class TestPokemonApp extends BaseTest {

    @Test
    public void newTest(){
        SearchPokemon searchPokemon = new SearchPokemon(driver,log);
        searchPokemon.execute();
    }
}
