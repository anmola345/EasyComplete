package com.example.anmol.easycomplete2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<ArrayList<String>> namesAndInfo;
    public static ArrayList<ArrayList<String>> getNamesAndInfo()
    {
        return namesAndInfo;
    }
    public static ArrayList<String> infoNeeded;
    public static ArrayList<String> getInfoNeeded(){return infoNeeded;}
    public static String nameToBeUsed;
    public static ArrayList<String> justNames;
    public static ArrayList<Bitmap> qrCodes;
    public static Drawable image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        infoNeeded = new ArrayList<String>();
        namesAndInfo = new ArrayList<ArrayList<String>>();
        setContentView(com.example.anmol.easycomplete2.R.layout.activity_main);
        nameToBeUsed = "";
        justNames = new ArrayList<String>();
        qrCodes = new ArrayList<Bitmap>();
    }
    public void makeForm(View v)
    {
        Intent intent = new Intent(this, FillInInformation.class);
        startActivity(intent);
    }
    public void sendMessage(View v)
    {
        Intent intent = new Intent(this, com.example.anmol.easycomplete2.DisplayMessageActivity.class);
        startActivity(intent);
    }
    public void showPeople(View v)
    {
        Intent intent = new Intent(this, ShowPeople.class);
        startActivity(intent);
    }
    public void goToScanner(View v)
    {
        Intent intent = new Intent(this, PreQRScanner.class);
        startActivity(intent);
    }
    public void makeQRCode(View v)
    {
        Intent intent = new Intent(this, QRGenerator.class);
        startActivity(intent);
    }
    public void seeQRCodes(View v)
    {
        Intent intent = new Intent(this, QRCodeDataBase.class);
        startActivity(intent);
    }
}
