package so.bubu.ui.test.mylibrary.page.tab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by zhengheng on 18/2/11.
 */
public class TabAdapter<T extends Fragment> extends FragmentStatePagerAdapter {

    private ArrayList<String> title = new ArrayList<>();
    private ArrayList<T> list = new ArrayList<>();
    private HashMap<Integer, Fragment> fragmentlist = new HashMap<>();
    private FragmentManager fm;
    private Fragment fragment;

    public TabAdapter(FragmentManager fm, ArrayList<String> title) {
        super(fm);
        this.fm = fm;
        this.title = title;
    }

    @Override
    public Fragment getItem(int position) {
        if (fragmentlist.get(position) == null) {

        } else {
            fragment = fragmentlist.get(position);
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return title.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        this.fm.beginTransaction().show(fragment).commit();
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        Fragment fragment = fragmentlist.get(position);
        fm.beginTransaction().hide(fragment).commit();
    }
//    public void setFragment(ArrayList<T> list){
//        this.list = list;
//    }
}
