// didnt complete part 2 of this, i will come back to it
// Part 1 Complete: 33:52, December 6, 2025, current time: 50:48.38

package Days;

import Eggtils.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Day05 {

    public static void run(String filePath) {
        // TODO: make this one input file
        ArrayList<String> input01 = InputLoader.loadInput(filePath);
        ArrayList<String> input02 = InputLoader.loadInput("input05-02.txt");
        //partOne(input01, input02);
        partTwo(input01, input02);
    }

    public static void partOne(ArrayList<String> input01, ArrayList<String> input02) {
        long freshCount = 0;
        record range(long bottom, long top) {}
        ArrayList<range> ranges = new ArrayList<>();

        for (String line01 : input01) {
            String[] splitNums = line01.split("-");
            Long[] nums = {Long.parseLong(splitNums[0]), Long.parseLong(splitNums[1])};
            ranges.add(new range(nums[0], nums[1]));
        }

        for (String line02: input02) {
            long numToCheck = Long.parseLong(line02);
            for (range numPair : ranges) {
                if (numToCheck <= numPair.top && numToCheck >= numPair.bottom) {
                    freshCount++;
                    break;
                }
            }
        }

        System.out.println(freshCount);
    }

    public static void partTwo(ArrayList<String> input01, ArrayList<String> input02) {
        long total = 0;
        long smallestBottom = -1;
        long biggestTop = 0;

        for (String line01 : input01) {
            String[] splitNums = line01.split("-");
            Long[] nums = {Long.parseLong(splitNums[0]), Long.parseLong(splitNums[1])};

            if (smallestBottom == -1 || nums[0] < smallestBottom) {
                smallestBottom = nums[0];
            }

            if (biggestTop < nums[1]) {
                biggestTop = nums[1];
            }
        }
        total = biggestTop - smallestBottom;
        System.out.println(biggestTop + " "  + smallestBottom + " " + total);
    }
}
