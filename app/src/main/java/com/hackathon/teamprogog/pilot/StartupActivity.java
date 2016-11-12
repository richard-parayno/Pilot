package com.hackathon.teamprogog.pilot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.parse.Parse;
import com.parse.ParseUser;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StartupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);
        // initialize parse
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("8OHITIMUQ3")
                .server("https://pilot-teamprog.herokuapp.com/parse")
                .build()
        );
        // clear sessions
        ParseUser currentUser = ParseUser.getCurrentUser();

        if (currentUser != null)
            currentUser.logOut();

        // start paymaya

        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }
}
