package com.triplanner.iti.startingrxjava.Day3.fetures;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.triplanner.iti.startingrxjava.Day2.DaggerMyComponent;
import com.triplanner.iti.startingrxjava.Day3.depencdecyinjection.DaggerMyComponent3;
import com.triplanner.iti.startingrxjava.Day3.entities.Post;
import com.triplanner.iti.startingrxjava.R;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindString;

/**
 * Created by Hanaa on 5/21/2018.
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {



    List<Post> posts;
    @Inject
    public PostAdapter(Context context,List<Post> posts){
       /// DaggerMyComponent3.builder().build().inject(this);
//        Log.i("MMM",str);
        this.posts = posts;
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        Log.i("TAG","onCreateViewHolder");
        View view= LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.post_layout,parent,false);
        return new PostViewHolder(view);

    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        Post post=posts.get(position);
        holder.author.setText(post.getUserId()+"");
        holder.title.setText(post.getTitle());
        holder.content.setText(post.getBody().substring(0,20)+"...");
        Log.i("Tag","onBindViewHolder");


    }

    @Override
    public int getItemCount() {
        return posts.size();
    }



    class PostViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{

        TextView title,author,content;
        public PostViewHolder(View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            author=itemView.findViewById(R.id.author);
            content=itemView.findViewById(R.id.content);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int pos=getAdapterPosition();
            Toast.makeText(view.getContext(),posts.get(pos).getBody(), Toast.LENGTH_SHORT).show();

        }
    }
}
