package so.bubu.ui.test.mylibrary.Adapter;

import android.content.Context;

import java.util.LinkedList;

import common.ComRecyclerViewAdapter;
import common.RecyclerViewHolder;
import so.bubu.ui.test.mylibrary.bean.CouponsItemBean;

/**
 * Created by zhengheng on 17/12/28.
 */
public class GridCouponItemAdapter<T extends CouponsItemBean.ObjectsBean> extends ComRecyclerViewAdapter {
    public GridCouponItemAdapter(Context context, LinkedList mDatas, int itemLayoutId) {
        super(context, mDatas, itemLayoutId);
    }

    @Override
    public void convert(RecyclerViewHolder viewHolder, Object item, int position) {

    }
}
