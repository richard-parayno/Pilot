package com.hackathon.teamprogog.pilot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.paymaya.sdk.android.PayMayaConfig;
import com.paymaya.sdk.android.checkout.PayMayaCheckout;
import com.paymaya.sdk.android.checkout.PayMayaCheckoutCallback;

public class BillActivity extends AppCompatActivity implements PayMayaCheckoutCallback {

    private static final String PUBLIC_FACING_API_KEY = "pk-O1IZfB3cLgwS0rrs4xekEoIOMvyfAeomFUSV9PRR0UD";
    private PayMayaCheckout mPayMayaCheckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
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
