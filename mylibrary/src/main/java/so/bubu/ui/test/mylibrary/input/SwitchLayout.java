package so.bubu.ui.test.mylibrary.input;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import Utils.ResourceUtil;
import so.bubu.ui.test.mylibrary.R;

/**
 * Created by zhengheng on 18/1/29.
 */
public class SwitchLayout extends LinearLayout {
    private View view;
    private TextView text;
    private SwitchView switchview;

    public SwitchLayout(Context context) {
        this(context, null);
    }

    public SwitchLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setOrientation(HORIZONTAL);
        view = LayoutInflater.from(context).inflate(R.layout.switchlayout, this, true);
        text = (TextView) view.findViewById(R.id.title);
        switchview = (SwitchView) view.findViewById(R.id.switchview);
        switchview.setOnStateChangedListener(new SwitchView.OnStateChangedListener() {
            @Override
            public void toggleToOn(SwitchView view) {
                view.setOpened(true);
                if (listener != null) {
                    listener.StateOn();
                }
            }

            @Override
            public void toggleToOff(SwitchView view) {
                view.setOpened(false);
                if (listener != null) {
                    listener.StateOff();
                }
            }
        });
        init();
    }

    public void init() {

    }

    public void setText(String s) {
        text.setText(s);
    }

    private OnSwitchStateChageListener listener;

    public interface OnSwitchStateChageListener {
        void StateOn();

        void StateOff();
    }

    public void setOnSwitchStateChageListener(OnSwitchStateChageListener listener) {
        this.listener = listener;
    }
}
