package com.rcode.random_challenges;

import com.rcode.project_euler.Exercise;

import java.io.*;

/**
 * Class description here
 *
 * @version 10/18/13
 * @author: ANTHONY
 */
public class GriffinAssignment1 implements Exercise {

    @Override
    public void run() {
        printTable(50);
    }

    /**
     * Prints a triangular multiplication table
     *
     * @param rows Number of rows in the table (<em>Only from 1-9</em>)
     */
    private void printTable(int rows) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("file.txt"));
            for (int i = 1; i <= rows; i++) {
                for (int j = 1; j <= i; j++) {
                    int maxSpacesAfter = String.valueOf(rows).length();
                    int spacesAfter = maxSpacesAfter - String.valueOf(i).length();
                    String spaces = "";
                    for (int k = 0; k < spacesAfter; k++) spaces += " ";
                    out.write((j != 1) ? formatNum(rows, i * j) : i + spaces);
                }
                out.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String formatNum(int rows, int num) {
        String result = "";
        int maxSpaces = String.valueOf(rows * rows).length();
        int necessarySpaces = maxSpaces - String.valueOf(num).length() + 1;
        for (int i = 0; i < necessarySpaces; i++) result += " ";
        return result + String.valueOf(num);
    }

    public static void main(String[] args) {
        new GriffinAssignment1().run();
    }
}
