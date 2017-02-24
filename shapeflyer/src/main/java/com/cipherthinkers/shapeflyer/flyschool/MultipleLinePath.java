package com.cipherthinkers.shapeflyer.flyschool;

import android.graphics.Path;

import java.util.ArrayList;

/**
 * Created by avin on 23/02/17.
 */

public class MultipleLinePath extends FlyPath {

    private ArrayList<FPoint> mFPoints;
    private Path mPath;

    public MultipleLinePath(ArrayList<FPoint> mFPoints) {
        this.mFPoints = mFPoints;
    }

    public MultipleLinePath() {

    }

    public ArrayList<FPoint> getmFPoints() {
        return mFPoints;
    }

    public void addFPoint(FPoint fPoint){
        if(fPoint == null){
            return;
        }

        if(mFPoints == null){
            mFPoints = new ArrayList<>();
        }

        mFPoints.add(fPoint);
    }

    @Override
    public Path getPath(FPoint mOrigin, float width, float height) {
        if(mPath == null) {
            mPath = new Path();
            mPath.moveTo(mOrigin.getmX() * width, mOrigin.getmY() * height);
            if(mFPoints != null && mFPoints.size() > 0){
                for(FPoint fPoint : mFPoints) {
                    mPath.lineTo(fPoint.getmX() * width, fPoint.getmY() * height);
                }
            }
        }
        return mPath;
    }

}
