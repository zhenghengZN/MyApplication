package so.bubu.ui.test.mylibrary.page;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.LinkedList;

import so.bubu.ui.test.mylibrary.Adapter.BannerActivityAdapter;
import so.bubu.ui.test.mylibrary.R;

/**
 * Created by zhengheng on 18/1/16.
 */
public class BaseBannerFragment extends Fragment {

    public BaseBannerFragment() {
    }

    private BannerActivityAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_banner, container, false);
        RecyclerView rcv = (RecyclerView) view.findViewById(R.id.rcv_information);
        rcv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayout.VERTICAL, false));
        adapter = new BannerActivityAdapter(new LinkedList<String>());
        rcv.setAdapter(adapter);
        return view;
    }
}
