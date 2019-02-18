package liushaojie.bawei.com.liushaojie.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import liushaojie.bawei.com.liushaojie.R;

/**
 * @Auther: 刘少杰
 * @Date: 2019/2/18 09:03:10
 * @Description:
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
    }
}