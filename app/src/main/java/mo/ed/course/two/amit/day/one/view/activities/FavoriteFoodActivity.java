package mo.ed.course.two.amit.day.one.view.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import mo.ed.course.two.amit.day.one.R;
import mo.ed.course.two.amit.day.one.databinding.ActivityFavoriteFoodBinding;
import mo.ed.course.two.amit.day.one.view.fragments.DealFragment;
import mo.ed.course.two.amit.day.one.view.fragments.HeaderFragment;
import mo.ed.course.two.amit.day.one.view.fragments.RestaurantFragment;

public class FavoriteFoodActivity extends AppCompatActivity {

    private ActivityFavoriteFoodBinding binding;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_favorite_food);
        getSupportFragmentManager().beginTransaction().replace(binding.headerFrame.getId(), new HeaderFragment())
                .commitAllowingStateLoss();
        getSupportFragmentManager().beginTransaction().replace(binding.dealFrame.getId(), new DealFragment())
                .commitAllowingStateLoss();
        getSupportFragmentManager().beginTransaction().replace(binding.restaurantsFrame.getId(), new RestaurantFragment())
                .commitAllowingStateLoss();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater= getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.settings:
                intent=new Intent(this, SettingsActivity.class); // explicit intent
                startActivity(intent);
            case R.id.share:
                PackageManager pm=getPackageManager();
                try {

                    Intent waIntent = new Intent(Intent.ACTION_SEND);
                    waIntent.setType("text/plain");
                    String text = "YOUR TEXT HERE";

//                    PackageInfo info=pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);
                    //Check if package exists or not. If not then code
                    //in catch block will be called
                    waIntent.setPackage("com.whatsapp");

                    waIntent.putExtra(Intent.EXTRA_TEXT, text);
                    startActivity(Intent.createChooser(waIntent, "Share with"));

                } catch (Exception e) {
                    Toast.makeText(this, "WhatsApp not Installed", Toast.LENGTH_SHORT)
                            .show();
                }
                return true;
            case R.id.browse:
                String url="https://www.google.com";
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url)); // implicit Intent
                startActivity(intent);
                return true;
            case R.id.call:
                if (ContextCompat.checkSelfPermission(this,android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, (new String[]{android.Manifest.permission.CALL_PHONE}),
                            2);
                } else {
                    String phone = "+34666777888";
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                    startActivity(intent);
                }
                return true;
            case R.id.location:
                String uri = "geo: "+31.00023+","+30.0783 +
                        "?q="+31.00023+","+30.0783;
                startActivity(new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri)));
                return true;
        }
        return true;
    }
}