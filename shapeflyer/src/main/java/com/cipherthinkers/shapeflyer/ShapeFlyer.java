package com.cipherthinkers.shapeflyer;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.cipherthinkers.shapeflyer.flyschool.FlyBluePrint;
import com.cipherthinkers.shapeflyer.flyschool.PATHS;

import java.util.ArrayList;
import java.util.Random;

/**
 * View that uses the BluePrints (refer to the {@link FlyBluePrint})
 * defined by you to create and start animations
 *
 * Created by avin on 09/01/17.
 */

//https://www.desmos.com/calculator/cahqdxeshd

public class ShapeFlyer extends RelativeLayout {

    private ArrayList<Path> mPaths;
    private ArrayList<FlyBluePrint> mFlyBluePrints;
    private int mShapeWidth;
    private int mShapeHeight;

    private boolean isAlphaEnabled, isScaleEnabled;
    private float mFromScale = 1f, mToScale = 0.6f, mFromAlpha = 1f, mToAlpha = 0f;

    public ShapeFlyer(Context context) {
        super(context);
        init(null);
    }

    public ShapeFlyer(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public ShapeFlyer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ShapeFlyer(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet attributeSet){
        mShapeWidth = Utils.dpToPx(50);
        mShapeHeight = Utils.dpToPx(50);
        if(attributeSet != null){
            TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.ShapeFlyer);
            mShapeWidth = typedArray.getDimensionPixelSize(R.styleable.ShapeFlyer_shape_width, (int) mShapeWidth);
            mShapeHeight = typedArray.getDimensionPixelSize(R.styleable.ShapeFlyer_shape_height, (int) mShapeHeight);
            isAlphaEnabled = typedArray.getBoolean(R.styleable.ShapeFlyer_enable_alpha, false);
            isScaleEnabled = typedArray.getBoolean(R.styleable.ShapeFlyer_enable_scale, false);
            mFromAlpha = typedArray.getFloat(R.styleable.ShapeFlyer_from_alpha, 1f);
            mToAlpha = typedArray.getFloat(R.styleable.ShapeFlyer_to_alpha, 0f);
            mFromScale = typedArray.getFloat(R.styleable.ShapeFlyer_from_scale, 1f);
            mToScale = typedArray.getFloat(R.styleable.ShapeFlyer_to_scale, 0.5f);
            typedArray.recycle();
        }
    }

    /**
     * @param flyBluePrint : {@link FlyBluePrint} to be added to the list
     * Adds a {@link FlyBluePrint} to the list, used to populate the animation
     * */
    public void addPath(FlyBluePrint flyBluePrint){
        if(flyBluePrint != null){
            if(mFlyBluePrints == null){
                mFlyBluePrints = new ArrayList<>();
            }

            mFlyBluePrints.add(flyBluePrint);
        }
    }

    public void clearPaths(){
        if(mFlyBluePrints != null){
            mFlyBluePrints.clear();
        }

        if(mPaths != null){
            mPaths.clear();
        }
    }

    /**
     * @param definedPath : {@link PATHS} to be added to the list
     * Adds a Predefined Blue print to the list, used to populate the animation
     * Please refer to the {@link PATHS} for more details
     * */
    public void addPath(PATHS definedPath){
        if(definedPath != null){
            addPath(definedPath.getmFlyBluePrint());
        }
    }

    private void createAndAddPath(FlyBluePrint flyBluePrint){
        if(flyBluePrint != null) {
            float w = getWidth(), h = getHeight();
            if (mPaths == null) {
                mPaths = new ArrayList<>();
            }

            Path path = flyBluePrint.getPath(w, h);
            mPaths.add(path);
        }
    }

    private void initPaths(){
        if(mFlyBluePrints != null) {
            for (FlyBluePrint flyBluePrint : mFlyBluePrints) {
                createAndAddPath(flyBluePrint);
            }
        }
    }

    private Path getRandomPath() {
        return mPaths.get(new Random().nextInt(mPaths.size()));
    }

    /**
     * @param drawable : Drawable to be animated along the given path(s)
     * @param flyBluePrint : BluePrint to generate Path
     * You should use a vector drawable for better performance
     * */
    public void startAnimation(int drawable, FlyBluePrint flyBluePrint){
        float w = getWidth(), h = getHeight();
        startAnimation(drawable, flyBluePrint.getPath(w, h));
    }

    /**
     * @param drawable : Drawable to be animated along the given path(s)
     * @param path : Path along which the animation should happen
     * You should use a vector drawable for better performance
     * */
    private void startAnimation(int drawable, Path path){
        initPaths();
        View shapeView = null;
        if(Utils.isLowerThanLollipop()){
            shapeView = new AppCompatShapeView(getContext());
        }else{
            shapeView = new ShapeView(getContext());
        }

        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.height = mShapeHeight;
        layoutParams.width = mShapeWidth;
        shapeView.setLayoutParams(layoutParams);
        ((ShapeSetter)shapeView).setShape(drawable);
        addView(shapeView);

        ValueAnimator pathAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
        pathAnimator.setDuration(2000);


        final Path finalPath = path;
        final View finalShapeView = shapeView;
        pathAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            float[] point = new float[2];

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float val = animation.getAnimatedFraction();
                PathMeasure pathMeasure = new PathMeasure(finalPath, false);
                pathMeasure.getPosTan(pathMeasure.getLength() * val, point, null);
                finalShapeView.setX(point[0]);
                finalShapeView.setY(point[1]);
                if(isAlphaEnabled) {
                    finalShapeView.setAlpha(mFromAlpha + (mToAlpha-mFromAlpha)*val);
                }

                if(isScaleEnabled) {
                    finalShapeView.setScaleX(mFromScale + (mToScale-mFromScale)*val);
                    finalShapeView.setScaleY(mFromScale + (mToScale-mFromScale)*val);
                }
            }
        });

        pathAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                removeView(finalShapeView);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        pathAnimator.start();
    }

    /**
     * @param drawable : Drawable to be animated along the given path(s)
     * You should use a vector drawable for better performance
     * */
    public void startAnimation(int drawable){
        initPaths();
        startAnimation(drawable, getRandomPath());

//        View shapeView = null;
//        if(Utils.isLowerThanLollipop()){
//            shapeView = new AppCompatShapeView(getContext());
//        }else{
//            shapeView = new ShapeView(getContext());
//        }
//
//        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT);
//        layoutParams.height = mShapeHeight;
//        layoutParams.width = mShapeWidth;
//        shapeView.setLayoutParams(layoutParams);
//        ((ShapeSetter)shapeView).setShape(drawable);
//        addView(shapeView);
//
//        ValueAnimator pathAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
//        pathAnimator.setDuration(2000);
//
//
//        final Path path = getRandomPath();
//        final View finalShapeView = shapeView;
//        pathAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            float[] point = new float[2];
//
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                float val = animation.getAnimatedFraction();
//                PathMeasure pathMeasure = new PathMeasure(path, false);
//                pathMeasure.getPosTan(pathMeasure.getLength() * val, point, null);
//                finalShapeView.setX(point[0]);
//                finalShapeView.setY(point[1]);
//                if(isAlphaEnabled) {
//                    finalShapeView.setAlpha(mFromAlpha + (mToAlpha-mFromAlpha)*val);
//                }
//
//                if(isScaleEnabled) {
//                    finalShapeView.setScaleX(mFromScale + (mToScale-mFromScale)*val);
//                    finalShapeView.setScaleY(mFromScale + (mToScale-mFromScale)*val);
//                }
//            }
//        });
//
//        pathAnimator.addListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                removeView(finalShapeView);
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animation) {
//
//            }
//        });
//
//        pathAnimator.start();
    }

    public void release(){
        removeAllViews();
        if(mPaths != null) {
            mPaths.clear();
        }
    }
}
