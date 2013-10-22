package com.rcode.project_euler;

/**
 * Created with IntelliJ IDEA.
 * User: ANTHONY
 * Date: 10/16/13
 * Time: 9:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class Problem5 implements Exercise {
    @Override
    public void run() {
        System.out.println(HelperFunctions.recursiveLcm(10));
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new Problem5().run();
        long end = System.nanoTime();
        System.out.println("It took " + ((end - start) / 1000000f) + " ms to execute.");
    }
}
