package com.shayekh.android.webservice;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView textView,textView2;
    ImageView imageView;
    private Api_Service service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.text);
        textView2=(TextView)findViewById(R.id.text2);
        imageView=(ImageView)findViewById(R.id.image);
        service = Api_Response.getUser().create(Api_Service.class);
        Call<UserResponse> paku = service.getUser();
        paku.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {

                if (response.code() == 200) {
                    UserResponse userResponse = response.body();
//                    textView.setText(userResponse.getInfo().getSeed()+"\n"
//                            +"\n"+ userResponse.getInfo().getVersion()
//                    + "\n"+userResponse.getInfo().getPage());
                    textView.setText(userResponse.getResults().get(0).getName().getFirst());
                    textView2.setText(userResponse.getResults().get(0).getLocation()
                    .getTimezone().getDescription());

                    //Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(imageView);
                    Picasso.get().load(userResponse.getResults().get(0).getPicture()
                    .getLarge()).into(imageView);




                }

            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

            }
        });

    }
}
