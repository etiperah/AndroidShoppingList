package com.example.mysecondapplication.Activities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import com.example.mysecondapplication.R;

public class CustomeAdapter extends RecyclerView.Adapter<CustomeAdapter.MyViewHolder> {

    private ArrayList<DataModel> dataSet;
    private ArrayList<DataModel> fullList;
    private ArrayList<DataModel> cartList;
    private String phone;


    public CustomeAdapter(ArrayList<DataModel> dataSet, String phone) {
        this.dataSet = dataSet;
        this.fullList = new ArrayList<>(dataSet);
        this.cartList = new ArrayList<>();
        this.phone = phone;
    }
    public ArrayList<DataModel> getCartList() {
        return cartList;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewDescription;
        TextView textViewPrice;
        ImageView imageView;
        NumberPicker quantityPicker;
        Button addToCartButton;
        Button removeFromCartButton;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            imageView = itemView.findViewById(R.id.imageView);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            quantityPicker = itemView.findViewById(R.id.quantityPicker);
            addToCartButton = itemView.findViewById(R.id.addToCartButton);
            removeFromCartButton = itemView.findViewById(R.id.removeFromCartButton);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardrow, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DataModel data = dataSet.get(position);
        holder.textViewName.setText(data.getName());
        holder.textViewDescription.setText(data.getDescription());
        holder.imageView.setImageResource(data.getImage());
        holder.textViewPrice.setText(String.format("Price: $%.2f", data.getPrice()));
        holder.quantityPicker.setValue(data.getQuantity());

        holder.quantityPicker.setOnValueChangedListener((picker, oldVal, newVal) -> {
            data.setQuantity(newVal);
        });

        holder.addToCartButton.setOnClickListener(v -> {
            String phone = MainActivity.getPhoneNumberFromFirebase();
            addToCart(phone, data);
            Toast.makeText(v.getContext(), "Added to cart: " + data.getName(), Toast.LENGTH_SHORT).show();
        });

        holder.removeFromCartButton.setOnClickListener(v -> {
            removeFromCart(data);
            Toast.makeText(v.getContext(), "Removed from cart: " + data.getName(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public void filter(String text) {
        dataSet.clear();
        if (text == null || text.isEmpty()) {
            dataSet.addAll(fullList);
        } else {
            text = text.toLowerCase();
            for (DataModel item : fullList) {
                String itemName = item.getName();
                if (itemName != null && itemName.toLowerCase().contains(text)) {
                    dataSet.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }
    private void addToCart(String phone, DataModel product) {
        if (!cartList.contains(product)) {
            cartList.add(product);
        }
    }
    private void removeFromCart(DataModel product) {
        if (cartList.contains(product)) {
            cartList.remove(product);
        }
    }
}
