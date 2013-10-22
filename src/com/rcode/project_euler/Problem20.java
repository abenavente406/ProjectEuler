package com.rcode.project_euler;

import java.math.BigInteger;

/**
 * Class description here
 *
 * @version 10/18/13
 * @author: ANTHONY
 */
public class Problem20 implements Exercise {

    @Override
    public void run() {
        String strNum = HelperFunctions.bigFactorial(BigInteger.valueOf(100L)).toString().trim();
        long sum = 0;
        for (int i = 0; i < strNum.length();i++) {
            sum += Long.parseLong(strNum.substring(i, i + 1));
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new Problem20().run();
        long stop = System.nanoTime();
        System.out.println("It took " + ((stop - start) / 1000000f) + " ms to execute.");
    }
}
