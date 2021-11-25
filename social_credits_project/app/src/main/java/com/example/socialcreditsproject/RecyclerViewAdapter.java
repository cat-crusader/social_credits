package com.example.socialcreditsproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    String data1[],data2[];
    int images [];
    int prices[];
    Context context;

    public RecyclerViewAdapter(Context ct, String s1[], String s2[], int imgs[],int price[]){
        context=ct;
        data1=s1;
        data2=s2;
        images = imgs;
        prices = price;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.row,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.myText1.setText(data1[position]);
        holder.myText2.setText(data2[position]+prices[position]);
        holder.myImage.setImageResource(images[position]);


        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,SecondActivity.class);
                intent.putExtra("data1",data1[position]);
                intent.putExtra("data2",data2[position]);
                intent.putExtra("myImage",images[position]);
                intent.putExtra("myPrice",prices[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {//number of items
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView myText1,myText2;
        ImageView myImage;
        ConstraintLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.recycler_view_shop_item_name_txt);
            myText2 = itemView.findViewById(R.id.recycler_view_shop_item_description_txt);
            myImage = itemView.findViewById(R.id.image_view_shop_item);

            mainLayout =itemView.findViewById(R.id.mainLayout);

        }
    }
}
