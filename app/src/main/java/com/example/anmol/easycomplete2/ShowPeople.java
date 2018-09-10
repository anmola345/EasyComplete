package com.example.anmol.easycomplete2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class ShowPeople extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.anmol.easycomplete2.R.layout.activity_show_people);
        final ArrayList<Button> buttons = new ArrayList<Button>();
        //DisplayMessageActivity test = (DisplayMessageActivity) getApplicationContext();
        final ArrayList<ArrayList<String>> namesAndInfo = MainActivity.getNamesAndInfo();
        Button btn = new Button(this);
        //btn.setOnClickListener(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                500, 300);
        for (int i = 0; i < namesAndInfo.size(); i++) {
            buttons.add(new Button(this));

            //final int id_ = btn.getId();
            buttons.get(i).setText(namesAndInfo.get(i).get(0).toString());
            buttons.get(i).setTag((Integer) i);
            buttons.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int x = (int) v.getTag();
                    String output = "Full Name:" + MainActivity.justNames.get(x) + "\n";
                    for(int y = 2; y < namesAndInfo.get(x).size(); y++)
                        output += namesAndInfo.get(x).get(y) + "\n";
                    Toast.makeText(ShowPeople.this, output, Toast.LENGTH_LONG).show();
                }
            });
            buttons.get(i).setBackgroundColor(Color.rgb(238, 238, 238));

            //btn = new Button(this);
        }
        System.out.println(buttons.size());
        addContentView(buttons.get(0), params);
        if(buttons.size() >= 2){
        for(int i = 1; i < buttons.size(); i++)
        {
            buttons.get(i).setY(buttons.get(i-1).getY() + 400);
            addContentView(buttons.get(i), params);
        }
        }
    }

    public void makeToastMessage(ArrayList<Button> buttons)
    {


    }

}
