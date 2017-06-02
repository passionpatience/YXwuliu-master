package eo.cn.yxwuliu.widgets;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import eo.cn.yxwuliu.R;
import eo.cn.yxwuliu.adapter.BannerAdapter;

/**
 * @author jk
 * @time 2017/1/3  22:00
 * @desc 轮播图相关的一个自定义控件
 */
public class BannerView extends RelativeLayout {
    private static final long LOOP_TIME = 2000;
    private ArrayList<String> mImgUrls;
    private ViewPager mViewPager;
    private LinearLayout mLlpoint;
    public int mMPicSize;
    private Handler mHandler;
    private BannerAdapter mBannerAdapter;
    private Context mContext;

    public BannerView(Context context, ArrayList<String> bannerImgUrls) {
        super(context);
        this.mImgUrls = bannerImgUrls;
        this.mContext = context;
        //图片的总长度
        mMPicSize = mImgUrls.size();
        initView();
        initData();
    }

    private void initData() {
        //设置自动滑动
        initHander();
        //无限循环
        initUnLimitPic();

        ArrayList<ImageView> list = new ArrayList<>();
        for (int i = 0; i < mImgUrls.size(); i++) {
            ImageView imageView = new ImageView(mContext);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            Glide.with(mContext).load(mImgUrls.get(i)).into(imageView);
            list.add(imageView);
        }

        mBannerAdapter = new BannerAdapter(list);
        mViewPager.setAdapter(mBannerAdapter);

        initDot();

        //设置ViewPager的页面切换监听器
        BannerPagerChangeListener changeListener = new BannerPagerChangeListener();
        mViewPager.addOnPageChangeListener(changeListener);
        mViewPager.setCurrentItem(1);

    }

    private void initUnLimitPic() {
        ArrayList<String> backup = new ArrayList<>();
        backup.addAll(mImgUrls);
        mImgUrls.clear();
        mImgUrls.add(backup.get(mMPicSize - 1));
        mImgUrls.addAll(backup);
        mImgUrls.add(backup.get(0));

    }


    private void initHander() {
        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                int currentItem = mViewPager.getCurrentItem();
                mViewPager.setCurrentItem(currentItem + 1);
                mHandler.sendEmptyMessageDelayed(0, LOOP_TIME);
            }
        };
    }

    //    private void unLimitPic() {
    //        //往图片集合当中首尾各添加一张图片来准备做无线循环(偷天换日)
    //        // 0 1 2 3 4  原来的
    //        //4 0 1 2 3 4 0  新的
    //        ArrayList<String> backup = new ArrayList<>();
    //        backup.addAll(mImgUrls);
    //        mImgUrls.clear();
    //        //将原来的后一张添加到第一张
    //        mImgUrls.add(backup.get(mMPicSize-1));
    //        mImgUrls.addAll(backup);
    //        //将原来的第一张添加到新的mImgUrls的最后一张
    //        mImgUrls.add(backup.get(0));
    //    }

    private void initDot() {
        //先移除以前的小点

        mLlpoint.removeAllViews();
        for (int i = 0; i < mMPicSize; i++) {
            ImageView imageView = new ImageView(getContext());
            //给控件设置背景形状
            imageView.setImageResource(R.drawable.bg_dot);
            //通过LayoutParams可以设置添加控件,更多的布局效果,比如:尺寸大小/margin/居中
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, -2);
            layoutParams.setMargins(0, 0, 10, 0);
            mLlpoint.addView(imageView, layoutParams);
        }
    }

    private void initView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.view_banner, this);
        mViewPager = (ViewPager) inflate.findViewById(R.id.viewPager_banner);
        //        mTextView = (TextView) inflate.findViewById(R.id.tv_banner_title);
        mLlpoint = (LinearLayout) inflate.findViewById(R.id.ll_dot);

    }


    class BannerPagerChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            position = getRealPosition(position);
            //            mTextView.setText(mTitles.get(position));
            changeDot(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    private int getRealPosition(int position) {
        int realPosition = 0;
        if (position == 0) {
            realPosition = mMPicSize - 1;
        } else if (position == mImgUrls.size() - 1) {
            realPosition = 0;
        } else {
            realPosition = position - 1;
        }
        return  realPosition;
    }


    //轮播图的数据更新   下拉刷新
//    public void updateData(ArrayList<String> banerImgList, ArrayList<String> banerTitleList) {
//        //        mTitles.clear();
//        //        mTitles.addAll(banerTitleList);
//        //        mImgUrls.clear();
//        //        mImgUrls.addAll(banerImgList);
//        for (int i = 0; i < banerImgList.size(); i++) {
//            Log.e("TAG", "i=====" + i);
//            if (mImgUrls.size() > i) {
//                mImgUrls.set(i, banerImgList.get(i));
//            } else {
//                mImgUrls.add(banerImgList.get(i));
//            }
//        }
//        mMPicSize = mImgUrls.size();
//
//
//        if (mBannerAdapter == null) {
//            mBannerAdapter = new BannerAdapter(mImgUrls);
//            mViewPager.setAdapter(mBannerAdapter);
//        } else {
//            mBannerAdapter.updateData(mImgUrls);
//        }
//    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int eventAction = ev.getAction();
        switch (eventAction) {
            case MotionEvent.ACTION_DOWN:
                stopLoop();
                break;
            case MotionEvent.ACTION_UP:
                startLoop();
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    public void startLoop() {
        //确保轮播只有一个任务在进行
        stopLoop();
        mHandler.sendEmptyMessageDelayed(0, LOOP_TIME);
    }

    public void stopLoop() {
        mHandler.removeCallbacksAndMessages(null);
    }

    //让小白球变粗
    private void changeDot(int position) {
        int childCount = mLlpoint.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ImageView childAt = (ImageView) mLlpoint.getChildAt(i);
            if (i == position) {
                childAt.setImageResource(R.drawable.bg_dot_selector);
            } else {
                childAt.setImageResource(R.drawable.bg_dot);
            }
        }
    }
}


//姿势:如果你希望在原先的触摸的基础上多一些逻辑,就可以考虑将该逻辑写到分发中dispatchTouchEvent




