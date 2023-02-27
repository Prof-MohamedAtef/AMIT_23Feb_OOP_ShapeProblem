package mo.ed.course.two.amit.day.one.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.os.Bundle;

import mo.ed.course.two.amit.day.one.R;
import mo.ed.course.two.amit.day.one.databinding.ActivityFavoriteFoodBinding;
import mo.ed.course.two.amit.day.one.view.fragments.HeaderFragment;

public class FavoriteFoodActivity extends AppCompatActivity {

    private ActivityFavoriteFoodBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_favorite_food);
        initAppBar();
        getSupportFragmentManager().beginTransaction().replace(binding.headerFrame.getId(), new HeaderFragment())
                .commitAllowingStateLoss();
    }

    private void initAppBar() {
        setSupportActionBar(binding.detailToolbar);
        assert getSupportActionBar()!=null;
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
}