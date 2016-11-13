package com.hackathon.teamprogog.pilot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.paymaya.sdk.android.PayMayaConfig;
import com.paymaya.sdk.android.checkout.PayMayaCheckout;
import com.paymaya.sdk.android.checkout.PayMayaCheckoutCallback;
import com.paymaya.sdk.android.checkout.models.Address;
import com.paymaya.sdk.android.checkout.models.Buyer;
import com.paymaya.sdk.android.checkout.models.Contact;

public class BillActivity extends AppCompatActivity implements PayMayaCheckoutCallback {

    private static final String PUBLIC_FACING_API_KEY = "pk-O1IZfB3cLgwS0rrs4xekEoIOMvyfAeomFUSV9PRR0UD";
    private PayMayaCheckout mPayMayaCheckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        imgBtnBill = (ImageButton) findViewById(R.id.billingButton);

        imgBtnBill.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent billIntent = new Intent(BillActivity.this, BillActivity.class/*NEXT ACTIVITY HERE */); //<----- PACHECK NLNG ITO, ALAM KO HINDI ITO GUMAGANA
                startActivity(billIntent);
            }
        });

        // initialize paymaya
        PayMayaConfig.setEnvironment(PayMayaConfig.ENVIRONMENT_PRODUCTION);
        mPayMayaCheckout = new PayMayaCheckout(PUBLIC_FACING_API_KEY, this);

    }




    @Override
    public void onCheckoutSuccess() {

    }

    @Override
    public void onCheckoutCanceled() {

    }

    @Override
    public void onCheckoutFailure(String message) {

    }
}
