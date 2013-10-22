package com.rcode.project_euler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ANTHONY
 * Date: 10/17/13
 * Time: 10:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class Problem7 implements Exercise {
    @Override
    public void run() {
        List<Long> primes = new ArrayList<Long>();
        primes.add(1L);
        primes.add(2L);
        long count = 1;
        while (primes.size() < 10002) {
            if (HelperFunctions.isPrime(count += 2)) {
                primes.add(count);
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new Problem7().run();
        long stop = System.nanoTime();
        System.out.println("It took " + ((stop - start) / 1000000f) + " ms to execute.");
    }
}
