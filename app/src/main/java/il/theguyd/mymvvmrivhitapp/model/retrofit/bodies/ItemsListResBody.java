package il.theguyd.mymvvmrivhitapp.model.retrofit.bodies;
import il.theguyd.mymvvmrivhitapp.model.objects.ItemData;

import com.google.gson.annotations.SerializedName;


public class ItemsListResBody {

    @SerializedName("error_code")
    int errorCode;
    @SerializedName("client_message")
    String clientMessage;
    @SerializedName("debug_message")
    String debugMessage;

    @SerializedName("data")
    private ItemData itemData;

    @Override
    public String toString() {
        return "ItemsListResBody{" +
                "errorCode=" + errorCode +
                ", clientMessage='" + clientMessage + '\'' +
                ", debugMessage='" + debugMessage + '\'' +
                ", itemsList=" + itemData +
                '}';
    }


    public ItemData getItemData() {
        return itemData;
    }
}
