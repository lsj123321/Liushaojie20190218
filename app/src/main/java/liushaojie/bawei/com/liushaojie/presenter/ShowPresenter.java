package liushaojie.bawei.com.liushaojie.presenter;

import java.io.IOException;

import liushaojie.bawei.com.liushaojie.model.bean.NewsBean;
import liushaojie.bawei.com.liushaojie.model.http.Http;
import liushaojie.bawei.com.liushaojie.view.interfaces.IShowView;

/**
 * @Auther: 刘少杰
 * @Date: 2019/2/18 08:57:19
 * @Description:
 */
public class ShowPresenter extends BaseShowPresenter<IShowView> implements Http.CallBackData<NewsBean> {

    private final Http http;

    public ShowPresenter(){
        http = Http.getInstance();
        http.setCallBackData(this);
    }
    @Override
    public void onSuccess(NewsBean newsBean) {
        getView().onSuccess(newsBean);
    }

    @Override
    public void onErr(IOException e) {

    }
}
