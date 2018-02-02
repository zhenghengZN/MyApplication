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
public class FormTextView extends LinearLayout {
    public FormTextView(Context context) {
        this(context, null);
    }
    private  TextView mTitle;
    private  WarningEditText content;
    public FormTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.formtextview, this, true);
        mTitle = (TextView) view.findViewById(R.id.title);
        content = (WarningEditText) view.findViewById(R.id.warin_edittext);
    }

    public void setTitle(String s){
        mTitle.setText(s);
    }


    public void init(JSONObject o){
        try {
            String title = (String) o.get("title");
            setTitle(title);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
