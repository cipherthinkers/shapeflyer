package com.cipherthinkers.shapeflyer.flyschool;

import android.graphics.Path;

/**
 * Simple line path generator
 * Requires one {@link FPoint} to generate the Path
 *
 * Created by avin on 20/01/17.
 */

public class SingleLinePath extends FlyPath {
    private FPoint mFPoint;
    private Path mPath;

    public SingleLinePath(FPoint mFPoint) {
        this.mFPoint = mFPoint;
    }

    public FPoint getmFPoint() {
        return mFPoint;
    }

    @Override
    public Path getPath(FPoint mOrigin, float width, float height) {
        if(mPath == null) {
            mPath = new Path();
            mPath.moveTo(mOrigin.getmX() * width, mOrigin.getmY() * height);
            mPath.lineTo(getmFPoint().getmX() * width, getmFPoint().getmY() * height);
        }
        return mPath;
    }
}
