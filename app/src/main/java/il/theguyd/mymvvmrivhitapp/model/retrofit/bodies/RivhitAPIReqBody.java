package il.theguyd.mymvvmrivhitapp.model.retrofit.bodies;

import com.google.gson.annotations.SerializedName;

public class RivhitAPIReqBody {

    @SerializedName("api_token")
    private String apiToken;

    public RivhitAPIReqBody(String apiToken){
        this.apiToken = apiToken;
    }
}
