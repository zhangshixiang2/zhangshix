package com.example.erzhou2.ui.Potho.Contract;


import com.example.erzhou2.bean.PothoBean;
import com.example.erzhou2.ui.base.Contract.BaseContract;


public interface PothoContract {
    interface View extends BaseContract.BaseView{
        void onSuccess(PothoBean pothoBean);

    }
    interface Presenter extends BaseContract.BasePresenter<View>{
        void getPotho();
    }

}
