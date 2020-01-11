package Models;
//SLIGHT REWORK

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PokemonList {

    ArrayList<Pokemon> pokemonList = new ArrayList<>();

    public static int currentIndex = 0;

    public ArrayList<String> getNames() {
        ArrayList<String> names = new ArrayList<>();
        for (int x = 0; x < pokemonList.size(); x++) {
            Pokemon currentPokemon = pokemonList.get(x);
            names.add(currentPokemon.getName());
        }
        return names;
    }

    public int getSize() {
        return pokemonList.size();
    }

    public Pokemon getCurrentPokemon(int index) {
        return pokemonList.get(index);
    }

    public static int getCurrentIndex() {
        return currentIndex;
    }

    public static void setCurrentIndex(int index) {
        currentIndex = index;
    }

    public void populateList() throws FileNotFoundException, IOException {

        //reads data from a file in the source folder
        try (BufferedReader br = new BufferedReader(new FileReader("PokemonDatabank.csv"))) {
            for (String line; (line = br.readLine()) != null;) {
                line.replaceAll(" ", "");
                String[] linesplit = line.split(";");
                String name = linesplit[1];
                String dexnum = linesplit[0];
                String type = linesplit[8];
                String hp = linesplit[2];
                String atk = linesplit[3];
                String def = linesplit[4];
                String spdef = linesplit[6];
                String spatk = linesplit[5];
                String speed = linesplit[7];

                Pokemon newPokemon = new Pokemon(name, dexnum, type, hp, atk, def, spdef, spatk, speed);
                pokemonList.add(newPokemon);
            }
        }
    }
}
