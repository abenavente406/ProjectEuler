package com.rcode.project_euler;

/**
 * Class description here
 *
 * @version 10/17/13
 * @author: ANTHONY
 */
public class Problem19 implements Exercise {
    @Override
    public void run() {
        int[] daysOfMonths = new int[] {
                31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
        };

        int year = 1901;
        int day = 2;     // 0: Sunday, 1: Monday, 2: Tuesday, 3: WED, 4: THURS, 5: FRI, 6: SAT
        int sundays = 0;

        while (year < 2001) {
            for (int i = 0; i < 12; i++) {
                if (i == 1) {
                    day = HelperFunctions.isLeapYear(year) ? (day + 29) % 7: (day + daysOfMonths[i]) % 7;
                } else {
                    day = (day + daysOfMonths[i]) % 7;
                }

                if (day == 0)
                    sundays++;
            }
            year++;
        }
        System.out.println(sundays);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new Problem19().run();
        long stop = System.nanoTime();
        System.out.println("It took " + ((stop - start) / 1000000f) + " ms to execute.");
    }
}
