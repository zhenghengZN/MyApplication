package so.bubu.ui.test.mylibrary.Adapter;

import android.content.Context;
import android.widget.ImageView;

import java.util.LinkedList;

import Utils.CommonMethod;
import Utils.GlideHelper;
import Utils.ResourceUtil;
import so.bubu.ui.test.mylibrary.Adapter.common.ComRecyclerViewAdapter;
import so.bubu.ui.test.mylibrary.Adapter.common.RecyclerViewHolder;
import so.bubu.ui.test.mylibrary.R;
import so.bubu.ui.test.mylibrary.bean.TravelsBean;

/**
 * Created by zhengheng on 18/1/10.
 */
public abstract class TravelsAdapter<T extends TravelsBean> extends ComRecyclerViewAdapter {

    private int mWidth, mHeight;
    private LinkedList<T> mDatasList;

    public TravelsAdapter(Context context, LinkedList mDatas) {
        super(context, mDatas, R.layout.taobao_item);
        mWidth = ResourceUtil.Dp2Px(115);
        mHeight = ResourceUtil.Dp2Px(115);
        mDatasList = mDatas;
    }

    @Override
    public void convert(RecyclerViewHolder holder, Object item, int position) {
        T t = mDatasList.get(position);
        GlideHelper.displayImageByResizeasBitmap(mContext, CommonMethod.getThumbUrl(t.getUrl(), mWidth, mHeight), mWidth, mHeight, (ImageView) holder.getView(R.id.product_img));
        holder.setText(R.id.taobao_pro_desc, t.getSubtitle());
        holder.setText(R.id.taobao_much, t.getTitle());
        doOther(holder, mDatasList.get(position), position);
        holder.itemView.setTag(position);
    }

    public abstract void doOther(RecyclerViewHolder viewHolder, T item, int position);

}
