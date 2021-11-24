package com.example.socialcreditsproject;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class AppCompatActivityManager extends AppCompatActivity {
    @Override
    public  boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            //============
            case R.id.item_main:
                intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                Toast.makeText(this, "main selected", Toast.LENGTH_SHORT).show();
                return true;
            //============
            case R.id.item_shop:
                intent = new Intent(this, ShopActivity.class);
                startActivity(intent);
                Toast.makeText(this, "shop selected", Toast.LENGTH_SHORT).show();
                return true;
            //============
            case R.id.item_work:
                intent = new Intent(this,WorkActivity.class);
                startActivity(intent);
                Toast.makeText(this, "work selected", Toast.LENGTH_SHORT).show();
                return true;
            //============
            default:
                return super.onOptionsItemSelected(item);}

    }
}
