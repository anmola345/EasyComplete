package com.example.anmol.easycomplete2;

import android.Manifest;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Drive;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import java.util.ArrayList;

import static com.example.anmol.easycomplete2.MainActivity.qrCodes;

public class QRGenerator extends AppCompatActivity
//        implements GoogleApiClient.ConnectionCallbacks,
//        GoogleApiClient.OnConnectionFailedListener, ActivityCompat.OnRequestPermissionsResultCallback
{

//    private static final int REQUEST_CODE_RESOLUTION = 1;
//    private static final String TAG = "Google Drive Activity";
//    private GoogleApiClient mGoogleApiClient;
//    private boolean fileOperation = false;
//
//    protected void ActivityCompat()
//    {
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.INTERNET)
//                != PackageManager.PERMISSION_GRANTED) {
//            // Check Permissions Now
//            ActivityCompat.requestPermissions(this,
//                    new String[]{Manifest.permission.INTERNET},
//                    2);
//        } else {
//            // permission has been granted, continue as usual
//            Toast.makeText(QRGenerator.this, "YAY", Toast.LENGTH_SHORT);
//        }
//    }
//
//    public void onRequestPermissionsResult(int requestCode,
//                                           String[] permissions,
//                                           int[] grantResults) {
//
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.INTERNET)
//                != PackageManager.PERMISSION_GRANTED) {
//            // Check Permissions Now
//
//            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
//                    Manifest.permission.INTERNET)) {
//                // Display UI and wait for user interaction
//            } else {
//                ActivityCompat.requestPermissions(
//                        this, new String[]{Manifest.permission.INTERNET}, 2);
//            }
//        } else {
//            // permission has been granted, continue as usual
//            Toast.makeText(QRGenerator.this, "YAY", Toast.LENGTH_SHORT);
//        }
//
//
//        if (requestCode == REQUEST_CODE_RESOLUTION) {
//            if(grantResults.length == 1
//                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                // We can now safely use the API we requested access to
//                Toast.makeText(QRGenerator.this, "YAY", Toast.LENGTH_SHORT);
//            } else {
//                // Permission was denied or request was cancelled
//            }
//        }
//    }




    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        public static ImageView image1;
    public void saveToDrive(View v)
    {
        image1 = new ImageView(this);
//        qrCodeImageview.setDrawingCacheEnabled(true);
//        qrCodeImageview.buildDrawingCache();
//        Bitmap image = Bitmap.createBitmap(qrCodeImageview.getDrawingCache());
        BitmapDrawable drawable = (BitmapDrawable) qrCodeImageview.getDrawable();
        Bitmap image = drawable.getBitmap();
        qrCodes.add(image);
        //MainActivity.image = image;
        System.out.println("DONEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
        System.out.println(qrCodes.size());
    }
//    @Override
//    protected void onResume() {
//        super.onResume();
//        if (mGoogleApiClient == null) {
//
//            /**
//             * Create the API client and bind it to an instance variable.
//             * We use this instance as the callback for connection and connection failures.
//             * Since no account name is passed, the user is prompted to choose.
//             */
//            mGoogleApiClient = new GoogleApiClient.Builder(this)
//                    .addApi(Drive.API)
//                    .addScope(Drive.SCOPE_FILE)
//                    .addConnectionCallbacks(this)
//                    .addOnConnectionFailedListener(this)
//                    .build();
//        }
//
//        mGoogleApiClient.connect();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        if (mGoogleApiClient != null) {
//
//            // disconnect Google API client connection
//            mGoogleApiClient.disconnect();
//        }
//        super.onPause();
//    }
//
//    @Override
//    public void onConnectionFailed(ConnectionResult result) {
//
//        // Called whenever the API client fails to connect.
//        Log.i(TAG, "GoogleApiClient connection failed: " + result.toString());
//
//        if (!result.hasResolution()) {
//
//            // show the localized error dialog.
//            GoogleApiAvailability.getInstance().getErrorDialog(this, result.getErrorCode(), REQUEST_CODE_RESOLUTION).show();
//            return;
//        }
//
//        /**
//         *  The failure has a resolution. Resolve it.
//         *  Called typically when the app is not yet authorized, and an  authorization
//         *  dialog is displayed to the user.
//         */
//
//        try {
//
//            result.startResolutionForResult(this, REQUEST_CODE_RESOLUTION);
//
//        } catch (IntentSender.SendIntentException e) {
//
//            Log.e(TAG, "Exception while starting resolution activity", e);
//        }
//    }
//
//    /**
//     * It invoked when Google API client connected
//     * @param connectionHint
//     */
//    @Override
//    public void onConnected(Bundle connectionHint) {
//
//        Toast.makeText(QRGenerator.this, "Connected", Toast.LENGTH_LONG).show();
//    }
//
//    /**
//     * It invoked when connection suspended
//     * @param cause
//     */
//    @Override
//    public void onConnectionSuspended(int cause) {
//
//        Log.i(TAG, "GoogleApiClient connection suspended");
//    }





    ImageView qrCodeImageview;
    ArrayList<String> QRcode;
    public final static int WIDTH=500;

    public String toString(ArrayList<String> x)
    {
        String out = "";
        for(int i = 0; i < x.size(); i++)
        {
            out += x.get(i) + "||";
        }
        return out;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(com.example.anmol.easycomplete2.R.layout.activity_qrgenerator);
        getID();
// create thread to avoid ANR Exception
        Thread t = new Thread(new Runnable() {
            public void run() {
// this is the msg which will be encode in QRcode
                QRcode= MainActivity.getInfoNeeded();

                try {
                    synchronized (this) {
                        wait(5000);
// runOnUiThread method used to do UI task in main thread.
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Bitmap bitmap = null;

                                    bitmap = encodeAsBitmap(QRcode.toString());
                                    qrCodeImageview.setImageBitmap(bitmap);

                                } catch (WriterException e) {
                                    e.printStackTrace();
                                } // end of catch block

                            } // end of run method
                        });

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }



            }
        });
        t.start();

    }

    private void getID() {
        qrCodeImageview=(ImageView) findViewById(com.example.anmol.easycomplete2.R.id.img_qr_code_image);
    }

    // this is method call from on create and return bitmap image of QRCode.
    Bitmap encodeAsBitmap(String str) throws WriterException {
        BitMatrix result;
        try {
            result = new MultiFormatWriter().encode(str,
                    BarcodeFormat.QR_CODE, WIDTH, WIDTH, null);
        } catch (IllegalArgumentException iae) {
            // Unsupported format
            return null;
        }
        int w = result.getWidth();
        int h = result.getHeight();
        int[] pixels = new int[w * h];
        for (int y = 0; y < h; y++) {
            int offset = y * w;
            for (int x = 0; x < w; x++) {
                pixels[offset + x] = result.get(x, y) ? getResources().getColor(com.example.anmol.easycomplete2.R.color.black):getResources().getColor(com.example.anmol.easycomplete2.R.color.white);
            }
        }
        Bitmap bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        bitmap.setPixels(pixels, 0, 500, 0, 0, w, h);
        return bitmap;
    }}
