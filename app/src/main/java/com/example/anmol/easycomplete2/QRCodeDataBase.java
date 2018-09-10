package com.example.anmol.easycomplete2;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.anmol.easycomplete2.R;
import com.example.anmol.easycomplete2.MainActivity.*;
public class QRCodeDataBase extends AppCompatActivity {

    public static ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        img = new ImageView(this);
        img.setImageDrawable(QRGenerator.image1.getDrawable());

        ImageView ivSrc = new ImageView(this);
        ivSrc = QRGenerator.image1;
        ivSrc.setDrawingCacheEnabled(true);
        System.out.println(ivSrc);

        Bitmap bmSrc1 = ((BitmapDrawable)ivSrc.getDrawable()).getBitmap();
        Bitmap bmSrc2 = bmSrc1.copy(bmSrc1.getConfig(), true);

        View vScr = (View) ivSrc.getParent();
        vScr.setDrawingCacheEnabled(true);
        Bitmap bmScr3 = Bitmap.createBitmap(vScr.getDrawingCache());
        //setContentView(img);
        ImageView ivDest = (ImageView) findViewById(R.id.img_qr_code_image2);
        ivDest.setImageBitmap(bmSrc2);
        setContentView(R.layout.activity_qrcode_data_base);
    }

}
