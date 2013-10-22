package com.rcode.project_euler;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Class description here
 *
 * @version 10/19/13
 * @author: ANTHONY
 */
public class Problem22 implements Exercise {

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("names.txt"));
            String[] names = reader.readLine().replaceAll("\"", "").split(",");
            List<String> namesList = new ArrayList<String>();
            for (String n : names) namesList.add(n);
            Collections.sort(namesList, HelperFunctions.ALPHABETICAL_ORDER);
            BigInteger sum = BigInteger.ZERO;
            for (int i = 0; i < namesList.size(); i++) {
                sum = sum.add(new BigInteger("" + (HelperFunctions.getWordScore(namesList.get(i)) * (i + 1))));
            }
            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new Problem22().run();
        long stop = System.nanoTime();
        System.out.println("It took " + ((stop - start) / 1000000f) + " ms to execute.");
    }
}
