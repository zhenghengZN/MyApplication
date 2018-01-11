package so.bubu.ui.test.mylibrary.Adapter;

import android.content.Context;

import java.util.LinkedList;

import so.bubu.ui.test.mylibrary.Adapter.common.ComRecyclerViewAdapter;
import so.bubu.ui.test.mylibrary.Adapter.common.RecyclerViewHolder;
import so.bubu.ui.test.mylibrary.R;
import so.bubu.ui.test.mylibrary.bean.ArticleRespBean;

/**
 * Created by zhengheng on 18/1/11.
 */
public abstract class RecommendedAdapter<T extends ArticleRespBean> extends ComRecyclerViewAdapter {

    private LinkedList<ArticleRespBean> mDatasList;
    private Context mContext;

    public RecommendedAdapter(Context context, LinkedList mDatas) {
        super(context, mDatas, R.layout.item_commended_content);
        this.mDatasList = mDatas;
        this.mContext = context;

    }

    @Override
    public void convert(RecyclerViewHolder viewHolder, Object item, int position) {
//        viewHolder.setImageResource(R.id.iv_go,);
//        viewHolder.setText(R.id.tv_title, );
//        viewHolder.setText(R.id.jtv_content,)
    }
}
