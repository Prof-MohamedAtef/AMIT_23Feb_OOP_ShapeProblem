package mo.ed.course.two.amit.day.one.view.fragments.bottomfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import mo.ed.course.two.amit.day.one.R;
import mo.ed.course.two.amit.day.one.databinding.DealLayoutBinding;
import mo.ed.course.two.amit.day.one.databinding.FavoriteLayoutBinding;

public class FavoriteFragment extends Fragment {
    private FavoriteLayoutBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding= DataBindingUtil.inflate(inflater, R.layout.favorite_layout,container,false);
        return binding.getRoot();
    }
}
