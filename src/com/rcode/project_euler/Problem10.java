package com.rcode.project_euler;

/**
 * Created with IntelliJ IDEA.
 * User: ANTHONY
 * Date: 10/17/13
 * Time: 4:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class Problem10 implements Exercise {
    @Override
    public void run() {
        int[] results = HelperFunctions.sieveOfSundaram(2000000);
        long sum = 0;
        for (int i : results)
            sum += i;
        System.out.println(sum);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new Problem10().run();
        long stop = System.nanoTime();
        System.out.println("It took " + ((stop - start) / 1000000f) + " ms to execute.");
    }
}
