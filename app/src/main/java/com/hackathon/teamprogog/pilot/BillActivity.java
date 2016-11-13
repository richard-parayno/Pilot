package com.hackathon.teamprogog.pilot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.parse.ParseObject;
import com.paymaya.sdk.android.PayMayaConfig;
import com.paymaya.sdk.android.checkout.PayMayaCheckout;
import com.paymaya.sdk.android.checkout.PayMayaCheckoutCallback;
import com.paymaya.sdk.android.checkout.models.Address;
import com.paymaya.sdk.android.checkout.models.Buyer;
import com.paymaya.sdk.android.checkout.models.Checkout;
import com.paymaya.sdk.android.checkout.models.Contact;
import com.paymaya.sdk.android.checkout.models.Item;
import com.paymaya.sdk.android.checkout.models.RedirectUrl;
import com.paymaya.sdk.android.checkout.models.TotalAmount;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class BillActivity extends AppCompatActivity implements PayMayaCheckoutCallback {

    private static final String PUBLIC_FACING_API_KEY = "pk-8rOz4MQKRxd5OLKBPcR6FIUx4Kay71kB3UrBFDaH172";
    private PayMayaCheckout mPayMayaCheckout;
    protected Buyer buyer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);


        // initialize paymaya
        PayMayaConfig.setEnvironment(PayMayaConfig.ENVIRONMENT_SANDBOX);
        mPayMayaCheckout = new PayMayaCheckout(PUBLIC_FACING_API_KEY, this);

        executeCheckout(constructBuyer());


    }

    private Checkout constructBuyer() {
        ParseObject buyerObject = new ParseObject("BuyerObject");
        buyerObject.put("firstName", "Michael");
        buyerObject.put("middleName", "Labjatan");
        buyerObject.put("lastName", "Tiu");

        buyerObject.put("line1", "19-A Onyx Street");
        buyerObject.put("line2", "Greenheights Village");
        buyerObject.put("city", "Paranaque City");
        buyerObject.put("state", "NCR");
        buyerObject.put("zipcode", 1702);
        buyerObject.put("ccode", 63);

        buyerObject.put("mobileNun", "+639284994286");
        buyerObject.put("emailAdd", "michael@yahoo.com");

        Contact contact = new Contact("+639284994286", "michael@yahoo.com");
        Address address = new Address("19-A Onyx Street", "Greenheights Village", "Paranaque City", "NCR", "1702", "PH");
        buyer = new Buyer("Michael", "Labiatan", "Tiu");
        buyer.setContact(contact);
        buyer.setBillingAddress(address);
        buyer.setShippingAddress(address);

        BigDecimal summaryTotal = BigDecimal.valueOf(2495.01);
        List itemsList = new ArrayList<>();
        String currency = "PHP";


        BigDecimal item1Amount = BigDecimal.valueOf(2495.01);
        summaryTotal.add(item1Amount);
        TotalAmount totalAmount = new TotalAmount(item1Amount, currency);
        int quantity = 1;
        Item item1 = new Item("PLDT Bill", quantity, totalAmount);
        item1.setSkuCode("SKU12345");
        item1.setDescription("Bill as of Nov 13 2016");
        itemsList.add(item1);
        summaryTotal.add(item1Amount);


        String successURL = "http://yourshop.com/success";
        String failedURL = "http://yourshop.com/failed";
        String canceledURL = "http://yourshop.com/canceled";

        String requestReference = "YourRequestReferenceCode";
        RedirectUrl redirectUrl = new RedirectUrl(successURL, failedURL, canceledURL);
        Checkout checkout = new Checkout(totalAmount, buyer, itemsList, requestReference, redirectUrl);
        return checkout;
    }



    

    private void executeCheckout(Checkout payload) {
        mPayMayaCheckout.execute(BillActivity.this, payload);
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }




    @Override
    public void onCheckoutSuccess() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onCheckoutCanceled() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onCheckoutFailure(String message) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
