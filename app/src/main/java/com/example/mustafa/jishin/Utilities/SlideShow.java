package com.example.mustafa.jishin.Utilities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.mustafa.jishin.R;
import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class SlideShow extends AppIntro {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Note here that we DO NOT use setContentView();

        // Add your slide fragments here.
        // AppIntro will automatically generate the dots indicator and buttons.


        // Instead of fragments, you can also use our default slide
        // Just set a title, description, background and image. AppIntro will do the rest.
        String[] slide_data=getResources().getStringArray(R.array.slideshow_number);
        int opening = getIntent().getIntExtra("int_code", 0);
       /* for(int i=0;i<slide_data.length;++i){
            System.out.println(slide_data[i]);
        }*/
        int icons[]={R.drawable.twitter_icon, R.drawable.alram,R.drawable.twitter_bird, R.drawable.checklist};
        addSlide(AppIntroFragment.newInstance(slide_data[opening], slide_data[opening+1],icons[opening], Color.parseColor("#1976D2")));
        addSlide(AppIntroFragment.newInstance(slide_data[opening+2], slide_data[opening+3],icons[opening+1], Color.parseColor("#1976D2")));
        addSlide(AppIntroFragment.newInstance(slide_data[opening+4], slide_data[opening+5], icons[opening+2], Color.parseColor("#1976D2")));
        addSlide(AppIntroFragment.newInstance(slide_data[opening+6], slide_data[opening+7], icons[opening+3], Color.parseColor("#1976D2")));
        // OPTIONAL METHODS
        // Override bar/separator color.
        setBarColor(Color.parseColor("#3F51B5"));
        setSeparatorColor(Color.parseColor("#2196F3"));
        setFlowAnimation();

        // Hide Skip/Done button.
        //showSkipButton(false);
        //setProgressButtonEnabled(false);

        // Turn vibration on and set intensity.
        // NOTE: you will probably need to ask VIBRATE permission in Manifest.
        setVibrate(true);
        setVibrateIntensity(30);
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        finish();
        // Do something when users tap on Skip button.
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        finish();
        // Do something when users tap on Done button.
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
        // Do something when the slide changes.
    }
}