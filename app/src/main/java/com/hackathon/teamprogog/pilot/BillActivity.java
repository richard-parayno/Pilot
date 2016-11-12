package com.hackathon.teamprogog.pilot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;


public class BillActivity extends AppCompatActivity {
    private ImageButton imgBtnBill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        imgBtnBill = (ImageButton) findViewById(R.id.billingButton);

        imgBtnBill.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent billIntent = new Intent(BillActivity.this, BillActivity.class); //<----- PACHECK NLNG ITO
                startActivity(billIntent);
            }
        });
    }
}
