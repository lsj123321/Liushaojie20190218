package liushaojie.bawei.com.liushaojie.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bumptech.glide.load.model.ModelLoader;

import liushaojie.bawei.com.liushaojie.R;
import liushaojie.bawei.com.liushaojie.model.bean.NewsBean;
import liushaojie.bawei.com.liushaojie.presenter.ShowPresenter;
import liushaojie.bawei.com.liushaojie.view.adapter.MyBaseAdapter;
import liushaojie.bawei.com.liushaojie.view.interfaces.IShowView;

public class ShowActivity extends BaseActivity implements IShowView {

    private RecyclerView recyclerView;
    private ShowPresenter showPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        initView();
        initData();
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerView_show);

    }

    private void initData() {
        showPresenter = new ShowPresenter();
        showPresenter.setView(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onSuccess(NewsBean newsBean) {

    }

    @Override
    public void onFail(String err) {

    }
    //解绑
    @Override
    protected void onDestroy() {
        super.onDestroy();
        showPresenter.detachView();
    }
}
