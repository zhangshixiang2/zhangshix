package com.example.erzhou2.ui.Video;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.erzhou2.Component.DaggerHttpComponent;
import com.example.erzhou2.Module.HttpModule;
import com.example.erzhou2.R;
import com.example.erzhou2.bean.VideoBean;
import com.example.erzhou2.ui.Video.Adapter.VideoAdapter;
import com.example.erzhou2.ui.Video.Contract.VideoContract;
import com.example.erzhou2.ui.Video.Presenter.VideoPresenter;
import com.example.erzhou2.ui.base.BaseFragment;




public class VideoFragment extends BaseFragment<VideoPresenter> implements VideoContract.View {
    private RecyclerView mRlv;
    @Override
    public int getContentLayout() {
        return R.layout.fragment_video;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httpModule(new HttpModule())
                .build()
                .inject(this);

    }

    @Override
    public void initView(View view) {

        mRlv = (RecyclerView) view.findViewById(R.id.rlv);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1, RecyclerView.VERTICAL, false);
        mRlv.setLayoutManager(gridLayoutManager);
        mPresenter.getVideo();
    }

    @Override
    public void onSuccess(VideoBean videoBean) {
        VideoAdapter videoAdapter = new VideoAdapter(getActivity(), videoBean.getData());
        mRlv.setAdapter(videoAdapter);

    }
}
