package com.dualeh.mustafa.jishin_free.Slideshows;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.dualeh.mustafa.jishin_free.R;
import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class AppOpenSlideShow extends AppIntro {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Note here that we DO NOT use setContentView();

        // Add your slide fragments here.
        // AppIntro will automatically generate the dots indicator and buttons.


        // Instead of fragments, you can also use our default slide
        // Just set a title, description, background and image. AppIntro will do the rest.
        addSlide(AppIntroFragment.newInstance(getText(R.string.slide1_title), getText(R.string.slide1_text), R.drawable.earthquakehome, Color.parseColor("#1976D2")));
        addSlide(AppIntroFragment.newInstance(getText(R.string.slide2_title), getText(R.string.slide2_text), R.drawable.history, Color.parseColor("#1976D2")));
        addSlide(AppIntroFragment.newInstance(getText(R.string.slide3_title), getText(R.string.slide3_text), R.drawable.map, Color.parseColor("#1976D2")));
        addSlide(AppIntroFragment.newInstance(getText(R.string.slide4_title), getText(R.string.slide4_text), R.drawable.prepare, Color.parseColor("#1976D2")));
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