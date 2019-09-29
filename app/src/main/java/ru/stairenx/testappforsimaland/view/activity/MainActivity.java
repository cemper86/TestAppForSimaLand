package ru.stairenx.testappforsimaland.view.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;

import android.os.Bundle;

import ru.stairenx.testappforsimaland.AndroidApplication;
import ru.stairenx.testappforsimaland.R;
import ru.stairenx.testappforsimaland.databinding.ActivityMainBinding;
import ru.stairenx.testappforsimaland.view.model.CategoryModel;

public class MainActivity extends AppCompatActivity  implements MainActivityListener {

    private ActivityMainBinding binding;
    private NavController navController;

    private String currentFragmentLayoutName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplication.getInstance().inject(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller,
                                             @NonNull NavDestination destination, @Nullable Bundle arguments) {
                getCurrentFragment();
            }
        });
        initBottomNavView();
    }

    private void initBottomNavView(){
        binding.bottomMenu.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()){
                case R.id.menu_catalog:
                    showCatalogFragment();
                    break;
                case R.id.menu_cart:
                    showCartFragment();
                    break;
                case R.id.menu_profile:
                    showProfileFragment();
                    break;
            }
            return true;
        });
    }

    @Override
    public void showCatalogFragment() {
        if (currentFragmentLayoutName != null && currentFragmentLayoutName.equals("fragment_catalog")) {
            return;
        }
        navController.navigate(R.id.catalogFragment);
    }

    @Override
    public void showCartFragment() {
        if (currentFragmentLayoutName != null && currentFragmentLayoutName.equals("fragment_cart")) {
            return;
        }
        navController.navigate(R.id.cartFragment);
    }

    @Override
    public void showProfileFragment() {
        if (currentFragmentLayoutName != null && currentFragmentLayoutName.equals("fragment_profile")) {
            return;
        }
        navController.navigate(R.id.profileFragment);
    }

    @Override
    public void showSubCategoryFragment(CategoryModel model) {
        if (currentFragmentLayoutName != null && currentFragmentLayoutName.equals("fragment_subcategory")) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("path",model.path);
        bundle.putString("name",model.name);
        navController.navigate(R.id.action_catalogFragment_to_subcategoryFragment,bundle);
    }

    private void getCurrentFragment() {
        currentFragmentLayoutName = navController.getCurrentDestination().getLabel().toString();
    }
}
