package com.hackathon.teamprogog.pilot.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by rparayno on 12/11/2016.
 */

public class BillingAddress {

    @SerializedName("line1")
    @Expose
    public String line1;
    @SerializedName("line2")
    @Expose
    public String line2;
    @SerializedName("city")
    @Expose
    public String city;
    @SerializedName("state")
    @Expose
    public String state;
    @SerializedName("zipCode")
    @Expose
    public String zipCode;
    @SerializedName("countryCode")
    @Expose
    public String countryCode;

}
