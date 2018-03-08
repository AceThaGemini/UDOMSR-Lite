package tz.ac.udom.udomsrlite.activities;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import tz.ac.udom.udomsrlite.R;
import tz.ac.udom.udomsrlite.fragments.MainFragment;
import tz.ac.udom.udomsrlite.utils.DialogHelper;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private CoordinatorLayout coordinatorLayout;
    private ActionBarDrawerToggle drawerToggle;
    private AlertDialog confirmLogoutDialog;

    private MainFragment mainFragment;
    private FragmentManager fragmentManager;

    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar) findViewById(R.id.mToolbar));

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        drawerLayout = findViewById(R.id.drawerLayout);
        coordinatorLayout = findViewById(R.id.coordinatorLayout);

        // drawer toggle
        drawerToggle = new ActionBarDrawerToggle(
                MainActivity.this,
                drawerLayout,
                R.string.drawer_open,
                R.string.drawer_close);
        drawerLayout.setDrawerListener(drawerToggle);

        buildConfirmLogoutDialog();

        mainFragment = new MainFragment();
        fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .replace(R.id.mainContentPane, mainFragment)
                .commitNow();


    }


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.optLogout:
                confirmLogoutDialog.show();

                confirmLogoutDialog.findViewById(R.id.positiveButton).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        logout();
                    }
                });

                confirmLogoutDialog.findViewById(R.id.negativeButton).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // cancel logout
                        confirmLogoutDialog.dismiss();
                    }
                });
                return true;

            default:
                return drawerToggle.onOptionsItemSelected(item)
                        || super.onOptionsItemSelected(item);
        }
    }


    private void buildConfirmLogoutDialog() {
        confirmLogoutDialog = DialogHelper.buildConfirmDialog(
                MainActivity.this,
                "Logout of your account?",
                true);
    }


    private void logout(){
        // TODO: 3/7/18 logout user
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
        finish();
    }


}
