package com.cipherthinkers.shapeflyer;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * ShapeView to be used inside {@link ShapeFlyer}
 * for Android >= LOLLIPOP
 * Created by avin on 31/01/17.
 */

public class ShapeView extends ImageView implements ShapeSetter{
    public ShapeView(Context context) {
        super(context);
        init();
    }

    public ShapeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ShapeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ShapeView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
        setImageResource(R.drawable.ic_heart);
    }

    /**
     * @param drawable : Drawable resource id
     *
     * Setter method that sets the source in {@link ShapeView}
     * */
    @Override
    public void setShape(int drawable){
        setImageResource(drawable);
    }
}
