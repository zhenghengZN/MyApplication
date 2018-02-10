package so.bubu.ui.test.mylibrary.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import so.bubu.ui.test.mylibrary.R;

/**
 * Created by zhengheng on 18/2/8.
 */
public class ActionSheet extends Dialog implements AdapterView.OnItemClickListener {

    private ArrayList<String> titles;

    public ActionSheet(Context context) {
        super(context);
    }


    public void init(ArrayList<String> titles) {
        this.titles = titles;
//        adapter.notifyDataSetChanged();
    }

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actionsheet);
        ListView list = (ListView) findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(getContext(), R.layout.actionsheet_item, R.id.actionSheetTitle, this.titles);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getContext(), titles.get(position), Toast.LENGTH_LONG).show();
        dismiss();
    }


    class ActionSheetApapter extends BaseAdapter {

        private Context context;
        private ArrayList<String> titles;

        public ActionSheetApapter(Context context, ArrayList<String> titles) {
            this.context = context;
            this.titles = titles;
        }

        @Override
        public int getCount() {
            return titles.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                View view = LayoutInflater.from(context).inflate(R.layout.actionsheet_item, null, false);
                TextView title = (TextView) view.findViewById(R.id.actionSheetTitle);
                holder = new ViewHolder(title);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.textview.setText(titles.get(position));
            return convertView;
        }

        class ViewHolder {
            TextView textview;

            public ViewHolder(View view) {
                textview = (TextView) view;
            }
        }
    }
}
