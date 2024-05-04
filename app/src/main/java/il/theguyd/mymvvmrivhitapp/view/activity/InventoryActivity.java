package il.theguyd.mymvvmrivhitapp.view.activity;

import android.os.Bundle;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.navigation.NavigationView;

import il.theguyd.mymvvmrivhitapp.R;
import il.theguyd.mymvvmrivhitapp.utils.Constants;
import il.theguyd.mymvvmrivhitapp.view.fragment.InventoryFragment;
import il.theguyd.mymvvmrivhitapp.viewmodel.InventorySettingsDialogViewModel;

public class InventoryActivity extends BaseActivity{
    private NavigationView navigationView;
    private InventorySettingsDialogViewModel inventorySettingsDialogViewModel;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_inventory);

        navigationView = findViewById(R.id.navigationMenu);
        navigationView.setNavigationItemSelectedListener(super::onOptionsItemSelected);
        inventorySettingsDialogViewModel = new ViewModelProvider(this).get(InventorySettingsDialogViewModel.class);

        FragmentManager fragmentManager = getSupportFragmentManager();
        if(fragmentManager.findFragmentByTag(Constants.MAIN_INVENTORY_FRAGMENT_TAG) == null ){
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true).setCustomAnimations(R.anim.fade_in,R.anim.fade_out).addToBackStack(Constants.MAIN_INVENTORY_FRAGMENT_TAG)
                    .add(R.id.container, new InventoryFragment(),Constants.MAIN_INVENTORY_FRAGMENT_TAG)
                    .addToBackStack(Constants.MAIN_INVENTORY_FRAGMENT_TAG)
                    .commit();

        }
    }




}
