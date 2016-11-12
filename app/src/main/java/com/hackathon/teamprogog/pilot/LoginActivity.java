package com.hackathon.teamprogog.pilot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // initialize parse
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("8OHITIMUQ3")
                .server("https://pilot-teamprog.herokuapp.com/parse")
                .build()
        );
        Button login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser(view);
            }
        });

    }

    public void loginUser(View view) {
        EditText userEmailInput  = (EditText)findViewById(R.id.email);
        String email = userEmailInput.getText().toString();
        EditText userPasswordInput  = (EditText)findViewById(R.id.password);
        String password = userPasswordInput.getText().toString();


        ParseUser.logInInBackground(email, password, new LogInCallback() {
            public void done(ParseUser user, ParseException e) {
                if (user != null) {
                    System.out.println("Login Successful");
                } else {
                    System.out.println("Login Failed");
                }
            }
        });
    }
}
