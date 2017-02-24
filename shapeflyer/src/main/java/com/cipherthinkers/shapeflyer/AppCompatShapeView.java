package com.cipherthinkers.shapeflyer;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * * ShapeView to be used inside {@link ShapeFlyer}
 * for Android < LOLLIPOP
 *
 * Created by avin on 30/01/17.
 */

public class AppCompatShapeView extends AppCompatImageView implements ShapeSetter{
    public AppCompatShapeView(Context context) {
        super(context);
        init();
    }

    public AppCompatShapeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AppCompatShapeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        setImageResource(R.drawable.ic_heart);
    }

    /**
     * @param drawable : Drawable resource id
     *
     * Setter method that sets the source in {@link AppCompatShapeView}
     * */
    @Override
    public void setShape(int drawable){
        setImageResource(drawable);
    }
}
