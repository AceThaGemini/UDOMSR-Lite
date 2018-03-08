package tz.ac.udom.udomsrlite.activities;

import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import java.text.SimpleDateFormat;
import java.util.Locale;

import tz.ac.udom.udomsrlite.R;
import tz.ac.udom.udomsrlite.adapters.SessionListAdapter;
import tz.ac.udom.udomsrlite.utils.TopBottomSpaceDecoration;

public class SessionsListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CoordinatorLayout coordinatorLayout;
    private LayoutAnimationController animationController;

    private static final String TAG = SessionsListActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sessions_list);
        setSupportActionBar((Toolbar) findViewById(R.id.mToolbar));

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        coordinatorLayout = findViewById(R.id.coordinatorLayout);
        recyclerView = findViewById(R.id.recyclerView);


        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE", Locale.getDefault());
        String day = dateFormat.format(System.currentTimeMillis());

        actionBar.setTitle(day + " Sessions");

        // manager
        recyclerView.setLayoutManager(new LinearLayoutManager(SessionsListActivity.this));

        // decoration
        recyclerView.addItemDecoration(new TopBottomSpaceDecoration(SessionsListActivity.this));


        // animation
        animationController = AnimationUtils.loadLayoutAnimation(
                SessionsListActivity.this, R.anim.layout_animation_fall_down);
        // animationController.setDelay(200);
        recyclerView.setLayoutAnimation(animationController);

        // adapter
        SessionListAdapter adapter = new SessionListAdapter(SessionsListActivity.this);
        recyclerView.setAdapter(adapter);
        recyclerView.scheduleLayoutAnimation();

        // TODO: 3/8/18 fetch sessions from db and to list

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
}
