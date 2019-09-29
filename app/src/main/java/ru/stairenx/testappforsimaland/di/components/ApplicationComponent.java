package ru.stairenx.testappforsimaland.di.components;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;
import ru.stairenx.testappforsimaland.AndroidApplication;
import ru.stairenx.testappforsimaland.di.modules.ApplicationModule;
import ru.stairenx.testappforsimaland.di.modules.RepositoryModule;
import ru.stairenx.testappforsimaland.di.scopes.PerApplication;
import ru.stairenx.testappforsimaland.view.activity.MainActivity;
import ru.stairenx.testappforsimaland.view.fragment.AbstractFragment;

@PerApplication
@Component(modules = {
    ApplicationModule.class,
    RepositoryModule.class,
    AndroidSupportInjectionModule.class})
public interface ApplicationComponent extends AndroidInjector<DaggerApplication> {

  @Component.Builder
  interface Builder {

    @BindsInstance
    Builder application(AndroidApplication application);

    ApplicationComponent build();
  }

  @Override
  void inject(DaggerApplication instance);

  void inject(AndroidApplication application);

  void inject(AbstractFragment fragment);

  void inject(MainActivity activity);

}
