package com.cipherthinkers.shapeflyer.flyschool;

import android.graphics.Path;

/**
 * Simple beizer path generator
 * Requires three {@link FPoint} to generate the Path
 *
 * Created by avin on 20/01/17.
 */

public class BeizerPath extends FlyPath {
    private FPoint mFPoint1, mFPoint2, mFPoint3;
    private Path mPath;

    public BeizerPath(FPoint mFPoint1, FPoint mFPoint2, FPoint mFPoint3) {
        this.mFPoint1 = mFPoint1;
        this.mFPoint2 = mFPoint2;
        this.mFPoint3 = mFPoint3;
    }

    public FPoint getmFPoint1() {
        return mFPoint1;
    }

    public FPoint getmFPoint2() {
        return mFPoint2;
    }

    public FPoint getmFPoint3() {
        return mFPoint3;
    }


    @Override
    public Path getPath(FPoint mOrigin, float width, float height) {
        if(mPath == null) {
            mPath = new Path();
            mPath.moveTo(mOrigin.getmX() * width, mOrigin.getmY() * height);
            float x1 = 0, y1 = 0, x2 = 0, y2 = 0, x3 = 0, y3 = 0;
            x1 = getmFPoint1().getmX() * width;
            y1 = getmFPoint1().getmY() * height;
            x2 = getmFPoint2().getmX() * width;
            y2 = getmFPoint2().getmY() * height;
            x3 = getmFPoint3().getmX() * width;
            y3 = getmFPoint3().getmY() * height;
            mPath.rCubicTo(x1, y1, x2, y2, x3, y3);
        }

        return mPath;
    }
}
