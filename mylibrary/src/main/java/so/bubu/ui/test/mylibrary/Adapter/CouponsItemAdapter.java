package so.bubu.ui.test.mylibrary.Adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.LinkedList;
import java.util.List;

import Utils.CommonMethod;
import Utils.ResourceUtil;
import common.ComRecyclerViewAdapter;
import common.RecyclerViewHolder;
import so.bubu.ui.test.mylibrary.R;
import so.bubu.ui.test.mylibrary.bean.CouponItemBean;


/**
 * Created by zhengheng on 17/12/25.
 */
public abstract class CouponsItemAdapter<T extends CouponItemBean.ObjectsBean> extends ComRecyclerViewAdapter {

    private LinkedList<T> mDatasList = new LinkedList();

    public CouponsItemAdapter(Context context, List<T> mDatas) {
        super(context, mDatas, R.layout.taobao_item);
        mDatasList.addAll(mDatas);
    }

    @Override
    public void convert(RecyclerViewHolder holder, Object item, int position) {

//        CouponItemBean.ObjectsBean taobaoContentBean = (T) mDatasList.get(position);
        T taobaoContentBean = (T) mDatasList.get(position);
        holder.setText(R.id.taobao_pro_desc, taobaoContentBean.getTitle());
        holder.setText(R.id.taobao_finalPrice, taobaoContentBean.getFinalPrice() + " ");

        holder.setText(R.id.biz30Day, "月销:" + taobaoContentBean.getBiz30Day());
        holder.setText(R.id.couponAmount, "立减 " + taobaoContentBean.getCouponAmount() + " 元");

        holder.setImageResource(R.id.taobao_platform, R.drawable.taobao_logo_30);
        holder.setText(R.id.taobao_discountPrice, "淘宝价 ¥" + taobaoContentBean.getDiscountPrice());

        CouponsItemAdapter.displayImageByResizeasBitmap(mContext, CommonMethod.getThumbUrl(taobaoContentBean.getPicUrl(), ResourceUtil.Dp2Px(115), ResourceUtil.Dp2Px(115)), ResourceUtil.Dp2Px(115), ResourceUtil.Dp2Px(115), (ImageView) holder.getView(R.id.product_img));
        doDrther(holder, mDatasList.get(position), position);
        holder.itemView.setTag(position);
    }


    public abstract void doDrther(RecyclerViewHolder viewHolder, T item, int position);

    public static void displayImageByResizeasBitmap(Context context, String url, int targetWidth, int targetHeight, ImageView targetView) {

        Glide
                .with(context)
                .load(R.drawable.bindtaobao)
//                .crossFade()
                .asBitmap()
                .placeholder(R.drawable.imagebackground)
                .error(R.drawable.imagebackground)
                .override(targetWidth, targetHeight)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .centerCrop()
//                .animate(animationObject)
                .into(targetView);
    }

}
