package xyz.felipearaujo.flexibletimemanager.view;

import android.content.Context;

/**
 * Created by Felipe on 03/05/2016.
 */
public class ViewUtil {
    public static int dpToPx(final Context context, int dp) {
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }

    public static int spToPx(Context context, int sp) {
        return (int) (sp * context.getResources().getDisplayMetrics().scaledDensity);
    }
}
