/*
 * @author ksb
 * @since 160314
 * to demo upcasting and downcasting
 */
package com.sd.turtle;
import ch.aplu.turtle.*;
import java.awt.Color;

public class WeightTurtle extends Turtle {
    protected int weight;
    public WeightTurtle(int w) {
        weight=w;
        setColor(Color.red);
        setPenColor(Color.red);
    }
    public int getWeight() {
        return weight;
    }
}