// NOTES
// i needed a hint from chatgpt to help me with part 1 at around 7:09 minutes, the question really confused me
// took a break at 18:28 minutes 22:14.63 + 4:13 (<--- keeping track of time)

package Days;

import Eggtils.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Day07 {

    public static void run(String filePath) {
        ArrayList<String> input = InputLoader.loadInput(filePath);
        partOne(input);
        partTwo(input);
    }

    public static void partOne(ArrayList<String> input) {
        record point(int row, int col) {}
        ArrayList<point> beams =  new ArrayList<>();
        ArrayList<point> tempBeams = new ArrayList<>();
        beams.add(new point(0, input.getFirst().indexOf('S')));
        int splitCounter = 0;

        for (String line : input) {
            for (int i = 0; i < beams.size(); i++) {
                if (line.charAt(beams.get(i).row + 1) == '.') {
                    beams.set(i, new point(beams.get(i).row + 1, beams.get(i).col));
                } else if (line.charAt(beams.get(i).row +1) == '^') {
                    beams.set(i, new point(beams.get(i).row + 1, beams.get(i).col + 1));
                    tempBeams.add(i, new point(beams.get(i).row + 1, beams.get(i).col - 1));
                }
            }
        }
    }

    public static void partTwo(ArrayList<String> input) {

    }

    public static void removeDupes(ArrayList<point> points) {
        ArrayList<Integer> indexesToRemove = new ArrayList<>();

        for (int i = 0; i < points.size()) {}
    }
}
