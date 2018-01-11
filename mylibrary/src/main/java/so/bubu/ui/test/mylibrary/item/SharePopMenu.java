package so.bubu.ui.test.mylibrary.item;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.PopupWindow;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Utils.DeviceHelper;
import so.bubu.ui.test.mylibrary.Adapter.common.ComRecyclerViewAdapter;
import so.bubu.ui.test.mylibrary.Adapter.common.RecyclerViewHolder;
import so.bubu.ui.test.mylibrary.R;
import so.bubu.ui.test.mylibrary.bean.ShareBean;
import so.bubu.ui.test.mylibrary.page.common.BaseApplication;

/**
 * @author linhuan on 2016/12/1 下午1:50
 */
public abstract class SharePopMenu<T> extends PopupWindow {

    private View view;
    private LinearLayout llContent;
    private LinkedList<T> shareBeanList = new LinkedList<>();

    public SharePopMenu(final Activity content) {
        addList(shareBeanList);
        view = LayoutInflater.from(content).inflate(R.layout.share_popup_menu, null); //ResourceHelper.loadLayout(content, R.layout.share_popup_menu, null);
        llContent = (LinearLayout) view.findViewById(R.id.ll_content);
        RecyclerView rcvContent = (RecyclerView) view.findViewById(R.id.rcv_content);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(content);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rcvContent.setLayoutManager(linearLayoutManager);

        view.findViewById(R.id.iv_image).setOnClickListener(null);

        ComRecyclerViewAdapter adapter = new ComRecyclerViewAdapter(content, shareBeanList, R.layout.item_share_show) {
            @Override
            public void convert(RecyclerViewHolder viewHolder, Object item, int position) {
                doSomethingInconvert(viewHolder, item, position);
            }
        };

        rcvContent.setAdapter(adapter);

        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        view.findViewById(R.id.tv_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        setBackgroundDrawable(new BitmapDrawable());
        setFocusable(true);
        setOutsideTouchable(true);

        setContentView(view);
    }

    public abstract void addList(LinkedList<T> shareBeanList);

    public abstract void doSomethingInconvert(RecyclerViewHolder viewHolder, Object item, int position);

    /**
     * 显示popupWindow
     *
     * @param parent
     */
    public void showPopupWindow(View parent, Context context) {
        if (!this.isShowing()) {
            // 以下拉方式显示popupwindow

            view.startAnimation(AnimationUtils.loadAnimation(BaseApplication.getInstance(), R.anim.fade_in));
            llContent.startAnimation(AnimationUtils.loadAnimation(context, R.anim.push_bottom_in));

            this.showAtLocation(parent, Gravity.BOTTOM, 0, 0);
            this.update();
        } else {
            this.dismiss();
        }
    }

}
