package pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class PokedexPageSection extends BasePageObject{
    By searchButtonLocator = By.xpath("//button[contains(text(),'Search')]");
    By pokemonButtonLocator = By.xpath("//button[contains(text(),'Pokémon')]");
    By movesButtonLocator = By.xpath("//button[contains(text(),'Moves')]");
    By searchTextBoxLocator = By.xpath("//body/div[2]/div[1]/form[1]/div[1]/input[1]");
    By firstPokemonLocator = By.xpath("//body[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/a[1]/span[3]/b[1]");
    By firstAttackLocator = By.xpath("//body[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/a[1]/span[1]/b[1]");
    By ppLocator = By.xpath("//body/div[2]/div[1]/div[1]/ul[1]/li[2]/a[1]/span[5]");


    public PokedexPageSection(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void searchPokemon(String name){
        click(searchTextBoxLocator);
        type(name,searchTextBoxLocator);
    }

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

    public void searchPokemonAttack(String name){
        click(searchTextBoxLocator);
        type(name,searchTextBoxLocator);
    }

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
}
