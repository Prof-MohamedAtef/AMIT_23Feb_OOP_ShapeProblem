package mo.ed.course.two.amit.day.one.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import mo.ed.course.two.amit.day.one.R;
import mo.ed.course.two.amit.day.one.databinding.ActivityRectangleBinding;

public class RectangleActivity extends AppCompatActivity {

    private ActivityRectangleBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_rectangle);
    }
}