package com.rcode.random_challenges;

import com.rcode.project_euler.Exercise;

/**
 * Class description here
 *
 * @version 10/19/13
 * @author: ANTHONY
 */
public class GriffinAssignment2 implements Exercise {

    @Override
    public void run() {
        String spaces = "";
        int width = 23;
        for (int i = 0; i < width; i++) spaces += " ";
        for (int i = 0; i < width; i++) {
            StringBuilder initial = new StringBuilder(spaces);
            initial.setCharAt(i, 'X');
            initial.setCharAt((width - 1) - i, 'X');
            System.out.println(initial.toString());
        }
    }

    public static void main(String[] args) {
        new GriffinAssignment2().run();
    }
}
