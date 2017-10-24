package com.hfad.bitsandpizzas;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class SaladDetailActivity extends AppCompatActivity {
    public static final String EXTRA_SALAD_ID = "saladId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salad_detail);

        //Set the toolbar as the activity's app bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Display details of the pizza
        int saladId = (Integer)getIntent().getExtras().get(EXTRA_SALAD_ID);
        String saladName = Salad.salads[saladId].getName();
        TextView textView = (TextView)findViewById(R.id.salad_text);
        textView.setText(saladName);
        int saladImage = Salad.salads[saladId].getImageResourceId();
        ImageView imageView = (ImageView)findViewById(R.id.salad_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, saladImage));
        imageView.setContentDescription(saladName);
    }
}