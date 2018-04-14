package so.bubu.ui.test.mylibrary.page.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.flyco.tablayout.SlidingTabLayout;

import so.bubu.ui.test.mylibrary.R;
import so.bubu.ui.test.mylibrary.wiget.FatherViewPager;

/**
 * Created by zhengheng on 18/2/28.
 */
public class TabWithViewPager extends LinearLayout {
    public TabWithViewPager(Context context) {
        this(context, null);
    }

    private View view;
    private SlidingTabLayout tab;
    private FatherViewPager pager;

    public TabWithViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        view = LayoutInflater.from(context).inflate(R.layout.tabview_layout, this, true);
        pager = (FatherViewPager) view.findViewById(R.id.tab_viewpager);
        tab = (SlidingTabLayout) view.findViewById(R.id.taobao_slidingTabLayout);
//        TabAdapter tabAdapter = new TabAdapter(getChildFragmentManager(), titles);
//        tabAdapter.setFragment(setFragment(list));
//        pager.setAdapter(tabAdapter);
    }
    
    
}
