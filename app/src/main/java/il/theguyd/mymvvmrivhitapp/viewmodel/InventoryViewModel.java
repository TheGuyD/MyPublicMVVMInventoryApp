package il.theguyd.mymvvmrivhitapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;

import java.util.List;

import il.theguyd.mymvvmrivhitapp.model.Repository;
import il.theguyd.mymvvmrivhitapp.model.objects.Item;

public class InventoryViewModel extends AndroidViewModel {
    private Repository repository;
    private SavedStateHandle savedStateHandle;
    LiveData<List<Item>> items;

    public InventoryViewModel(@NonNull Application application) {
        super(application);
        this.repository = new Repository(application);
        items = repository.getDbRepository().getAllItems();
    }

    public LiveData<List<Item>> getObservableAllItems() {
        return items;
    }

    public LiveData<List<Item>> searchItemByName(String itemName) {
        return this.repository.getDbRepository().searchItemByName(itemName);
    }

    //TODO: implement search using id
    public LiveData<List<Item>> searchItemById(String itamId) {
        return this.repository.getDbRepository().searchItemById(itamId);
    }


}
