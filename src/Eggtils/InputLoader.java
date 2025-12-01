package Eggtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import static java.lang.Integer.parseInt;

public class InputLoader {
    public static ArrayList<String> loadInput(String filePath) {
        filePath = "src\\Inputs\\" + filePath;
        ArrayList<String> returnStringArray = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                returnStringArray.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }

        return returnStringArray;
    }
}
