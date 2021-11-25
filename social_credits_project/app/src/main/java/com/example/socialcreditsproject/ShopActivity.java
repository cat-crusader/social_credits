package com.example.socialcreditsproject;

import androidx.appcompat.app.ActionBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

public class ShopActivity extends AppCompatActivityManager {

    String s1[],s2[];
    int images[]={R.drawable.snack_img,
                  R.drawable.map_img,
                  R.drawable.relax_img,
                  R.drawable.minecraft_img};
    int prices[]={-20,-10,-50,-3000};
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        recyclerView = findViewById(R.id.recycler_view_shop);

        getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.pink_background));
        ActionBar actionBar;
        actionBar = getSupportActionBar();

        // Define ColorDrawable object and parse color
        // using parseColor method
        // with color hash code as its parameter
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#FF0030"));

        // Set BackgroundDrawable
        actionBar.setBackgroundDrawable(colorDrawable);

        s1 = getResources().getStringArray(R.array.shop_items);
        s2 = getResources().getStringArray(R.array.shop_items_description);



        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,s1,s2,images,prices);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}