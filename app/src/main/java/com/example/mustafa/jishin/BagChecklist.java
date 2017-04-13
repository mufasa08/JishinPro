package com.example.mustafa.jishin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.GridView;

import com.example.mustafa.jishin.Utilities.ChecklistGridViewActivity;

public class BagChecklist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checklist);

        String[] gridViewString = {
                this.getString(R.string.prep_icon1_text), this.getString(R.string.prep_icon2_text), this.getString(R.string.prep_icon3_text), this.getString(R.string.prep_icon4_text),
                this.getString(R.string.prep_icon5_text), this.getString(R.string.prep_icon6_text),

        };
        ChecklistGridViewActivity adapterViewAndroid = new ChecklistGridViewActivity(this, gridViewString);
        GridView androidGridView = (GridView) findViewById(R.id.grid_view_checklist);
        androidGridView.setAdapter(adapterViewAndroid);
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        /*Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checklist_item1:
                if (checked);
                // Put some meat on the sandwich
                else;
                // Remove the meat
                break;
            case R.id.checklist_item2:
                if (checked);
                // Cheese me
                else;
                // I'm lactose intolerant
                break;
            // TODO: Veggie sandwich
        }*/
    }
}
