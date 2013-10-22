package com.rcode.project_euler;

/**
 * Created with IntelliJ IDEA.
 * User: ANTHONY
 * Date: 10/16/13
 * Time: 1:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class Problem3 implements Exercise {
    @Override
    public void run() {
        long largestFactor = 0;
        for (long i = 1; i < Math.sqrt(600851475143L); i++) {
            if (600851475143L % i == 0 && HelperFunctions.isPrime(i)) {
                largestFactor = i;
            }
        }
        System.out.println(largestFactor);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new Problem3().run();
        long end = System.nanoTime();
        System.out.println("It took " + ((end - start) / 1000) + " ms to execute.");
    }
}
