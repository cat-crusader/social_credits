package com.example.socialcreditsproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ShopActivity extends AppCompatActivityManager {

    String s1[],s2[];
    int images[]={R.drawable.img_2,
                  R.drawable.img_1,
                  R.drawable.img_3,
                  R.drawable.img};
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        recyclerView = findViewById(R.id.recycler_view_shop);

        s1 = getResources().getStringArray(R.array.shop_items);
        s2 = getResources().getStringArray(R.array.shop_items_description);



        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,s1,s2,images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}