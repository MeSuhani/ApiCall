package com.example.apicall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var start:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        start=findViewById(R.id.start)

        start.setOnClickListener {
            intent = Intent(this,ApicallActivity::class.java)
            startActivity(intent)
        }

    }
}