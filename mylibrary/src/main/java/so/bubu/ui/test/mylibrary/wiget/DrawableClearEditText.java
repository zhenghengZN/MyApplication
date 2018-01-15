package so.bubu.ui.test.mylibrary.wiget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import so.bubu.ui.test.mylibrary.R;

/**
 * Created by zhengheng on 18/1/12.
 */
public class DrawableClearEditText  {

    private View view;
    public DrawableClearEditText(Context context){

        view = LayoutInflater.from(context).inflate(R.layout.drawable_clearedit_text, null);
    }

    public View getView(){
        return view;
    }

    public ImageView getLeftDrawable(){
        ImageView image = (ImageView) view.findViewById(R.id.v_icon_user);
        return image;
    }

    public ClearEditText getClearEditText(){
        ClearEditText clearEditText = (ClearEditText) view.findViewById(R.id.edt_name);
        return clearEditText;
    }

    public LinearLayout getLayout(){
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.layout);
        return layout;
    }
}
