package com.beshoykamal.businesscardapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.beshoykamal.businesscardapp.Pojo.Slide;
import com.beshoykamal.businesscardapp.R;

import java.util.List;

public class InfoAdapter extends  RecyclerView.Adapter<InfoAdapter.MyViewHolder> {
private Context mContext;
private List<Slide> mList;

public InfoAdapter(Context mContext, List<Slide> mList) {
        super();
        this.mContext = mContext;
        this.mList = mList;
        }
@NonNull
@Override
public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.infolayout,parent,false);
        return new  MyViewHolder(view);
        }

@Override
public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {

        myViewHolder.title.setText(mList.get(position).getTitle());

        myViewHolder.imagMovie.setImageResource(mList.get(position).getImage());

        }

@Override
public int getItemCount() {
        return mList.size();
        }


public class MyViewHolder extends RecyclerView.ViewHolder {

    private TextView title;

    private ImageView imagMovie;


    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        imagMovie = itemView.findViewById(R.id.imaginfo);
        title = itemView.findViewById(R.id.tv_info);



    }
}}


