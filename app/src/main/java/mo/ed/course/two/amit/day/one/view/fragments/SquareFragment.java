package mo.ed.course.two.amit.day.one.view.fragments;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import mo.ed.course.two.amit.day.one.R;
import mo.ed.course.two.amit.day.one.area.Square;
import mo.ed.course.two.amit.day.one.databinding.SquareFragmentBinding;
import mo.ed.course.two.amit.day.one.view.activities.MainActivity;

public class SquareFragment extends Fragment {

    private SquareFragmentBinding binding;
    private Double mLength;
    private Square square;
    private double mArea;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding= DataBindingUtil.inflate(inflater, R.layout.square_fragment,container,false);
        binding.btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(binding.etLength.getText())){
                    binding.tvResult.setText("Result");
                    mLength= Double.valueOf(binding.etLength.getText().toString());
                    square=new Square();
                    mArea=square.area(mLength);
                    binding.tvResult.append(" : "+ mArea);
//                    hideKeyboard(MainActivity.this);
                }
            }
        });
        return binding.getRoot();
    }
}
