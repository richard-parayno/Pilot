package com.hackathon.teamprogog.pilot;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        Button register = (Button) findViewById(R.id.create_account);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createUser(view);
            }
        });



    }

    public void createUser(View view) {
        EditText userAccountNo = (EditText)findViewById(R.id.accountno);
        String accountNo = userAccountNo.getText().toString();
        EditText userNameInput = (EditText)findViewById(R.id.username);
        String userName = userNameInput.getText().toString();
        EditText userEmailInput  = (EditText)findViewById(R.id.email);
        String email = userEmailInput.getText().toString();
        EditText userPasswordInput  = (EditText)findViewById(R.id.password);
        String password = userPasswordInput.getText().toString();
        EditText userAddressInput  = (EditText)findViewById(R.id.address);
        String address = userAddressInput.getText().toString();

        ParseUser newUser = new ParseUser();
        newUser.setUsername(userName);
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.put("address", address);
        newUser.put("accountNo", accountNo);

        newUser.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    // Hooray! Let them use the app now.
                    System.out.println("Account created");
                    Toast.makeText(getApplicationContext(),
                            "Account creation successful.",
                            Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                    finish();

                } else {
                    // Sign up didn't succeed. Look at the ParseException
                    // to figure out what went wrong
                    e.printStackTrace();
                    System.out.println("Error in creating account");

                }
            }
        });

    }

}
