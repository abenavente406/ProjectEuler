package com.rcode.project_euler;

/**
 * Class description here
 *
 * @version 10/22/13
 * @author: ANTHONY
 */
public class Problem34 implements Exercise {
    @Override
    public void run() {

    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new Problem34().run();
        long stop = System.nanoTime();
        System.out.println("It took " + ((stop - start) / 1000000f) + " ms to execute.");
    }
}
