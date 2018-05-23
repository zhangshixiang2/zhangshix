package com.example.erzhou2.ui.base.Presenter;


import com.example.erzhou2.ui.base.Contract.BaseContract;



public class BasePresenter<T extends BaseContract.BaseView> implements BaseContract.BasePresenter<T> {
    protected T mView;


    @Override
    public void attchView(T view) {
        this.mView = view;
    }


    @Override
    public void detachView() {
        if (mView != null) {
            mView = null;
        }
    }

}
