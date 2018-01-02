package so.bubu.ui.test.mylibrary.page.common;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import so.bubu.ui.test.mylibrary.R;

/**
 * Created by zhengheng on 18/1/2.
 */
public abstract class BaseActivity extends BaseCompatActivity{

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
