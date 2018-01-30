package so.bubu.ui.test.mylibrary.input;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

import Utils.StringUtils;
import so.bubu.ui.test.mylibrary.R;
import so.bubu.ui.test.mylibrary.wiget.PickTimePopWindow;
import so.bubu.ui.test.mylibrary.wiget.pickTimeView.PickTimeView;

/**
 * Created by zhengheng on 18/1/29.
 */
public class FormView extends LinearLayout {
    public FormView(Context context) {
        this(context, null);
    }

    private View view;
    private TextView getCheck, date, time;
    private EditText mQqNum, mPhoneNum, check;
    private ImageView checkImg;
    private Context context;

    public FormView(final Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        view = LayoutInflater.from(context).inflate(R.layout.form, this, true);
        mQqNum = (EditText) view.findViewById(R.id.qq_num);
        mPhoneNum = (EditText) view.findViewById(R.id.phone_num);
        checkPhoneAndQq();
        getCheck = (TextView) view.findViewById(R.id.getcheck);
        date = (TextView) view.findViewById(R.id.date);
        time = (TextView) view.findViewById(R.id.time);
        check = (EditText) view.findViewById(R.id.check);
        checkImg = (ImageView) view.findViewById(R.id.check_img);
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH) + 1;
        String months;
        if (month < 10) {
            months = "0" + month;
        } else {
            months = month + "";
        }
        date.setText(calendar.get(Calendar.YEAR) + "-" + months + "-" + calendar.get(Calendar.DAY_OF_MONTH));
        time.setText(calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE));
        checkImg.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onCheckCodeListener != null) {
                    onCheckCodeListener.getPhoneCheckCode();
                }
            }
        });

        getCheck.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onCheckCodeListener != null) {
                    onCheckCodeListener.getImageCheckCode();
                }
            }
        });


        final PickTimePopWindow datePick = new PickTimePopWindow((Activity) context, PickTimeView.TYPE_PICK_DATE);
        final PickTimePopWindow timePick = new PickTimePopWindow((Activity) context, PickTimeView.TYPE_PICK_TIME);
        datePick.setOnSucessClickListener(new PickTimePopWindow.OnSucessClickListener() {
            @Override
            public void sucessClick(String s, View v) {
                date.setText(s);
            }
        });
        timePick.setOnSucessClickListener(new PickTimePopWindow.OnSucessClickListener() {
            @Override
            public void sucessClick(String date, View v) {
                time.setText(date);
            }
        });


        date.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                datePick.showPopWindow(FormView.this, (Activity) context);
            }
        });

        time.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                timePick.showPopWindow(FormView.this, (Activity) context);
            }
        });
    }


    public void checkPhoneAndQq() {
        mPhoneNum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                boolean b = StringUtils.checkPhone(mPhoneNum.getText().toString());
                if (!b) {
                    Toast.makeText(context, "输入的手机号有误", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mQqNum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                boolean b = StringUtils.checkQQ(mQqNum.getText().toString());
                if (!b) {
                    Toast.makeText(context, "输入的QQ号有误", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


    public ArrayList<String> getValue() {
        ArrayList<String> strings = new ArrayList<>();
        String qq = mQqNum.getText().toString();
        String phone = mPhoneNum.getText().toString();
        String dt = date.getText().toString();
        String tm = time.getText().toString();
        String check = getCheck.getText().toString();
        strings.add(qq);
        strings.add(phone);
        strings.add(dt);
        strings.add(tm);
        strings.add(check);
        return strings;
    }

    private OnCheckCodeListener onCheckCodeListener;

    public interface OnCheckCodeListener {
        void getPhoneCheckCode();

        void getImageCheckCode();
    }

    public void setOnCheckCodeListener(OnCheckCodeListener onCheckCodeListener) {
        this.onCheckCodeListener = onCheckCodeListener;
    }

//    public interface OnFormFinishListener {
//        void OnFormFinish(String qq, String phone, String date, String time, String check);
//    }
//
//    private OnFormFinishListener listener;
//
//    public void setOnFormFinishListener(OnFormFinishListener listener) {
//        this.listener = listener;
//    }
}
