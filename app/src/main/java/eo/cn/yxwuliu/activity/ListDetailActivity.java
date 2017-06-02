package eo.cn.yxwuliu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import eo.cn.yxwuliu.R;
import eo.cn.yxwuliu.bean.GoodsBean;


/**
 * Created by Administrator on 2017/5/9.
 * 首页详情
 */
public class ListDetailActivity extends AppCompatActivity {
    private TextView mTvName;
    private TextView mTvGoodStart;
    private TextView mTvGoodDetail;
    private TextView mTvCarWant;
    private TextView mTvGoodEnd;
    private TextView mTvGetgoods;
    private TextView mTvWheregoods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_detail);
        initUI();
    }

    protected void initUI() {
        mTvName = (TextView) findViewById(R.id.g_name_tv);
        mTvGoodStart = (TextView) findViewById(R.id.tv_mypublishcars_starting);
        mTvGetgoods = (TextView) findViewById(R.id.get_goods_adress_tv);
        mTvWheregoods = (TextView) findViewById(R.id.goods_adress_tv);
        mTvGoodEnd = (TextView) findViewById(R.id.tv_mypublishcars_ending);
        mTvGoodDetail = (TextView) findViewById(R.id.goods_detail_tv);
        mTvCarWant = (TextView) findViewById(R.id.cars_want_tv);
        Intent intent = getIntent();
        GoodsBean.DataBean data = (GoodsBean.DataBean) intent.getSerializableExtra("data");
        mTvName.setText(data.getHuozhu_name());

        mTvWheregoods.setText("具体的送货到哪里");
        mTvGetgoods.setText("具体的取货地址");
        mTvGoodStart.setText(data.getYuan_dizhi());
        mTvGoodEnd.setText(data.getFahuo_dizhi());
        mTvGoodDetail.setText("货物详情:"+data.getHuo_kg() + "");
        mTvCarWant.setText("车辆需求:"+data.getChe_class());
    }

    public void back(View view) {
        finish();
    }
}
