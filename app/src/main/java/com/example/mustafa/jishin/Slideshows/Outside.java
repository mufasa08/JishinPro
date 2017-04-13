
package com.example.mustafa.jishin.Slideshows;

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

public class Outside extends AppIntro {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Note here that we DO NOT use setContentView();

        // Add your slide fragments here.
        // AppIntro will automatically generate the dots indicator and buttons.


        // Instead of fragments, you can also use our default slide
        // Just set a title, description, background and image. AppIntro will do the rest.
        addSlide(AppIntroFragment.newInstance(getText(R.string.show3_slide1_title), getText(R.string.show3_slide1_text), R.drawable.outside_slide1, Color.parseColor("#1976D2")));
        addSlide(AppIntroFragment.newInstance(getText(R.string.show3_slide2_title), getText(R.string.show3_slide2_text), R.drawable.outside_slide3, Color.parseColor("#1976D2")));
        addSlide(AppIntroFragment.newInstance(getText(R.string.show3_slide3_title), getText(R.string.show3_slide3_text), R.drawable.outside_slide3, Color.parseColor("#1976D2")));
        addSlide(AppIntroFragment.newInstance(getText(R.string.show3_slide4_title), getText(R.string.show3_slide4_text), R.drawable.outside_slide4, Color.parseColor("#1976D2")));
        addSlide(AppIntroFragment.newInstance(getText(R.string.show3_slide5_title), getText(R.string.show3_slide5_text), R.drawable.outside_slide5, Color.parseColor("#1976D2")));
        addSlide(AppIntroFragment.newInstance(getText(R.string.show3_slide6_title), getText(R.string.show3_slide6_text), R.drawable.outside_slide6, Color.parseColor("#1976D2")));
        addSlide(AppIntroFragment.newInstance(getText(R.string.show3_slide7_title), getText(R.string.show3_slide7_text), R.drawable.outside_slide7, Color.parseColor("#1976D2")));
        addSlide(AppIntroFragment.newInstance(getText(R.string.show3_slide8_title), getText(R.string.show3_slide8_text), R.drawable.outside_slide8, Color.parseColor("#1976D2")));
        addSlide(AppIntroFragment.newInstance(getText(R.string.show3_slide9_title), getText(R.string.show3_slide9_text), R.drawable.outside_slide9, Color.parseColor("#1976D2")));
        addSlide(AppIntroFragment.newInstance(getText(R.string.show3_slide10_title), getText(R.string.show3_slide10_text), R.drawable.outside_slide10, Color.parseColor("#1976D2")));
        addSlide(AppIntroFragment.newInstance(getText(R.string.show3_slide11_title), getText(R.string.show3_slide11_text), R.drawable.outside_slide11, Color.parseColor("#1976D2")));
        addSlide(AppIntroFragment.newInstance(getText(R.string.show3_slide12_title), getText(R.string.show3_slide12_text), R.drawable.outside_slide12, Color.parseColor("#1976D2")));
        addSlide(AppIntroFragment.newInstance(getText(R.string.show3_slide13_title), getText(R.string.show3_slide13_text), R.drawable.outside_slide13, Color.parseColor("#1976D2")));
        addSlide(AppIntroFragment.newInstance(getText(R.string.show3_slide14_title), getText(R.string.show3_slide14_text), R.drawable.outside_slide14, Color.parseColor("#1976D2")));
        addSlide(AppIntroFragment.newInstance(getText(R.string.show3_slide15_title), getText(R.string.show3_slide15_text), R.drawable.outside_slide10, Color.parseColor("#1976D2")));
        addSlide(AppIntroFragment.newInstance(getText(R.string.show3_slide16_title), getText(R.string.show3_slide16_text), R.drawable.outside_slide11, Color.parseColor("#1976D2")));
        addSlide(AppIntroFragment.newInstance(getText(R.string.show3_slide17_title), getText(R.string.show3_slide17_text), R.drawable.outside_slide12, Color.parseColor("#1976D2")));
        addSlide(AppIntroFragment.newInstance(getText(R.string.show3_slide18_title), getText(R.string.show3_slide18_text), R.drawable.outside_slide13, Color.parseColor("#1976D2")));
        addSlide(AppIntroFragment.newInstance(getText(R.string.show3_slide19_title), getText(R.string.show3_slide19_text), R.drawable.outside_slide14, Color.parseColor("#1976D2")));
        addSlide(AppIntroFragment.newInstance(getText(R.string.credit_title), getText(R.string.credit_text), R.drawable.gnav_logo, Color.parseColor("#1976D2")));
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