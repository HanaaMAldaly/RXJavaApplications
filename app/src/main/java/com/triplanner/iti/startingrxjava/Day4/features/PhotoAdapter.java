package com.triplanner.iti.startingrxjava.Day4.features;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.triplanner.iti.startingrxjava.Day4.entities.Photo;
import com.triplanner.iti.startingrxjava.R;

import java.util.List;
import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.subjects.BehaviorSubject;

/**
 * Created by Hanaa on 5/25/2018.
 */

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> {
    Context context;
    BehaviorSubject<List<Photo>> photos;
    public PhotoAdapter(Context context,BehaviorSubject<List<Photo>> photos){
        this.context=context;
        this.photos=photos;
        photos.observeOn(AndroidSchedulers.mainThread());

    }
    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.photo_view_layout,parent,false);
        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PhotoViewHolder holder, int position) {
        holder.textView.setText(photos.getValue().get(position).getTitle());
        Picasso.get()
                .load(photos.getValue().get(position).getUrl())
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return photos.getValue().size();
    }

    public class PhotoViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.textView2)
        TextView textView;
        @BindView(R.id.imageView)
        ImageView imageView;
        public PhotoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
