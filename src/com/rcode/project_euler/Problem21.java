package com.rcode.project_euler;

/**
 * Class description here
 *
 * @version 10/18/13
 * @author: ANTHONY
 */
public class Problem21 implements Exercise {
    @Override
    public void run() {
        long sum = 0;
        for (int i = 1; i < 10000;i++) {
            sum += (HelperFunctions.isAmicableNumber(i) ? i : 0);
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new Problem21().run();
        long stop = System.nanoTime();
        System.out.println("It took " + ((stop - start) / 1000000f) + " ms to execute.");
    }
}
