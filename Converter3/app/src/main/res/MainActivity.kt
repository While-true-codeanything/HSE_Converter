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
import com.example.converter2.ConverterRow
import com.example.converter2.R
import com.example.converter2.ResponceModel
import com.example.converter2.СurrencyAdapter
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.*
import retrofit2.Callback as Callback1

class MainActivity : AppCompatActivity() {
    lateinit var  resc:RecyclerView

    public interface Service {
        @GET("https://api.exchangeratesapi.io/latest")
        fun data(): Call<ResponceModel?>
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        m = this
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_page)
        resc = findViewById(R.id.Content)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://exchangeratesapi.io/") //unused
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(Service::class.java)
        val pd = ProgressDialog.show(
            this@MainActivity, "", "Loading...", true,
            false
        )
       /* val cb= */
        service.data().enqueue(object:Callback1<ResponceModel?> {
            override fun onResponse(
                call: Call<ResponceModel?>,
                response: Response<ResponceModel?>
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

            override fun onFailure(call: Call<ResponceModel?>, t: Throwable) {
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
        private var resc: RecyclerView? = null
        var m: MainActivity? = null
        private var Base: ArrayList<ConverterRow>? = null
        fun ResetAdapter(ct: Context?) {
            if (!resc!!.isComputingLayout) {
                val r = RecyclerView(ct!!)
                val l = m!!.findViewById<LinearLayout>(R.id.mp)
                val lo = LinearLayoutManager(ct)
                r.layoutManager = lo
                l.removeAllViewsInLayout()
                l.addView(r)
                r.adapter = СurrencyAdapter(ct, Base)
            }
        }
    }
}