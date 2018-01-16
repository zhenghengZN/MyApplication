package so.bubu.ui.test.mylibrary.page;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.flyco.tablayout.SlidingTabLayout;

import so.bubu.ui.test.mylibrary.R;
import so.bubu.ui.test.mylibrary.wiget.FatherViewPager;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class TabBaseFragment extends Fragment {


    public TabBaseFragment() {
        // Required empty public constructor
    }


    private View view;
    private SlidingTabLayout tab;
    private FatherViewPager pager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        if (view == null) {
        view = inflater.inflate(R.layout.tabview_layout, null);
//            LinearLayout content = (LinearLayout) view.findViewById(R.id.content);
        pager = (FatherViewPager) view.findViewById(R.id.tab_viewpager);
        pager.setAdapter(setPagerAdapter());
//            content.addView(addBaseContenetView(view));
        tab = (SlidingTabLayout) view.findViewById(R.id.taobao_slidingTabLayout);
        tab.setViewPager(pager);
        doInOnCreateView(view, pager);
//        }
        return view;
    }

    public abstract PagerAdapter setPagerAdapter();

//    public abstract View addBaseContenetView(View parentView);


    public abstract void doInOnCreateView(View parentView, FatherViewPager pager);


    public void tabViewSetViewPager() {

    }
}
