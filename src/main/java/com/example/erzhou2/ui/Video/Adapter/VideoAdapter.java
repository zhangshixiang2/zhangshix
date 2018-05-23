package com.example.erzhou2.ui.Video.Adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;


import com.example.erzhou2.R;
import com.example.erzhou2.bean.VideoBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;



public class VideoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<VideoBean.DataBean> list;
    private LayoutInflater inflater;

    public VideoAdapter(Context context, List<VideoBean.DataBean> list) {
        this.context = context;
        this.list = list;
        inflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.video_item, parent, false);
        VideoViewHolder videoViewHolder = new VideoViewHolder(view);
        return videoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
       VideoViewHolder videoViewHolder= (VideoViewHolder) holder;
        VideoBean.DataBean dataBean = list.get(position);
        videoViewHolder.image.setImageURI(dataBean.getProfile_image());
        videoViewHolder.tv.setText(dataBean.getName());
        videoViewHolder.tv2.setText(dataBean.getPasstime());
        videoViewHolder.tv3.setText(dataBean.getText());
       videoViewHolder.video.setVideoURI(Uri.parse(dataBean.getVideouri()));
       videoViewHolder.video.start();

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class VideoViewHolder extends RecyclerView.ViewHolder {
        private final SimpleDraweeView image;
        private final TextView tv;
        private final TextView tv2;
        private final TextView tv3;
        private final VideoView video;

        public VideoViewHolder(View view) {
            super(view);
            image = view.findViewById(R.id.image);
            video = view.findViewById(R.id.video_player);
            tv = view.findViewById(R.id.tv1);
            tv2 = view.findViewById(R.id.tv2);
            tv3 = view.findViewById(R.id.tv3);


        }
    }
}
