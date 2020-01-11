package Views;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import Controllers.MenuUICntrl;
import java.io.IOException;

//source: https://stackoverflow.com/questions/22884312/javafx-listview-bind-button-to-the-index-of-the-cell
public abstract class MenuUI {

    //The next view that is called in the action handler
    static StatUI statUI = new StatUI();
    //View list that is set to a model list
    ListView<String> list = new ListView<>();

    //This View sets up a list of buttons based on the the Pokemon data we have in Pokemon List
    public void start(Stage stage) throws IOException{
        VBox box = new VBox();
        Scene scene = new Scene(box, 400, 400);
        stage.setScene(scene);
        box.getChildren().addAll(list);
        VBox.setVgrow(list, Priority.ALWAYS);

        list.setItems(MenuUICntrl.getObList());
        list.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> list) {
                return new ButtonCell();
            }
        });
        stage.setTitle("The Comprehensive Pokedex");
        stage.show();
    }

    //This is the button handler that opens StatUI with the correct index
    static class ButtonCell extends ListCell<String> {

        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            super.setStyle("-fx-background-color: #FF6347;");
            if (item != null) {
                final Button btn = new Button(getIndex() + 1 + ". " + item);
                btn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        MenuUICntrl.setIndex(getIndex());
                        try {
                            //This is where Stat UI is opened with the correct button Index
                            statUI.start(stage);
                        } catch (Exception ex) {
                            Logger.getLogger(MenuUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                setGraphic(btn);
            } else {
                setGraphic(null);
            }
        }
    }
}
