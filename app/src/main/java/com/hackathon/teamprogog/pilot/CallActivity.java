package com.hackathon.teamprogog.pilot;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.*;
import android.os.Bundle;
import android.view.View;
import android.widget.*;


public class CallActivity extends AppCompatActivity {
    private ImageButton imgBtnCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        imgBtnCall = (ImageButton) findViewById(R.id.callButton);

        imgBtnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:09284994286"));

                if (ActivityCompat.checkSelfPermission(CallActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    System.out.println("Button Failed");

                    return;
                }
                startActivity(callIntent);

            }
        });
    }
}