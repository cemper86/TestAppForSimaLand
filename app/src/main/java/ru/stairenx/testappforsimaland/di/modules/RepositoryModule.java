package ru.stairenx.testappforsimaland.di.modules;


import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import ru.stairenx.testappforsimaland.di.scopes.PerApplication;
import ru.stairenx.testappforsimaland.network.ApiConnection;
import ru.stairenx.testappforsimaland.network.CategoryRepository;
import ru.stairenx.testappforsimaland.network.CategoryService;

@Module
public class RepositoryModule {

  @Provides
  @PerApplication
  Retrofit provideRetrofit(){
    return new ApiConnection().createService();
  }

  @Provides
  @PerApplication
  CategoryService provideCategotyService(Retrofit retrofit) {
    return retrofit.create(CategoryService.class);
  }

  @Provides
  @PerApplication
  CategoryRepository provideCategoryRepository(CategoryService  categoryService) {
    return new CategoryRepository(categoryService);
  }

}
