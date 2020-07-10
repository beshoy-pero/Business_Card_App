package com.beshoykamal.businesscardapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.beshoykamal.businesscardapp.Pojo.Slide;
import com.beshoykamal.businesscardapp.R;

import java.util.List;

public class VideoAdapter extends  RecyclerView.Adapter<VideoAdapter.MyViewHolder> {
    private Context mContext;
    private List<Slide> mList;

    public VideoAdapter(Context mContext, List<Slide> mList) {
        super();
        this.mContext = mContext;
        this.mList = mList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.wepview,parent,false);
        return new  MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {



        myViewHolder.webView.loadData(mList.get(position).getTitle(),"text/html","utf-8");


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {


        private WebView webView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            webView = itemView.findViewById(R.id.wepview);

            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setBuiltInZoomControls(true);
            webView.getSettings().setAllowFileAccess(true);
            webView.getSettings().setAppCacheEnabled(true);

            webView.setWebChromeClient(new WebChromeClient(){

            });
        }
    }
}
