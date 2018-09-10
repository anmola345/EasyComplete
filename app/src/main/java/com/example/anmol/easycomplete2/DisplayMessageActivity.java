package com.example.anmol.easycomplete2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.anmol.easycomplete2.R.styleable.View;

public class DisplayMessageActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
    }

    public void displayMessage(View v)
    {


        TextView textView =  (TextView) findViewById(R.id.Name);
        String input = textView.getText().toString();

        String lastName = ((TextView) findViewById(R.id.LastName)).getText().toString();
        MainActivity.justNames.add(input + " " + lastName);
        String email = ((TextView) findViewById(R.id.Email)).getText().toString();
        String phoneNumber = ((TextView) findViewById(R.id.PhoneNumber)).getText().toString();

        MainActivity.namesAndInfo.add(new ArrayList<String>());
        MainActivity.namesAndInfo.get(MainActivity.namesAndInfo.size() - 1).add(input);
        MainActivity.namesAndInfo.get(MainActivity.namesAndInfo.size() - 1).add(lastName);
        MainActivity.namesAndInfo.get(MainActivity.namesAndInfo.size() - 1).add(email);
        MainActivity.namesAndInfo.get(MainActivity.namesAndInfo.size() - 1).add(phoneNumber);
        //System.out.println(namesAndInfo.size() + "sdfvwergfvewrgfvwergfv");
        System.out.println(MainActivity.namesAndInfo.get(MainActivity.namesAndInfo.size() - 1).toString());


        Toast.makeText(DisplayMessageActivity.this, "Your information has been added to the database as " + input + " " + lastName,
                Toast.LENGTH_LONG).show();
    }
}
