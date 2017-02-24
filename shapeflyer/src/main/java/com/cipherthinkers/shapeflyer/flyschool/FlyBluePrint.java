package com.cipherthinkers.shapeflyer.flyschool;

import android.graphics.Path;

/**
 * Class that defines the Blue Print of the complete Animation
 * Has two members variables that define everything:
 * 1. mOrigin : That defines the origin point of the animation
 * 2. mFlyPath : That defines tha path the object is going to take starting at the mOrigin
 *
 * Refer to the {@link FlyPath} for more details
 *
 * Created by avin on 12/01/17.
 */

public class FlyBluePrint {
    private FPoint mOrigin;
    private FlyPath mFlyPath;

    public FlyBluePrint(FPoint mOrigin, FlyPath mFlyPath) {
        this.mOrigin = mOrigin;
        this.mFlyPath = mFlyPath;
    }

    public FlyPath getmFlyPath() {
        return mFlyPath;
    }

    public FPoint getmOrigin() {
        return mOrigin;
    }

    public Path getPath(float width, float height){
        if(mFlyPath == null){
            throw new NullPointerException("FlyPath should not be null. Create a FlyBluePrint with FlyPath defined");
        }
        return mFlyPath.getPath(mOrigin, width, height);
    }
}
