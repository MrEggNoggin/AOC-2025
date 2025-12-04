// Completed 2:05:21.84 (more like 2:05:10 but i was celebrating :))
// Part 1 completed 20:16
// Completed on December 3, 2025, start at ~2:50 PM
// NOTES
// i really thought i wouldn't be able to do this but i'm happy i pulled it off!
// a drew a diagram near the end that helped me out a lot, i'm gonna do that for now on

package Days;

import Eggtils.*;

import java.util.ArrayList;

public class Day03 {

    public static void run(String filePath) {
        ArrayList<String> input = InputLoader.loadInput(filePath);
        partOne(input);
        partTwo(input);
    }

    public static void partOne(ArrayList<String> input) {
        int joltTotal = 0;

        for (String i : input) {
            joltTotal += joltFinder(i);
        }

        System.out.println(joltTotal);

    }

    public static void partTwo(ArrayList<String> input) {
        long joltTotal = 0;

        for (String i : input) {
            joltTotal += joltFinderGIGAVERSION(i);
        }

        System.out.println(joltTotal);
    }

    private static int joltFinder(String batteryBank) {
        int max = 0;

        for (int i = 0; i < batteryBank.length() - 1; i++) {
            for (int j = i + 1; j < batteryBank.length(); j++) {
                int nummedNum = Integer.parseInt(batteryBank.substring(i, i+1) + batteryBank.substring(j, j+1));
                if (nummedNum > max) {
                    max = nummedNum;
                }
            }
        }


        return max;
    }
    /*
    idea: go through each number. the highest number with 11 digits after it. repeat process with other numbers.
     */
    private static long joltFinderGIGAVERSION(String batteryBank) {
        long max = 0;
        String finalString = "";

        int[] digits = new int[12];
        int[] inverseIndex = {12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        for (int i = 0; i < 12; i++) {
            int index = -1;
            int currentMax = 0;
            for (int j = 0; j < batteryBank.length(); j++) {
                int numberAtCurrentIndex = Integer.parseInt(batteryBank.substring(j, j+1));

                if (j > batteryBank.length() - inverseIndex[i]) {
                    continue;
                }

                if (numberAtCurrentIndex > currentMax && j != index) {
                    currentMax = numberAtCurrentIndex;
                    index = j;
                }
            }
            digits[i] = currentMax;
            batteryBank = batteryBank.substring(index + 1);
        }


        for (int i = 0; i < 12; i++) {
            finalString = finalString + digits[i];
        }

        max = Long.parseLong(finalString);

        return max;
    }
}
