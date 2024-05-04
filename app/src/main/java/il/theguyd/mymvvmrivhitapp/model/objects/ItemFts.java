package il.theguyd.mymvvmrivhitapp.model.objects;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Fts4;

import com.google.gson.annotations.SerializedName;

/**
 * this Entity represent the rows in our virtual table the ItemsFts
 * here we specify the columns we wish to perform a search
 * **/
@Fts4(contentEntity = Item.class)
@Entity(tableName = "ItemsFts")
public class ItemFts {

    @ColumnInfo(name=("name"))
    private String itemName;

    @ColumnInfo(name=("id"))
    private String itemId;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public ItemFts(String itemName, String itemId) {
        this.itemName = itemName;
        this.itemId = itemId;
    }
}
