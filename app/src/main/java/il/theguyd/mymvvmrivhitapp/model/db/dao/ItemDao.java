package il.theguyd.mymvvmrivhitapp.model.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import il.theguyd.mymvvmrivhitapp.model.objects.Item;

//SSOT - Single Source Of Truth
@Dao
public interface ItemDao {

    @Query("SELECT * FROM Items")
    LiveData<List<Item>> getAllItems();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     void insertItems(List<Item> items);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Item item);

    @Delete
    void delete(Item item);
    @Transaction
    @Query("SELECT items.* FROM items " +
            "JOIN itemsFts ON (items._id = itemsFts.docid) " +
            "WHERE itemsFts.id MATCH :itemID")
    LiveData<List<Item>> searchItemById(String itemID);



    @Transaction
    @Query(
            "SELECT items.* FROM items " +
                    "JOIN itemsFts ON (items._id = itemsFts.docid) " +
                    "WHERE itemsFts.name MATCH :name")
    LiveData<List<Item>> searchItemByName(String name);
}


