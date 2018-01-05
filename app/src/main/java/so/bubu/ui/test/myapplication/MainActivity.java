package so.bubu.ui.test.myapplication;


import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import Utils.ResourceUtil;
import so.bubu.ui.test.mylibrary.button.SolidButton;
import so.bubu.ui.test.mylibrary.button.StrokeButton;
import so.bubu.ui.test.mylibrary.page.common.BaseActivity;

public class MainActivity extends BaseActivity {


    @Override
    protected void doBack(int keyCode, KeyEvent event) {
        finish();
    }

    @Override
    public View addBaseContenetView() {
        LinearLayout inflate = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.activity_main, null);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setBackgroundColor(0xff0000);

        LinearLayout.LayoutParams commomlayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        SolidButton button = new SolidButton(this);
        button.setLayoutParams(commomlayoutParams);
        button.setText("demo");
        linearLayout.addView(button, commomlayoutParams);

        StrokeButton strokeButton = new StrokeButton(this);
        strokeButton.setLayoutParams(commomlayoutParams);
        strokeButton.setStrokeWidth(1);
        strokeButton.setText("demo");

//        linearLayout.setLayoutParams(commomlayoutParams);
        linearLayout.addView(strokeButton, commomlayoutParams);
        inflate.addView(linearLayout);
        SolidButton btn = (SolidButton) findViewById(R.id.data_button);
        btn.setVisibility(View.VISIBLE);

        return inflate;
    }

    @Override
    public void doInCreateView() {
        Button btn = (Button) findViewById(R.id.test);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"test",Toast.LENGTH_SHORT).show();
            }
        });
        setBackClick();
    }

    public void solidbtn(View view){
        Toast.makeText(this,"SolidButton",Toast.LENGTH_SHORT).show();
    }

    public void strokebtn(View view){
        Toast.makeText(this,"StrokeButton",Toast.LENGTH_SHORT).show();
    }
}
