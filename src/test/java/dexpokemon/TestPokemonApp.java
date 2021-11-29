package dexpokemon;

import actions.SearchPokemon;
import actions.SearchPokemonAttack;
import base.TestUtilities;
import org.testng.annotations.Test;


public class TestPokemonApp extends TestUtilities {

    @Test
    public void SearchPokemonTest(){
        SearchPokemon searchPokemon = new SearchPokemon(driver,log);
        searchPokemon.execute();
    }

    @Test
    public void SearchPokemonAttackTest(){
        SearchPokemonAttack searchPokemonAttack = new SearchPokemonAttack(driver,log);
        searchPokemonAttack.execute();
    }


}
