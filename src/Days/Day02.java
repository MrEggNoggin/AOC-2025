package Days;

import Eggtils.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Day02 {

    public static void run(String filePath) {
        ArrayList<String> input = InputLoader.loadInput(filePath);
        partOne(input);
        partTwo(input);
    }

    public static void partOne(ArrayList<String> input) {
        long total = 0;
        String[] rangesStrings = input.getFirst().split(",");

        for (String i : rangesStrings) {
            total += invalidIDDetector(i);
        }

        System.out.println(total);
    }

    public static void partTwo(ArrayList<String> input) {
        long total = 0;
        String[] rangeStrings = input.getFirst().split(",");

        for (String i : rangeStrings) {
            total += invalidIDDetectorButReallyBruteforced(i);
        }

        System.out.println(total);
    }

    private static long invalidIDDetector(String idRange) {
        long total = 0;
        String[] splitStringRange = idRange.split("-");

        long numOne = Long.parseLong(splitStringRange[0]);
        long numTwo = Long.parseLong(splitStringRange[1]);

        for (long i = numOne; i <= numTwo; i++) {
            String numString = "" + i;

            if (numString.substring(0, numString.length() / 2).equals(numString.substring(numString.length() / 2))) {
                total += i;
            }

        }

        return total;
    }

    private static long invalidIDDetectorButReallyBruteforced(String idRange) {
        long total = invalidIDDetector(idRange); // this doesn't feel right
        String[] splitStringRange = idRange.split("-");

        long numOne = Long.parseLong(splitStringRange[0]);
        long numTwo = Long.parseLong(splitStringRange[1]);

        for (long i = numOne; i <= numTwo; i++) {
            HashMap<Long, Long> seqTracker = new HashMap<>();

            String numString = "" + i;
            if (numString.length() % 2 == 0) {
                for (int j = 0; j < numString.length() - 2; j+=2) {
                    // TODO: there has to be a better way to do this
                    seqTracker.putIfAbsent(Long.parseLong(numString.substring(j, j + 2)), (long)0);
                    seqTracker.put(Long.parseLong(numString.substring(j, j + 2)), seqTracker.get(Long.parseLong(numString.substring(j, j + 2))) + 1);
                }
            } else if (numString.length() == 6 || numString.length() == 9 || numString.length() == 12) {
                for (int j = 0; j < numString.length() - 3; j+=3) {
                    // TODO: there has to be a better way to do this
                    seqTracker.putIfAbsent(Long.parseLong(numString.substring(j, j + 3)), (long)0);
                    seqTracker.put(Long.parseLong(numString.substring(j, j + 3)), seqTracker.get(Long.parseLong(numString.substring(j, j + 3))) + 1);
                }
            } else if (numString.length() == 12) {
                for (int j = 0; j < numString.length() - 4; j+=4) {
                    // TODO: there has to be a better way to do this
                    seqTracker.putIfAbsent(Long.parseLong(numString.substring(j, j + 4)), (long)0);
                    seqTracker.put(Long.parseLong(numString.substring(j, j + 4)), seqTracker.get(Long.parseLong(numString.substring(j, j + 4))) + 1);
                }

                for (int j = 0; j < numString.length() - 6; j+=6) {
                    // TODO: there has to be a better way to do this
                    seqTracker.putIfAbsent(Long.parseLong(numString.substring(j, j + 6)), (long)0);
                    seqTracker.put(Long.parseLong(numString.substring(j, j + 6)), seqTracker.get(Long.parseLong(numString.substring(j, j + 6))) + 1);
                }
            }
            for (long num : seqTracker.values()) {
                if (num > 1) {
                    total += i;
                    break;
                }
            }
        }

        return total;
    }
}
