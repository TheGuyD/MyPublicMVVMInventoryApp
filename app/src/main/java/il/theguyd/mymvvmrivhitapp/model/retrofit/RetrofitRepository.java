package il.theguyd.mymvvmrivhitapp.model.retrofit;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import il.theguyd.mymvvmrivhitapp.utils.Constants;
import il.theguyd.mymvvmrivhitapp.model.objects.Item;
import il.theguyd.mymvvmrivhitapp.model.retrofit.apiclients.RivhitAPIClient;
import il.theguyd.mymvvmrivhitapp.model.retrofit.bodies.ItemsListResBody;
import il.theguyd.mymvvmrivhitapp.model.retrofit.bodies.RivhitAPIReqBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

//TODO: generate abstract class to centralize retrofit response handling
public class RetrofitRepository {
    private Retrofit rivhitAPIClient;
    private MutableLiveData<List<Item>> items = new MutableLiveData<>();
    public RetrofitRepository() {
        this.rivhitAPIClient = RivhitAPIClient.getService();
    }
    public void fetchItems() {
        IRivhitAPIService iRivhitAPIService = RivhitAPIClient.getService().create(IRivhitAPIService.class);
        Call<ItemsListResBody> call = iRivhitAPIService.getItemList(new RivhitAPIReqBody(Constants.TOKEN));
        call.enqueue(new Callback<ItemsListResBody>() {
            @Override
            public void onResponse(Call<ItemsListResBody> call, Response<ItemsListResBody> response) {
                ItemsListResBody itemsListResBody = response.body();
                try{
                    items.postValue(itemsListResBody.getItemData().getItemsList());
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ItemsListResBody> call, Throwable t) {

            }
        });
    }


    public MutableLiveData<List<Item>> getFetchedItemsLiveData(){
        return items;
    }
}
