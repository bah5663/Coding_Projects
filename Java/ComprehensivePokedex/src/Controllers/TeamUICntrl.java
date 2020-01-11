package Controllers;

import Models.TeamList;
import Models.readTeam;
import Models.writeTeam;
import java.util.ArrayList;

public class TeamUICntrl {
    
    //This controller class keeps track of how many pokemon are on a given team
    //The following methods will either increment a spot on the team, reset the team, refresh the counter, or get the team
    static int teamCounter = 0;
    
    public static ArrayList<String> getTeamList() {
        return TeamList.teamList;
    }
    
    public static void resetList(){
        TeamList.clearList(); 
    }
    
    public static void incrementCounter(){
        teamCounter += 1;
    }

    public static int getTeamCounter() {
        return teamCounter;
    }

    public static void resetTeamCounter() {
        teamCounter = 0;
    }
    
    public static void writeTeam(ArrayList<String> theTeamList){
        writeTeam.WriteTeam(theTeamList);
    }
    
    public static ArrayList<String> readTeam(){
        return readTeam.ReadTeam();
    }   
}
