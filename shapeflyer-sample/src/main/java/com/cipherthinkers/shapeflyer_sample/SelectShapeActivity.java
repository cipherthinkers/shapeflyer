package com.cipherthinkers.shapeflyer_sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.cipherthinkers.shapeflyer.ShapeFlyer;
import com.cipherthinkers.shapeflyer.flyschool.FPoint;
import com.cipherthinkers.shapeflyer.flyschool.FlyBluePrint;
import com.cipherthinkers.shapeflyer.flyschool.FlyPath;
import com.cipherthinkers.shapeflyer.flyschool.PATHS;

import java.util.ArrayList;
import java.util.Random;

public class SelectShapeActivity extends AppCompatActivity implements View.OnClickListener{

    private ShapeFlyer mShapeFlyer;
    private Spinner mPathSpinner, mShapeSpinner;

    private ArrayList<Integer> mShapeDrawableIds;
    private ArrayList<FlyBluePrint> mFlyBluePrints;
    private ArrayList<String> mFlyBluePrintsName;
    private ArrayAdapter mPathsAdapter;
    private ImageArrayAdapter mShapesAdapter;
    private Button mStartAnimationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_shape);

        mFlyBluePrints = new ArrayList<>();
        mFlyBluePrintsName = new ArrayList<>();
        mFlyBluePrints.add(PATHS.S_INVERTED_TOP_LEFT.getmFlyBluePrint());
        mFlyBluePrintsName.add("S-INVERTED TOP_LEFT");

        mFlyBluePrints.add(PATHS.S_BOTTOM_LEFT.getmFlyBluePrint());
        mFlyBluePrintsName.add("S BOTTOM_LEFT");

        mFlyBluePrints.add(PATHS.S_INVERTED_BOTTOM_RIGHT.getmFlyBluePrint());
        mFlyBluePrintsName.add("S-INVERTED BOTTOM_RIGHT");

        mFlyBluePrints.add(PATHS.S_TOP_RIGHT.getmFlyBluePrint());
        mFlyBluePrintsName.add("S TOP_RIGHT");

        mFlyBluePrints.add(PATHS.LINE_DIAGONAL_BOTTOM_LEFT.getmFlyBluePrint());
        mFlyBluePrintsName.add("LINE-DIAGONAL BOTTOM_LEFT");

        mFlyBluePrints.add(PATHS.LINE_DIAGONAL_BOTTOM_RIGHT.getmFlyBluePrint());
        mFlyBluePrintsName.add("LINE-DIAGONAL BOTTOM_RIGHT");

        mFlyBluePrints.add(PATHS.LINE_DIAGONAL_TOP_LEFT.getmFlyBluePrint());
        mFlyBluePrintsName.add("LINE-DIAGONAL TOP_LEFT");

        mFlyBluePrints.add(PATHS.LINE_DIAGONAL_TOP_RIGHT.getmFlyBluePrint());
        mFlyBluePrintsName.add("LINE-DIAGONAL TOP_RIGHT");

        mFlyBluePrints.add(PATHS.LINE_MIDDLE_TOP.getmFlyBluePrint());
        mFlyBluePrintsName.add("LINE-MIDDLE TOP");

        mFlyBluePrints.add(PATHS.LINE_MIDDLE_BOTTOM.getmFlyBluePrint());
        mFlyBluePrintsName.add("LINE-MIDDLE BOTTOM");

        mFlyBluePrints.add(PATHS.LINE_MIDDLE_LEFT.getmFlyBluePrint());
        mFlyBluePrintsName.add("LINE-MIDDLE LEFT");

        mFlyBluePrints.add(PATHS.LINE_MIDDLE_RIGHT.getmFlyBluePrint());
        mFlyBluePrintsName.add("LINE-MIDDLE RIGHT");

        mFlyBluePrints.add(new FlyBluePrint(new FPoint(0, 0),
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
        mFlyBluePrintsName.add("MULTIPLE-LINE STAIRCASE");

        mShapeFlyer = (ShapeFlyer) findViewById(R.id.shape_flyer);
        mShapeFlyer.setOnClickListener(this);
        mPathSpinner = (Spinner) findViewById(R.id.path_spinner);
        mPathsAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, mFlyBluePrintsName);
        mPathsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mPathSpinner.setAdapter(mPathsAdapter);


        mShapeDrawableIds = new ArrayList<>();
        mShapeDrawableIds.add(com.cipherthinkers.shapeflyer.R.drawable.ic_cake);
        mShapeDrawableIds.add(com.cipherthinkers.shapeflyer.R.drawable.ic_heart);
        mShapeDrawableIds.add(com.cipherthinkers.shapeflyer.R.drawable.ic_star);
        mShapeDrawableIds.add(com.cipherthinkers.shapeflyer.R.drawable.ic_audiotrack);
        mShapeDrawableIds.add(com.cipherthinkers.shapeflyer.R.drawable.ic_flag);
        mShapeDrawableIds.add(com.cipherthinkers.shapeflyer.R.drawable.ic_cloud);
        mShapeDrawableIds.add(com.cipherthinkers.shapeflyer.R.drawable.ic_thumb_down);
        mShapeDrawableIds.add(com.cipherthinkers.shapeflyer.R.drawable.ic_thumb_up);
        mShapeDrawableIds.add(com.cipherthinkers.shapeflyer.R.drawable.ic_mood_bad);


        mShapeSpinner = (Spinner) findViewById(R.id.shape_spinner);
        mShapesAdapter = new ImageArrayAdapter(this, R.layout.spinner_shape_item, R.id.text, mShapeDrawableIds);
        mShapeSpinner.setAdapter(mShapesAdapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.shape_flyer:
                mShapeFlyer.clearPaths();
                mShapeFlyer.addPath(mFlyBluePrints.get(mPathSpinner.getSelectedItemPosition()));
                mShapeFlyer.startAnimation(mShapeDrawableIds.get(mShapeSpinner.getSelectedItemPosition()));
                break;
        }
    }

}
