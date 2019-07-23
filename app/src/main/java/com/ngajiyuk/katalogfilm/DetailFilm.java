package com.ngajiyuk.katalogfilm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailFilm extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_film);

        Intent intent = getIntent();
        Film film = intent.getParcelableExtra("extra_detail");

        int imgPhoto = film.getPhoto();
        String tvName = film.getName();
        String tvDate = film.getDate();
        String tvRate = film.getRate();
        String tvDescrip = film.getDescrip();

        ImageView imageView = findViewById(R.id.img_detail_film);
        imageView.setImageResource(imgPhoto);

        TextView tvDetailName = findViewById(R.id.tv_detail_name);
        tvDetailName.setText(tvName);
        TextView tvDetailDate = findViewById(R.id.tv_detail_date);
        tvDetailDate.setText(tvDate);
        TextView tvDetailRate = findViewById(R.id.tv_detail_rate);
        tvDetailRate.setText(tvRate);
        TextView tvDetailDesc = findViewById(R.id.tv_detail_descrip);
        tvDetailDesc.setText(tvDescrip);

    }
}
