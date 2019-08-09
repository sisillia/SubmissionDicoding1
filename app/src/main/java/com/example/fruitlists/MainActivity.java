package com.example.fruitlists;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] dataName;
    private String[] dataYear;
    private String[] dataDesc;
    private String[] dataPhoto;
    private ArrayList<Film> list;
    private ListFilmAdapter listFilmAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listFilmAdapter = new ListFilmAdapter(this);

        ListView listView = findViewById(R.id.rv_category);

        listView.setAdapter(listFilmAdapter);

        takeData();
        addData();
    }

    private void takeData(){
        dataName = getResources().getStringArray(R.array.name);
        dataYear = getResources().getStringArray(R.array.year);
        dataDesc = getResources().getStringArray(R.array.desc);
        dataPhoto = getResources().getStringArray(R.array.image);
    }

    private void addData() {
        list = new ArrayList<>();

        for(int i = 0; i < dataYear.length; i++){
            Film film = new Film();
            film.setPhoto(dataPhoto[i]);
            film.setName(dataName[i]);
            film.setYear(dataYear[i]);
            film.setLongDesc(dataDesc[i]);
            list.add(film);
        }

        listFilmAdapter.setFilm(list);
    }
}
