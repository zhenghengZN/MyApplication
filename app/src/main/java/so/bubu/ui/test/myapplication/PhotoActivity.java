package so.bubu.ui.test.myapplication;

import android.app.Activity;
import android.content.Context;

import Activity.BrowseImageActivity;

/**
 * Created by zhengheng on 18/1/15.
 */
public class PhotoActivity extends BrowseImageActivity {

    @Override
    public void setImagePhotoOnclick(Context ctx, int position, String[] dataList) {
        ImageActivity.imageBrower(PhotoActivity.this, ImageActivity.class, position, dataList);
    }
}
