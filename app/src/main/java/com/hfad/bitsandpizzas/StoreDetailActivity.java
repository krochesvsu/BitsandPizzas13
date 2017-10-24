package com.hfad.bitsandpizzas;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class StoreDetailActivity extends AppCompatActivity {
    public static final String EXTRA_STORE_ID = "storeId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_detail);

        //Set the toolbar as the activity's app bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Display details of the pizza
        int storeId = (Integer)getIntent().getExtras().get(EXTRA_STORE_ID);
        String storeName = Stores.stores[storeId].getName();
        TextView textView = (TextView)findViewById(R.id.store_text);
        textView.setText(storeName);
        int storeImage = Stores.stores[storeId].getImageResourceId();
        ImageView imageView = (ImageView)findViewById(R.id.store_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, storeImage));
        imageView.setContentDescription(storeName);
    }
}