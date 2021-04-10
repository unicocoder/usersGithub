package com.unicocoder.usergithub.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.unicocoder.usergithub.R;
import com.unicocoder.usergithub.databinding.ActivityMainBinding;
import com.unicocoder.usergithub.utils.OnBackPressedListner;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    NavController navController;
    AppBarConfiguration appbar;
    NavHostFragment navHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        appbar = new AppBarConfiguration.Builder(R.navigation.navigation).build();

        navHost = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        assert navHost != null;
        navController = navHost.getNavController();
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appbar) || super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        final Fragment currentFragment = navHost.getChildFragmentManager().getFragments().get(0);
        navController = Navigation.findNavController(this, R.id.fragment);
        if (currentFragment instanceof OnBackPressedListner)
            ((OnBackPressedListner) currentFragment).onBackPressed();
        else if (!navController.popBackStack())
            finish();
    }
}