package Models;

import Views.StatUI;
import java.util.ArrayList;
import Controllers.StatUICntrl;
import java.io.IOException;

//This model class acts as the backbone for the team class
//It keeps track of the amount (> 6) or can clear a team
public class TeamList {

    public static ArrayList<String> teamList = new ArrayList<>();

    public static ArrayList<String> addPokemonTeam(int Index, int counter) throws IOException {

        Pokemon currentPokemon = StatUICntrl.getCurrentPokemon();

        if (counter < 6) {
            teamList.add(currentPokemon.getName());
            StatUI.successAlert(currentPokemon);
        } else {
            StatUI.failAlert();
        }
        return teamList;
    }
    
    public static void clearList(){
        teamList.clear();
    }

    public ArrayList<String> returnTeam() {
        return teamList;
    }
    
    public static void setList(ArrayList<String> newList){
        teamList = newList;
    }

}
