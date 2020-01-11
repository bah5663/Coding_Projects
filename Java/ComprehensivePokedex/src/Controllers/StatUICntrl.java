package Controllers;

import Models.Pokemon;
import Models.PokemonList;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StatUICntrl {
    
    MenuUICntrl Menu = new MenuUICntrl();
    
    //Gets the current index to display corresponding Pokemon
    public static Pokemon getCurrentPokemon() {
        PokemonList pokemonList = new PokemonList(); //Total available pokemon
        try {
            pokemonList.populateList();
        } catch (IOException ex) {
            Logger.getLogger(StatUICntrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Pokemon currentPokemon = pokemonList.getCurrentPokemon(MenuUICntrl.getIndex());
        return currentPokemon;
    }
    
    
    //The following two methods will navigate either up or down pokemonList
    public static void nextPokemon() throws IOException{
        PokemonList pList = new PokemonList();
        pList.populateList();
        if (MenuUICntrl.getIndex()<=149){
            MenuUICntrl.setIndex(MenuUICntrl.getIndex()+1);
        }
    }
    
    public static void previousPokemon() throws IOException{
        PokemonList pList = new PokemonList();
        pList.populateList();
        if (MenuUICntrl.getIndex()>=1) {
            MenuUICntrl.setIndex(MenuUICntrl.getIndex()-1);
        }
    }
}
