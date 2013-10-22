package com.rcode.project_euler;

import java.math.BigInteger;

/**
 * Class description here
 *
 * @version 10/17/13
 * @author: ANTHONY
 */
public class Problem16 implements Exercise {
    @Override
    public void run() {
        BigInteger i = BigInteger.valueOf(2L);
        i = i.pow(1000);
        String num = i.toString();
        int sum = 0;
        for (int j = 0; j < num.length(); j++) {
            sum += Integer.parseInt(i.toString().substring(j, j+1));
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new Problem16().run();
        long stop = System.nanoTime();
        System.out.println("It took " + ((stop - start) / 1000000f) + " ms to execute.");
    }
}
