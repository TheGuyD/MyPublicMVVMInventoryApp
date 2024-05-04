package il.theguyd.mymvvmrivhitapp.model.db;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


import il.theguyd.mymvvmrivhitapp.model.db.instances.ItemsListDatabase;
import il.theguyd.mymvvmrivhitapp.model.objects.Item;

public class DBRepository {
    private final ItemsListDatabase itemsListDatabase;
    private final ExecutorService executorService;
    private final Handler handler;

    public DBRepository(Application application) {
        this.itemsListDatabase = ItemsListDatabase.getDatabase(application);

        //execute the db operation in the background and sequentially using newSingleThreadExecutor
        executorService = Executors.newSingleThreadExecutor();

        //update the UI
        handler = new Handler(Looper.getMainLooper());
    }

    //Methods in DAO being executed from DBRepository
    public void addItem(Item item) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                itemsListDatabase.itemDao().insert(item);
            }
        });
    }

    public void insertItems(List<Item> items){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                itemsListDatabase.itemDao().insertItems(items);
            }
        });
    }

    public void deleteItem(Item item) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                itemsListDatabase.itemDao().delete(item);
            }
        });
    }

    public LiveData<List<Item>> getAllItems() {
        return itemsListDatabase.itemDao().getAllItems();
    }

    public LiveData<List<Item>> searchItemById(String itemID){
        String wildcardQuery = String.format("*%s*", itemID);
       return  itemsListDatabase.itemDao().searchItemById(wildcardQuery);
    }

    public LiveData<List<Item>> searchItemByName(String name){
        String wildcardQuery = String.format("*%s*", name);
        return itemsListDatabase.itemDao().searchItemByName(wildcardQuery);
    }

}
