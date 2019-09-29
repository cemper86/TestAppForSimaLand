package ru.stairenx.testappforsimaland.view.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

public class CategoryModel {

    @SerializedName("id")
    @Expose
    int id;
    @SerializedName("sid")
    @Expose
    int sid;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("path")
    @Expose
    public String path;
    @SerializedName("priority")
    @Expose
    int priority;
    @SerializedName("priority_home")
    @Expose
    int priority_home;
    @SerializedName("priority_menu")
    @Expose
    int priority_menu;
    @SerializedName("type")
    @Expose
    int type;
    @SerializedName("is_adult")
    @Expose
    int is_adult;
    @SerializedName("photo")
    @Expose
    public String photo;
    @SerializedName("icon")
    @Expose
    public String icon;
    @SerializedName("name_alias")
    @Expose
    String name_alias;

    @BindingAdapter({"app:url"})
    public static void loadImage(ImageView view, String url) {
        Picasso.get().load(url).into(view);
    }
}
