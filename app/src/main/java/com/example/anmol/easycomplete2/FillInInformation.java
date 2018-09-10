package com.example.anmol.easycomplete2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FillInInformation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.anmol.easycomplete2.R.layout.activity_fill_in_information);
    }
    public void addFirstNameToArray(View v)
    {
        MainActivity.getInfoNeeded()
                .add("First Name: ");
    }
    public void addLastNameToArray(View v)
    {
        MainActivity.getInfoNeeded()
                .add("Last Name: ");
    }
    public void addEmailToArray(View v)
    {
        MainActivity.getInfoNeeded()
                .add("Email: ");
    }
    public void addPhoneNumberToArray(View v)
    {
        MainActivity.getInfoNeeded()
                .add("Phone Number: ");
    }
    public void addCustomToArray(View v)
    {
        MainActivity.getInfoNeeded()
                .add(((TextView) findViewById(com.example.anmol.easycomplete2.R.id.custom)).getText().toString());
    }
    public void goToQRCode(View v)
    {
        Intent intent = new Intent(this, QRGenerator.class);
        startActivity(intent);
    }
}
