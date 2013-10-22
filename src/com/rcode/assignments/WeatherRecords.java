package com.rcode.assignments;

/**
 * Class description here
 *
 * @version 10/21/13
 * @author: ANTHONY
 */
public class WeatherRecords {

    private SnowFall maximum;
    private SnowFall minimum;
    private float total;
    private float average;
    private String locale;
    private int yearCount;

    public WeatherRecords(String locale) {
        this.locale = locale;
        maximum = new SnowFall();
        minimum = new SnowFall();
        total = 0f;
        average = 0f;
        yearCount = 0;
    }

    public SnowFall getMaximum() {
        return maximum;
    }

    public void setMaximum(SnowFall maximum) {
        this.maximum = maximum;
    }

    public SnowFall getMinimum() {
        return minimum;
    }

    public void setMinimum(SnowFall minimum) {
        this.minimum = minimum;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public int getYearCount() {
        return yearCount;
    }

    public void setYearCount(int yearCount) {
        this.yearCount = yearCount;
    }

    public void read() {

    }
}
