package ru.stairenx.testappforsimaland.network;

import androidx.lifecycle.LiveData;

import javax.inject.Inject;

import io.reactivex.Single;
import ru.stairenx.testappforsimaland.view.model.AllCategoty;

public class CategoryRepository {

    private CategoryService categoryService;

    @Inject
    public CategoryRepository(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public Single<AllCategoty> getCategories(){
        return categoryService.getCategory(1, 1, 1, 1,
                "priority_home", 1, "name_alias");
    }

    public Single<AllCategoty> getSubCategories(String path){
        return categoryService.getSubCategory(1,1,"priority",
                1,"name_alias",2, path);
    }

}
