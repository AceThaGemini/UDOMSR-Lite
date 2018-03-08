package tz.ac.udom.udomsrlite.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;
import android.widget.TextView;

import tz.ac.udom.udomsrlite.R;


/**
 * Created by ali on 11/19/17.
 */

public class DialogHelper {

    public static AlertDialog buildProgressDialog(Activity activity, String message, boolean isCancelable) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(activity);
        View dialogView = activity.getLayoutInflater().inflate(R.layout.layout_progress_dialog, null);

        dialogBuilder.setView(dialogView).setCancelable(isCancelable);

        ((TextView) dialogView.findViewById(R.id.textDialogMessage)).setText(message);


        return dialogBuilder.create();
    }

    public static AlertDialog buildConfirmDialog(Activity activity, String message, boolean isCancelable) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(activity);
        View dialogView = activity.getLayoutInflater().inflate(R.layout.layout_confirm_dialog, null);

        dialogBuilder.setView(dialogView).setCancelable(isCancelable);

        ((TextView) dialogView.findViewById(R.id.textDialogMessage)).setText(message);


        return dialogBuilder.create();
    }

    public static AlertDialog buildSimpleMessageDialog(Activity activity, String message, boolean isCancelable) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(activity);
        final View dialogView = activity.getLayoutInflater().inflate(R.layout.layout_simple_message_dialog, null);

        dialogBuilder.setView(dialogView).setCancelable(isCancelable);

        final AlertDialog alertDialog = dialogBuilder.create();
        ((TextView) dialogView.findViewById(R.id.textDialogMessage)).setText(message);
        dialogView.findViewById(R.id.textOk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });


        return alertDialog;
    }
}
