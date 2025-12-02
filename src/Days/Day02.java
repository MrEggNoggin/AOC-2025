// Completed 1:55:51.20 (more like 1:55:47 but i was celebrating :D)
// Part 1 Completed 14:57
// Completed on December 2, 2025, starting at ~2:55 PM
// NOTES
// for some reason i got REALLY stuck on day 2 part 2, kind of like last year with golang
// HOWEVER, i pushed through my dumbness this time and did it! hooray!
// also i learned that ArrayList set() != ArrayList add(), probably should've look at the function descriptions a little closer...
// this can 100% be cleaned up, there is no reason why this class needs to be 269 lines long.
// i figured out by the end the set() and add() thing which caused an error before when i used set()
// so instead of using for-loops like a regular person, i just hard coded all of it
// so now that i know the difference, i can get rid of the giant blocks of variables! yipeee!
// even though it took almost two hours, i'm glad i just stuck with it and got it done. :)

// TODO: replace EVERYTHING in this, this might be the worst stuff ive ever written, but hey, it works!

package Days;

import Eggtils.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Day02 {

    public static void run(String filePath) {
        ArrayList<String> input = InputLoader.loadInput(filePath);
        //partOne(input);
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
        long total = 0;
        String[] splitStringRange = idRange.split("-");

        long numOne = Long.parseLong(splitStringRange[0]);
        long numTwo = Long.parseLong(splitStringRange[1]);

        for (long i = numOne; i <= numTwo; i++) {
            String numString = Long.toString(i);

            if (numString.length() % 2 == 0) {
                long halveOne = Long.parseLong(numString.substring(0, numString.length() / 2));
                long halveTwo = Long.parseLong(numString.substring(numString.length() / 2));
                boolean equal = true;
                ArrayList<Long> numArray = new ArrayList<>();

                 if (halveOne == halveTwo) {
                     System.out.println(i);

                     total += i;
                     continue;
                 }

                 if (numString.length() == 2) {
                     continue;
                 }

                 for (int j = 0; j < numString.length() - 1; j+=2) {
                     numArray.add(Long.parseLong(numString.substring(j, j+2)));
                 }

                 for (int j = 0; j < numArray.size() - 1; j++) {
                     for (int k = j; k < numArray.size(); k++) {
                         if (!numArray.get(j).equals(numArray.get(k))) {
                             equal = false;
                             break;
                         }
                     }
                 }

                 if (equal) {
                     total += i;
                     System.out.println(i);

                     continue;
                 }
            }

            if (numString.length() == 3) {
                long partOne = Long.parseLong(numString.substring(0, 1));
                long partTwo = Long.parseLong(numString.substring(1,2));
                long partThree = Long.parseLong(numString.substring(2));

                if (partOne == partTwo && partTwo == partThree) {
                    total += i;
                    System.out.println(i);

                    continue;
                }
            }

            if (numString.length() == 5) {
                long partOne = Long.parseLong(numString.substring(0, 1));
                long partTwo = Long.parseLong(numString.substring(1,2));
                long partThree = Long.parseLong(numString.substring(2, 3));
                long partFour = Long.parseLong(numString.substring(3, 4));
                long partFive = Long.parseLong(numString.substring(4));

                if (partOne == partTwo && partTwo == partThree && partThree == partFour && partFour == partFive) {
                    total += i;
                    System.out.println(i);

                    continue;
                }

            }

            if (numString.length() == 7) {
                long partOne = Long.parseLong(numString.substring(0, 1));
                long partTwo = Long.parseLong(numString.substring(1,2));
                long partThree = Long.parseLong(numString.substring(2, 3));
                long partFour = Long.parseLong(numString.substring(3, 4));
                long partFive = Long.parseLong(numString.substring(4, 5));
                long partSix = Long.parseLong(numString.substring(5, 6));
                long partSeven = Long.parseLong(numString.substring(6));

                if (partOne == partTwo && partTwo == partThree && partThree == partFour && partFour == partFive
                && partFive == partSix && partSix == partSeven) {
                    total += i;
                    System.out.println(i);

                    continue;
                }
            }

            if (numString.length() == 9) {
                long partOne = Long.parseLong(numString.substring(0, 1));
                long partTwo = Long.parseLong(numString.substring(1, 2));
                long partThree = Long.parseLong(numString.substring(2, 3));
                long partFour = Long.parseLong(numString.substring(3, 4));
                long partFive = Long.parseLong(numString.substring(4, 5));
                long partSix = Long.parseLong(numString.substring(5, 6));
                long partSeven = Long.parseLong(numString.substring(6, 7));
                long partEight = Long.parseLong(numString.substring(7, 8));
                long partNine = Long.parseLong(numString.substring(8));

                long thirdOne = Long.parseLong(numString.substring(0, 3));
                long thirdTwo = Long.parseLong(numString.substring(3, 6));
                long thirdThree = Long.parseLong(numString.substring(6));

                if (partOne == partTwo && partTwo == partThree && partThree == partFour && partFour == partFive
                        && partFive == partSix && partSix == partSeven && partSeven == partEight && partEight == partNine) {
                    total += i;
                    System.out.println(i);

                    continue;
                }

                if (thirdOne == thirdTwo && thirdTwo == thirdThree) {
                    total += i;
                    continue;
                }

            }

            if (numString.length() == 11) {
                long partOne = Long.parseLong(numString.substring(0, 1));
                long partTwo = Long.parseLong(numString.substring(1, 2));
                long partThree = Long.parseLong(numString.substring(2, 3));
                long partFour = Long.parseLong(numString.substring(3, 4));
                long partFive = Long.parseLong(numString.substring(4, 5));
                long partSix = Long.parseLong(numString.substring(5, 6));
                long partSeven = Long.parseLong(numString.substring(6, 7));
                long partEight = Long.parseLong(numString.substring(7, 8));
                long partNine = Long.parseLong(numString.substring(8, 9));
                long partTen = Long.parseLong(numString.substring(9, 10));
                long partEleven = Long.parseLong(numString.substring(10));

                if (partOne == partTwo && partTwo == partThree && partThree == partFour && partFour == partFive
                        && partFive == partSix && partSix == partSeven && partSeven == partEight && partEight == partNine
                        && partNine == partTen && partTen == partEleven) {
                    total += i;
                    System.out.println(i);

                    continue;
                }
            }

            if (numString.length() == 12) {
                ArrayList<Long> numArray = new ArrayList<>();
                boolean equal = true;

                for (int j = 0; j < numString.length() - 2; j+=3) {
                    numArray.add(Long.parseLong(numString.substring(j, j+3)));
                }

                for (int j = 0; j < numArray.size() - 1; j++) {
                    for (int k = j; k < numArray.size(); k++) {
                        if (!numArray.get(j).equals(numArray.get(k))) {
                            equal = false;
                            break;
                        }
                    }
                }

                if (equal) {
                    System.out.println(i);
                    total += i;
                    continue;
                }
            }

            if (numString.length() == 12) {
                ArrayList<Long> numArray = new ArrayList<>();
                boolean equal = true;

                for (int j = 0; j < numString.length() - 3; j+=4) {
                    numArray.add(Long.parseLong(numString.substring(j, j+4)));
                }

                for (int j = 0; j < numArray.size() - 1; j++) {
                    for (int k = j; k < numArray.size(); k++) {
                        if (!numArray.get(j).equals(numArray.get(k))) {
                            equal = false;
                            break;
                        }
                    }
                }

                if (equal) {
                    System.out.println(i);
                    total += i;
                    continue;
                }
            }

        }

        return total;
    }
}