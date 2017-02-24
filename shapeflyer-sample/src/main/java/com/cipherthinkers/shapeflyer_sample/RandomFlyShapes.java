package com.cipherthinkers.shapeflyer_sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.cipherthinkers.shapeflyer.ShapeFlyer;
import com.cipherthinkers.shapeflyer.flyschool.FPoint;
import com.cipherthinkers.shapeflyer.flyschool.FlyBluePrint;
import com.cipherthinkers.shapeflyer.flyschool.FlyPath;
import com.cipherthinkers.shapeflyer.flyschool.PATHS;

import java.util.Random;

public class RandomFlyShapes extends AppCompatActivity implements View.OnClickListener {

    private ShapeFlyer mShapeFlyer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_fly_shapes);

        mShapeFlyer = (ShapeFlyer) findViewById(R.id.floating_container);
        mShapeFlyer.setOnClickListener(this);

        mShapeFlyer.addPath(PATHS.S_INVERTED_TOP_LEFT);
        mShapeFlyer.addPath(PATHS.S_BOTTOM_LEFT);
        mShapeFlyer.addPath(PATHS.S_INVERTED_BOTTOM_RIGHT);
        mShapeFlyer.addPath(PATHS.S_TOP_RIGHT);
        mShapeFlyer.addPath(PATHS.LINE_DIAGONAL_BOTTOM_LEFT);
        mShapeFlyer.addPath(PATHS.LINE_DIAGONAL_BOTTOM_RIGHT);
        mShapeFlyer.addPath(PATHS.LINE_DIAGONAL_TOP_LEFT);
        mShapeFlyer.addPath(PATHS.LINE_DIAGONAL_TOP_RIGHT);
        mShapeFlyer.addPath(PATHS.LINE_MIDDLE_TOP);
        mShapeFlyer.addPath(PATHS.LINE_MIDDLE_BOTTOM);
        mShapeFlyer.addPath(PATHS.LINE_MIDDLE_LEFT);
        mShapeFlyer.addPath(PATHS.LINE_MIDDLE_RIGHT);
        mShapeFlyer.addPath(new FlyBluePrint(new FPoint(0, 0),
                FlyPath.getMultipleLinePath(
                        new FPoint(0.1f, 0f),
                        new FPoint(0.1f, 0.1f),
                        new FPoint(0.2f, 0.1f),
                        new FPoint(0.2f, 0.2f),
                        new FPoint(0.3f, 0.2f),
                        new FPoint(0.3f, 0.3f),
                        new FPoint(0.4f, 0.3f),
                        new FPoint(0.4f, 0.4f),
                        new FPoint(0.5f, 0.4f),
                        new FPoint(0.5f, 0.5f),
                        new FPoint(0.6f, 0.5f),
                        new FPoint(0.6f, 0.6f),
                        new FPoint(0.7f, 0.6f),
                        new FPoint(0.7f, 0.7f),
                        new FPoint(0.8f, 0.7f),
                        new FPoint(0.8f, 0.8f),
                        new FPoint(0.9f, 0.8f),
                        new FPoint(0.9f, 0.9f),
                        new FPoint(1f, 1f)
                )));
    }

    @Override
    public void onClick(View v) {
        int[] drawables = {com.cipherthinkers.shapeflyer.R.drawable.ic_cake, com.cipherthinkers.shapeflyer.R.drawable.ic_heart,
                com.cipherthinkers.shapeflyer.R.drawable.ic_smiley, com.cipherthinkers.shapeflyer.R.drawable.ic_star,
                com.cipherthinkers.shapeflyer.R.drawable.ic_audiotrack, com.cipherthinkers.shapeflyer.R.drawable.ic_flag, com.cipherthinkers.shapeflyer.R.drawable.ic_cloud,
                com.cipherthinkers.shapeflyer.R.drawable.ic_thumb_down, com.cipherthinkers.shapeflyer.R.drawable.ic_thumb_up,
                com.cipherthinkers.shapeflyer.R.drawable.ic_mood_good
        };
        mShapeFlyer.startAnimation(drawables[new Random().nextInt(drawables.length)]);
    }

    @Override
    protected void onDestroy() {
        if(mShapeFlyer != null){
            mShapeFlyer.release();
        }

        super.onDestroy();
    }
}
