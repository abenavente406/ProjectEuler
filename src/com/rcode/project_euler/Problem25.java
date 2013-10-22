package com.rcode.project_euler;

import java.math.BigInteger;

/**
 * Class description here
 *
 * @version 10/22/13
 * @author: ANTHONY
 */
public class Problem25 implements Exercise {
    @Override
    public void run() {
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ZERO;
        BigInteger c = BigInteger.ZERO;
        int count = 1;
        while (c.toString().length() < 1000) {
            c = a.add(b);
            b = new BigInteger(a.toString());
            a = new BigInteger(c.toString());
            count ++;
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new Problem25().run();
        long stop = System.nanoTime();
        System.out.println("It took " + ((stop - start) / 1000000f) + " ms to execute.");
    }
}
