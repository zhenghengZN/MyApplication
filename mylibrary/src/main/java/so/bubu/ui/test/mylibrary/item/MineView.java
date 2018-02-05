package so.bubu.ui.test.mylibrary.item;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
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

    public void init(JSONObject objects) {
        this.objects = objects;
        try {
            String title = (String) objects.get("title");
            if (title != null && !title.isEmpty()) {
                name.setVisibility(VISIBLE);
                name.setText(title);
            }
            String leftUrl = (String) objects.get("iconFontCode");
            if (leftUrl != null && !leftUrl.isEmpty()) {
                leftIcon.setVisibility(VISIBLE);
                leftIcon.setImageBitmap(GlideHelper.getHttpBitmap(leftUrl));
            }
            String detail = (String) objects.get("detail");
            if (detail != null && !detail.isEmpty()) {
                this.detail.setVisibility(VISIBLE);
                this.detail.setText(title);
            }
            String url = (String) objects.get("url");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
