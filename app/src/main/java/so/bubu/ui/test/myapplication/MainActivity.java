package so.bubu.ui.test.myapplication;


import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import so.bubu.ui.test.mylibrary.page.common.BaseActivity;

public class MainActivity extends BaseActivity {


    @Override
    protected void doBack(int keyCode, KeyEvent event) {
        finish();
    }

    @Override
    public View addBaseContenetView() {
        return LayoutInflater.from(this).inflate(R.layout.activity_main, null);
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
    }
}
