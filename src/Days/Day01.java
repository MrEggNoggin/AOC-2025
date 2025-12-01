// Completed 37:41.42 (more like 37:30 - 37:40 because i was celebrating lol)
// Part 1 Completed in ~32 Minutes
// Completed on December 1, 2025, starting at 3:58 PM
// NOTES
// i got the part 2 solution right before i got the part 1 solution right ;-;
// im happy i was able to fit everything inside of dialer and not a new function
// im gonna clean this up more so that the parts are separate (<-- did that) but im happy with my completion time!

package Days;

import Eggtils.*;
import java.util.ArrayList;

public class Day01 {

    public static void run(String filePath) {
        ArrayList<String> input = InputLoader.loadInput(filePath);
        partOne(input);
        partTwo(input);
    }

    public static void partOne(ArrayList<String> input) {
        int dial = 50;
        int zeroCount = 0;

        for (int i = 0; i < input.size(); i++) {
            int rotations = Integer.parseInt(input.get(i).substring(1));
            boolean direction = input.get(i).substring(0, 1).contains("R");
            int[] output = dialer(direction, rotations, dial, false);
            dial = output[0];
            zeroCount += output[1];
        }

        System.out.println(zeroCount);
    }

    public static void partTwo(ArrayList<String> input) {
        int dial = 50;
        int zeroCount = 0;

        for (int i = 0; i < input.size(); i++) {
            int rotations = Integer.parseInt(input.get(i).substring(1));
            boolean direction = input.get(i).substring(0, 1).contains("R");
            int[] output = dialer(direction, rotations, dial, true);
            dial = output[0];
            zeroCount += output[1];
        }

        System.out.println(zeroCount);
    }

    private static int[] dialer(boolean direction, int rotations, int dial, boolean modified) {
        // left = false, right = true
        // dial = [0], zeroCount = [1]
        int newDial = dial;
        int zeroCount = 0;
        for (int i = 0; i < rotations; i++) {
            if (direction) {
                newDial++;
            } else {
                newDial--;
            }

            if (newDial == 100) {
                newDial = 0;
            } else if (newDial == -1) {
                newDial = 99;
            }

            if (modified && newDial == 0) {
                zeroCount++;
            }
        }
        if (newDial == 0 && !modified) {
            zeroCount += 1;
        }
        return new int[]{newDial, zeroCount};
    }


}
