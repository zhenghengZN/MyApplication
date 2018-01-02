package so.bubu.ui.test.mylibrary.page.common;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import so.bubu.ui.test.mylibrary.R;

/**
 * Created by zhengheng on 18/1/2.
 */
public abstract class BaseActivity extends BaseCompatActivity {

    private LinearLayout view;

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_base);
        view = (LinearLayout) findViewById(R.id.base_scroll_content);
        view.addView(addBaseContenetView());
        doInCreateView();
    }

//    public View addBaseContenetView(int layoutResID) {
//      return  LayoutInflater.from(this).inflate(layoutResID, null);
//    }

    public abstract View addBaseContenetView();


    public abstract void doInCreateView();

    /**
     * 设置后退按钮
     */
    public void setBackClick() {
        findViewById(R.id.tv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doBack(-1, null);
            }
        });
    }

}
