package com.example.android.sample.samplerecyclerview.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.sample.samplerecyclerview.R
import com.example.android.sample.samplerecyclerview.adapter.List1Adapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView1 = findViewById<RecyclerView>(R.id.list1)

        val adapter = List1Adapter(this) {
            timeZone -> Toast.makeText(this, timeZone.displayName, Toast.LENGTH_SHORT).show()
        }

        recyclerView1.adapter = adapter

        recyclerView1.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}