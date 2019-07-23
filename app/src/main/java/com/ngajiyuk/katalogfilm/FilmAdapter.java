package com.ngajiyuk.katalogfilm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FilmAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Film> films;

    public void setFilms(ArrayList<Film> films){
        this.films = films;
    }

    public FilmAdapter(Context context){
        this.context = context;
        films = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return films.size();
    }

    @Override
    public Object getItem(int position) {
        return films.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_film, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        Film film = (Film) getItem(position);
        viewHolder.bind(film);
        return view;
    }

    private class ViewHolder {
        private TextView txtName, txtDate, txtRate, txtDescrip;
        private ImageView imgPhoto;

        ViewHolder(View view){
            txtName = view.findViewById(R.id.txt_name);
            txtDate = view.findViewById(R.id.txt_date);
            txtRate = view.findViewById(R.id.txt_rate);
            txtDescrip = view.findViewById(R.id.txt_descrip);
            imgPhoto = view.findViewById(R.id.img_film);
        }

        void bind(Film film){
            txtName.setText(film.getName());
            txtDate.setText(film.getDate());
            txtRate.setText(film.getRate());
            txtDescrip.setText(film.getDescrip());
            imgPhoto.setImageResource(film.getPhoto());
        }
    }
}
