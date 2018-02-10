package so.bubu.ui.test.mylibrary.item;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import org.json.JSONArray;

import so.bubu.ui.test.mylibrary.R;

/**
 * Created by zhengheng on 18/2/8.
 */
public class MineViewLayout extends LinearLayout {
    public MineViewLayout(Context context) {
        this(context, null);
    }
    private MineViewList mineViewList ;
    public MineViewLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOrientation(VERTICAL);
        View view = LayoutInflater.from(context).inflate(R.layout.mineviewlayout, this, true);
        mineViewList = (MineViewList) view.findViewById(R.id.mineViewList);
    }

    public void init(JSONArray list){
        mineViewList.init(list);
    }
}
