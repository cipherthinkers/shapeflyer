package com.cipherthinkers.shapeflyer;

import android.content.res.Resources;
import android.os.Build;

/**
 * Utility class with simple utility functions
 * Created by avin on 09/01/17.
 */

public class Utils {
    /**
     * @param dp : Dimension in dp
     *           Calculates and returns the dimension value in pixels from dp
     * */
    public static int dpToPx(int dp) {
        return (int) ((dp * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    /**
     * Checks and tell us whether the android phone is on version < LOLLIPOP or not
     * */
    public static boolean isLowerThanLollipop() {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP;
    }
}
