package com.hackathon.teamprogog.pilot.models;

/**
 * Created by rparayno on 12/11/2016.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("firstName")
    @Expose
    public String firstName;
    @SerializedName("middleName")
    @Expose
    public String middleName;
    @SerializedName("lastName")
    @Expose
    public String lastName;
    @SerializedName("contact")
    @Expose
    public Contact contact;
    @SerializedName("billingAddress")
    @Expose
    public BillingAddress billingAddress;
    @SerializedName("sex")
    @Expose
    public String sex;
    @SerializedName("birthday")
    @Expose
    public String birthday;
    @SerializedName("createdAt")
    @Expose
    public String createdAt;
    @SerializedName("updatedAt")
    @Expose
    public String updatedAt;

}
