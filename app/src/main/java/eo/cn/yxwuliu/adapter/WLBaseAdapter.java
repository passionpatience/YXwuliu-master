package eo.cn.yxwuliu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * @author jk
 * @time 2017/2/22  19:15
 * @desc ${TODD}
 */
public abstract class WLBaseAdapter<T> extends BaseAdapter {
    protected List<T> mDatas;
    protected LayoutInflater mInflater;

    public WLBaseAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }
    public void setDatas(List<T> datas) {
        mDatas = datas;
    }

    @Override
    public int getCount() {
        return mDatas != null ? mDatas.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
