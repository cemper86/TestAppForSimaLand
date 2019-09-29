package ru.stairenx.testappforsimaland.view_model;

import android.content.Context;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import ru.stairenx.testappforsimaland.view.fragment.SubCategoryFragment;

public class ToolbarViewModel extends ViewModel {

    public ObservableField<String> toolBatTitle = new ObservableField<>();
    public ObservableBoolean showBackArrow = new ObservableBoolean();
    private ActionLiveData<Boolean> onBackClickLiveData = new ActionLiveData<>();

    private final Context context;

    @Inject
    public ToolbarViewModel(Context context) {
        this.context = context;
    }

    public void setToolbarTitle(String toolBatTitle) {
        this.toolBatTitle.set(toolBatTitle);
    }

    public void setCurrentFragment(Fragment fragment) {
        if (fragment instanceof SubCategoryFragment) {
            showBackArrow.set(true);
        } else {
            showBackArrow.set(false);
        }
    }


    public void onBackClick() {
        onBackClickLiveData.postValue(true);
    }

    public LiveData<Boolean> getOnBackClickLiveData() {
        return onBackClickLiveData;
    }

}
