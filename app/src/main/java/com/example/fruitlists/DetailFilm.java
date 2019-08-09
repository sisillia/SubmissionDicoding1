package com.example.fruitlists;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailFilm extends AppCompatActivity {

    CircleImageView imgFilm;
    TextView titleFilm, yearOfFilm, descOfFilm;
    public static final String EXTRA_FILM = "extra_film";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_film);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Film Detail");

        imgFilm = (CircleImageView) findViewById(R.id.img_film);
        titleFilm = (TextView) findViewById(R.id.tv_title_film);
        yearOfFilm = (TextView) findViewById(R.id.tv_year);
        descOfFilm = (TextView) findViewById(R.id.tv_desc_film);

        Film film = getIntent().getParcelableExtra(EXTRA_FILM);

        titleFilm.setText(film.getName());
        yearOfFilm.setText(film.getYear());
        descOfFilm.setText(film.getLongDesc());
        Glide.with(this)
                .load(film.getPhoto())
                .into(imgFilm);

    }
}
