package com.example.erzhou2.ui.Video.Contract;


import com.example.erzhou2.bean.VideoBean;
import com.example.erzhou2.ui.base.Contract.BaseContract;



public interface VideoContract {
    interface View extends BaseContract.BaseView{
        void onSuccess(VideoBean videoBean);

    }
    interface Presenter extends BaseContract.BasePresenter<View>{
        void getVideo();
    }
}
