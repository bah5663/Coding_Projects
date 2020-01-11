package Views;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import Models.TeamList;
import Controllers.TeamUICntrl;

public class TeamUI {
    //This view class displays the user's "team" of Pokemon
    //The user can either clear the team or go back to add more

    public static void start(Stage stage) throws Exception {
        
        //Creating the Pane and the buttons
        Pane root = new Pane();
        root.setStyle("-fx-background-color: #FF6347;");
        StatUI theStatUI = new StatUI();

        Button back = new Button();
        back.setText("Back");
        back.setLayoutX(10);
        back.setLayoutY(530);
        
        Button clear = new Button();
        clear.setText("Clear Team");
        clear.setLayoutX(150);
        clear.setLayoutY(530);
  
        //Sends users back to previous screen
        back.setOnAction((ActionEvent event) -> {
            Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage1.close();
            try {
                theStatUI.start(stage1);
            }catch (Exception ex) {
                Logger.getLogger(TeamUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
         clear.setOnAction((ActionEvent event) -> {
            Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage1.close();
            TeamUICntrl.resetList();
            TeamUICntrl.resetTeamCounter();
            TeamUICntrl.writeTeam(TeamList.teamList);
            try {
                start(stage1);
            } catch (Exception ex) {
                Logger.getLogger(TeamUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });

        //Creating 6 text fields
        TextField slot1 = new TextField();
        slot1.setLayoutX(10);
        slot1.setLayoutY(10);
        slot1.setPrefHeight(20);
        slot1.setPrefWidth(200);
        slot1.setEditable(false);
        slot1.setDisable(false);

        TextField slot2 = new TextField();
        slot2.setLayoutX(10);
        slot2.setLayoutY(100);
        slot2.setPrefHeight(20);
        slot2.setPrefWidth(200);
        slot2.setEditable(false);
        slot2.setDisable(false);

        TextField slot3 = new TextField();
        slot3.setLayoutX(10);
        slot3.setLayoutY(190);
        slot3.setPrefHeight(20);
        slot3.setPrefWidth(200);
        slot3.setEditable(false);
        slot3.setDisable(false);

        TextField slot4 = new TextField();
        slot4.setLayoutX(10);
        slot4.setLayoutY(280);
        slot4.setPrefHeight(20);
        slot4.setPrefWidth(200);
        slot4.setEditable(false);
        slot4.setDisable(false);

        TextField slot5 = new TextField();
        slot5.setLayoutX(10);
        slot5.setLayoutY(370);
        slot5.setPrefHeight(20);
        slot5.setPrefWidth(200);
        slot5.setEditable(false);
        slot5.setDisable(false);

        TextField slot6 = new TextField();
        slot6.setLayoutX(10);
        slot6.setLayoutY(460);
        slot6.setPrefHeight(20);
        slot6.setPrefWidth(200);
        slot6.setEditable(false);
        slot6.setDisable(false);
        

        //Logic to display only images present in the list to avoid errors
        for (int i = 0; i < TeamUICntrl.readTeam().size(); i++) {
            String name = TeamUICntrl.readTeam().get(i);
            if (i == 0) {
                slot1.setText(name);
                String filename = "Images/" + name.toLowerCase() + ".gif";
                Image img1 = new Image(filename);
                ImageView imgView1 = new ImageView(img1);
                imgView1.setFitHeight(80);
                imgView1.setFitWidth(80);
                imgView1.setLayoutX(220);
                imgView1.setLayoutY(-5);
                root.getChildren().add(imgView1);
            } else if (i == 1) {
                slot2.setText(name);
                String filename = "Images/" + name.toLowerCase() + ".gif";
                Image img2 = new Image(filename);
                ImageView imgView2 = new ImageView(img2);
                imgView2.setFitHeight(80);
                imgView2.setFitWidth(80);
                imgView2.setLayoutX(220);
                imgView2.setLayoutY(85);
                root.getChildren().add(imgView2);
            } else if (i == 2) {
                slot3.setText(name);
                String filename = "Images/" + name.toLowerCase() + ".gif";
                Image img3 = new Image(filename);
                ImageView imgView3 = new ImageView(img3);
                imgView3.setFitHeight(80);
                imgView3.setFitWidth(80);
                imgView3.setLayoutX(220);
                imgView3.setLayoutY(175);
                root.getChildren().add(imgView3);
            } else if (i == 3) {
                slot4.setText(name);
                String filename = "Images/" + name.toLowerCase() + ".gif";
                Image img4 = new Image(filename);
                ImageView imgView4 = new ImageView(img4);
                imgView4.setFitHeight(80);
                imgView4.setFitWidth(80);
                imgView4.setLayoutX(220);
                imgView4.setLayoutY(265);
                root.getChildren().add(imgView4);
            } else if (i == 4) {
                slot5.setText(name);
                String filename = "Images/" + name.toLowerCase() + ".gif";
                Image img5 = new Image(filename);
                ImageView imgView5 = new ImageView(img5);
                imgView5.setFitHeight(80);
                imgView5.setFitWidth(80);
                imgView5.setLayoutX(220);
                imgView5.setLayoutY(355);
                root.getChildren().add(imgView5);
            } else if (i == 5) {
                slot6.setText(name);
                String filename = "Images/" + name.toLowerCase() + ".gif";
                Image img6 = new Image(filename);
                ImageView imgView6 = new ImageView(img6);
                imgView6.setFitHeight(80);
                imgView6.setFitWidth(80);
                imgView6.setLayoutX(220);
                imgView6.setLayoutY(445);
                root.getChildren().add(imgView6);
            }
        }

        //adding the view elements to the pane
        root.getChildren().add(back);
        root.getChildren().add(clear);
        root.getChildren().add(slot1);
        root.getChildren().add(slot2);
        root.getChildren().add(slot3);
        root.getChildren().add(slot4);
        root.getChildren().add(slot5);
        root.getChildren().add(slot6);

        stage.setScene(new Scene(root, 350, 570));
        stage.show();
    }

}
