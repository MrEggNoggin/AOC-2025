// Completed 1:12:53 (more like 1:12:50)
// Part 1 Completed 52:37
// Completed on December 4, 2025, starting at ~2:50 PM
// NOTES
// i felt pretty solid on this one, i think im getting a little better!
// also x/y and row/col confuse me, i gotta work on that

package Days;

import Eggtils.*;
import java.util.ArrayList;

public class Day04 {

    public static void run(String filePath) {
        ArrayList<String> input = InputLoader.loadInput(filePath);
       partOne(input);
        partTwo(input);
    }

    public static void partOne(ArrayList<String> input) {
        int total = 0;
        for (int row = 0; row < input.size(); row++) {
            for (int col = 0; col < input.getFirst().length(); col++) {
                if (input.get(row).charAt(col) == '@') {
                    if (checkAround(input, row, col)) {
                        total++;
                    }
                }
            }
        }
        System.out.println(total);
    }

    public static void partTwo(ArrayList<String> input) {
        record point(int x, int y) {}
        int total = 0;

        for (int i = 0; i < 60; i++) {
            ArrayList<point> toReplace = new ArrayList<>();
            for (int row = 0; row < input.size(); row++) {
                for (int col = 0; col < input.getFirst().length(); col++) {
                    if (input.get(row).charAt(col) == '@') {
                        if (checkAround(input, row, col)) {
                            toReplace.add(new point(col, row));
                            total++;
                        }
                    }
                }
            }
            for (point coords : toReplace) {
                input.set(coords.y, input.get(coords.y).substring(0, coords.x) + "." + input.get(coords.y).substring(coords.x + 1));
            }
        }
        System.out.println(total);
    }

    private static boolean checkAround(ArrayList<String> input, int row, int col) {
        int total = 0;

        for (int curRow = -1; curRow < 2; curRow++) {
            if (row + curRow < 0 || row + curRow > input.size() -1 ) {
                continue;
            }
            for (int curCol = -1; curCol < 2; curCol++) {
                if (row - curRow == row && col - curCol == col) {
                    continue;
                }

                if (col + curCol < 0 || col + curCol > input.getFirst().length() -1 ) {
                    continue;
                }

                if (input.get(row + curRow).charAt(col + curCol) == '@') {
                    total++;
                }
            }
        }

        if (total < 4) {
            return true;
        }
        return false;
    }
}
