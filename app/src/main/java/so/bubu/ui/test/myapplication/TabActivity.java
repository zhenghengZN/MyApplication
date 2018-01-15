package so.bubu.ui.test.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import so.bubu.ui.test.mylibrary.page.TabBaseFragment;

public class TabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
//        FrameLayout view = (FrameLayout) findViewById(R.id.parent);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction bt = manager.beginTransaction();
        bt.replace(R.id.parent, new TabBaseFragment() {
            @Override
            public View addBaseContenetView(View parent) {
                TextView textView = new TextView(TabActivity.this);
                textView.setText("aa");
                return textView;
            }

            @Override
            public void doInOnCreateView(View view,ViewPager pager) {

            }
        });
        bt.commitAllowingStateLoss();
    }


}
