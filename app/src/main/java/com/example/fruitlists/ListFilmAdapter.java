package com.example.fruitlists;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListFilmAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Film> filmArrayList;

    void setFilm(ArrayList<Film> film){
        this.filmArrayList = film;
    }

    ListFilmAdapter(Context context){
        this.context = context;
        filmArrayList = new ArrayList<>();
    }


    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_card_film, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        Film film = (Film) getItem(position);
        viewHolder.bind(film);
        return view;

    }

    @Override
    public int getCount() {
        return filmArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return filmArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    public class ViewHolder  {
        TextView tvName;
        TextView tvYear;
        TextView tvDesc;
        ImageView imgPhoto;
        Button btnReadMore;

        ViewHolder(View itemView){
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvYear = itemView.findViewById(R.id.tv_item_year);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvDesc = itemView.findViewById(R.id.longdesc_item);
            btnReadMore = itemView.findViewById(R.id.btn_read_more);
        }

        void bind(final Film film){
            tvName.setText(film.getName());
            tvYear.setText(film.getYear());
            Glide.with(context)
                    .load(film.getPhoto())
                    .into(imgPhoto);
            tvDesc.setText(film.getLongDesc());

            btnReadMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Film filmData = new Film();
                    filmData.setName(film.getName());
                    filmData.setYear(film.getYear());
                    filmData.setLongDesc(film.getLongDesc());
                    filmData.setPhoto(film.getPhoto());

                    Intent sendData = new Intent(context,DetailFilm.class);
                    sendData.putExtra(DetailFilm.EXTRA_FILM,filmData);
                    context.startActivity(sendData);
                }
            });
        }
    }
}