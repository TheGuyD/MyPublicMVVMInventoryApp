package il.theguyd.mymvvmrivhitapp.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;

import il.theguyd.mymvvmrivhitapp.R;
import il.theguyd.mymvvmrivhitapp.viewmodel.BaseActivityViewModel;

public class BaseActivity extends AppCompatActivity {
    private BaseActivityViewModel baseActivityViewModel;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        baseActivityViewModel = new ViewModelProvider(this).get(BaseActivityViewModel.class);
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.item1){
            Intent i = new Intent(this, InventoryActivity.class);
            this.startActivity(i);
        }
        else if(id == R.id.item2){
            baseActivityViewModel.getFetchedItems().observe((LifecycleOwner) this, newData -> {
                baseActivityViewModel.insertToDB(newData);
            });
            baseActivityViewModel.fetchData();
        }

        return super.onOptionsItemSelected(item);

    }







}
