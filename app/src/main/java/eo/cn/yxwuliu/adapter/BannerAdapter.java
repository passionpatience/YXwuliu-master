package eo.cn.yxwuliu.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * @author jk
 * @time 2017/1/3  23:59
 * @desc ${TODD}
 */
public class BannerAdapter extends PagerAdapter {
    private ArrayList<ImageView> mImgurls;

    public BannerAdapter(ArrayList<ImageView> list) {
        mImgurls = list;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //每个页面都是一个ImageView
        ImageView imageView = mImgurls.get(position);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return mImgurls.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
    //数据更新
    public void updateData(ArrayList<ImageView> imageViews) {
        mImgurls.clear();
        mImgurls.addAll(imageViews);
        notifyDataSetChanged();
    }
}
