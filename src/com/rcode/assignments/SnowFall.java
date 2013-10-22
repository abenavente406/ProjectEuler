package com.rcode.assignments;

/**
 * Class description here
 *
 * @version 10/20/13
 * @author: ANTHONY
 */
public class SnowFall {
    private float total;
    private float minimum;
    private float maximum;
    private float average;
    private String year;
    private int count;
    private int maxDay;
    private int minDay;

    public SnowFall() {
        this(0f, Float.MAX_VALUE, Float.MIN_VALUE, 0f, "", 0);
    }

    public SnowFall(String year, int count) {
        this(0f, Float.MAX_VALUE, Float.MIN_VALUE, 0f, year, count);
    }

    public SnowFall(float total, float minimum, float maximum, float average,
                    String year, int count) {
        this.total = total;
        this.minimum = minimum;
        this.maximum = maximum;
        this.average = average;
        this.year = year;
        this.count = count;
        this.minDay = 0;
        this.maxDay = 0;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getMinimum() {
        return minimum;
    }

    public void setMinimum(float minimum) {
        this.minimum = minimum;
    }

    public float getMaximum() {
        return maximum;
    }

    public void setMaximum(float maximum) {
        this.maximum = maximum;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void read(int count) {
        this.count = count;
        for (int i = 0; i < count; i++) {
            System.out.println("DAY " + i + " / " + count + " : Enter the amount of snow in centimeters: ");
            float amount = UserInput.readFloat();
            total += amount;
            if (amount > maximum) {
                maximum = amount;
                maxDay = i + 1;
            }
            if (amount < maximum) {
                minimum = amount;
                minDay = i + 1;
            }
        }
        this.average = this.total / this.count;
    }

    public void read() {
        read(count);
    }

    public void report() {
        System.out.println("****SNOW FALL REPORT FOR 2012****");
        System.out.println();
        System.out.println("This year there were " + count + " snowfall occurences.");
        System.out.println("The total snowfall was: " + total + "cm");
        System.out.println("The average snowfall was: " + average + "cm");
        System.out.println("The greatest of them was snowfall " + "" + " which has " + maximum + "cm of snow.");
        System.out.println("The least significant was snowfall " + "" + " which saw " + minimum + "cm of snow.");
        System.out.println();
        System.out.println("****End of Report****");
    }
}
