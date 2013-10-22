package com.rcode.project_euler;

/**
 * Created with IntelliJ IDEA.
 * User: ANTHONY
 * Date: 10/16/13
 * Time: 8:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class Problem4 implements Exercise {
    @Override
    public void run() {
        int largestPalindrome = 0;
        boolean stopLoop = false;
        for (int i = 999; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                if (HelperFunctions.isPalindrome(j * i)) {
                    if (largestPalindrome < (j * i)) {
                        largestPalindrome = j * i;
                    }
                }
            }
            if (stopLoop) break;
        }
        System.out.println(largestPalindrome);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new Problem4().run();
        long end = System.nanoTime();
        System.out.println("It took " + ((end - start) / 1000000f) + " ms to execute.");
    }
}
