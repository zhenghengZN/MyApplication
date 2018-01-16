package so.bubu.ui.test.mylibrary.page;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.LinkedList;

import Utils.DeviceHelper;
import Utils.GlideImageLoader;
import Utils.ResourceUtil;
import so.bubu.ui.test.mylibrary.Adapter.BannerActivityAdapter;
import so.bubu.ui.test.mylibrary.R;

/**
 * Created by zhengheng on 18/1/15.
 */
public class BannerActivity extends AppCompatActivity{


    private BannerActivityAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        RecyclerView rcv = (RecyclerView) findViewById(R.id.rcv_information);
        rcv.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL,false));
        adapter = new BannerActivityAdapter(new LinkedList<String>());
        rcv.setAdapter(adapter);
//        findViewById()


        LinkedList<String> urls= new LinkedList<>();
        urls.add("http://gd2.alicdn.com/imgextra/i2/1810079026/TB2vMVedZbI8KJjy1zdXXbe1VXa_!!1810079026.jpg");
        urls.add("http://gd2.alicdn.com/imgextra/i2/1810079026/TB2vMVedZbI8KJjy1zdXXbe1VXa_!!1810079026.jpg");

        urls.add("http://gd2.alicdn.com/imgextra/i2/1810079026/TB2vMVedZbI8KJjy1zdXXbe1VXa_!!1810079026.jpg");

        View header = LayoutInflater.from(this).inflate(R.layout.banner_layout, rcv, false);
        Banner banner = (Banner) header;
        banner.isAutoPlay(false);
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object o, ImageView imageView) {
                Glide
                        .with(context)
                        .load((String) o)
                        .placeholder(R.drawable.loading)
                        .error(R.drawable.loading)
                        .override(DeviceHelper.getScreenWidth(), ResourceUtil.Dp2Px(160))
                        .into(imageView);
            }
        });
        banner.setImages(urls);
        banner.start();

        adapter.addHeaderView(banner);
//        adapter.
    }
}
