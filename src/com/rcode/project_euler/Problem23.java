package com.rcode.project_euler;

/**
 * Class description here
 *
 * @version 10/20/13
 * @author: ANTHONY
 */
public class Problem23 implements Exercise {
    @Override
    public void run() {
        long[] abundantNums = new long[6965];
        int count = 0;
        for (int i = 1; i < 28123; i++) {
            if (HelperFunctions.isAbundantNumber(i)) {
                abundantNums[count++] = i;
            }
        }
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new Problem23().run();
        long stop = System.nanoTime();
        System.out.println("It took " + ((stop - start) / 1000000f) + " ms to execute.");
    }
}
