package com.rcode.project_euler;

/**
 * Created with IntelliJ IDEA.
 * User: ANTHONY
 * Date: 10/11/13
 * Time: 5:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class Problem1 implements Exercise {
    @Override
    public void run() {
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            sum += ((((i % 3) == 0) || ((i % 5) == 0)) ? i : 0);
        }
        System.out.println("The sum is: " + sum);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new Problem1().run();
        long stop = System.nanoTime();
        System.out.println("It took " + ((stop - start) / 1000) + "ms to execute.");
    }
}