package com.example.mustafa.jishin;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class BagChecklist extends AppCompatActivity implements android.widget.CompoundButton.OnCheckedChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checklist);

        CheckBox cb1, cb2, cb3, cb4;

        cb1 = (CheckBox) findViewById(R.id.checklist_item1);
        cb1.setChecked(getFromSP("cb1"));
        cb1.setOnCheckedChangeListener(this);
        cb2 = (CheckBox) findViewById(R.id.checklist_item2);
        cb2.setChecked(getFromSP("cb2"));
        cb2.setOnCheckedChangeListener(this);

    }

    private boolean getFromSP(String key) {
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
        return preferences.getBoolean(key, false);
    }

    private void saveInSp(String key, boolean value) {
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        // TODO Auto-generated method stub
        switch (buttonView.getId()) {
            case R.id.checklist_item1:
                saveInSp("cb1", isChecked);
                break;
            case R.id.checklist_item2:
                saveInSp("cb2", isChecked);
                break;

        }

    }
}
