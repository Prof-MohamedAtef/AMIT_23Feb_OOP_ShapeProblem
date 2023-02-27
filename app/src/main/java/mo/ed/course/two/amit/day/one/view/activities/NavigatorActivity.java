package mo.ed.course.two.amit.day.one.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.os.Bundle;

import mo.ed.course.two.amit.day.one.R;
import mo.ed.course.two.amit.day.one.databinding.ActivityNavigatorBinding;
import mo.ed.course.two.amit.day.one.view.fragments.SquareFragment;

public class NavigatorActivity extends AppCompatActivity {

    private ActivityNavigatorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_navigator);
        getSupportFragmentManager().beginTransaction().replace(binding.frameSquare.getId(), new SquareFragment())
                .commitAllowingStateLoss();

    }
}