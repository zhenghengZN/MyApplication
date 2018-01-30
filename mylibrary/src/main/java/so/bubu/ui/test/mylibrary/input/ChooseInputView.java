package so.bubu.ui.test.mylibrary.input;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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

    public ChooseInputView(final Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        View view = LayoutInflater.from(context).inflate(R.layout.chooseinputview, this, true);
        View addressPnum = view.findViewById(R.id.address_pnum);
        num = (TextView) view.findViewById(R.id.address);
        phoneNum = (EditText) view.findViewById(R.id.phone_num);
        checkPhone();

        final PickTimePopWindow pickTimePopWindow = new PickTimePopWindow((Activity) context, 0);
        pickTimePopWindow.setOnSucessClickListener(new PickTimePopWindow.OnSucessClickListener() {
            @Override
            public void sucessClick(String date, View v) {
                num.setText(date);
            }
        });

        addressPnum.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                pickTimePopWindow.showPopWindow(ChooseInputView.this, (Activity) context);
            }
        });
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
