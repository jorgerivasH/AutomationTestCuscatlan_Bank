package pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PokedexPageSection extends BasePageObject{
    By searchButtonLocator = By.xpath("//button[contains(text(),'Search')]");
    By pokemonButtonLocator = By.xpath("//button[contains(text(),'Pokémon')]");
    By movesButtonLocator = By.xpath("//button[contains(text(),'Moves')]");
    By searchTextBoxLocator = By.xpath("//body/div[2]/div[1]/form[1]/div[1]/input[1]");
    By firstElementLocator = By.xpath("//body[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/a[1]/span[3]/b[1]");


    public PokedexPageSection(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void searchPokemon(String name){
        click(searchTextBoxLocator);
        type(name,searchTextBoxLocator);
    }

    public boolean firstPokemon(){
        boolean pokemon = false;
        find(firstElementLocator).click();
        pokemon = true;
        return pokemon;
    }





}
