package so.bubu.ui.test.mylibrary.Adapter;

import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;

import so.bubu.ui.test.mylibrary.Adapter.common.RecyclerViewHolder;

/**
 * Created by zhengheng on 18/1/25.
 */
public class MyAdapter extends DelegateAdapter.Adapter<RecyclerViewHolder> {

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return null;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

    }

    @Override
    protected void onBindViewHolderWithOffset(RecyclerViewHolder holder, int position, int offsetTotal) {
        super.onBindViewHolderWithOffset(holder, position, offsetTotal);
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
