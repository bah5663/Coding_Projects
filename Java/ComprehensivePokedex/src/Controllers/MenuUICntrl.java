package Controllers;

import Models.PokemonList;
import Views.MenuUI;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

public class MenuUICntrl {

    //Creates the Menu UI
    MenuUI thePokedexMenu = new MenuUI() {
    };
    Stage theStage = new Stage();
    
    //Launches the Menu UI
    public void start(Stage primaryStage) throws Exception {

        thePokedexMenu.start(primaryStage);
        this.theStage = primaryStage;
    }

    public Stage returnStage() {
        return theStage;
    }
    
    //Gets a List from the Model PokemonList used in the Menu
    public static ObservableList<String> getObList() throws IOException {
        PokemonList pList = new PokemonList();
        pList.populateList();
        ObservableList<String> pData = FXCollections.observableArrayList(pList.getNames());
        return pData;
    }

    //These index Methods are used to keep track of all the buttons on the main menu
    public static void setIndex(int set) {
        PokemonList.setCurrentIndex(set);
    }

    public static int getIndex() {
        return PokemonList.getCurrentIndex();
    }

}
