package ru.stairenx.testappforsimaland.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import javax.inject.Inject;

import ru.stairenx.testappforsimaland.AndroidApplication;
import ru.stairenx.testappforsimaland.view.activity.MainActivityListener;
import ru.stairenx.testappforsimaland.view_model.NetworkViewModel;
import ru.stairenx.testappforsimaland.view_model.ToolbarViewModel;

public abstract class AbstractFragment extends Fragment {

    @Inject
    public ViewModelProvider.Factory factory;

    public MainActivityListener listener;
    public ToolbarViewModel toolbarViewModel;
    public NetworkViewModel networkViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplication.getInstance().inject(this);
        toolbarViewModel = ViewModelProviders.of(this, factory).get(ToolbarViewModel.class);
        networkViewModel = ViewModelProviders.of(this, factory).get(NetworkViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initToolbar();
        initRecyclerView();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof MainActivityListener) {
            listener = (MainActivityListener) context;
        }
    }

    public abstract void initToolbar();

    public abstract void initRecyclerView();

}
