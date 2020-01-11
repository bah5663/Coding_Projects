package Models;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class writeTeam {
    
     public static void WriteTeam(ArrayList<String> theTeamList) {
        try {
            try (FileOutputStream fileOut = new FileOutputStream("team.ser"); ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(theTeamList);
            }
        } catch (IOException i) {
            System.out.println("IO Exception!");
        }
    }  
}
