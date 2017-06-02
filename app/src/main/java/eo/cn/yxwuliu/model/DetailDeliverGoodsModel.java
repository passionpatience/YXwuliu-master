package eo.cn.yxwuliu.model;

import eo.cn.yxwuliu.base.BaseModel;

/**
 * @author jk
 * @time 2017/6/1  10:25
 * @desc ${TODD}
 */
public class DetailDeliverGoodsModel extends BaseModel implements IDetailDeliverGoodsModel {

    public DetailDeliverGoodsModel(boolean isCache) {
        super(isCache);
    }


    @Override
    public void SetOnGetGoodsListener(OnGetGoodsListener onGetGoodsListener) {

    }
}
