// Completed 1:53:41.90
// Part 1 Complete: 33:52
// Completed on December 6, 2025, starting at ~12:00 PM (i had to do other things)
// NOTES
// i'm glad got to the answer for part two, i wasn't going anywhere with it for a while
// probably the hardest day so far, specifically part 2

package Days;

import Eggtils.*;

import java.awt.desktop.SystemSleepEvent;
import java.util.ArrayList;
import java.util.Collections;
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
        record range(long bottom, long top) {}
        long total = 0;
        HashMap<Long, Long> newRanges = new HashMap<>();
        ArrayList<range> ranges = new ArrayList<>();
        ArrayList<Long> leftNums = new ArrayList<>();
        ArrayList<Long> rightNums = new ArrayList<>();

        for (String line01 : input01) {
            String[] splitNums = line01.split("-");
            leftNums.add(Long.parseLong(splitNums[0]));
            rightNums.add(Long.parseLong(splitNums[1]));
        }

        Collections.sort(leftNums, Collections.reverseOrder());
        Collections.sort(rightNums, Collections.reverseOrder());

        for (int i = 0; i < leftNums.size(); i++) {
            ranges.add(new range(leftNums.get(i), rightNums.get(i)));
        }
        for (int j = 0; j < 1000000; j++) {
            for (int i = 0; i < ranges.size() - 1; i++) {
                if (ranges.get(i).bottom >= ranges.get(i + 1).bottom && ranges.get(i).bottom <= ranges.get(i + 1).top) {
                    ranges.set(i, new range(ranges.get(i + 1).bottom, ranges.get(i).top));
                }
            }
        }

        for (range r : ranges) {
            newRanges.putIfAbsent(r.bottom, 0L);
            if (newRanges.get(r.bottom) < r.top) {
                newRanges.put(r.bottom, r.top);
            }
        }

        for (long key : newRanges.keySet()) {
            total += newRanges.get(key) - key + 1;
        }

        System.out.println(total);
    }
}
