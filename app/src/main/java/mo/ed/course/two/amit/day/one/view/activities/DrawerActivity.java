package mo.ed.course.two.amit.day.one.view.activities;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.os.Bundle;
import android.view.View;

import mo.ed.course.two.amit.day.one.R;
import mo.ed.course.two.amit.day.one.databinding.ActivityDrawerBinding;

public class DrawerActivity extends AppCompatActivity {

    private ActivityDrawerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_drawer);
        initAppBar();
    }

    private void initAppBar() {
        setSupportActionBar(binding.detailToolbar);
        assert getSupportActionBar()!=null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setSupportActionBar(binding.detailToolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        binding.detailToolbar.setNavigationIcon(R.drawable.ic_drawer_orange);

        // Initializing Drawer Layout and ActionBarToggle
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,binding.navDrawer, binding.detailToolbar, R.string.openDrawer, R.string.closeDrawer){
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