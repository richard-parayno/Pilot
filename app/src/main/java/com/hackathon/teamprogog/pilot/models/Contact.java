
package com.hackathon.teamprogog.pilot.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Contact {

    @SerializedName("phone")
    @Expose
    public String phone;
    @SerializedName("email")
    @Expose
    public String email;

}
