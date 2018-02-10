package so.bubu.ui.test.mylibrary.item;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.LinkedHashMap;

import Utils.GlideHelper;
import so.bubu.ui.test.mylibrary.R;

/**
 * Created by zhengheng on 18/2/5.
 */
public class MineView extends LinearLayout {
    public MineView(Context context) {
        this(context, null);
    }

    private ImageView leftIcon, rightIcon;
    private TextView name, detail;
    private RelativeLayout layout;

    public MineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.mine_cell, this, true);
        leftIcon = (ImageView) view.findViewById(R.id.left_icon);
        name = (TextView) view.findViewById(R.id.tv_name);
        detail = (TextView) view.findViewById(R.id.tv_detail);
        rightIcon = (ImageView) view.findViewById(R.id.right_icon);
        layout = (RelativeLayout) view.findViewById(R.id.img_icon);
    }

    private JSONObject objects;

    private ViewGroup.LayoutParams lp=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    public void init(JSONObject objects) {
        this.setLayoutParams(lp);
        this.objects = objects;
        try {
            String title = (String) objects.get("title");
            if (title != null && !title.isEmpty()) {
                name.setVisibility(VISIBLE);
                name.setText(title);
            }
            String leftUrl = (String) objects.get("picUrl");
            if (leftUrl != null && !leftUrl.isEmpty()) {
                layout.setVisibility(VISIBLE);
                GlideHelper.display(getContext(),leftUrl,leftIcon);
            }
            String detail = (String) objects.get("detail");
            if (detail != null && !detail.isEmpty()) {
                this.detail.setVisibility(VISIBLE);
                this.detail.setText(detail);
            }
            String url = (String) objects.get("url");
            if (url != null && !url.isEmpty()) {
                rightIcon.setVisibility(VISIBLE);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
