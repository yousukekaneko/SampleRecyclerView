package com.example.android.sample.samplerecyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.sample.samplerecyclerview.R
import java.util.*

class List1Adapter(context: Context,
        private val onItemClicked: (TimeZone) -> Unit)
    : RecyclerView.Adapter<List1Adapter.List1ViewHolder>() {

    private val inflater = LayoutInflater.from(context)

    private val timeZones = TimeZone.getAvailableIDs().map {
        id -> TimeZone.getTimeZone(id)
    }

    class List1ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val time = view.findViewById<TextView>(R.id.time)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): List1ViewHolder {
        val view = inflater.inflate(R.layout.list1_row, parent, false)

        val viewHolder = List1ViewHolder(view)

        view.setOnClickListener {
            val position = viewHolder.adapterPosition

            val timeZone = timeZones[position]

            onItemClicked(timeZone)
        }

        return viewHolder
    }

    override fun getItemCount(): Int = timeZones.size

    override fun onBindViewHolder(holder: List1ViewHolder, position: Int) {
        val timeZone = timeZones[position]

        holder.time.text = timeZone.id
    }
}