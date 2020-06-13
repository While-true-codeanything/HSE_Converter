package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;


public class MainActivity extends AppCompatActivity {
    private static RecyclerView resc;
    static MainActivity m;
    private static ArrayList<ConverterRow> Base;

    public interface Service {
        @GET("https://api.exchangeratesapi.io/latest")
        Call<ResponceModel> getData();
    }

    public static void ResetAdapter(Context ct) {
        if (!resc.isComputingLayout()) {
            RecyclerView r = new RecyclerView(ct);
            LinearLayout l = m.findViewById(R.id.mp);
            LinearLayoutManager lo = new LinearLayoutManager(ct);
            r.setLayoutManager(lo);
            l.removeAllViewsInLayout();
            l.addView(r);
            r.setAdapter(new СurrencyAdapter(ct, Base));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        m = this;
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_page);
        resc = findViewById(R.id.Content);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://exchangeratesapi.io/")//unused
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Service service = retrofit.create(Service.class);
        ProgressDialog pd = ProgressDialog.show(MainActivity.this, "", "Loading...", true,
                false);
        service.getData().enqueue(new Callback<ResponceModel>() {
            @Override
            public void onResponse(Call<ResponceModel> call, Response<ResponceModel> response) {
                Base = response.body().GetBase();
                pd.dismiss();
                resc.setAdapter(new СurrencyAdapter(MainActivity.this, Base));
                setTitle("Последние курсы: " + response.body().getDate());
            }

            @Override
            public void onFailure(Call<ResponceModel> call, Throwable t) {
                pd.dismiss();
                setContentView(R.layout.error);
                Toast.makeText(MainActivity.this, "Ошибка, проверьте подключение к интернету или доступность сервиса!",
                        Toast.LENGTH_LONG).show();
                Button b = findViewById(R.id.button);
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        recreate();
                    }
                });
            }
        });
    }
}