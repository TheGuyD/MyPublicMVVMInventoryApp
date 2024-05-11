package il.theguyd.mymvvmrivhitapp.view.adapter;


import static il.theguyd.mymvvmrivhitapp.utils.Utils.cleanString;
import static il.theguyd.mymvvmrivhitapp.utils.Utils.showImage;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

import il.theguyd.mymvvmrivhitapp.R;
import il.theguyd.mymvvmrivhitapp.model.objects.Item;
import il.theguyd.mymvvmrivhitapp.utils.Constants;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private static final String TAG = "ItemAdapter";

    private Context context;
    private ArrayList<Item> items = new ArrayList<>();

    private boolean showName;
    private boolean showCost;
    private boolean showQuantity;

    Activity activity;

    public ItemAdapter( HashMap<String,Boolean> initMap) {
        initMap.forEach(this::changeItemDetailVisibility);
    }

    // update the ItemViewHolder based on change preferences
    public void changeItemDetailVisibility(String show, boolean b) {
        switch (show) {
            case Constants.SHOW_NAME:
                this.showName = b;
                break;
            case Constants.SHOW_PRICE:
                this.showCost = b;
                break;
            case Constants.SHOW_QUANTITY:
                this.showQuantity = b;
                break;
        }
        if(!items.isEmpty()){
            notifyDataSetChanged();
        };

    }

    //creating new View holders for items in recyclerView
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_rec_view_card, parent, false);
        ItemViewHolder holder = new ItemViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        // Called by recyclerView when it needs to display or update an item
        // at a specific position in the list or grid

        Item item = items.get(position);
        holder.layoutImageView.post(new Runnable() {

            @Override
            public void run() {
                int width = holder.layoutImageView.getWidth();
                int height = holder.layoutImageView.getHeight();

                // Set ImageView size dynamically if needed
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, height);
                holder.imgItem.setLayoutParams(params);
                showImage(holder.cardParent.getContext(), holder.imgItem, item.getPicture_link(), height * width);

            }

        });


        holder.imgItem.setScaleType(ImageView.ScaleType.FIT_XY);


        holder.txtItemName.setText(cleanString(item.getItemName()));
        holder.txtItemQuantity.setText(cleanString(String.valueOf(item.getQuantity())));
        holder.txtItemCost.setText(cleanString(String.valueOf(item.getCostNis())));


        holder.cardParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: is it appropriate to navigate activities from adapter?
//                card.setOnLongClickListener {
//                    card.setChecked(!card.isChecked)
//                    true
//                }
//                Intent intent = new Intent(context, ItemActivity.class);
//                intent.putExtra("contactID", Items.get(position).getId());
//                context.startActivity(intent);
            }
        });

        holder.bind();


    }

    @Override
    public int getItemCount() {
        if (items != null) {
            return items.size();
        } else {
            return 0;
        }

    }

    public void setItems(ArrayList<Item> Items) {
        this.items = Items;
        notifyDataSetChanged();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgItem;
        private TextView txtTitleName;
        private TextView txtTitleQuantity;
        private TextView txtTitleCost;
        private TextView txtItemName;
        private TextView txtItemQuantity;
        private TextView txtItemCost;
        private CardView cardParent;
        private LinearLayout layoutImageView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            imgItem = itemView.findViewById(R.id.imgItem);
            cardParent = itemView.findViewById(R.id.cardParent);
            layoutImageView = itemView.findViewById(R.id.layoutImageView);
            txtTitleName = itemView.findViewById(R.id.txtTitleName);
            txtItemName = itemView.findViewById(R.id.txtItemName);
            txtTitleQuantity = itemView.findViewById(R.id.txtTitleQuantity);
            txtItemQuantity = itemView.findViewById(R.id.txtItemQuantity);
            txtTitleCost = itemView.findViewById(R.id.txtTitleCost);
            txtItemCost = itemView.findViewById(R.id.txtItemCost);
        }

        // update the view based on updates from changeItemDetailVisibility
        void bind() {
            txtTitleName.setVisibility(showName ? View.VISIBLE : View.GONE);
            txtItemName.setVisibility(showName ? View.VISIBLE : View.GONE);
            txtTitleCost.setVisibility(showCost ? View.VISIBLE : View.GONE);
            txtItemCost.setVisibility(showCost ? View.VISIBLE : View.GONE);
            txtTitleQuantity.setVisibility(showQuantity ? View.VISIBLE : View.GONE);
            txtItemQuantity.setVisibility(showQuantity ? View.VISIBLE : View.GONE);
        }
    }
}
