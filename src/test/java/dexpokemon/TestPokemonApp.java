package dexpokemon;

import actions.SearchPokemon;
import actions.SearchPokemonAbility;
import actions.SearchPokemonAttack;
import base.TestUtilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestPokemonApp extends TestUtilities {

    @Test
    @Parameters("pokemon")
    public void SearchPokemonTest(String pokemon){
        SearchPokemon searchPokemon = new SearchPokemon(driver,log);
        searchPokemon.execute(pokemon);
    }

    @Test
    @Parameters("attack")
    public void SearchPokemonAttackTest(String attack){
        SearchPokemonAttack searchPokemonAttack = new SearchPokemonAttack(driver,log);
        searchPokemonAttack.execute(attack);
    }

    @Test
    @Parameters("ability")
    public void SearchPokemonAbilityTest(String ability){
        SearchPokemonAbility searchPokemonAbility = new SearchPokemonAbility(driver,log);
        searchPokemonAbility.execute(ability);
    }
}
