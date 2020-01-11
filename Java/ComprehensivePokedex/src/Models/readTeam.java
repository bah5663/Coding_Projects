package Models;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class readTeam {
    
    public static ArrayList<String> ReadTeam() {
        ArrayList<String> t = null;
        try {
            try (FileInputStream fileIn = new FileInputStream("team.ser"); ObjectInputStream in = new ObjectInputStream(fileIn)) {
                t = (ArrayList<String>) in.readObject();
            }
        } catch (IOException | ClassNotFoundException i) {
            System.out.println("IO Exception or ClassNotFoundException!");
        }
        return t;
    }
}
