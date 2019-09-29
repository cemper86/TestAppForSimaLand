package ru.stairenx.testappforsimaland.di.modules;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import ru.stairenx.testappforsimaland.view_model.NetworkViewModel;
import ru.stairenx.testappforsimaland.view_model.ToolbarViewModel;
import ru.stairenx.testappforsimaland.view_model.ViewModelFactory;

@Module
public abstract class ViewModelModule {

  /*@Binds
  @IntoMap
  @ViewModelKey(BottomMenuViewModel.class)
  abstract ViewModel bindBottomViewModel(BottomMenuViewModel viewModel);

  @Binds
  @IntoMap
  @ViewModelKey(SettingsViewModel.class)
  abstract ViewModel bindSettingsStatusViewModel(SettingsViewModel viewModel);*/

  @Binds
  @IntoMap
  @ViewModelKey(ToolbarViewModel.class)
  abstract ViewModel bindToolBarViewModel(ToolbarViewModel viewModel);

  @Binds
  @IntoMap
  @ViewModelKey(NetworkViewModel.class)
  abstract ViewModel bindNetworkViewModel(NetworkViewModel viewModel);

  @Binds
  abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

}
