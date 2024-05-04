package il.theguyd.mymvvmrivhitapp.model.retrofit;

import il.theguyd.mymvvmrivhitapp.model.retrofit.bodies.ItemsListResBody;
import il.theguyd.mymvvmrivhitapp.model.retrofit.bodies.RivhitAPIReqBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IRivhitAPIService {

    @POST("Item.List")
    Call<ItemsListResBody> getItemList(@Body RivhitAPIReqBody body);
}
