package com.rcode.project_euler;

/**
 * Created with IntelliJ IDEA.
 * User: ANTHONY
 * Date: 10/17/13
 * Time: 10:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class Problem9 implements Exercise {


    @Override
    public void run() {
        long a = 1  , b, c;
        for (b = 1; b <= 1000; b++) {
            a = (500000-1000*b)/(1000-b);
            if (a + b + ((int)Math.sqrt(a*a + b*b)) == 1000) {
                break;
            }
        }
        System.out.println(a + " | " + b + " | " + (c = 1000 - a - b));
        System.out.println("Product:   " + (a*b*c));
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new Problem9().run();
        long stop = System.nanoTime();
        System.out.println("It took " + ((stop - start) / 1000000f) + " ms to execute.");
    }
}
