package pct.droid.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class StringArrayAdapter extends BaseAdapter {

    private String[] mData;
    private LayoutInflater mInflater;

    class ViewHolder {
        public ViewHolder(View v) {
            ButterKnife.inject(this, v);
        }

        @InjectView(android.R.id.text1)
        TextView text1;
    }

    public StringArrayAdapter(Context context, String[] data) {
        mData = data;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mData.length;
    }

    @Override
    public String getItem(int position) {
        return mData[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            holder = new ViewHolder(convertView);
            holder.text1.setPadding(32, 0, 32, 0);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.text1.setText(getItem(position));

        return convertView;
    }
}
