package com.example.erzhou2.ui.Potho;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.erzhou2.Component.DaggerHttpComponent;
import com.example.erzhou2.Module.HttpModule;
import com.example.erzhou2.R;
import com.example.erzhou2.bean.PothoBean;
import com.example.erzhou2.ui.Potho.Adapter.PothoAdapter;
import com.example.erzhou2.ui.Potho.Contract.PothoContract;
import com.example.erzhou2.ui.Potho.Presenter.PothoPresenter;
import com.example.erzhou2.ui.base.BaseFragment;



public class PothoFragment extends BaseFragment<PothoPresenter> implements PothoContract.View {
    private View view;
    private RecyclerView mRlv;

    @Override
    public int getContentLayout() {
        return R.layout.fragment_potho;
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
        mPresenter.getPotho();
    }

    @Override
    public void onSuccess(PothoBean pothoBean) {
        PothoAdapter pothoAdapter = new PothoAdapter(getActivity(), pothoBean.getData());
        mRlv.setAdapter(pothoAdapter);


    }

}
