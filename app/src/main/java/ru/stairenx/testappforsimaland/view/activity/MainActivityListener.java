package ru.stairenx.testappforsimaland.view.activity;

import ru.stairenx.testappforsimaland.view.model.CategoryModel;

public interface MainActivityListener {

    void showCatalogFragment();

    void showCartFragment();

    void showProfileFragment();

    void showSubCategoryFragment(CategoryModel model);
}
