package com.rcode.project_euler;

/**
 * Created with IntelliJ IDEA.
 * User: ANTHONY
 * Date: 10/16/13
 * Time: 1:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class Problem2 implements Exercise {
    @Override
    public void run() {
        int a = 1;
        int b = 0;
        int c = 0;
        int sum = 0;
        while (c < 4000000) {
            c = a + b;
            b = a;
            a = c;
            sum += ((c % 2 == 0) ? c : 0);
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new Problem2().run();
        long stop = System.nanoTime();
        System.out.println("It took " + ((stop - start) / 1000000f) + " ms to execute.");
    }
}
