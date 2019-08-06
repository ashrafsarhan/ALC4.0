package com.example.travelmantics;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

public class DealDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deal_details
        );
        TextView txtDescription = findViewById(R.id.description);
        TextView txtPrice =  findViewById(R.id.price);
        ImageView imageView = findViewById(R.id.image);
        Intent intent = getIntent();
        TravelDeal deal = (TravelDeal) intent.getSerializableExtra("Deal");
        if (deal == null) {
            deal = new TravelDeal();
        }
        setTitle(deal.getTitle());
        txtDescription.setText(deal.getDescription());
        txtPrice.setText(deal.getPrice());
        int width = Resources.getSystem().getDisplayMetrics().widthPixels;
        Picasso.with(this)
                .load(deal.getImageUrl())
                .resize(width, width * 2 / 3)
                .centerCrop()
                .placeholder(R.drawable.img_placeholder) // can also be a drawable
                .error(R.drawable.error_placeholder) // will be displayed if the image cannot be loaded
                .into(imageView);
    }
}
