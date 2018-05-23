package com.example.erzhou2.ui.Potho.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.erzhou2.R;
import com.example.erzhou2.bean.PothoBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;


public class PothoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<PothoBean.DataBean> list;
    private LayoutInflater inflater;

    public PothoAdapter(Context context, List<PothoBean.DataBean> list) {
        this.context = context;
        this.list = list;
        inflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.potho_item, parent, false);
        PothoViewHolder pothoViewHolder = new PothoViewHolder(view);
        return pothoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        PothoViewHolder pothoViewHolder= (PothoViewHolder) holder;
        PothoBean.DataBean dataBean = list.get(position);

        pothoViewHolder.image.setImageURI(dataBean.getProfile_image());
        pothoViewHolder.image2.setImageURI(dataBean.getImage0());
        pothoViewHolder.tv.setText(dataBean.getName());
        pothoViewHolder.tv2.setText(dataBean.getPasstime());
        pothoViewHolder.tv3.setText(dataBean.getText());



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class PothoViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView image;
        private final TextView tv;
        private final TextView tv2;
        private final TextView tv3;
        private final SimpleDraweeView image2;

        public PothoViewHolder(View view) {
            super(view);
            image = view.findViewById(R.id.image);
            image2 = view.findViewById(R.id.image2);
            tv = view.findViewById(R.id.tv1);
            tv2 = view.findViewById(R.id.tv2);
            tv3 = view.findViewById(R.id.tv3);



        }
    }
}
