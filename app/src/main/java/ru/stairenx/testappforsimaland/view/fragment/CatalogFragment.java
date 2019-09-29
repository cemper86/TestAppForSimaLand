package ru.stairenx.testappforsimaland.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.observers.DisposableSingleObserver;
import ru.stairenx.testappforsimaland.R;
import ru.stairenx.testappforsimaland.databinding.FragmentCatalogBinding;
import ru.stairenx.testappforsimaland.view.adapter.CatalogAdapter;
import ru.stairenx.testappforsimaland.view.adapter.SettingsGridDecorator;
import ru.stairenx.testappforsimaland.view.model.AllCategoty;
import ru.stairenx.testappforsimaland.view.model.CategoryModel;

public class CatalogFragment extends AbstractFragment implements OnRefreshListener {

    private FragmentCatalogBinding binding;
    private List<CategoryModel> data;

    private CatalogAdapter catalogAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_catalog,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.refresh.setOnRefreshListener(this);
        updateList();
    }

    @Override
    public void initToolbar() {

    }

    @Override
    public void initRecyclerView(){
        if (catalogAdapter == null) {
            if(data == null) data = new ArrayList<>();
            catalogAdapter = new CatalogAdapter(data, model -> listener.showSubCategoryFragment(model));
        }
        binding.recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        binding.recyclerView.addItemDecoration(new SettingsGridDecorator(4));
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setAdapter(catalogAdapter);
    }

    @Override
    public void onRefresh() {
        updateList();
    }

    private void updateList(){
        binding.refresh.setRefreshing(true);
        networkViewModel.getCategories()
                .subscribe(new DisposableSingleObserver<AllCategoty>() {
                    @Override
                    public void onSuccess(AllCategoty allCategoty) {
                        if(data.size() > 0){
                            data = new ArrayList<>();
                        }
                        data.addAll(allCategoty.items);
                        catalogAdapter.notifyDataSetChanged();
                        binding.refresh.setRefreshing(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        binding.refresh.setRefreshing(false);
                    }
        });
    }
}
