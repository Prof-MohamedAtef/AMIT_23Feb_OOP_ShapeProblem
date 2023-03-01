package mo.ed.course.two.amit.day.one.view.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import mo.ed.course.two.amit.day.one.R;
import mo.ed.course.two.amit.day.one.databinding.ActivityBottomNavigationViewBinding;
import mo.ed.course.two.amit.day.one.view.fragments.SquareFragment;
import mo.ed.course.two.amit.day.one.view.fragments.bottomfragments.FavoriteFragment;
import mo.ed.course.two.amit.day.one.view.fragments.bottomfragments.MusicFragment;
import mo.ed.course.two.amit.day.one.view.fragments.bottomfragments.NewsFragment;
import mo.ed.course.two.amit.day.one.view.fragments.bottomfragments.PlacesFragment;

public class BottomNavigationViewActivity extends AppCompatActivity {

    private ActivityBottomNavigationViewBinding binding;
    private String[] menus ={"Favorite", "Music","Places","News"};
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bottom_navigation_view);
        binding.bottomNavigationview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.favorite:
                        binding.deliveryLocationLayout.tvDeliverTo.setText(menus[0]);
                        fragment=new FavoriteFragment();
                        loadFragment(fragment);
                        return true;
                    case R.id.music:
                        binding.deliveryLocationLayout.tvDeliverTo.setText(menus[1]);
                        fragment=new MusicFragment();
                        loadFragment(fragment);
                        return true;
                    case R.id.places:
                        binding.deliveryLocationLayout.tvDeliverTo.setText(menus[2]);
                        fragment=new PlacesFragment();
                        loadFragment(fragment);
                        return true;
                    case R.id.news:
                        binding.deliveryLocationLayout.tvDeliverTo.setText(menus[3]);
                        fragment=new NewsFragment();
                        loadFragment(fragment);
                        return true;
                }
                return false;
            }
        });
    }

    private void loadFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(binding.frameLayout.getId(), fragment)
                .commitAllowingStateLoss();

    }
}