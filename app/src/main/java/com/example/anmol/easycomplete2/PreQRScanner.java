package com.example.anmol.easycomplete2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class PreQRScanner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.anmol.easycomplete2.R.layout.activity_pre_qrscanner);
        ArrayList<ArrayList<String>> namesAndInfo = MainActivity.getNamesAndInfo();
    }
    public void checkName(View v)
    {
        MainActivity.nameToBeUsed = ((TextView) findViewById(com.example.anmol.easycomplete2.R.id.inputName)).getText().toString();
        Intent intent = new Intent(this, QRScanner.class);
        startActivity(intent);
    }
}
