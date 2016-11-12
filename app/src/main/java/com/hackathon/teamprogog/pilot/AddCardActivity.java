package com.hackathon.teamprogog.pilot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hackathon.teamprogog.pilot.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;


public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitData(view);
            }
        });
    }

    public void submitData(View view) {



    }

    public interface MyApiEndpointInterface {
        // Request method and URL specified in the annotation
        // Callback for the parsed response is the last parameter

        @GET("customers/{id}")
        Call<User> getCustomer(@Path("id") String username);

        @PUT("customers/{id}")
        Call<List<User>> groupList(@Path("id") int groupId, @Query("sort") String sort);

        @POST("customers")
        Call<User> createCustomer(@Body User user);
    }
}
