package so.bubu.ui.test.mylibrary.Adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.LinkedList;

import Utils.CommonMethod;
import Utils.ResourceUtil;
import common.ComRecyclerViewAdapter;
import common.RecyclerViewHolder;
import so.bubu.ui.test.mylibrary.R;
import so.bubu.ui.test.mylibrary.bean.CouponsItemBean;

/**
 * Created by zhengheng on 17/12/28.
 */
public abstract class GridCouponItemAdapter<T extends CouponsItemBean.ObjectsBean> extends ComRecyclerViewAdapter {
    private LinkedList<T> mDatasList;
    private int mGridWidth;

    public GridCouponItemAdapter(Context context, LinkedList mDatas) {
        super(context, mDatas, R.layout.taobao_item2);
        mDatasList = mDatas;
        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        // 计算显示大小
        mGridWidth = wm.getDefaultDisplay().getWidth() / 2;
    }

    @Override
    public void convert(RecyclerViewHolder holder, Object item, int position) {
        T taobaoContentBean = (T) mDatasList.get(position);
        holder.setText(R.id.taobao_pro_desc, taobaoContentBean.getTitle());
        holder.setText(R.id.taobao_finalPrice, taobaoContentBean.getFinalPrice() + " ");

        ViewGroup.LayoutParams layoutParams = holder.getView(R.id.rl_content).getLayoutParams();
        layoutParams.width = mGridWidth;
        layoutParams.height = mGridWidth + ResourceUtil.Dp2Px(110);
        holder.getView(R.id.rl_content).setLayoutParams(layoutParams);
        holder.setText(R.id.biz30Day, "月销:" + taobaoContentBean.getBiz30Day());
        holder.setText(R.id.couponAmount, "立减 " + taobaoContentBean.getCouponAmount() + " 元");
        if (taobaoContentBean.getPlatform().equals("天猫")) {
            holder.setImageResource(R.id.taobao_platform, R.drawable.tmall_logo_30);
            holder.setText(R.id.taobao_discountPrice, "天猫价 ¥" + taobaoContentBean.getDiscountPrice());
        } else {
            holder.setImageResource(R.id.taobao_platform, R.drawable.taobao_logo_30);
            holder.setText(R.id.taobao_discountPrice, "淘宝价 ¥" + taobaoContentBean.getDiscountPrice());
        }
        GridCouponItemAdapter.displayImageByResizeasBitmap(mContext, CommonMethod.getThumbUrl(taobaoContentBean.getPicUrl(), mGridWidth, mGridWidth), mGridWidth, mGridWidth, (ImageView) holder.getView(R.id.product_img));
        doOther(holder, mDatasList.get(position), position);
        holder.itemView.setTag(position);
    }

    public abstract void doOther(RecyclerViewHolder viewHolder, T item, int position);


    public static void displayImageByResizeasBitmap(Context context, String url, int targetWidth, int targetHeight, ImageView targetView) {

        Glide
                .with(context)
                .load(url)
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
