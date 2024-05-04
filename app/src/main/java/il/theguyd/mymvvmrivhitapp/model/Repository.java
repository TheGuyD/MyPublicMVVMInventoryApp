package il.theguyd.mymvvmrivhitapp.model;

import android.app.Application;

import il.theguyd.mymvvmrivhitapp.model.db.DBRepository;
import il.theguyd.mymvvmrivhitapp.model.retrofit.RetrofitRepository;

public class Repository {
    private DBRepository dbRepository;
    private RetrofitRepository retrofitRepository;

    private Application application;

    public Repository(Application application) {
        this.application = application;
        this.dbRepository = new DBRepository(application);
        this.retrofitRepository = new RetrofitRepository();
    }

    public DBRepository getDbRepository() {
        return dbRepository;
    }

    public RetrofitRepository getRetrofitRepository() {
        return retrofitRepository;
    }

}
