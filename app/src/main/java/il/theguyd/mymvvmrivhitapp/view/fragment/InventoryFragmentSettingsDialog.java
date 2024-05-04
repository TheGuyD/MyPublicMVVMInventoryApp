package il.theguyd.mymvvmrivhitapp.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import il.theguyd.mymvvmrivhitapp.R;
import il.theguyd.mymvvmrivhitapp.databinding.DialogInventoryFragmentSettingsBinding;
import il.theguyd.mymvvmrivhitapp.viewmodel.InventorySettingsDialogViewModel;

/**
 * example for Data Binding with MVVM
 * **/
public class InventoryFragmentSettingsDialog extends DialogFragment {
    private InventorySettingsDialogViewModel inventorySettingsDialogViewModel;

    private DialogInventoryFragmentSettingsBinding dataBinding;

    public InventoryFragmentSettingsDialog() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.dialog_inventory_fragment_settings, container, false);
        inventorySettingsDialogViewModel = new ViewModelProvider(requireActivity()).get(InventorySettingsDialogViewModel.class);
        dataBinding.setViewModel(inventorySettingsDialogViewModel);
        dataBinding.setLifecycleOwner(this);
        return dataBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        dataBinding.toolbar.setElevation(8);
        dataBinding.toolbar.setTitle("הגדרות");
        dataBinding.toolbar.setTitleCentered(true);
    }




}
