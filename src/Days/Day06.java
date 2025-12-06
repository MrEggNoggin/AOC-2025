// Completed 1:48:03
// Part 1 Completed 27:02
// Completed on December 6, 2025, starting at ~12:00 PM (i had to do other things)
// NOTES
// im VERY happy i got part 2, for some reason it was confusing to me

package Days;

import Eggtils.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day06 {

    public static void run(String filePath) {
        ArrayList<String> input = InputLoader.loadInput(filePath);
        // partOne(input);
        partTwo(input);
    }

    public static void partOne(ArrayList<String> input) {
        long total = 0;
        ArrayList<Long> numLine01 = new ArrayList<>();
        ArrayList<Long> numLine02 = new ArrayList<>();
        ArrayList<Long> numLine03 = new ArrayList<>();
        ArrayList<Long> numLine04 = new ArrayList<>();
        ArrayList<Character> operationLine = new ArrayList<>();

        for (int i = 0; i < input.size() - 1; i++) {
            Pattern p = Pattern.compile("-?\\d+");
            Matcher m = p.matcher(input.get(i));
            while (m.find()) {
                if (i == 0) {
                    numLine01.add(Long.parseLong(m.group()));
                } else if (i == 1) {
                    numLine02.add(Long.parseLong(m.group()));
                } else if (i == 2) {
                    numLine03.add(Long.parseLong(m.group()));
                } else if (i == 3) {
                    numLine04.add(Long.parseLong(m.group()));
                }
            }
        }

        Pattern p = Pattern.compile("[+,*]");
        Matcher m = p.matcher(input.getLast());
        while (m.find()) {
            operationLine.add(m.group().toCharArray()[0]);
        }

        for (int i = 0; i < numLine01.size(); i++) {
            if (operationLine.get(i) == '+') {
                total += (numLine01.get(i) + numLine02.get(i) + numLine03.get(i) + numLine04.get(i));
            } else {
                total += (numLine01.get(i) * numLine02.get(i) * numLine03.get(i) * numLine04.get(i));
            }
        }

        System.out.println(total);
    }

    public static void partTwo(ArrayList<String> input) {
        long total = 0;
        int lastIndex = 0;
        record stack(String line01, String line02, String line03, String line04, char operator) {}
        fixInput(input);

        ArrayList<stack> problems = new ArrayList<>();
        String stackInfo01 = "";
        String stackInfo02 = "";
        String stackInfo03 = "";
        String stackInfo04 = "";
        char stackOperator = ' ';

        for (int i = 0; i < input.getFirst().length(); i++) {
            if (input.get(0).charAt(i) == ' ' && input.get(1).charAt(i) == ' ' && input.get(2).charAt(i) == ' ' && input.get(3).charAt(i) == ' ' && input.get(4).charAt(i) == ' ') {
                problems.add(new stack(stackInfo01, stackInfo02, stackInfo03, stackInfo04, stackOperator));
                stackInfo01 = "";
                stackInfo02 = "";
                stackInfo03 = "";
                stackInfo04 = "";
                stackOperator = ' ';
                continue;
            }

            if (input.get(4).charAt(i) == '+') {
                stackOperator = '+';
            } else if (input.get(4).charAt(i) == '*') {
                stackOperator = '*';
            }

            stackInfo01 += input.get(0).substring(i, i+1);
            stackInfo02 += input.get(1).substring(i, i+1);
            stackInfo03 += input.get(2).substring(i, i+1);
            stackInfo04 += input.get(3).substring(i, i+1);
        }

        for (stack problem : problems) {
            int length = problem.line01.length();
            long[] nums = new long[length];

            for (int i = 0; i < length; i++) {
                nums[i] = Long.parseLong(problem.line01.substring(i, i+1).trim() + problem.line02.substring(i, i+1).trim() + problem.line03.substring(i, i+1).trim() + problem.line04.substring(i, i+1).trim());
            }

            if (problem.operator == '+') {
                for (int i = 0; i < length; i++) {
                    total += nums[i];
                }
            } else if (problem.operator == '*') {
                long temp = 1;
                for (int i = 0; i < length; i++) {
                    temp *= nums[i];
                }
                total += temp;
            }
        }
        System.out.println(total);
    }
    
    public static void fixInput(ArrayList<String> input) {
        input.set(0, input.getFirst() + "     ");
        for (int i = 1; i < input.size(); i++) {
            while (input.get(i).length() < input.getFirst().length()) {
                input.set(i, input.get(i) + " ");
            }
        }
    }
}
