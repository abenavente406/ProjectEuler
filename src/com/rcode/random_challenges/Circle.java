package com.rcode.random_challenges;

/**
 * Class description here
 *
 * @version 10/21/13
 * @author: ANTHONY
 */
public class Circle {

    /**
     * Loose approximation of the value PI
     */
    private static final double PI = 3.14159;

    private double radius, area;

    /**
     * Creates a circle with a default radius of 3
     */
    public Circle() {
        this.radius = 3;
        getArea();
    }

    /**
     * Sets the radius of the circle
     *
     * @param radius New radius
     */
    public void setRadius(double radius) {
        this.radius = radius;
        calculateArea();
    }

    /**
     * Gets the radius of the circle
     *
     * @return The radius of the circle
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Calculates and returns the area of the circle
     *
     * @return The area of the circle (PI * (r * r))
     */
    private double calculateArea() {
        area = PI * radius * radius;
        return area;
    }

    public double getArea() {
        return area;
    }
}
