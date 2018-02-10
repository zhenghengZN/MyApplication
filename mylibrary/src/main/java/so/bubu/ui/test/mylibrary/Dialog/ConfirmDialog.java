package so.bubu.ui.test.mylibrary.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import Utils.StringUtils;
import so.bubu.ui.test.mylibrary.R;

/**
 * Created by zhengheng on 18/2/8.
 */
public class ConfirmDialog extends Dialog implements View.OnClickListener {
    public ConfirmDialog(Context context) {
        super(context);
    }

    private TextView major, sup, content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmdialog);
        content = (TextView) findViewById(R.id.confirmdialog_content);
        major = (TextView) findViewById(R.id.major);
        major.setOnClickListener(this);
        sup = (TextView) findViewById(R.id.sup);
        sup.setOnClickListener(this);
        setContentColor();
//        String s = StringUtils.ToDBC("弹窗内容,告知当前状态,信息和解决方法,描述文字尽量控制在三行内");
//        content.setText(s);
    }


    public void setContentColor(){
        content.setTextColor(Color.BLACK);
    }
    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.major) {

        } else if (i == R.id.sup) {

        }
        dismiss();
    }
}
