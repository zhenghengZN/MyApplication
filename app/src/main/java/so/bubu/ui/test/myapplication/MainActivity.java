package so.bubu.ui.test.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.HashMap;
import java.util.LinkedList;

import Utils.ResourceUtil;
import so.bubu.ui.test.mylibrary.Adapter.GridItemAdapter;
import so.bubu.ui.test.mylibrary.Adapter.RecommendedAdapter;
import so.bubu.ui.test.mylibrary.Adapter.TravelsAdapter;
import so.bubu.ui.test.mylibrary.Adapter.common.RecyclerViewHolder;
import so.bubu.ui.test.mylibrary.button.SolidButton;
import so.bubu.ui.test.mylibrary.button.StrokeButton;
import so.bubu.ui.test.mylibrary.item.SharePopMenu;
import so.bubu.ui.test.mylibrary.page.common.BaseActivity;
import so.bubu.ui.test.mylibrary.wiget.ClearEditText;
import so.bubu.ui.test.mylibrary.wiget.DrawableClearEditText;

public class MainActivity extends BaseActivity {


    @Override
    protected void doBack(int keyCode, KeyEvent event) {
        finish();
    }

    @Override
    public View addBaseContenetView() {
        LinearLayout inflate = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.activity_main, null);
        RecyclerView rcv = (RecyclerView) inflate.findViewById(R.id.rcv);

        //4ge  griditem
//        rcv.setLayoutManager(new GridLayoutManager(this, 4));
//        LinkedList<HashMap<String, Object>> mDatasList = new LinkedList<>();
//        for (int i = 0; i < 4; i++) {
//            HashMap<String, Object> objectHashMap = new HashMap<>();
//            objectHashMap.put("title", "title");
//            objectHashMap.put("url", "http://gd2.alicdn.com/imgextra/i2/1810079026/TB2vMVedZbI8KJjy1zdXXbe1VXa_!!1810079026.jpg");
//            mDatasList.add(objectHashMap);
//        }
//        rcv.setAdapter(new GridItemAdapter(this, mDatasList) {
//            @Override
//            public void doOther(RecyclerViewHolder viewHolder, HashMap<String, Object> item, int position) {
//
//            }
//
//        });

        //攻略游记
//        LinkedList<HashMap<String, Object>> mDatasList = new LinkedList<>();
//        for (int i = 0; i < 4; i++) {
//            HashMap<String, Object> objectHashMap = new HashMap<>();
//            objectHashMap.put("title", "title");
//            objectHashMap.put("subtitle", "subtitle");
//            objectHashMap.put("url", "http://gd2.alicdn.com/imgextra/i2/1810079026/TB2vMVedZbI8KJjy1zdXXbe1VXa_!!1810079026.jpg");
//            mDatasList.add(objectHashMap);
//        }
//        rcv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//        rcv.setAdapter(new TravelsAdapter(this, mDatasList) {
//            @Override
//            public void doOther(RecyclerViewHolder viewHolder, HashMap<String, Object> item, int position) {
//
//            }
//
//        });

        //推荐布局
//        LinkedList<HashMap<String, Object>> mDatasList = new LinkedList<>();
//        for (int i = 0; i < 4; i++) {
//            HashMap<String, Object> objectHashMap = new HashMap<>();
//            objectHashMap.put("title", "title");
//            objectHashMap.put("content", "subtitleahttp://gd2.alicdn.com/imgextra/i2/1810079026/TB2vMVedZbI8KJjy1zdXXbe1VXa_!!1810079026.jpghttp://gd2.alicdn.com/imgextra/i2/1810079026/TB2vMVedZbI8KJjy1zdXXbe1VXa_!!1810079026.jpghttp://gd2.alicdn.com/imgextra/i2/1810079026/TB2vMVedZbI8KJjy1zdXXbe1VXa_!!1810079026.jpg" +
//                    "http://gd2.alicdn.com/imgextra/i2/1810079026/TB2vMVedZbI8KJjy1zdXXbe1VXa_!!1810079026.jpghttp://gd2.alicdn.com/imgextra/i2/1810079026/TB2vMVedZbI8KJjy1zdXXbe1VXa_!!1810079026.jpghttp://gd2.alicdn.com/imgextra/i2/1810079026/TB2vMVedZbI8KJjy1zdXXbe1VXa_!!1810079026.jpg");
//            objectHashMap.put("like", "subtitle");
//            objectHashMap.put("comment", "subtitle");
//            objectHashMap.put("url", "http://gd2.alicdn.com/imgextra/i2/1810079026/TB2vMVedZbI8KJjy1zdXXbe1VXa_!!1810079026.jpg");
//            mDatasList.add(objectHashMap);
//        }
//        rcv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//        rcv.setAdapter(new RecommendedAdapter(this, mDatasList) {
//
//            @Override
//            public void doOther(RecyclerViewHolder viewHolder, HashMap item, int position) {
//
//            }
//        });

        //带图片的编辑view
//        DrawableClearEditText editText = new DrawableClearEditText(this);
//        editText.getLeftDrawable().setImageResource(R.drawable.loading);
//        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) editText.getLayout().getLayoutParams();
//        layoutParams.setMargins(10,0,10,0);
//        inflate.addView(editText.getView());



        return inflate;
    }

    @Override
    public void doInCreateView() {
        Button btn = (Button) findViewById(R.id.test);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "test", Toast.LENGTH_SHORT).show();
            }
        });
        setBackClick();
    }

    public void solidbtn(View view) {
        Toast.makeText(this, "SolidButton", Toast.LENGTH_SHORT).show();
        //popupwindw分享
        final LinkedList<HashMap<String, Object>> mDatasList = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            HashMap<String, Object> objectHashMap = new HashMap<>();
            objectHashMap.put("title", "title");
            objectHashMap.put("url", "http://gd2.alicdn.com/imgextra/i2/1810079026/TB2vMVedZbI8KJjy1zdXXbe1VXa_!!1810079026.jpg");
            mDatasList.add(objectHashMap);
        }
        SharePopMenu<HashMap<String, Object>> sharePopMenu = new SharePopMenu<HashMap<String, Object>>(this, mDatasList) {
//            @Override
//            public void addList(LinkedList<HashMap<String, Object>> shareBeanList) {
//                shareBeanList = mDatasList;
//            }

            @Override
            public void doSomethingInconvert(RecyclerViewHolder viewHolder, Object item, int position) {

            }
        };
        sharePopMenu.setPopWindowItemClick(new SharePopMenu.PopWindowItemClick() {
            @Override
            public void onItemClick() {
                Toast.makeText(MainActivity.this, "onItemClick", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onItemLongClick() {
                Toast.makeText(MainActivity.this, "onItemLongClick", Toast.LENGTH_SHORT).show();

            }
        });
        sharePopMenu.showPopupWindow(view, MainActivity.this);

    }

    public void strokebtn(View view) {
        startActivity(new Intent(MainActivity.this,TabActivity.class));
    }
}
