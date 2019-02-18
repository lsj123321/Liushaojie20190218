package liushaojie.bawei.com.liushaojie.view.interfaces;

import liushaojie.bawei.com.liushaojie.model.bean.NewsBean;

/**
 * @Auther: 刘少杰
 * @Date: 2019/2/18 08:56:27
 * @Description:
 */
public interface IShowView extends IBaseShowView {
    public void onSuccess(NewsBean newsBean);
    public void onFail(String err);
}
