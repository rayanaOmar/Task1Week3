package com.example.task1week3

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class printOut : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nextactivity)

        val tvMain = findViewById<TextView>(R.id.print)
        val pri = intent.extras?.get("Text")

        tvMain.text = pri.toString()
    }
}