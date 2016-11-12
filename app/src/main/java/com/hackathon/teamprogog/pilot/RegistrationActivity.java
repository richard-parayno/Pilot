package com.hackathon.teamprogog.pilot;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // initialize parse
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("8OHITIMUQ3")
                .server("https://pilot-teamprog.herokuapp.com/parse")
                .build()
        );
        Button register = (Button) findViewById(R.id.create_account);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createUser(view);
            }
        });



    }

    public void createUser(View view) {
        EditText userTextInput  = (EditText)findViewById(R.id.accountno);
        String username = userTextInput.getText().toString();
        EditText userEmailInput  = (EditText)findViewById(R.id.email);
        String email = userEmailInput.getText().toString();
        EditText userPasswordInput  = (EditText)findViewById(R.id.password);
        String password = userPasswordInput.getText().toString();
        EditText userAddressInput  = (EditText)findViewById(R.id.address);
        String address = userAddressInput.getText().toString();

        ParseUser newUser = new ParseUser();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.put("address", address);

        newUser.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    // Hooray! Let them use the app now.

                } else {
                    // Sign up didn't succeed. Look at the ParseException
                    // to figure out what went wrong
                }
            }
        });

    }

    public void logIn(View view) {
        EditText userEmailInput  = (EditText)findViewById(R.id.email);
        String email = userEmailInput.getText().toString();
        EditText userPasswordInput  = (EditText)findViewById(R.id.password);
        String password = userPasswordInput.getText().toString();


        ParseUser.logInInBackground(email, password, new LogInCallback() {
            public void done(ParseUser user, ParseException e) {
                if (user != null) {
                    // Hooray! The user is logged in.
                } else {
                    // Signup failed. Look at the ParseException to see what happened.
                }
            }
        });
    }

}
