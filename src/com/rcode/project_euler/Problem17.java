package com.rcode.project_euler;

/**
 * Class description here
 *
 * @version 10/21/13
 * @author: ANTHONY
 */
public class Problem17 implements Exercise {
    @Override
    public void run() {
        long sum = 0;
        for (int i = 1; i <= 999; i++) {
            sum += HelperFunctions.numToWords(i).trim().replace(" ", "").length();
        }
        System.out.println(sum + ("onethousand").length());
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new Problem17().run();
        long stop = System.nanoTime();
        System.out.println("It took " + ((stop - start) / 1000000f) + " ms to execute.");
    }
}
