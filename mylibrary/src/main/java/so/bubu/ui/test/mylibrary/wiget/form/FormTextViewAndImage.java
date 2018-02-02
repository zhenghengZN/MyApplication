package so.bubu.ui.test.mylibrary.wiget.form;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import Utils.GlideHelper;
import Utils.ResourceUtil;
import so.bubu.ui.test.mylibrary.R;
import so.bubu.ui.test.mylibrary.wiget.WarningEditText;

/**
 * Created by zhengheng on 18/2/1.
 */
public class FormTextViewAndImage extends LinearLayout {
    public FormTextViewAndImage(Context context) {
        this(context, null);
    }

    private TextView title;
    private WarningEditText content;
    private ImageView checkCodeImg;
    private Context ctx;

    public FormTextViewAndImage(Context context, AttributeSet attrs) {
        super(context, attrs);
        ctx = context;
        View view = LayoutInflater.from(context).inflate(R.layout.formtextviewandimage, this, true);
        title = (TextView) view.findViewById(R.id.title);
        content = (WarningEditText) view.findViewById(R.id.warin_edittext);
        checkCodeImg = (ImageView) view.findViewById(R.id.checkcode_img);
    }

    public void init(JSONObject object) {
        try {
            String title = (String) object.get("title");
            setTitle(title);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setTitle(String s) {
        title.setText(s);
    }

    public void setImage(String url) {
        GlideHelper.display(ctx, url, ResourceUtil.Dp2Px(95), ResourceUtil.Dp2Px(40), checkCodeImg);
    }

}
