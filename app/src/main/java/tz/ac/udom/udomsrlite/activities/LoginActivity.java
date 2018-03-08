package tz.ac.udom.udomsrlite.activities;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import tz.ac.udom.udomsrlite.R;
import tz.ac.udom.udomsrlite.utils.DialogHelper;
import tz.ac.udom.udomsrlite.utils.SnackbarHelper;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextUsername, editTextPassword;
    private AlertDialog progressDialog;
    private CoordinatorLayout coordinatorLayout;

    private static final String TAG = LoginActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        coordinatorLayout = findViewById(R.id.coordinatorLayout);

        progressDialog = DialogHelper.buildProgressDialog(
                LoginActivity.this,
                "Please Wait...",
                false);

        findViewById(R.id.buttonLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // do magic
                if (isFormValid()) {
                    onStartLogin();

                }
            }
        });
    }


    private boolean isFormValid() {

        if (TextUtils.isEmpty(editTextUsername.getText())
                || TextUtils.isEmpty(editTextPassword.getText())) {
            // show err
            SnackbarHelper.makeSnackbar(coordinatorLayout,
                    "Please enter all required fields.",
                    2000);
            return false;

        } else {
            return true;
        }
    }


    private void onStartLogin() {
        // TODO: 3/7/18 initialize login process
        if (!progressDialog.isShowing())
            progressDialog.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onSuccessLogin();
            }
        }, 2000);
    }


    private void onSuccessLogin() {
        // TODO: 3/7/18 take user to main activity after successful login
        if (progressDialog.isShowing())
            progressDialog.dismiss();

        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        // clear top
        finish();
    }
}
