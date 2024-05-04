package il.theguyd.mymvvmrivhitapp.model.objects;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ItemData {
    @SerializedName("item_list")
    private ArrayList<Item> itemsList;

    public ArrayList<Item> getItemsList() {
        return itemsList;
    }

    public void setItemsList(ArrayList<Item> itemsList) {
        this.itemsList = itemsList;
    }

    @Override
    public String toString() {
        return itemsList.toString();
    }
}
