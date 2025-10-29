package com.example.pr22_voroshilov

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.snackbar.Snackbar
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    lateinit var city:EditText
    lateinit var humidity: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        city = findViewById(R.id.city)
        humidity = findViewById(R.id.humidity)
    }

    fun Find(view: View) {

        val key = "5273d30df428d8f715c77721f2121238"
        val url = "https://api.openweathermap.org/data/2.5/weather?q="+city.text.toString()+"&appid="+key+"&units=metric&lang=ru"

        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            {
                response ->
                val obj = JSONObject(response)
                val temp = obj.getJSONObject("weather")
                Snackbar.make(view, "Response: ${temp.getString("temp")}",Snackbar.LENGTH_LONG).show()
            },
            {
                Log.d("MyLog", "VOLLEY ERROR: $it")
                humidity.text = "VOLLEY ERROR: $it"
            }
        )
        queue.add(stringRequest)
    }
}