package so.bubu.ui.test.mylibrary.wiget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;

import java.text.SimpleDateFormat;

import so.bubu.ui.test.mylibrary.R;
import so.bubu.ui.test.mylibrary.wiget.pickTimeView.PickTimeView;
import so.bubu.ui.test.mylibrary.wiget.pickTimeView.PickValueView;

/**
 * Created by zhengheng on 18/1/30.
 */
public class PickTimePopWindow extends PopupWindow implements PickTimeView.onSelectedChangeListener, PickValueView.onSelectedChangeListener {

    private PickTimeView pickDate, pickTime;
    private PickValueView pickPhone;
    private View inflate;
    private Activity act;
    private SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");
    private String date;
//    private String[] phoneVaule = {"+80", "+84", "+86", "+87"};

    //    SimpleDateFormat sdfDate;
    public PickTimePopWindow(Activity act) {
        this.act = act;
        inflate = LayoutInflater.from(act).inflate(R.layout.picktime, null);
        pickDate = (PickTimeView) inflate.findViewById(R.id.pickDate);
        pickTime = (PickTimeView) inflate.findViewById(R.id.pickTime);
        pickPhone = (PickValueView) inflate.findViewById(R.id.pickPhone);

        pickDate.setOnSelectedChangeListener(this);
        pickTime.setOnSelectedChangeListener(this);
        pickPhone.setOnSelectedChangeListener(this);
        inflate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                setTransBg(false);
            }
        });

        inflate.findViewById(R.id.cancle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                setTransBg(false);
            }
        });

        inflate.findViewById(R.id.sucess).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.sucessClick(date, v);
                }
                dismiss();
            }
        });
        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        setBackgroundDrawable(new BitmapDrawable());
        setFocusable(true);
        setOutsideTouchable(true);
        setContentView(inflate);

    }


    public void setType(int type) {
        if (type == PickTimeView.TYPE_PICK_DATE) {
            pickDate.setViewType(PickTimeView.TYPE_PICK_DATE);
            pickDate.setVisibility(View.VISIBLE);
        } else if (type == PickTimeView.TYPE_PICK_TIME) {
            pickTime.setViewType(PickTimeView.TYPE_PICK_TIME);
            pickTime.setVisibility(View.VISIBLE);
        } else if (type == PickValueView.TYPE_PICK_PHONE) {
            pickPhone.setVisibility(View.VISIBLE);
//            pickPhone.setValueData(phoneVaule, phoneVaule[2]);
        }
    }


    public void setPickViewValue(String[]  phoneVaule){
        pickPhone.setValueData(phoneVaule, phoneVaule[0]);
    }

    public void showPopWindow(View parent, Activity context) {
        if (!this.isShowing()) {
            this.showAtLocation(parent, Gravity.BOTTOM, 0, 0);
            setTransBg(true);
        } else {
            this.dismiss();
            setTransBg(false);
        }
    }

    @Override
    public void onSelected(PickTimeView view, long timeMillis) {
        if (view == pickTime) {
            String str = sdfTime.format(timeMillis);
            date = str;
        } else {
            String str = sdfDate.format(timeMillis);
            date = str;
        }
    }

    private OnSucessClickListener listener;

    @Override
    public void onSelected(PickValueView view, Object leftValue, Object middleValue, Object rightValue) {
        if (view == pickPhone) {
            date = (String) leftValue;
        }
    }

    public interface OnSucessClickListener {
        void sucessClick(String date, View v);
    }

    public void setOnSucessClickListener(OnSucessClickListener listener) {
        this.listener = listener;
    }


    public void setTransBg(boolean isTrans) {
        if (isTrans) {
            WindowManager.LayoutParams attributes = act.getWindow().getAttributes();
//            attributes.alpha = 0.7f;
            act.getWindow().setAttributes(attributes);
        } else {
            WindowManager.LayoutParams attributes = act.getWindow().getAttributes();
//            attributes.alpha = 1.0f;
            act.getWindow().setAttributes(attributes);
        }
    }
}
