package so.bubu.ui.test.mylibrary.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.LinkedList;
import java.util.List;

import Utils.CommonMethod;
import Utils.ResourceUtil;
import so.bubu.ui.test.mylibrary.R;
import so.bubu.ui.test.mylibrary.bean.CouponItemBean;
import so.bubu.ui.test.mylibrary.item.CouponItem;


/**
 * Created by zhengheng on 17/12/25.
 */
public class CouponItemAdapter extends RecyclerView.Adapter<CouponItemAdapter.ViewHolder> implements View.OnClickListener, View.OnLongClickListener {

    private Context mContext;
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_ITEM = 1;
    private LinkedList<CouponItemBean.ObjectsBean> mlist = new LinkedList();

    public <T> CouponItemAdapter(Context context, List<CouponItemBean.ObjectsBean> list) {
        this.mContext = context;
        this.mlist.addAll(list);
    }

    @Override
    public CouponItemAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        if (mHeaderView != null && viewType == TYPE_HEADER) {
            return new ViewHolder(mHeaderView);
        } else {
            CouponItem item = new CouponItem(mContext);
            ViewHolder holder = new ViewHolder(item.getCouponItem(), item);
            item.getCouponItem().setOnClickListener(this);
            item.getCouponItem().setOnLongClickListener(this);
            return holder;
        }
    }

    @Override
    public void onBindViewHolder(CouponItemAdapter.ViewHolder holder, int pos) {
        if (getItemViewType(pos) == TYPE_HEADER) {
            return;
        }
        final int position = getRealPosition(holder);
        CouponItemBean.ObjectsBean taobaoContentBean = mlist.get(pos);
        holder.mProDesc.setText(taobaoContentBean.getTitle());
        holder.mFinalPrice.setText(taobaoContentBean.getFinalPrice() + " ");

        holder.mDiz30Day.setText("月销:" + taobaoContentBean.getBiz30Day());
        holder.mCouponAmount.setText("立减 " + taobaoContentBean.getCouponAmount() + " 元");

        holder.mPlatformImage.setImageResource(R.drawable.taobao_logo_30);
        holder.mDiscountPrice.setText("淘宝价 ¥" + taobaoContentBean.getDiscountPrice());

        CouponItemAdapter.displayImageByResizeasBitmap(mContext, CommonMethod.getThumbUrl(taobaoContentBean.getPicUrl(), ResourceUtil.Dp2Px(115), ResourceUtil.Dp2Px(115)), ResourceUtil.Dp2Px(115), ResourceUtil.Dp2Px(115), holder.mProImage);
        holder.itemView.setTag(position);
    }


    @Override
    public int getItemViewType(int position) {
        if (getHeaderView() != null && position == 0) {
            return TYPE_HEADER;
        }else {
            return TYPE_ITEM;
        }
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(mContext, "" + mlist.get((int) v.getTag()), Toast.LENGTH_SHORT).show();
        if (onitemclicklistener != null) {
            onitemclicklistener.OnItemClickListener(v, (int) v.getTag());
            onitemclicklistener.LongItemClickListener(v, (int) v.getTag());
        }
    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }

    private OnItemClickListener onitemclicklistener;

    public void setOnClickListener(OnItemClickListener onitemclicklistener) {
        this.onitemclicklistener = onitemclicklistener;
    }

    interface OnItemClickListener {
        void OnItemClickListener(View view, int position);

        void LongItemClickListener(View view, int position);
    }


    public void setHeaderView(View headerView) {
        mHeaderView = headerView;
        notifyItemInserted(0);
    }

    public View getHeaderView() {
        return mHeaderView;
    }

    public int getRealPosition(RecyclerView.ViewHolder holder) {
        int position = holder.getLayoutPosition();
        return mHeaderView == null ? position : position - 1;
    }

    private View mHeaderView;

    class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mProImage, mPlatformImage;
        public TextView mProDesc, mDiscountPrice, mDiz30Day, mMuch, mFinalPrice, mCouponAmount;

        public ViewHolder(View itemView, CouponItem item) {
            super(itemView);
            mProImage = item.getProImage();
            mPlatformImage = item.getPlatformImage();
            mProDesc = item.getProDesc();
            mDiscountPrice = item.getDiscountPrice();
            mDiz30Day = item.getDiz30Day();
            mMuch = item.getMuch();
            mFinalPrice = item.getFinalPrice();
            mCouponAmount = item.getCouponAmount();
        }

        public ViewHolder(View itemView){
            super(itemView);

        }
    }

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
