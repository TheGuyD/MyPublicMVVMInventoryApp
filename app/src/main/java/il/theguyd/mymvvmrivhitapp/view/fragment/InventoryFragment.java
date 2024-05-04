package il.theguyd.mymvvmrivhitapp.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import il.theguyd.mymvvmrivhitapp.R;
import il.theguyd.mymvvmrivhitapp.model.objects.Item;
import il.theguyd.mymvvmrivhitapp.view.adapter.ItemAdapter;
import il.theguyd.mymvvmrivhitapp.viewmodel.InventorySettingsDialogViewModel;
import il.theguyd.mymvvmrivhitapp.viewmodel.InventoryViewModel;


public class InventoryFragment extends Fragment {

    private RecyclerView rcContact;
    private ItemAdapter adapter;
    List<Item> items, filterItems;
    private InventoryViewModel viewModel;
    private InventorySettingsDialogViewModel inventorySettingsDialogViewModel;

    private ImageButton imageButtonSearchSettings;
    private SearchView searchView;


    public InventoryFragment() {
        items = new ArrayList<>();
        filterItems = new ArrayList<>();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        inventorySettingsDialogViewModel = new ViewModelProvider(requireActivity()).get(InventorySettingsDialogViewModel.class);
        viewModel = new ViewModelProvider(this).get(InventoryViewModel.class);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_inventory, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rcContact = view.findViewById(R.id.rcView);
        searchView = view.findViewById(R.id.searchView);
        imageButtonSearchSettings = view.findViewById(R.id.imgBtnSearchSettings);
        rcContact.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
        adapter = new ItemAdapter(this.getContext(), this.getActivity());
        rcContact.setAdapter(adapter);

        viewModel.getObservableAllItems().observe(getViewLifecycleOwner(), new Observer<List<Item>>() {
            @Override
            public void onChanged(List<Item> allItems) {
                items.addAll(allItems);
                filterItems.addAll(items);
                adapter.setItems((ArrayList<Item>) items);
            }
        });

        inventorySettingsDialogViewModel.getColumns().observe(this.getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer radioId) {
                Toast.makeText(getContext(), "check " + radioId, Toast.LENGTH_SHORT).show();
                rcContact.setLayoutManager(new GridLayoutManager(getContext(), radioId));
                GridLayoutManager layoutManager = (GridLayoutManager) rcContact.getLayoutManager();
                if (layoutManager != null) {
                    layoutManager.setSpanCount(radioId);
                    rcContact.getAdapter().notifyDataSetChanged();
                }
            }
        });

        inventorySettingsDialogViewModel.getInfoOnCard().observe(this.getViewLifecycleOwner(), new Observer<List<Boolean>>() {
            @Override
            public void onChanged(List<Boolean> booleans) {
                for (int i = 0; i < booleans.size(); i++) {
                    adapter.changeItemDetailVisibility(i, booleans.get(i));
                }

            }
        });

        // in older apis the search view was automatically focused
        searchView.clearFocus();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterItems(newText);
                return false;
            }
        });

        imageButtonSearchSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "click", Toast.LENGTH_SHORT).show();
                InventoryFragmentSettingsDialog settingsDialog = new InventoryFragmentSettingsDialog();
                if (getParentFragmentManager().findFragmentByTag(settingsDialog.getTag()) == null)
                    settingsDialog.show(getParentFragmentManager(), String.valueOf(imageButtonSearchSettings.getId()));
            }
        });

    }

    private void filterItems(String newText) {
        if (newText.isEmpty()) {
            filterItems.addAll(items);
            adapter.setItems((ArrayList<Item>) filterItems);
        } else {
            viewModel.searchItemByName(newText).observe(this, new Observer<List<Item>>() {
                @Override
                public void onChanged(List<Item> items) {
                    filterItems.clear();
                    filterItems.addAll(items);
                    adapter.setItems((ArrayList<Item>) filterItems);
                }
            });
        }
    }


}


