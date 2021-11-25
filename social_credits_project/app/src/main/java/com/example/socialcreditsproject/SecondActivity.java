package com.example.socialcreditsproject;

import static com.example.socialcreditsproject.R.id.activity_second_description;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivityManager {

    ImageView mainImageView;
    TextView title, description;
    Button actionButton;

    String data1, data2;
    int myImage;
    int price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mainImageView = findViewById(R.id.activity_second_imageView);
        title=findViewById(R.id.activity_second_title);
        description=findViewById(activity_second_description);
        actionButton = findViewById(R.id.activity_second_action_button);

        getData();
        setData();

        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentPoints = loadData();
                saveData(currentPoints+price);
            }
        });
    }


    private  void getData(){
        if(getIntent().hasExtra("myImage")&& getIntent().hasExtra("data1")&&getIntent().hasExtra("data2"))
        {
            data1 =getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            myImage = getIntent().getIntExtra("myImage",1);
            price = getIntent().getIntExtra("myPrice",1);
        }
        else Toast.makeText(this, "NO DATA", Toast.LENGTH_SHORT).show();
    }
    private void setData(){
        title.setText(data1);
        description.setText(data2);
        mainImageView.setImageResource(myImage);
    }
}