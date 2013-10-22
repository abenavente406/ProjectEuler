package com.rcode.project_euler;

/**
 * Class description here
 *
 * @version 10/22/13
 * @author: ANTHONY
 */
public class Problem18 implements Exercise {
    @Override
    public void run() {
        int[][] grid = HelperFunctions.getTriangleData("triangle.txt");
        for (int i = grid.length - 2; i >= 0; i--) {
            for (int j = grid.length - 2; j >= 0; j--) {
                grid[i][j] = grid[i][j] + Math.max(grid[i + 1][j], grid[i + 1][j + 1]);
            }
        }

        System.out.println(grid[0][0]);
    }


    public static void main(String[] args) {
        long start = System.nanoTime();
        new Problem18().run();
        long stop = System.nanoTime();
        System.out.println("It took " + ((stop - start) / 1000000f) + " ms to execute.");
    }
}
