package so.bubu.ui.test.mylibrary.page;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import so.bubu.ui.test.mylibrary.R;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class TabBaseFragment extends Fragment {


    public TabBaseFragment() {
        // Required empty public constructor
    }


    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.tabview_layout, null);
            LinearLayout content = (LinearLayout) view.findViewById(R.id.content);
            ViewPager pager = (ViewPager) view.findViewById(R.id.tab_viewpager);
            content.addView(addBaseContenetView(view));
            doInOnCreateView(view, pager);
        }
        return view;
    }

    public abstract View addBaseContenetView(View parentView);


    public abstract void doInOnCreateView(View parentView, ViewPager pager);

}
