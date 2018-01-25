package so.bubu.ui.test.mylibrary.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengheng on 18/1/25.
 */
public class TypeDiffVLayoutManger {

    private RecyclerView mRecylerView;
    private Context context;
    public void init(){
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(context);
        mRecylerView.setLayoutManager(virtualLayoutManager);

        final RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        mRecylerView.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 20);

        DelegateAdapter delegateAdapter = new DelegateAdapter(virtualLayoutManager, false);
        mRecylerView.setAdapter(delegateAdapter);

//        TypeDiffItemAdapter adapters = new TypeDiffItemAdapter(new ArrayList()) {
//
//            @Override
//            public void doOther(BaseViewHolder viewHolder, MultipleItem multipleItem) {
//
//            }
//
//            @Override
//            public void setGridItemOnclick(Activity mContext, int position, List<String> urls, AdapterView<?> parent, View view) {
//
//            }
//        };
//        delegateAdapter.addAdapters(adapters);

//        delegateAdapter.addAdapter(new MyAdapter(this, new LinearLayoutHelper(, 0)));
    }
}