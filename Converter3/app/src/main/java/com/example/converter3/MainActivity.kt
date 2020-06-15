package com.example.converter3

import android.app.ProgressDialog
import android.content.Context
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class MainActivity : AppCompatActivity() {

    interface Service {
        @GET("https://api.exchangeratesapi.io/latest")
        fun data(): Call<ResponceModel>
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_page)
        m = this
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        resc = findViewById(R.id.Content)
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://exchangeratesapi.io/") //unused
            .build()
        val service = retrofit.create(Service::class.java)
        val pd = ProgressDialog.show(
            this@MainActivity, "", "Loading...", true,
            false
        )
        service.data().enqueue(object : Callback<ResponceModel> {
            override fun onResponse(
                call: Call<ResponceModel>,
                response: Response<ResponceModel>
            ) {
                Base = response.body()!!.GetBase()
                pd.dismiss()
                resc.setAdapter(
                    СurrencyAdapter(
                        this@MainActivity,
                        Base
                    )
                )
                title = "Последние курсы: " + response.body()!!.date
            }

            override fun onFailure(call: Call<ResponceModel>, t: Throwable) {
                pd.dismiss()
                setContentView(R.layout.error)
                Toast.makeText(
                    this@MainActivity,
                    "Ошибка, проверьте подключение к интернету или доступность сервиса!",
                    Toast.LENGTH_LONG
                ).show()
                val b = findViewById<Button>(R.id.button)
                b.setOnClickListener { recreate() }
            }
        })
    }

    companion object {
        private lateinit var resc: RecyclerView
        private lateinit var m: MainActivity
        private lateinit var Base: ArrayList<ConverterRow>
        fun ResetAdapter(ct: Context) {
            if (!resc.isComputingLayout) {
                val r = RecyclerView(ct)
                val l = m.findViewById<LinearLayout>(R.id.mp)
                val lo = LinearLayoutManager(ct)
                r.layoutManager = lo
                l.removeAllViewsInLayout()
                l.addView(r)
                r.adapter = СurrencyAdapter(ct, Base)
            }
        }
    }
}