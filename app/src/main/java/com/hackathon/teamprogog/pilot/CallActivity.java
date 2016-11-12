package com.hackathon.teamprogog.pilot;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.*;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class CallActivity extends AppCompatActivity {
    private Button callButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        callButton = (Button) findViewById(R.id.btnCall);

        callButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 09284994286"));

                if (ActivityCompat.checkSelfPermission(CallActivity.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED)
                    startActivity(callIntent);

            }
        });
    }
}