package so.bubu.ui.test.mylibrary.page;


import android.os.Bundle;
import android.view.KeyEvent;

import so.bubu.ui.test.mylibrary.R;
import so.bubu.ui.test.mylibrary.page.common.BaseCompatActivity;

/**
 * Created by zhengheng on 18/1/19.
 */
public class SeachActivity extends BaseCompatActivity {

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_search);
    }

    @Override
    protected void doBack(int keyCode, KeyEvent event) {
        finish();
        this.overridePendingTransition(R.anim.pull_alpha_in, R.anim.pull_alpha_out);
    }
}
