package com.maciejkozlowski.constraintlayoutperformance

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Maciej Kozłowski on 24.11.2018.
 */

class Adapter(private val list: List<String>) : RecyclerView.Adapter<Adapter.Holder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.item1_constraint, p0, false)
        return Holder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = list[position]
    }

    inner class Holder(view: View) : RecyclerView.ViewHolder(view)
}