package il.theguyd.mymvvmrivhitapp.view.activity;

import android.os.Bundle;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import il.theguyd.mymvvmrivhitapp.R;

public class MainActivity extends BaseActivity {

    private NavigationView navigationView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView = findViewById(R.id.navigationMenu);
        navigationView.setNavigationItemSelectedListener(super::onOptionsItemSelected);
    }



}