package mo.ed.course.two.amit.day.one.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import mo.ed.course.two.amit.day.one.utils.Constants;
import mo.ed.course.two.amit.day.one.R;
import mo.ed.course.two.amit.day.one.databinding.ActivitySignInBinding;

public class SignInActivity extends AppCompatActivity {

    private ActivitySignInBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in);
        binding.btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(binding.etUserName.getText()) && !TextUtils.isEmpty(binding.etEmail.getText().toString())) {
                    if(isValidUserName(binding.etUserName.getText().toString())) {
                        if (isValidEmail(binding.etEmail.getText().toString())){
                            /*
                            show progress Dialogue
                             */
                            startActivity(new Intent(SignInActivity.this, DrawerActivity.class)
                                    .putExtra(Constants.KEY_USERNAME, binding.etUserName.getText().toString())
                                    .putExtra(Constants.KEY_EMAIL, binding.etEmail.getText().toString()));
                            finish();
                        }else {
                            binding.etEmail.setError("Invalid Email");
                        }
                    }else {
                        binding.etUserName.setError("username must be at least 8 chars.");
                    }
                }
            }
        });
    }

    private boolean isValidUserName(String userName) {
        if (userName.length() >= 8) {
            Toast.makeText(getApplicationContext(), "valid username", Toast.LENGTH_SHORT).show();
            // or
            return true;
        } else {
            Toast.makeText(getApplicationContext(), "Invalid username", Toast.LENGTH_SHORT).show();
            //or
            return false;
        }
    }


    private boolean isValidEmail(String email) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (email.matches(emailPattern)) {
            Toast.makeText(getApplicationContext(), "valid email address", Toast.LENGTH_SHORT).show();
            // or
            return true;
        } else {
            Toast.makeText(getApplicationContext(), "Invalid email address", Toast.LENGTH_SHORT).show();
            //or
            return false;
        }
    }
}