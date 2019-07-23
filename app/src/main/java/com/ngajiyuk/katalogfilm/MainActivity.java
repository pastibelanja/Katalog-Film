package com.ngajiyuk.katalogfilm;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] dataName;
    private String[] dataDate;
    private String[] dataRate;
    private String[] dataDescrip;
    private TypedArray dataPhoto;
    private FilmAdapter adapter;
    private ArrayList<Film> films;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new FilmAdapter(this);

        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailFilm.class);
                intent.putExtra("extra_detail", films.get(position));
                startActivity(intent);
            }
        });
    }

    private void prepare(){
        dataName = getResources().getStringArray(R.array.data_name);
        dataDate = getResources().getStringArray(R.array.data_date);
        dataRate = getResources().getStringArray(R.array.data_rate);
        dataDescrip = getResources().getStringArray(R.array.data_descrip);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }

    private void addItem(){
        films = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++){
            Film film = new Film();
            film.setPhoto(dataPhoto.getResourceId(i, -1));
            film.setName(dataName[i]);
            film.setDate(dataDate[i]);
            film.setRate(dataRate[i]);
            film.setDescrip(dataDescrip[i]);
            films.add(film);
        }
        adapter.setFilms(films);
    }


}
