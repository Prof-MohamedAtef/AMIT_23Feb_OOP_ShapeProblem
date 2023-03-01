package mo.ed.course.two.amit.day.one.view.activities;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.HashMap;

import mo.ed.course.two.amit.day.one.utils.Constants;
import mo.ed.course.two.amit.day.one.R;
import mo.ed.course.two.amit.day.one.databinding.ActivityDrawerBinding;
import mo.ed.course.two.amit.day.one.databinding.DrawerHeaderBinding;
import mo.ed.course.two.amit.day.one.utils.SharedPrefs;

public class DrawerActivity extends AppCompatActivity {

    private ActivityDrawerBinding binding;
    private DrawerHeaderBinding drawerBinding;
    private SharedPrefs sharedPrefs;
    private HashMap<String, String> userSession;
    private String userName;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_drawer);
        drawerBinding = DataBindingUtil.setContentView(this, R.layout.drawer_header);

        sharedPrefs = new SharedPrefs(getApplicationContext());
        userSession = sharedPrefs.getSessionInfo();
        initAppBar();
        drawerBinding.btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DrawerActivity.this, SignInActivity.class));
            }
        });

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(Constants.KEY_USERNAME) && intent.hasExtra(Constants.KEY_EMAIL)) {
            userName = intent.getStringExtra(Constants.KEY_USERNAME);
            email = intent.getStringExtra(Constants.KEY_EMAIL);
            sharedPrefs.setSignInInfo(userName, email);
            showViews();
        } else {
            if (userSession != null) {
                userName = userSession.get(Constants.KEY_USERNAME);
                email = userSession.get(Constants.KEY_EMAIL);
                if (email!=null && userName!=null){
                    showViews();
                }else {
                    drawerBinding.imageView.setVisibility(View.GONE);
                    drawerBinding.tvName.setVisibility(View.GONE);
                    drawerBinding.tvEmail.setVisibility(View.GONE);
                    drawerBinding.btnSignIn.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    private void showViews() {
        drawerBinding.imageView.setVisibility(View.VISIBLE);
        drawerBinding.tvName.setVisibility(View.VISIBLE);
        drawerBinding.tvEmail.setVisibility(View.VISIBLE);
        drawerBinding.btnSignIn.setVisibility(View.GONE);
        drawerBinding.tvName.setText(userName);
        drawerBinding.tvEmail.setText(email);
    }

    private void initAppBar() {
        setSupportActionBar(binding.detailToolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setSupportActionBar(binding.detailToolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        binding.detailToolbar.setNavigationIcon(R.drawable.ic_drawer_orange);

        // Initializing Drawer Layout and ActionBarToggle
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, binding.navDrawer, binding.detailToolbar, R.string.openDrawer, R.string.closeDrawer) {
            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };

        actionBarDrawerToggle.setDrawerIndicatorEnabled(false);
        actionBarDrawerToggle.setHomeAsUpIndicator(R.drawable.ic_drawer_orange);
        //Setting the actionbarToggle to drawer layout
        binding.navDrawer.setDrawerListener(actionBarDrawerToggle);
        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();
        actionBarDrawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.navDrawer.isDrawerVisible(GravityCompat.START)) {
                    binding.navDrawer.closeDrawer(GravityCompat.START);
                } else {
                    binding.navDrawer.openDrawer(GravityCompat.START);
                }
            }
        });
    }
}