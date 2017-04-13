package com.example.mustafa.jishin.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.mustafa.jishin.BagChecklist;
import com.example.mustafa.jishin.CustomGridViewActivity;
import com.example.mustafa.jishin.R;
import com.example.mustafa.jishin.Slideshows.ToRemember;
import com.example.mustafa.jishin.Slideshows.Outside;
import com.example.mustafa.jishin.Slideshows.AtHome;
import com.example.mustafa.jishin.Slideshows.Prepare;

public class SecondFragment extends Fragment {
    GridView androidGridView;


    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_second, container, false);
        int[] gridViewImageId = {
                R.drawable.icon_checklist, R.drawable.prepare, R.drawable.home, R.drawable.outside, R.drawable.remember, R.drawable.web

        };
        String[] gridViewString = {
                getActivity().getString(R.string.prep_icon1_text), getActivity().getString(R.string.prep_icon2_text), getActivity().getString(R.string.prep_icon3_text), getActivity().getString(R.string.prep_icon4_text),
                getActivity().getString(R.string.prep_icon5_text), getActivity().getString(R.string.prep_icon6_text),

        };
        CustomGridViewActivity adapterViewAndroid = new CustomGridViewActivity(getContext(), gridViewString, gridViewImageId);
        androidGridView = (GridView) rootView.findViewById(R.id.grid_view_image_text);
        androidGridView.setAdapter(adapterViewAndroid);
        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int i, long id) {
                Intent intent = new Intent(getActivity(), Prepare.class);
                //Toast.makeText(getContext(), "GridView Item: " + gridViewString[+i], Toast.LENGTH_LONG).show();
                switch (i) {
                    case 0:
                        intent = new Intent(getActivity(), BagChecklist.class);
                        break;
                    case 1:
                        intent = new Intent(getActivity(), Prepare.class);
                        break;
                    case 2:
                        intent = new Intent(getActivity(), AtHome.class);
                        break;
                    case 3:
                        intent = new Intent(getActivity(), Outside.class);
                        break;
                    case 4:
                        intent = new Intent(getActivity(), ToRemember.class);
                        break;
                    case 5:
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.metro.tokyo.jp/ENGLISH/GUIDE/BOSAI/"));


                }
                startActivity(intent);

            }
        });
        return rootView;
    }

}
