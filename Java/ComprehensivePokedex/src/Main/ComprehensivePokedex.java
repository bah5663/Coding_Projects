package Main;

import javafx.application.Application;
import javafx.stage.Stage;
import Controllers.MenuUICntrl;

/*
 Group 7
 Benjamin Herr, Jacob Galushka, Stephen Giacobe, Joe Loembardi
 Project Deliverable 2

 What the App Should do/Criteria
1. Upon Launch the user should see a red menu wuth a list of buttons of 151 different Pokemon
2. From this screen, the user can choose any Pokemon they would like.
3. A new window should pop up displaying a GIF of that Pokemon and the stats of the Pokemon.
4. Clicking the Menu button will take the user back to the previous screen.
5. The user can also cycle between the Pokemon by using the next and previous buttons below the stats.
6. Clicking the "add to team" button will add the pokemon to the team and display a confirmation button
7. There can only be 6 pokemon on a team at once, so if the user tries to add more they will get an error message.
8. To view the team you have created, click the view team button.
9. A new view should open up displaying the Pokemon that the user selected. 
10. If the user goes back, the team is written to a file and will automatically save until the user exits the app.
11. To reset your team click clear when you are viewing your team.

** There is a design diagram named ComprehensivePokedexDesign.png located in the source directory.
 */

// Gifs for Pokemon: http://www.pokestadium.com/tools/sprites
public class ComprehensivePokedex extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Starts the MainMenuController that opens the MenuUI.java View
        MenuUICntrl menuController = new MenuUICntrl();
        menuController.start(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
