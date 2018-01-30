package so.bubu.ui.test.mylibrary.input;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Utils.ResourceUtil;
import so.bubu.ui.test.mylibrary.Adapter.common.ViewHolder;
import so.bubu.ui.test.mylibrary.R;
import so.bubu.ui.test.mylibrary.wiget.NoScrollListView;

/**
 * Created by zhengheng on 18/1/29.
 */
public class ListSingleButton extends LinearLayout {
    public ListSingleButton(Context context) {
        this(context, null);
    }

    private ArrayList<String> titles = new ArrayList<>();
    private View more;
    private TextView footerTitle;
    private Context ctx;
    private SingleChoiceAdapter singleChoiceAdapter;

    public ListSingleButton(final Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setOrientation(VERTICAL);
        this.ctx = context;
        this.addView(Stroke());
        more = LayoutInflater.from(context).inflate(R.layout.more, null, false);
        footerTitle = (TextView) more.findViewById(R.id.more);
        more.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.FooterClick(v);
                }
            }
        });

        View inflate = LayoutInflater.from(context).inflate(R.layout.listsinglebutton, null, false);
        ListView listView = (ListView) inflate.findViewById(R.id.list);
        singleChoiceAdapter = new SingleChoiceAdapter(context, titles);
        singleChoiceAdapter.check(0);
        listView.setAdapter(singleChoiceAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                singleChoiceAdapter.check(position);
                if (listener != null) {
                    listener.CheckItem(parent, view, position, singleChoiceAdapter.getItem(position));
                }
            }
        });
        listView.addFooterView(more);
        this.addView(inflate);
        this.addView(Stroke());
    }

    public View Stroke() {
        View view = new View(ctx);
        LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, ResourceUtil.Dp2Px(0.5f));
        view.setLayoutParams(lp);
        view.setBackgroundColor(getResources().getColor(R.color.color_e2e2e2));
        return view;
    }

    private OnCheckItemListener listener;

    public void setOnCheckItemListener(OnCheckItemListener listener) {
        this.listener = listener;
    }

    public interface OnCheckItemListener {
        void CheckItem(AdapterView<?> parent, View view, int position, String title);

        void FooterClick(View v);
    }

    public void setFooterTitle(String s) {
        footerTitle.setText(s);
    }

    public void setTitles(ArrayList<String> titles) {
        this.titles.addAll(titles);
        singleChoiceAdapter.notifyDataSetChanged();
    }

    private class SingleChoiceAdapter extends BaseAdapter {
        private final LayoutInflater layoutInflater;
        private List<String> data;
        private int currentCheckedItemPosition = 0;

        public SingleChoiceAdapter(Context context, List<String> data) {
            layoutInflater = LayoutInflater.from(context);
            this.data = data;
            // 默认为-1，没有选择任何item
            currentCheckedItemPosition = AbsListView.INVALID_POSITION; // -1
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public String getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final ViewHolder viewHolder;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = layoutInflater.inflate(R.layout.singlecheckbox, parent, false);
                viewHolder.textView = (TextView) convertView.findViewById(R.id.title);
                viewHolder.radioButton = (RadioButton) convertView.findViewById(R.id.check_img);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            if (currentCheckedItemPosition == position) {
                viewHolder.radioButton.setChecked(true);
            } else {
                viewHolder.radioButton.setChecked(false);
            }
            viewHolder.textView.setText(getItem(position));

            return convertView;
        }

        public void setDefaultCheckedItemPosition(int position) {
            currentCheckedItemPosition = position;
        }

        public int getCheckedItemPosition() {
            return currentCheckedItemPosition;
        }

        public void check(int position) {
            if (currentCheckedItemPosition == position) {
                return;
            }
            setDefaultCheckedItemPosition(position);
            notifyDataSetChanged();
        }


        class ViewHolder {
            TextView textView;
            RadioButton radioButton;
        }
    }
}

