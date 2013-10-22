package com.rcode.project_euler;

/**
 * Created with IntelliJ IDEA.
 * User: ANTHONY
 * Date: 10/17/13
 * Time: 10:17 AM
 * To change this template use File | Settings | File Templates.
 */
public class Problem6 implements Exercise {
    @Override
    public void run() {
        int testNumber = 100;
        System.out.println(HelperFunctions.squareOfSum(testNumber) - HelperFunctions.sumOfSquares(testNumber));
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new Problem6().run();
        long stop = System.nanoTime();
        System.out.println("It took " + ((stop - start) / 1000000f) + " ms to execute.");
    }
}
