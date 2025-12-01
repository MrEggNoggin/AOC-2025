package Eggtils;

public class TimeCalculator {
    public static double totalTime(long start, long end) {
        return (double) (end - start) / 1_000_000;
    }
}
