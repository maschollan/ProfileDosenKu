package com.chollan.profiledosenku

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "extra name"
        const val EXTRA_NIP = "extra nip"
        const val EXTRA_KEAHLIAN = "extra keahlian"
        const val EXTRA_PHOTO = "extra photo"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val tvName : TextView = findViewById(R.id.tv_detail_name)
        val tvNip : TextView = findViewById(R.id.tv_detail_nip)
        val tvKeahlian : TextView = findViewById(R.id.tv_detail_keahlian)
        val photo : CircleImageView = findViewById(R.id.img_profile)

        tvName.text = intent.getStringExtra(EXTRA_NAME)
        tvNip.text = intent.getStringExtra(EXTRA_NIP)
        tvKeahlian.text = intent.getStringExtra(EXTRA_KEAHLIAN)
        photo.setImageResource(intent.getIntExtra(EXTRA_PHOTO, 0))

        val btnBack : Button = findViewById(R.id.btn_kembali)
        btnBack.setOnClickListener {
            super.onBackPressed()
        }
    }
}