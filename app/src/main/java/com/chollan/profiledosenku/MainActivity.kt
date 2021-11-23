package com.chollan.profiledosenku

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var list : ArrayList<Dosen> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var rvDosen : RecyclerView = findViewById(R.id.rv_dosen)
        rvDosen.setHasFixedSize(true)

        list.addAll(DataDosen.listData)

        val cardViewHolder = DosenAdapter(list)
        rvDosen.adapter = cardViewHolder

        rvDosen.layoutManager = LinearLayoutManager(this)
    }
}