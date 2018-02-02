package so.bubu.ui.test.mylibrary.wiget.form;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import so.bubu.ui.test.mylibrary.R;
import so.bubu.ui.test.mylibrary.wiget.WarningEditText;

/**
 * Created by zhengheng on 18/2/1.
 */
public class FormTwoTextView extends LinearLayout {
    public FormTwoTextView(Context context) {
        this(context, null);
    }

    private TextView title, getCheck;
    private WarningEditText content;

    public FormTwoTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.formtwotextview, this, true);
        title = (TextView) view.findViewById(R.id.title);
        content = (WarningEditText) view.findViewById(R.id.warin_edittext);
        getCheck = (TextView) view.findViewById(R.id.getcheck);
    }


    public void setTitle(String s) {
        title.setText(s);
    }

    public void setButtonTitle(String s) {
        getCheck.setText(s);
    }

    public void init(JSONObject object) {
        try {
            String title = (String) object.get("title");
            setTitle(title);

            String buttonTitle = (String) object.get("buttonTitle");
            setButtonTitle(buttonTitle);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
