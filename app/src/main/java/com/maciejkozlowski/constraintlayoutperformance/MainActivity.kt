package com.maciejkozlowski.constraintlayoutperformance

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = Adapter(getList())
    }

    private fun getList(): List<String> {
        val random = Random()
        val list = mutableListOf<String>()
        for (i in 1..100) {
            list.add(random.nextLong().toString())
        }

        return list
    }
}
