/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia1.chuck.norris;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.InputStream;
import java.util.Scanner;

public class IA1ChuckNorris {

    public static void main(String[] args) throws MalformedURLException, IOException {

        URL ctgurl = new URL("https://api.chucknorris.io/jokes/categories");

        try {
            HttpURLConnection conn = (HttpURLConnection) ctgurl.openConnection();
            conn.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
            conn.setRequestMethod("GET");
            conn.connect();
            JsonParser jp = new JsonParser();
            JsonArray Jarray = (JsonArray) jp.parse(new InputStreamReader((InputStream) conn.getContent()));

            ArrayList<String> categories = new Gson().fromJson(Jarray, ArrayList.class);
            //remove unwanted categories
            categories.remove(12);
            categories.remove(11);
            categories.remove(4);

            String input = "";

            while (!input.equals("quit")) {
                System.out.println("\n" + categories);
                System.out.println("Type a category for a joke of enter quit to exit:");
                Scanner in = new Scanner(System.in);
                input = in.nextLine();
                if (!input.equals("quit")) {
                    String selectedCategory = input;
                    URL specificurl = new URL("https://api.chucknorris.io/jokes/random?category=" + selectedCategory);

                    ArrayList<String> prevJokes = new ArrayList<>();

                    int stopCounter = 0;

                    try {
                        outerloop:
                        for (int i = 0; i < 3; i++) {
                            stopCounter += 1;
                            if (stopCounter > 10) {
                                break outerloop;
                            }
                            HttpURLConnection conn2 = (HttpURLConnection) specificurl.openConnection();
                            conn2.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
                            conn2.setRequestMethod("GET");
                            conn2.connect();
                            JsonObject joke = (JsonObject) jp.parse(new InputStreamReader((InputStream) conn2.getContent()));

                            if (!prevJokes.contains(joke.get("value").getAsString())) {
                                prevJokes.add(joke.get("value").getAsString());
                                System.out.println("\n" + joke.get("value").getAsString());
                            } else {
                                i = i - 1;
                            }
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
