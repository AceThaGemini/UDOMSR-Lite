package tz.ac.udom.udomsrlite.activities;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Locale;

import tz.ac.udom.udomsrlite.R;
import tz.ac.udom.udomsrlite.utils.SnackbarHelper;

public class SessionDetailActivity extends AppCompatActivity {

    private LinearLayout layoutLoginTime, layoutLogoutTime;
    private CheckBox checkInstructorShowedUp;
    private TextView textStartTime, textEndTime;
    private FloatingActionButton fab;
    private CoordinatorLayout coordinatorLayout;

    private long pickedTime = 0;

    private static final String TAG = SessionDetailActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session_detail);
        setSupportActionBar((Toolbar) findViewById(R.id.mToolbar));

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Course Code : Course Name");

        layoutLoginTime = findViewById(R.id.layoutLoginTime);
        layoutLogoutTime = findViewById(R.id.layoutLogoutTime);
        textStartTime = findViewById(R.id.textStartTime);
        textEndTime = findViewById(R.id.textEndTime);
        fab = findViewById(R.id.fab);
        coordinatorLayout = findViewById(R.id.coordinatorLayout);

        textStartTime.setText("--:--");
        textEndTime.setText("--:--");

        checkInstructorShowedUp = findViewById(R.id.checkInstructorShowedUp);
        checkInstructorShowedUp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                if (isChecked) {
                    layoutLoginTime.setVisibility(View.VISIBLE);
                    layoutLogoutTime.setVisibility(View.VISIBLE);
                } else {
                    layoutLoginTime.setVisibility(View.GONE);
                    layoutLogoutTime.setVisibility(View.GONE);
                }
            }
        });
        // default check;
        checkInstructorShowedUp.setChecked(false);


        layoutLoginTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // pick login time
                pickTime(R.id.textStartTime);
            }
        });


        layoutLogoutTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // pick logout time
                pickTime(R.id.textEndTime);
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: 3/8/18 submit session records
                SnackbarHelper.makeSnackbar(coordinatorLayout,
                        "Session records will be submitted.",
                        2000);
            }
        });


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void pickTime(final int targetId) {

        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {
                // get selected time
                Log.d(TAG, "onTimeSet: h=" + hourOfDay + ", m=" + minute + ", s=" + second);

                Time time = new Time(hourOfDay, minute, second);
                pickedTime = time.getTime();
                // SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm aa", Locale.US); // 04:00 pm
                SimpleDateFormat timeFormat = new SimpleDateFormat("kk:mm", Locale.US); // 16:00
                Log.d(TAG, "time=" + time.getTime() + " pretty=" + timeFormat.format(pickedTime));
                // update views
                if (targetId == R.id.textStartTime) {
                    textStartTime.setText(timeFormat.format(time));
                } else {
                    textEndTime.setText(timeFormat.format(time));
                }

            }
        };

        // start from 08:00 am
        TimePickerDialog timePickerDialog = TimePickerDialog.newInstance(onTimeSetListener,
                8,
                0,
                0,
                false);

        if (targetId == R.id.textStartTime)
            timePickerDialog.setTitle("Instructor In Time");
        else
            timePickerDialog.setTitle("Instructor Out Time");

        timePickerDialog.setAccentColor(ContextCompat.getColor(getApplicationContext(), R.color.color_primary));
        timePickerDialog.setOkColor(ContextCompat.getColor(getApplicationContext(), android.R.color.holo_blue_light));
        timePickerDialog.setCancelColor(ContextCompat.getColor(getApplicationContext(), android.R.color.holo_red_light));

        // show dialog
        timePickerDialog.show(getFragmentManager(), "TimePickerDialog");
    }
}
