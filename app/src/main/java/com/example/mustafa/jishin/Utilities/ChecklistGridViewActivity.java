package com.example.mustafa.jishin.Utilities;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mustafa.jishin.R;

public class ChecklistGridViewActivity extends BaseAdapter {

    private Context mContext;
    private final String[] gridViewString;

    public ChecklistGridViewActivity(Context context, String[] gridViewString) {
        mContext = context;
        this.gridViewString = gridViewString;
    }

    @Override
    public int getCount() {
        return gridViewString.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View gridViewAndroid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            gridViewAndroid = new View(mContext);
            gridViewAndroid = inflater.inflate(R.layout.checklistlayout, null);

            TextView textViewAndroid = (TextView) gridViewAndroid.findViewById(R.id.checkbox);
            textViewAndroid.setText(gridViewString[i]);

        } else {
            gridViewAndroid = (View) convertView;
        }

        return gridViewAndroid;
    }
}