package il.theguyd.mymvvmrivhitapp.model.retrofit.apiclients;

import il.theguyd.mymvvmrivhitapp.utils.Constants;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RivhitAPIClient {

    private static Retrofit retrofit = null;

    public static Retrofit getService()
    {
        //initialize logging-interceptors instance
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

        //determine the information level that will be logged for response and request
        //in this case the BODY of the req/res.
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        //create the OkHttpClient and add interceptors .
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.RIVHIT_ONLINE_ADDR)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }

}
