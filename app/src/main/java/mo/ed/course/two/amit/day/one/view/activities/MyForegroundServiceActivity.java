package mo.ed.course.two.amit.day.one.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import mo.ed.course.two.amit.day.one.R;
import mo.ed.course.two.amit.day.one.databinding.ActivityMyForegroundServiceBinding;
import mo.ed.course.two.amit.day.one.services.MyForegroundService;
import mo.ed.course.two.amit.day.one.utils.Constants;

public class MyForegroundServiceActivity extends AppCompatActivity {

    private Intent foregroundIntent;
    private ActivityMyForegroundServiceBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_my_foreground_service);

        foregroundIntent=new Intent(MyForegroundServiceActivity.this, MyForegroundService.class);

        binding.btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // main thread
                new Thread(new Runnable() { // background
                    @Override
                    public void run() {
                        startService(); // Background Thread
                    }
                });
//                startService(); // main thread - > block ui / ANR ( Application Not responding - Ui freezing
            }
        });

        binding.btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService_();
            }
        });
    }

    private void stopService_(){
        stopService(foregroundIntent);
    }

    private void startService(){
        foregroundIntent.putExtra(Constants.FOREGROUND_SERVICE_INTENT,"Foreground Service is running ...");
        ContextCompat.startForegroundService(MyForegroundServiceActivity.this, foregroundIntent);
    }
}