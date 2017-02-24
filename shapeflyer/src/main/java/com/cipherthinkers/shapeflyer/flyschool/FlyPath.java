package com.cipherthinkers.shapeflyer.flyschool;

import android.graphics.Path;

import com.cipherthinkers.shapeflyer.ShapeFlyer;

/**
 * Class that actually defines how the path will look like.
 * Currently being extended by {@link BeizerPath} and {@link SingleLinePath}
 *
 * You can always extend it to create your own Fly Path
 *
 * Created by avin on 20/01/17.
 */

public abstract class FlyPath {
    public static SingleLinePath getSimpleLinePath(FPoint mFPoint){
        return new SingleLinePath(mFPoint);
    }

    public static BeizerPath getBeizerPath(FPoint mFPoint1,
                                    FPoint mFPoint2,
                                    FPoint mFPoint3){
        return new BeizerPath(mFPoint1, mFPoint2, mFPoint3);
    }

    public static MultipleLinePath getMultipleLinePath(FPoint... mFPoints){
        if(mFPoints == null){
            throw new IllegalArgumentException("Passed FPoints should not be null");
        }

        MultipleLinePath multipleLinePath = null;
        if(mFPoints.length > 0){
            multipleLinePath = new MultipleLinePath();
            for(FPoint fPoint : mFPoints){
                multipleLinePath.addFPoint(fPoint);
            }
        }

        return multipleLinePath;

    }

    /**
     * @param mOrigin : Origin point where the PATH should start
     * @param width : Width of the {@link ShapeFlyer} in pixels
     * @param height : Height of the {@link ShapeFlyer} in pixels
     *
     * Should return the path/trajectory of the animation.
     * Please refer to {@link BeizerPath} and {@link SingleLinePath} for examples
     * */
    public abstract Path getPath(FPoint mOrigin, float width, float height);
}
