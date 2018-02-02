package so.bubu.ui.test.mylibrary.input;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import Utils.StringUtils;
import so.bubu.ui.test.mylibrary.R;
import so.bubu.ui.test.mylibrary.wiget.PickTimePopWindow;

/**
 * Created by zhengheng on 18/1/30.
 */
public class ChooseInputView extends LinearLayout {
    public ChooseInputView(Context context) {
        this(context, null);
    }

    private TextView num;
    private EditText phoneNum;
    private Context context;
    private PickTimePopWindow pickTimePopWindow;

    public ChooseInputView(final Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        View view = LayoutInflater.from(context).inflate(R.layout.chooseinputview, this, true);
        View addressPnum = view.findViewById(R.id.address_pnum);
        num = (TextView) view.findViewById(R.id.address);
        phoneNum = (EditText) view.findViewById(R.id.phone_num);
//        checkPhone();

        pickTimePopWindow = new PickTimePopWindow((Activity) context);
        pickTimePopWindow.setType(3);
        pickTimePopWindow.setOnSucessClickListener(new PickTimePopWindow.OnSucessClickListener() {
            @Override
            public void sucessClick(String date, View v) {
                if (date != null && !date.isEmpty()) {
                    num.setText(date);
                }
            }
        });

        addressPnum.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = ((Activity)context).getWindow().peekDecorView();
                if (view != null) {
                    InputMethodManager inputmanger = (InputMethodManager) ((Activity)context).getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputmanger.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
                pickTimePopWindow.showPopWindow(ChooseInputView.this, (Activity) context);
            }
        });
    }

    private ArrayList<String> titles = new ArrayList<>();

    public void init(JSONObject object) {
        try {
            String hint = (String) object.get("hint");
            phoneNum.setHint(hint);
            JSONArray inputContent = (JSONArray) object.get("inputContent");
            for (int i = 0; i < inputContent.length(); i++) {
                JSONObject jsonObject = inputContent.getJSONObject(i);
                String title = (String) jsonObject.get("title");
                titles.add(title);
            }
            if (titles.size() > 0) {
                num.setText(titles.get(0));
            }
            String[] values = titles.toArray(new String[titles.size()]);
            Log.e("zhengheng",""+ values.toString());
            pickTimePopWindow.setPickViewValue(values);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void checkPhone() {
        phoneNum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                boolean b = StringUtils.checkPhone(phoneNum.getText().toString());
                if (!b) {
                    Toast.makeText(context, "输入的手机号有误", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
