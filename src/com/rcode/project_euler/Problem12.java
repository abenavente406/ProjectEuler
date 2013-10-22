package com.rcode.project_euler;

/**
 * Created with IntelliJ IDEA.
 * User: ANTHONY
 * Date: 10/17/13
 * Time: 10:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class Problem12 implements Exercise {
    @Override
    public void run() {
        long divisors = 0;
        long counter = 1;
        long triangleNumber = 0;
        while (divisors < 500) {
            triangleNumber = 0;
            for (long i = counter; i >= 1; i--) {
                triangleNumber += i;
            }
            divisors = HelperFunctions.countDivisors(triangleNumber);
            counter++;
        }

        System.out.println(triangleNumber + ": " + divisors);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new Problem12().run();
        long stop = System.nanoTime();
        System.out.println("It took " + ((stop - start) / 1000000f) + " ms to execute.");
    }
}
