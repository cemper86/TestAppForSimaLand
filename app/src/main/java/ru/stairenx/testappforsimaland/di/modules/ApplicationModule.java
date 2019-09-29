package ru.stairenx.testappforsimaland.di.modules;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import ru.stairenx.testappforsimaland.AndroidApplication;
import ru.stairenx.testappforsimaland.di.scopes.PerApplication;

@Module (includes = ViewModelModule.class)
public class ApplicationModule {

  @Provides
  @PerApplication
  Context provideContext(AndroidApplication application) {
    return application;
  }

}
