package com.rcode.project_euler;

/**
 * Class description here
 *
 * @version 10/17/13
 * @author: ANTHONY
 */
public class Problem14 implements Exercise {
    @Override
    public void run() {
        long longestChain = 0, highestIndex = 0;
        for (int i = 1000000; i >= 1; i--) {
            long tmpChain = HelperFunctions.collatzChainLength(i);
            if (tmpChain > longestChain) {
                longestChain = tmpChain;
                highestIndex = i;
            }
        }
        System.out.println(longestChain + " - " + highestIndex);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new Problem14().run();
        long stop = System.nanoTime();
        System.out.println("It took " + ((stop - start) / 1000000f) + " ms to execute.");
    }
}
