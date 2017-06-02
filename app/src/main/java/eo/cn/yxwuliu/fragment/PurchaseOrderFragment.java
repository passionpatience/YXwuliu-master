package eo.cn.yxwuliu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import eo.cn.yxwuliu.R;
import eo.cn.yxwuliu.base.BaseFragment;

/**
 * Created by mk on 2017/5/26.
 */

public class PurchaseOrderFragment extends BaseFragment {
    public static volatile PurchaseOrderFragment instance = null;

    public static PurchaseOrderFragment newInstance(){
        if(instance == null){
            synchronized (PurchaseOrderFragment.class){
                if(instance == null){
                    instance = new PurchaseOrderFragment();
                }
            }
        }
        return instance;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.categorizefragment,null);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initTitle() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void setListener() {

    }
}
