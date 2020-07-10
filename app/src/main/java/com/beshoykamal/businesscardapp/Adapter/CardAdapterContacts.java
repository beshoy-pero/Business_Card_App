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

public class CardAdapterContacts extends  RecyclerView.Adapter<CardAdapterContacts.MyViewHolder> {
    private Context mContext;
    private List<Slide> mList;
     OnItemClick onItemClick;
    public CardAdapterContacts(Context mContext, List<Slide> mList,OnItemClick onItemClick) {
        super();
        this.mContext = mContext;
        this.mList = mList;
        this.onItemClick = onItemClick;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.cardlayoutcontact,parent,false);
        return new  MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {

        myViewHolder.title.setText(mList.get(position).getTitle());
        myViewHolder.descrip.setText(mList.get(position).getDescrip());
        myViewHolder.imagMovie.setImageResource(mList.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView descrip;
        private ImageView imagMovie;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imagMovie = itemView.findViewById(R.id.cardimage);
            title = itemView.findViewById(R.id.contactPosition);
            descrip = itemView.findViewById(R.id.contactNumper);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /// bn3ml interface
                    onItemClick.onItemClick(mList.get(getAdapterPosition()));
                }
            });
        }
    }
}
