package ru.stairenx.testappforsimaland.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import ru.stairenx.testappforsimaland.R;
import ru.stairenx.testappforsimaland.databinding.FragmentProfileBinding;

public class ProfileFragment extends AbstractFragment {

    private FragmentProfileBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.setToolbar(toolbarViewModel);
    }

    @Override
    public void initToolbar() {
        toolbarViewModel.setToolbarTitle("Профиль");
        toolbarViewModel.setCurrentFragment(this);
    }

    @Override
    public void initRecyclerView() {

    }
}
