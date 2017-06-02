package eo.cn.yxwuliu.presenter;

import eo.cn.yxwuliu.base.BasePresenter;
import eo.cn.yxwuliu.view.IClassifyProductView;

/**
 * @author jk
 * @time 2017/5/30  17:11
 * @desc 分类的p层
 */
public class ClassifyPresenter extends BasePresenter<IClassifyProductView> {

    private IClassifyProductView mIClassifyView;

    public ClassifyPresenter(IClassifyProductView mIClassifyView) {
        this.mIClassifyView = mIClassifyView;

    }
}
