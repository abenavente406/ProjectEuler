package com.rcode.project_euler;

import java.math.BigInteger;

/**
 * Class description here
 *
 * @version 10/21/13
 * @author: ANTHONY
 */
public class Problem15 implements Exercise {
    @Override
    public void run() {
        int gridSize = 20;
        BigInteger[][] grid = new BigInteger[gridSize + 1][gridSize + 1];

        for (int i = 0; i < gridSize; i++) {
            grid[i][gridSize] = BigInteger.ONE;
            grid[gridSize][i] = BigInteger.ONE;
        }

        for (int i = gridSize - 1; i >= 0; i--) {
            for (int j = gridSize - 1; j >= 0; j--) {
                grid[i][j] = BigInteger.ZERO.add(grid[i + 1][j].add(grid[i][j+1]));
            }
        }

        System.out.println("In a " + gridSize + "x" + gridSize + " grid, there are "
                + grid[0][0].toString() + " lattice paths.");
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new Problem15().run();
        long stop = System.nanoTime();
        System.out.println("It took " + ((stop - start) / 1000000f) + " ms to execute.");
    }
}
