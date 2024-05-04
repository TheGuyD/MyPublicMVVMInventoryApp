package il.theguyd.mymvvmrivhitapp.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import il.theguyd.mymvvmrivhitapp.utils.Constants;
/**
 * <p><b>ViewModel</b> is designed to store and manage UI-related data in a lifecycle-conscious way. It survives configuration changes such as screen rotations,
 * meaning that data you hold inside the ViewModel will not be destroyed and re-created during these events.</p>
 *
 * <p><b>Limitation: The main limitation of a regular ViewModel</b> is that it does not survive the process death.
 * If the Android system needs to reclaim resources and terminates the app process, when the app is brought back to the foreground (incoming phone call),
 * the ViewModel will be re-initialized, losing all its previous state.
 * This scenario typically occurs when the user navigates away from the app and returns to it after some time, especially if the device is under memory pressure.</p>
 *
 * <p><b>Surviving Process Death:</b> Unlike a regular ViewModel, when using SavedStateHandle,
 * the data persists not only through configuration changes but also through process death.
 * The data within SavedStateHandle is saved to a Bundle that is managed by the Android framework,
 * making it more robust against temporary process termination.</p>
 * {@link}  <a href="https://medium.com/androiddevelopers/viewmodels-persistence-onsaveinstancestate-restoring-ui-state-and-loaders-fc7cc4a6c090">explanation</a>
 * {@link } <a href="https://github.com/android/codelab-android-lifecycles/blob/master/app/src/main/java/com/example/android/lifecycles/step6_solution/SavedStateViewModel.java">example 1</a>
 * {@link } <a href="https://developer.android.com/codelabs/android-lifecycles#6">example 2</a>
 ***/
public class InventorySettingsDialogViewModel extends AndroidViewModel {
    public final MutableLiveData<Integer> columns;
    public final MutableLiveData<List<Boolean>> infoOnCard;
    public SavedStateHandle savedStateHandle;

    public InventorySettingsDialogViewModel(@NonNull Application application, SavedStateHandle savedStateHandle) {
        super(application);
        this.savedStateHandle = savedStateHandle;

        //TODO: in future the default will be user preferences

        // Retrieve the saved value or default to 2 columns
        columns = savedStateHandle.getLiveData(Constants.SPAN_COUNT, 2);

        //  Retrieve the saved value or default to all checked
        infoOnCard = savedStateHandle.getLiveData(Constants.INFO_ON_CARD, new ArrayList<>(Arrays.asList(true, true, true)));
    }

    public LiveData<Integer> getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns.setValue(columns);
        savedStateHandle.set(Constants.SPAN_COUNT, columns);
    }

    public void setInfoOnCard(int index){
            this.infoOnCard.getValue().set(index,!infoOnCard.getValue().get(index));
            savedStateHandle.set(Constants.INFO_ON_CARD, this.infoOnCard.getValue());
    }

    public LiveData<List<Boolean>> getInfoOnCard(){
        return infoOnCard;
    }







}
