package so.bubu.ui.test.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import so.bubu.ui.test.mylibrary.input.TextEditText;

/**
 * Created by zhengheng on 18/1/26.
 */
public class TestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        LinearLayout view = findViewById(R.id.parent);
        View submit = findViewById(R.id.submit);

        final TextEditText text = new TextEditText(this);

        text.setAllTextColor(0xffff0000, 0xff00ff00);
//        text.isTitle(false);
//        text.setAllTextSize(20);
        text.setTitletEms(4);
        text.setTitle("姓名");
        text.setTextEditTextHint("请输入名字");
//        text.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
//        text.setBackground();
//        text.setNumberDecimalStyle();
        text.setRadius(2);
        text.setBackgroundStrokeColor(0xffff0000);
        text.setBackgroundStrokeWidth(2);

        text.setTextWatcherImpl(new TextEditText.TextWatcherImpl() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                Toast.makeText(TestActivity.this, "beforeTextChanged", Toast.LENGTH_SHORT).show();
                Log.e("zhengheng","beforeTextChanged");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                Toast.makeText(TestActivity.this, "onTextChanged", Toast.LENGTH_SHORT).show();
                Log.e("zhengheng", "onTextChanged");
            }

            @Override
            public void afterTextChanged(Editable s) {
//                Toast.makeText(TestActivity.this, "afterTextChanged", Toast.LENGTH_SHORT).show();
                Log.e("zhengheng", "afterTextChanged");
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TestActivity.this, text.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
//        Log.e("zhengheng", text.getText().toString());
        view.addView(text);
    }
}
