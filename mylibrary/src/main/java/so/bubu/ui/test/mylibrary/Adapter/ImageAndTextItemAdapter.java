package so.bubu.ui.test.mylibrary.Adapter;

import android.content.Context;

import java.util.LinkedList;
import java.util.List;

import common.ComRecyclerViewAdapter;
import common.RecyclerViewHolder;
import so.bubu.ui.test.mylibrary.R;
import so.bubu.ui.test.mylibrary.bean.MineBean;

/**
 * Created by zhengheng on 17/12/26.
 */
public  abstract class ImageAndTextItemAdapter <T extends MineBean.ObjectsBean> extends ComRecyclerViewAdapter{
    private LinkedList<T> mDataList = new LinkedList<>();
    public ImageAndTextItemAdapter(Context context, List mDatas, int itemLayoutId) {
        super(context, mDatas, R.layout.mine_cell);
        mDataList.addAll(mDatas);
    }

    @Override
    public void convert(RecyclerViewHolder viewHolder, Object item, int position)
    {
        T t = mDataList.get(position);
        viewHolder.setText(R.id.tv_name, mDataList.get(position).getTitle());
        doOrther(viewHolder, mDataList.get(position), position);
    }

    public abstract void doOrther(RecyclerViewHolder viewHolder, T item, int position);

}
