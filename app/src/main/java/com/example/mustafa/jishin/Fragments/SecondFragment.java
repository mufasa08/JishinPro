package com.example.mustafa.jishin.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.mustafa.jishin.CustomGridViewActivity;
import com.example.mustafa.jishin.R;

public class SecondFragment extends Fragment {
    GridView androidGridView;

    String[] gridViewString = {
            "Can you write a long sentence?", "Android", "Mobile", "Website", "Profile", "WordPress"

    } ;
    int[] gridViewImageId = {
            R.drawable.alram, R.drawable.android, R.drawable.mobile, R.drawable.web, R.drawable.profile_icon, R.drawable.wordpress

    };
    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View rootView= inflater.inflate(R.layout.fragment_second, container, false);


        CustomGridViewActivity adapterViewAndroid = new CustomGridViewActivity(getContext(), gridViewString, gridViewImageId);
        androidGridView=(GridView)rootView.findViewById(R.id.grid_view_image_text);
        androidGridView.setAdapter(adapterViewAndroid);
        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int i, long id) {
                Toast.makeText(getContext(), "GridView Item: " + gridViewString[+i], Toast.LENGTH_LONG).show();
            }
        });
        return rootView;
    }

}
