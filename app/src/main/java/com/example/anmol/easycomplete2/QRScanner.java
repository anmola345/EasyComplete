package com.example.anmol.easycomplete2;

//package com.javacodegeeks.androidqrcodeexample;

        import android.app.Activity;
        import android.app.AlertDialog;
        import android.content.ActivityNotFoundException;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.net.Uri;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;

        import java.util.ArrayList;
        import java.util.Arrays;

public class QRScanner extends AppCompatActivity {

    static final String ACTION_SCAN = "com.google.zxing.client.android.SCAN";
    public static String doneTheData;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set the main content layout of the Activity
        setContentView(com.example.anmol.easycomplete2.R.layout.activity_qrscanner);
    }

    //product barcode mode
    public void scanBar(View v) {
        try {
            //start the scanning activity from the com.google.zxing.client.android.SCAN intent
            Intent intent = new Intent(ACTION_SCAN);
            intent.putExtra("SCAN_MODE", "PRODUCT_MODE");
            startActivityForResult(intent, 0);
        } catch (ActivityNotFoundException anfe) {
            //on catch, show the download dialog
            showDialog(QRScanner.this, "No Scanner Found", "Download a scanner code activity?", "Yes", "No").show();
        }
    }


    //product qr code mode
    public void scanQR(View v) {
        try {
            //start the scanning activity from the com.google.zxing.client.android.SCAN intent
            Intent intent = new Intent(ACTION_SCAN);
            intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
            startActivityForResult(intent, 0);
        } catch (ActivityNotFoundException anfe) {
            //on catch, show the download dialog
            showDialog(QRScanner.this, "No Scanner Found", "Download a scanner code activity?", "Yes", "No").show();
        }
    }

    //alert dialog for downloadDialog
    private static AlertDialog showDialog(final Activity act, CharSequence title, CharSequence message, CharSequence buttonYes, CharSequence buttonNo) {
        AlertDialog.Builder downloadDialog = new AlertDialog.Builder(act);
        downloadDialog.setTitle(title);
        downloadDialog.setMessage(message);
        downloadDialog.setPositiveButton(buttonYes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                Uri uri = Uri.parse("market://search?q=pname:" + "com.google.zxing.client.android");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                try {
                    act.startActivity(intent);
                } catch (ActivityNotFoundException anfe) {

                }
            }
        });
        downloadDialog.setNegativeButton(buttonNo, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        return downloadDialog.show();
    }


    //on ActivityResult method
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                //get the extras that are returned from the intent
                String contents = intent.getStringExtra("SCAN_RESULT");
                contents = contents.substring(1,contents.length()-3);
                ArrayList<String> result = new ArrayList<String>();
                String[] check = contents.split(": ,");
                System.out.println(Arrays.toString(check) + "--------------------------------------------------------------Check");
                for(int i = 0; i < check.length; i++) {
                    result.add(check[i]);
                    result.add("");
                }
                System.out.println(result.toString() + "--------------------------------------------------------------Result 1");
                ArrayList<String> getInfo;
                int index = MainActivity.justNames.indexOf(MainActivity.nameToBeUsed);
                System.out.println(index);
                if(index > -1){
                    getInfo = MainActivity.namesAndInfo.get(index);
                System.out.println(getInfo.toString() + "-------------------------------------------------------------------getInfo");
                ArrayList<String> test = new ArrayList<String>();
                test.add("First Name");
                test.add("Last Name");
                test.add("Email");
                test.add("Phone Number");

                for(int i = 1; i < result.size(); i = i + 2) {
                    System.out.println(getInfo.get(test.indexOf(result.get(i-1).trim())));
                    result.set(i, getInfo.get(test.indexOf(result.get(i-1).trim())));
                }
                doneTheData = gettingThePerfectData(result);
           //         System.out.println("----------------------------------------------------------------WORKING");
                String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
                //String[] result = intent.getStringArrayExtra("SCAN_RESULT");
                Intent done = new Intent(this, QRGenerator2.class);
                startActivity(done);

            }}
        }
    }
    public String gettingThePerfectData(ArrayList<String> x)
    {
        String done = "";
        for(int i = 0; i < x.size(); i+= 2)
            done += x.get(i) + ": " + x.get(i+1) + "\n";

        return done;
    }
}
