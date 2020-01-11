package Views;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import Models.Pokemon;
import Models.PokemonList;
import Controllers.StatUICntrl;
import Controllers.TeamUICntrl;
import Models.TeamList;
import java.io.IOException;


//This view class is responsible for showing each indiviudal Pokemon
//It displays stats and a gif of the Pokemon
public class StatUI {

    MenuUI thePokedexMenu = new MenuUI() {
    };
        
    Pokemon currentPokemon = StatUICntrl.getCurrentPokemon();
    
    //Alert if there are less than 6 Pokemon
    public static void successAlert(Pokemon currentPokemon) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Pokemon Added");
        alert.setContentText(currentPokemon.getName() + " has been added to your team!");
        alert.showAndWait();
    }
    
    //Alert if there are more than 6 Pokemon
    public static void failAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Pokemon Not Added");
        alert.setContentText("You can only have 6 Pokemon on a team!");
        alert.showAndWait();
    }

    //This method contains all the view elements
    public void start(Stage stage) throws Exception {

        //Creating Buttons
        Button menu = new Button();
        menu.setText("Menu");

        Button team = new Button();
        team.setText("View Team");

        Button add = new Button();
        add.setText("Add to Team");
        
        Button next = new Button();
        next.setText("Next");
        
        Button previous = new Button();
        previous.setText("Previous");
        
        TextArea textA = new TextArea();
        
        //Placing the buttons on the Pane
        Pane root = new Pane();
        root.setStyle("-fx-background-color: #FF6347;");	
        menu.setLayoutX(10);
        menu.setLayoutY(320);
        textA.setLayoutX(300);
        textA.setLayoutY(10);
        textA.setPrefHeight(300);
        textA.setPrefWidth(250);
        team.setLayoutX(185);
        team.setLayoutY(320);
        add.setLayoutX(75);
        add.setLayoutY(320);
        next.setLayoutX(445);
        next.setLayoutY(320);
        previous.setLayoutX(365);
        previous.setLayoutY(320);
        
        //Action Handlers
        //Redirects back to main menu
        menu.setOnAction((ActionEvent event) -> {
            Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage1.close();
            try {
                thePokedexMenu.start(stage1);
            } catch (IOException ex) {
                Logger.getLogger(StatUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        //Adds pokemon to team
        add.setOnAction((ActionEvent event) -> {
            try {
                TeamList.addPokemonTeam(PokemonList.currentIndex, TeamUICntrl.getTeamCounter());
            } catch (IOException ex) {
                Logger.getLogger(StatUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            TeamUICntrl.incrementCounter();
        });

        //Launches TeamUI (The next View)
        team.setOnAction((ActionEvent event) -> {
            Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage1.close();
            TeamUICntrl.writeTeam(TeamList.teamList);
            TeamList.setList(TeamUICntrl.readTeam());
            try {
                TeamUI.start(stage1);
            }catch (Exception ex) {
                Logger.getLogger(StatUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        //Displays the next Pokemon
         next.setOnAction((ActionEvent event) -> {
             try {
                 StatUICntrl.nextPokemon();
                 currentPokemon = StatUICntrl.getCurrentPokemon();
                 try {
                     start(stage);
                 } catch (Exception ex) {
                     Logger.getLogger(StatUI.class.getName()).log(Level.SEVERE, null, ex);
                 }
             } catch (IOException ex) {
                 Logger.getLogger(StatUI.class.getName()).log(Level.SEVERE, null, ex);
             }
        });
         
         //Displays the previous Pokemon
         previous.setOnAction((ActionEvent event) -> {
             try {
                 StatUICntrl.previousPokemon();
                 currentPokemon = StatUICntrl.getCurrentPokemon();
                 try {
                     start(stage);
                 } catch (Exception ex) {
                     Logger.getLogger(StatUI.class.getName()).log(Level.SEVERE, null, ex);
                 }
             } catch (IOException ex) {
                 Logger.getLogger(StatUI.class.getName()).log(Level.SEVERE, null, ex);
             }
        });
        
         //Getting Current pokemon from control and displaying image + data
        currentPokemon = StatUICntrl.getCurrentPokemon();
        String filename = "Images/" + currentPokemon.getName().toLowerCase() + ".gif";
        Image img = new Image(filename);
        double width = img.getWidth();
        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(width * 2);
        imgView.setPreserveRatio(true);
        imgView.setY(20);
        imgView.setX(10);

        textA.setText("Name: " + currentPokemon.getName() + "\n" + "PokedexNumber: " + currentPokemon.getDexNum() + "\n" + "Type: " + currentPokemon.getType() + "\n" + "HP: " + currentPokemon.getHp() + "\n" + "Attack: " + currentPokemon.getAttack() + "\n" + "Defense: " + currentPokemon.getDefense() + "\n" + "Special Attack: " + currentPokemon.getSpatk() + "\n" + "Special Defense: " + currentPokemon.getSpdef() + "\n" + "Speed: " + currentPokemon.getSpeed());
        textA.setEditable(false);
        textA.setDisable(false);

        //Adding the elements to the pane
        root.getChildren().add(menu);
        root.getChildren().add(textA);
        root.getChildren().add(imgView);
        root.getChildren().add(team);
        root.getChildren().add(add);
        root.getChildren().add(next);
        root.getChildren().add(previous);

        //Starting the view
        stage.setScene(new Scene(root, 590, 370));
        stage.show();
    }
}
