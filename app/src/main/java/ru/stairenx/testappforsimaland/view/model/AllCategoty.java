package ru.stairenx.testappforsimaland.view.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AllCategoty {

    @SerializedName("items")
    @Expose
    public List<CategoryModel> items;
}
