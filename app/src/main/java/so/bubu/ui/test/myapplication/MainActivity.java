package so.bubu.ui.test.myapplication;


import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

import so.bubu.ui.test.mylibrary.page.common.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setBackClick();
    }

    @Override
    protected void onCreateView(Bundle savedInstanceState) {

    }

    @Override
    protected void doBack(int keyCode, KeyEvent event) {
        finish();
    }

}
