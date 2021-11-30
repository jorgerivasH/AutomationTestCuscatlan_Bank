package retounoproject.pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PokedexPageSection extends BasePageObject{
    // Declare Locators in the pokedex page section
    By pokemonButtonLocator = By.xpath("//button[contains(text(),'Pokémon')]");
    By movesButtonLocator = By.xpath("//button[contains(text(),'Moves')]");
    By searchTextBoxLocator = By.xpath("//body/div[2]/div[1]/form[1]/div[1]/input[1]");
    By firstPokemonLocator = By.xpath("//body[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/a[1]/span[3]/b[1]");
    By firstAttackLocator = By.xpath("//body[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/a[1]/span[1]/b[1]");
    By firstAbilityLocator = By.xpath("//b[contains(text(),'Protean')]");
    By ppLocator = By.xpath("//body/div[2]/div[1]/div[1]/ul[1]/li[2]/a[1]/span[5]");


    public PokedexPageSection(WebDriver driver, Logger log) {
        super(driver, log);
    }

    // This method search an specific pokemon
    public void searchPokemon(String name){
        click(searchTextBoxLocator);
        type(name,searchTextBoxLocator);
    }

    // This method search an specific pokemon ability
    public void searchPokemonAbility(String ability){
        click(pokemonButtonLocator);
        type(ability,searchTextBoxLocator);
    }

    // This method gets the first pokemon in the search page
    public boolean firstPokemon(String pokemonName){
        boolean pokemon = false;
        log.info("The name found is: "+ getText(firstPokemonLocator));
        if (getText(firstPokemonLocator).contains(pokemonName))
        {
            pokemon = true;
            log.info("The pokemon was found");
        }
        else {
            log.info("No exact match found");
        }
        return pokemon;
    }

    public WebElement moveButton(){
        WebElement moveBtn = find(movesButtonLocator);
        return moveBtn;
    }

    // This method search an specific pokemon attack
    public void searchPokemonAttack(String attack){
        click(searchTextBoxLocator);
        type(attack,searchTextBoxLocator);
    }

    // This method gets the first pokemon attack in the search page
    public boolean firstPokemonAttack(String pokemonAttack){
        boolean pokemon = false;
        log.info("The name found is: "+ getText(firstAttackLocator));
        if (getText(firstAttackLocator).contains(pokemonAttack))
        {
            pokemon = true;
            log.info("The pokemon attack was found");
        }
        else {
            log.info("No exact match found");
        }
        return pokemon;
    }

    // This method search the pp for a pokemon
    public boolean getPp(){
        boolean ppStatus = false;

        if (find(ppLocator).isDisplayed())
        {
            ppStatus = true;
            log.info("The pp was found");
            log.info("The pp is"+"'"+getText(ppLocator)+"'");
        }
        else {
            log.info("No pp was found");
        }
        return ppStatus;
    }

    //This method gets the first pokemon ability
    public boolean firstPokemonAbility(String pokemonAbility){
        boolean pokemonA = false;
        log.info("The name found is: "+ getText(firstAbilityLocator));
        if (getText(firstAbilityLocator).contains(pokemonAbility))
        {
            pokemonA = true;
            log.info("The pokemon Ability was found");
        }
        else {
            log.info("No exact match found");
        }
        return pokemonA;
    }

    //This method gets the list of the pokemon shown by ability
    public void listPokemon(){
        for (int i = 4; i<=7; i++){
            String pokemonList = getText(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/ul[1]/li[" + i + "]/a[1]/span[3]"));
            log.info("The pokemon is: " + pokemonList);
        }
    }
}
