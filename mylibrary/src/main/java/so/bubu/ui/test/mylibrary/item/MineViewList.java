package so.bubu.ui.test.mylibrary.item;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedHashMap;

import Utils.DividerGridItemDecoration;
import so.bubu.ui.test.mylibrary.Adapter.MyItemDecoration;
import so.bubu.ui.test.mylibrary.R;

/**
 * Created by zhengheng on 18/2/7.
 */
public class MineViewList extends RecyclerView {
    public MineViewList(Context context) {
        this(context, null);
    }

    private Context context;
    private JSONArray list;
    private MineViewApapter mineViewApapter;

    public MineViewList(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        LinearLayoutManager manager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
//        GridLayoutManager manager = new GridLayoutManager(context, 1);
        MyItemDecoration divider = new MyItemDecoration(context, manager.getOrientation());
//        DividerGridItemDecoration divider = new DividerGridItemDecoration(context);
        this.setLayoutManager(manager);
//        divider.setDrawable(ContextCompat.getDrawable(this, R.drawable.list_divider));
        this.addItemDecoration(divider);
    }

    public void init(JSONArray list) {
        this.list = list;
        mineViewApapter = new MineViewApapter(list, context);
        this.setAdapter(mineViewApapter);
        mineViewApapter.notifyDataSetChanged();
    }

    class MineViewApapter extends RecyclerView.Adapter<MineViewList.ViewHolder> {

        //        private LinkedHashMap<String, Object> map;
        private Context context;
        private JSONArray list;

        public MineViewApapter(JSONArray list, Context context) {
//            this.map = map;
            this.list = list;
            this.context = context;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MineView mineView = new MineView(context);
            ViewHolder viewHolder = new ViewHolder(mineView);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            MineView itemView = (MineView) holder.itemView;
            try {
                JSONObject object = list.getJSONObject(position);
                itemView.init(object);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public int getItemCount() {
            return list == null ? 0 : list.length();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
