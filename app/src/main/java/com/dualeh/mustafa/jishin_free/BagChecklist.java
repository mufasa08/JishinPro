package com.dualeh.mustafa.jishin_free;

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

        CheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8, cb9, cb10, cb11, cb12, cb13, cb14, cb15, cb16, cb17, cb18, cb19, cb20;

        cb1 = (CheckBox) findViewById(R.id.checklist_item1);
        cb1.setChecked(getFromSP("cb1"));
        cb1.setOnCheckedChangeListener(this);
        cb2 = (CheckBox) findViewById(R.id.checklist_item2);
        cb2.setChecked(getFromSP("cb2"));
        cb2.setOnCheckedChangeListener(this);
        cb3 = (CheckBox) findViewById(R.id.checklist_item3);
        cb3.setChecked(getFromSP("cb3"));
        cb3.setOnCheckedChangeListener(this);
        cb4 = (CheckBox) findViewById(R.id.checklist_item4);
        cb4.setChecked(getFromSP("cb4"));
        cb4.setOnCheckedChangeListener(this);
        cb5 = (CheckBox) findViewById(R.id.checklist_item5);
        cb5.setChecked(getFromSP("cb5"));
        cb5.setOnCheckedChangeListener(this);
        cb6 = (CheckBox) findViewById(R.id.checklist_item6);
        cb6.setChecked(getFromSP("cb6"));
        cb6.setOnCheckedChangeListener(this);
        cb7 = (CheckBox) findViewById(R.id.checklist_item7);
        cb7.setChecked(getFromSP("cb7"));
        cb7.setOnCheckedChangeListener(this);
        cb8 = (CheckBox) findViewById(R.id.checklist_item8);
        cb8.setChecked(getFromSP("cb8"));
        cb8.setOnCheckedChangeListener(this);
        cb9 = (CheckBox) findViewById(R.id.checklist_item9);
        cb9.setChecked(getFromSP("cb9"));
        cb9.setOnCheckedChangeListener(this);
        cb10 = (CheckBox) findViewById(R.id.checklist_item10);
        cb10.setChecked(getFromSP("cb10"));
        cb10.setOnCheckedChangeListener(this);
        cb11 = (CheckBox) findViewById(R.id.checklist_item11);
        cb11.setChecked(getFromSP("cb11"));
        cb11.setOnCheckedChangeListener(this);
        cb12 = (CheckBox) findViewById(R.id.checklist_item12);
        cb12.setChecked(getFromSP("cb12"));
        cb12.setOnCheckedChangeListener(this);
        cb13 = (CheckBox) findViewById(R.id.checklist_item13);
        cb13.setChecked(getFromSP("cb13"));
        cb13.setOnCheckedChangeListener(this);
        cb14 = (CheckBox) findViewById(R.id.checklist_item14);
        cb14.setChecked(getFromSP("cb14"));
        cb14.setOnCheckedChangeListener(this);
        cb15 = (CheckBox) findViewById(R.id.checklist_item15);
        cb15.setChecked(getFromSP("cb15"));
        cb15.setOnCheckedChangeListener(this);
        cb16 = (CheckBox) findViewById(R.id.checklist_item16);
        cb16.setChecked(getFromSP("cb16"));
        cb16.setOnCheckedChangeListener(this);
        cb17 = (CheckBox) findViewById(R.id.checklist_item17);
        cb17.setChecked(getFromSP("cb17"));
        cb17.setOnCheckedChangeListener(this);
        cb18 = (CheckBox) findViewById(R.id.checklist_item18);
        cb18.setChecked(getFromSP("cb18"));
        cb18.setOnCheckedChangeListener(this);
        cb19 = (CheckBox) findViewById(R.id.checklist_item19);
        cb19.setChecked(getFromSP("cb19"));
        cb19.setOnCheckedChangeListener(this);
        cb20 = (CheckBox) findViewById(R.id.checklist_item20);
        cb20.setChecked(getFromSP("cb20"));
        cb20.setOnCheckedChangeListener(this);


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
            case R.id.checklist_item3:
                saveInSp("cb3", isChecked);
                break;
            case R.id.checklist_item4:
                saveInSp("cb4", isChecked);
                break;
            case R.id.checklist_item5:
                saveInSp("cb5", isChecked);
                break;
            case R.id.checklist_item6:
                saveInSp("cb6", isChecked);
                break;
            case R.id.checklist_item7:
                saveInSp("cb7", isChecked);
                break;
            case R.id.checklist_item8:
                saveInSp("cb8", isChecked);
                break;
            case R.id.checklist_item9:
                saveInSp("cb9", isChecked);
                break;
            case R.id.checklist_item10:
                saveInSp("cb10", isChecked);
                break;
            case R.id.checklist_item11:
                saveInSp("cb11", isChecked);
                break;
            case R.id.checklist_item12:
                saveInSp("cb12", isChecked);
                break;
            case R.id.checklist_item13:
                saveInSp("cb13", isChecked);
                break;
            case R.id.checklist_item14:
                saveInSp("cb14", isChecked);
                break;
            case R.id.checklist_item15:
                saveInSp("cb15", isChecked);
                break;
            case R.id.checklist_item16:
                saveInSp("cb16", isChecked);
                break;
            case R.id.checklist_item17:
                saveInSp("cb17", isChecked);
                break;
            case R.id.checklist_item18:
                saveInSp("cb18", isChecked);
                break;
            case R.id.checklist_item19:
                saveInSp("cb19", isChecked);
                break;
            case R.id.checklist_item20:
                saveInSp("cb20", isChecked);
                break;
        }

    }
}
