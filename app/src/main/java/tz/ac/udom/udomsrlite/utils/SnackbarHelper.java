package tz.ac.udom.udomsrlite.utils;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by ali on 1/11/18.
 */

public class SnackbarHelper {

    public static void makeSnackbar(View view, String message, int duration) {
        Snackbar.make(view,
                message,
                duration).show();
    }

}
