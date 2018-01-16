package so.bubu.ui.test.mylibrary.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Entity;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.util.MultiTypeDelegate;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import Utils.CommonMethod;
import Utils.DeviceHelper;
import Utils.GlideHelper;
import Utils.ResourceUtil;
import Utils.transformation.RoundedCornersTransformation;
import so.bubu.ui.test.mylibrary.Adapter.common.ComRecyclerViewAdapter;
import so.bubu.ui.test.mylibrary.Adapter.common.RecyclerViewHolder;
import so.bubu.ui.test.mylibrary.R;
import so.bubu.ui.test.mylibrary.item.HotItemView;
import so.bubu.ui.test.mylibrary.item.VideoItem;
import so.bubu.ui.test.mylibrary.page.helper.Helper;
import so.bubu.ui.test.mylibrary.wiget.CircleImageView;

/**
 * Created by zhengheng on 18/1/16.
 */
public  class TypeDiffItemAdapter extends BaseMultiItemQuickAdapter<TypeDiffItemAdapter.MultipleItem, BaseViewHolder> {


    private List list;
    private int mWidth, mHeight;


    public TypeDiffItemAdapter(List list) {
        super(list);
        this.list = list;

        addItemType(MultipleItem.COUPONITEM, R.layout.taobao_item);
        addItemType(MultipleItem.GRIDCOUPONITEM, R.layout.taobao_item2);
        addItemType(MultipleItem.RECOMMEND, R.layout.item_commended_content);
        addItemType(MultipleItem.HOTITEM, R.layout.item_main_hot_disney);
        addItemType(MultipleItem.VIDEOITEM, R.layout.video_item);
        addItemType(MultipleItem.COMMENT, R.layout.comment_list_item);
        addItemType(MultipleItem.TRAVELS, R.layout.travels_item);


    }

    @Override
    protected void convert(BaseViewHolder holder, MultipleItem item) {
        HashMap<String, Object> object = item.getObjects();
//        int position = getParentPosition(item);
//        LinkedList<HashMap<String, Object>> objects = item.getObjects();
//        HashMap<String, Object> object = objects.get(0);
        switch (holder.getItemViewType()) {
            case MultipleItem.COUPONITEM:
                holder.setText(R.id.taobao_pro_desc, (String) object.get("title"));
                holder.setText(R.id.taobao_finalPrice, object.get("finalPrice") + " ");

                holder.setText(R.id.biz30Day, "月销:" + object.get("biz30Day"));
                holder.setText(R.id.couponAmount, "立减 " + object.get("couponAmount") + " 元");

                if (("天猫").equalsIgnoreCase((String) object.get("platform"))) {
                    holder.setImageResource(R.id.taobao_platform, R.drawable.tmall_logo_30);
                    holder.setText(R.id.taobao_discountPrice, "天猫价 ¥" + object.get("discountPrice"));
                } else {
                    holder.setImageResource(R.id.taobao_platform, R.drawable.taobao_logo_30);
                    holder.setText(R.id.taobao_discountPrice, "淘宝价 ¥" + object.get("discountPrice"));
                }
                CouponsItemAdapter.displayImageByResizeasBitmap(mContext, CommonMethod.getThumbUrl((String) object.get("picUrl"), ResourceUtil.Dp2Px(115), ResourceUtil.Dp2Px(115)), ResourceUtil.Dp2Px(115), ResourceUtil.Dp2Px(115), (ImageView) holder.getView(R.id.product_img));
                break;
            case MultipleItem.GRIDCOUPONITEM:
                break;
            case MultipleItem.RECOMMEND:
                mWidth = DeviceHelper.getScreenWidth() - ResourceUtil.Dp2Px(22 * 2);
                mHeight = mWidth * (320 + 11 * 2) / 628;
                holder.setImageResource(R.id.iv_go, R.drawable.back);
                holder.setText(R.id.tv_title, (String) object.get("title"));
                holder.setText(R.id.jtv_content, (String) object.get("content"));

                GlideHelper.displayRoundedCornersImage702(mContext, CommonMethod.getThumbUrl((String) object.get("url"), mWidth, mHeight), mWidth, mHeight, ResourceUtil.Dp2Px(4), (ImageView) holder.getView(R.id.iv_recommended));
                holder.setImageResource(R.id.iv_like, R.drawable.back);
                holder.setImageResource(R.id.iv_comment, R.drawable.back);
                holder.setText(R.id.tv_like, (String) object.get("like"));
                holder.setText(R.id.tv_comment, (String) object.get("comment"));
                break;
            case MultipleItem.HOTITEM:
                mWidth = DeviceHelper.getScreenWidth() - ResourceUtil.Dp2Px(12 * 2);
                mHeight = mWidth * 280 / 702;
//                HotItemView itemView = new HotItemView(this);
//                View itemView1 = itemView.getItemView();
                GlideHelper.displayRoundedCornersImage702(mContext, CommonMethod.getThumbUrl((String) object.get("backgroundImageUrl350"), mWidth, mHeight), mWidth, mHeight, ResourceUtil.Dp2Px(4), (ImageView) holder.getView(R.id.iv_hot), RoundedCornersTransformation.CornerType.ALL);

                holder.setText(R.id.tv_name_desc, (String) object.get("subtitle"));
                holder.setText(R.id.tv_name_cn, (String) object.get("subtitle"));

                break;
            case MultipleItem.VIDEOITEM:
                mWidth = DeviceHelper.getScreenWidth() - ResourceUtil.Dp2Px(12 * 2);
                mHeight = mWidth * 280 / 702;
                GlideHelper.displayRoundedCornersImage702(mContext, CommonMethod.getThumbUrl((String) object.get("backgroundImageUrl"), mWidth, mHeight), mWidth, mHeight, ResourceUtil.Dp2Px(4), (ImageView) holder.getView(R.id.iv_hot), RoundedCornersTransformation.CornerType.ALL);
                holder.setText(R.id.video_title, (String) object.get("subtitle"));
                break;
            case MultipleItem.COMMENT:
                holder.setText(R.id.comment_list_content, (String) object.get("content"));
                holder.setText(R.id.comment_list_time, CommonMethod.showTime((String) object.get("time")));

                holder.setText(R.id.comment_user_name, (String) object.get("userName"));

                GridView view = holder.getView(R.id.review_item_gridview);
                final List<String> urls = (LinkedList) object.get("urls");
                view.setAdapter(new ReviewAdapter(mContext, urls));
                view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                ImagePageActivity.imageBrower((Activity)mContext, position, urls.toArray(new String[urls.size()]));
//                        setGridItemOnclick((Activity) mContext, position, urls, parent, view);
                    }
                });


                final CircleImageView iconImg = holder.getView(R.id.comment_user_icon);

                SimpleTarget target = new SimpleTarget<Bitmap>(ResourceUtil.Dp2Px(44), ResourceUtil.Dp2Px(44)) {
                    @Override
                    public void onResourceReady(Bitmap bitmap, GlideAnimation glideAnimation) {
                        iconImg.setImageBitmap(bitmap);
                    }
                };

                if (Helper.isNotEmpty((String) object.get("userPicUrl"))) {
                    Glide.with(mContext.getApplicationContext())
                            .load((String) object.get("userPicUrl"))
                            .asBitmap()
                            .into(target);
                } else {
                    iconImg.setImageResource(R.drawable.pho_user_head);
                }
                break;
            case MultipleItem.TRAVELS:
                GlideHelper.displayImageByResizeasBitmap(mContext, CommonMethod.getThumbUrl((String) object.get("url"), mWidth, mHeight), mWidth, mHeight, (ImageView) holder.getView(R.id.product_img));
                holder.setText(R.id.taobao_pro_desc, (String) object.get("subtitle"));
                holder.setText(R.id.taobao_much, (String) object.get("title"));
                break;
        }
//        doOther(holder, item);
    }

//    public abstract void doOther(BaseViewHolder viewHolder, MultipleItem multipleItem);

//    public abstract void setGridItemOnclick(Activity mContext, int position, List<String> urls, AdapterView<?> parent, View view);
//

    public class MultipleItem implements MultiItemEntity {
        public static final int COUPONITEM = 1;
        public static final int GRIDCOUPONITEM = 2;
        public static final int HOTITEM = 3;
        public static final int VIDEOITEM = 4;
        public static final int RECOMMEND = 5;
        public static final int COMMENT = 6;
        public static final int TRAVELS = 7;

        private int itemType;
        private HashMap<String, Object>  objects;

        public MultipleItem(int itemType) {
            this.itemType = itemType;
        }

        public MultipleItem(int itemType, HashMap<String, Object>  objects) {
            this.itemType = itemType;
            this.objects = objects;
        }

        @Override
        public int getItemType() {
            return itemType;
        }

        public HashMap<String, Object> getObjects() {
            return objects;
        }

        public void setObjects(HashMap<String, Object> objects) {
            this.objects = objects;
        }
    }

}
