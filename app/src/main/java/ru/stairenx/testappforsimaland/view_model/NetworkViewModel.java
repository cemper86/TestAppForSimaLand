package ru.stairenx.testappforsimaland.view_model;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ru.stairenx.testappforsimaland.network.CategoryRepository;
import ru.stairenx.testappforsimaland.view.model.AllCategoty;

public class NetworkViewModel extends ViewModel {

    private CategoryRepository categoryRepository;
    private final Context context;

    @Inject
    public NetworkViewModel(Context context, CategoryRepository categoryRepository) {
        this.context = context;
        this.categoryRepository = categoryRepository;
    }


    public Single<AllCategoty> getCategories(){
        return categoryRepository.getCategories()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    public Single<AllCategoty> getSubCategories(String path){
        return categoryRepository.getSubCategories(path)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
