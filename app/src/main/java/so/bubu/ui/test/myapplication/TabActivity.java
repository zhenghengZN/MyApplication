package so.bubu.ui.test.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import so.bubu.ui.test.mylibrary.page.TabBaseFragment;
import so.bubu.ui.test.mylibrary.wiget.FatherViewPager;

public class TabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
//        FrameLayout view = (FrameLayout) findViewById(R.id.parent);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction bt = manager.beginTransaction();
        TabBaseFragment tabBaseFragment = new TabBaseFragment() {
            @Override
            public PagerAdapter setPagerAdapter() {
                MyPagerAdapter myPagerAdapter = new MyPagerAdapter(TabActivity.this.getSupportFragmentManager());
                return myPagerAdapter;
            }

            @Override
            public void doInOnCreateView(View view, FatherViewPager pager) {

            }
        };

        bt.add(R.id.parent, tabBaseFragment);
        bt.commit();
//        tabBaseFragment.tabViewSetViewPager();
    }


}
