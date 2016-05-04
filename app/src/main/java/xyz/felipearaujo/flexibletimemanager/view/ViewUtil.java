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

    public static String secToText(long time, boolean omitSeconds) {
        StringBuilder formatedTime = new StringBuilder();

        if(time/3600 < 10) {
            formatedTime.append("0");
        }

        formatedTime.append(time/3600);
        formatedTime.append(":");
        time = time % 3600;

        if(time/60 < 10) {
            formatedTime.append("0");
        }

        formatedTime.append(time/60);
        time = time % 60;

        if(!omitSeconds) {
            formatedTime.append(":");

            if(time < 10) {
                formatedTime.append("0");
            }

            formatedTime.append(time);
        }

        return formatedTime.toString();
    }
}
