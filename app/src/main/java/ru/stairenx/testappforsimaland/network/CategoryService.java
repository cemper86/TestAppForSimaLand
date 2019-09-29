package ru.stairenx.testappforsimaland.network;

import androidx.lifecycle.LiveData;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.stairenx.testappforsimaland.view.model.AllCategoty;

public interface CategoryService {

    @GET(" /api/v3/category")
    Single<AllCategoty> getCategory(
            @Query("is_not_empty") int isNotEmpty,
            @Query("with_adult") int withAdult,
            @Query("page") int page,
            @Query("level") int level,
            @Query("sort") String sort,
            @Query("expand-root") int expandRoot,
            @Query("expand") String expand
    );

    @GET(" /api/v3/category")
    Single<AllCategoty> getSubCategory(
            @Query("is_not_empty") int isNotEmpty,
            @Query("with_adult") int withAdult,
            @Query("sort") String sort,
            @Query("expand-root") int expandRoot,
            @Query("expand") String expand,
            @Query("level") int level,
            @Query("path") String path
    );
}
