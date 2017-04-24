package com.dualeh.mustafa.jishin_free.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.dualeh.mustafa.jishin_free.BagChecklist;
import com.dualeh.mustafa.jishin_free.CustomGridViewActivity;
import com.dualeh.mustafa.jishin_free.R;
import com.dualeh.mustafa.jishin_free.Slideshows.AtHome;
import com.dualeh.mustafa.jishin_free.Slideshows.Outside;
import com.dualeh.mustafa.jishin_free.Slideshows.Prepare;
import com.dualeh.mustafa.jishin_free.Slideshows.ToRemember;

public class SecondFragment extends Fragment {
    GridView androidGridView;


    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_second, container, false);
        int[] gridViewImageId = {
                R.drawable.icon_checklist, R.drawable.home, R.drawable.outside, R.drawable.remember, R.drawable.web

        };

        String[] gridViewString = {
                getActivity().getString(R.string.prep_icon1_text), getActivity().getString(R.string.prep_icon3_text), getActivity().getString(R.string.prep_icon4_text),
                getActivity().getString(R.string.prep_icon5_text), getActivity().getString(R.string.prep_icon6_text),

        };

        //Initialize Second Fragment View with GridView
        CustomGridViewActivity adapterViewAndroid = new CustomGridViewActivity(getContext(), gridViewString, gridViewImageId);
        androidGridView = (GridView) rootView.findViewById(R.id.grid_view_image_text);
        androidGridView.setAdapter(adapterViewAndroid);

        //Grid Items action
        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int i, long id) {
                Intent intent = new Intent(getActivity(), Prepare.class);
                switch (i) {
                    case 0:
                        intent = new Intent(getActivity(), BagChecklist.class);
                        break;
                    case 1:
                        intent = new Intent(getActivity(), AtHome.class);
                        break;
                    case 2:
                        intent = new Intent(getActivity(), Outside.class);
                        break;
                    case 3:
                        intent = new Intent(getActivity(), ToRemember.class);
                        break;
                    case 4:
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.metro.tokyo.jp/ENGLISH/GUIDE/BOSAI/"));


                }
                startActivity(intent);

            }
        });
        return rootView;
    }

}
