package com.example.converter3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnFocusChangeListener
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class СurrencyAdapter(
    ct: Context,
    Base2: ArrayList<ConverterRow>

) : RecyclerView.Adapter<СurrencyAdapter.ViewHolder2>() {
    private val context: Context = ct
    private var Base: ArrayList<ConverterRow> = Base2
    private val inflater: LayoutInflater

    init {
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): СurrencyAdapter.ViewHolder2 {
        val subj = inflater.inflate(R.layout.currency_item, parent, false)
        return ViewHolder2(subj)
    }

    override fun onBindViewHolder(holder: ViewHolder2, position: Int) {
        holder.name.text = Base[position].name
        holder.value.text = String.format(
            "%.2f",
            Base[position].Course * Value
        ).replace(",", ".")
        holder.value.onFocusChangeListener = OnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                Value = if (holder.value.text.toString() == "") 0.0 else {
                    holder.value.text.toString().toDouble() / Base[position].Course
                }
                MainActivity.ResetAdapter(context)
            }
        }
    }

    override fun getItemCount(): Int {
        return Base.size
    }

    inner class ViewHolder2(view: View) : ViewHolder(view) {
        var name: TextView
        var value: TextView

        init {
            name = view.findViewById(R.id.Name)
            value = view.findViewById(R.id.Value)
        }
    }


    companion object {
        private var Value = 1.0
    }
}

