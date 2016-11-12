package com.hackathon.teamprogog.pilot.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by rparayno on 12/11/2016.
 */

public class Contact {

    @SerializedName("phone")
    @Expose
    public String phone;
    @SerializedName("email")
    @Expose
    public String email;

}
