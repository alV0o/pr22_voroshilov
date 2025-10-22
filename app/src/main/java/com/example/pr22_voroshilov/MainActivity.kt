package com.example.pr22_voroshilov

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun Find(view: View) {
        val key = "https://api.openweathermap.org/data/2.5/weather?q=Ekaterinburg&appid=5273d30df428d8f715c77721f2121238&units=metric&lang=ru"
    }
}