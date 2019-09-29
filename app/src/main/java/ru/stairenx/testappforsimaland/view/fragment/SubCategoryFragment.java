package ru.stairenx.testappforsimaland.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.observers.DisposableSingleObserver;
import ru.stairenx.testappforsimaland.R;
import ru.stairenx.testappforsimaland.databinding.FragmentSubcategoryBinding;
import ru.stairenx.testappforsimaland.view.adapter.SubCategoryAdapter;
import ru.stairenx.testappforsimaland.view.model.AllCategoty;
import ru.stairenx.testappforsimaland.view.model.CategoryModel;

public class SubCategoryFragment  extends AbstractFragment {

    private FragmentSubcategoryBinding binding;
    private List<CategoryModel> data;
    private SubCategoryAdapter subcategoryAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_subcategory,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.setToolbar(toolbarViewModel);
        toolbarViewModel.getOnBackClickLiveData().observe(this, aBoolean -> {
            if (aBoolean != null && aBoolean) {
                Navigation.findNavController(binding.getRoot()).popBackStack();
            }
        });

        networkViewModel.getSubCategories(getArguments().getString("path"))
                .subscribe(new DisposableSingleObserver<AllCategoty>() {
                    @Override
                    public void onSuccess(AllCategoty allCategoty) {
                        if(data.size() > 0){
                            data = new ArrayList<>();
                        }
                        data.addAll(allCategoty.items);
                        subcategoryAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    @Override
    public void initToolbar() {
        toolbarViewModel.setToolbarTitle(getArguments().getString("name"));
        toolbarViewModel.setCurrentFragment(this);
    }

    @Override
    public void initRecyclerView() {
        if (subcategoryAdapter == null) {
            if(data == null) data = new ArrayList<>();
            subcategoryAdapter = new SubCategoryAdapter(data);
        }
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(subcategoryAdapter);
    }
}
