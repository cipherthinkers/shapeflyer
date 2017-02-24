package com.cipherthinkers.shapeflyer.flyschool;

import com.cipherthinkers.shapeflyer.ShapeFlyer;

/**
 * Point class that takes everything with respect to the width and height
 * of the ShapeFlyer {@link ShapeFlyer} view
 * e.g. if it is given X = 0.5f and Y = 0.5f
 * It actially means : X = 0.5w and Y = 0.5h
 *
 * Created by avin on 31/01/17.
 */
public class FPoint {
    private float mX, mY;

    public FPoint(float mX, float mY) {
        this.mX = mX;
        this.mY = mY;
    }

    public float getmX() {
        return mX;
    }

    public float getmY() {
        return mY;
    }
}
