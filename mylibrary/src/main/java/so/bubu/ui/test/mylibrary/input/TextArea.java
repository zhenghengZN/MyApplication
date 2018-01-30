package so.bubu.ui.test.mylibrary.input;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import so.bubu.ui.test.mylibrary.R;

/**
 * Created by zhengheng on 18/1/29.
 */
public class TextArea extends LinearLayout {
    public TextArea(Context context) {
        this(context, null);
    }

    private TextView numText;
    private EditText textarea;

    public TextArea(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setOrientation(VERTICAL);
        View view = LayoutInflater.from(context).inflate(R.layout.textarea, this, true);
        textarea = (EditText) view.findViewById(R.id.textarea);
        numText = (TextView) view.findViewById(R.id.text_num);
        textarea.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                numText.setText(s.length() + "/200");

            }
        });
    }

    public Editable getTextAreaText() {
        Editable text = textarea.getText();
        return text;
    }
}
