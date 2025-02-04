package com.barengsaya.animeview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimaryDark)

        // Mengambil data dari Intent
        val title = intent.getStringExtra("title")
        val imageResId = intent.getIntExtra("imageResId", 0)
        val longDescription = intent.getStringExtra("longDescription")

        // Menghubungkan dengan view
        val titleView: TextView = findViewById(R.id.detail_title)
        val overviewView: TextView = findViewById(R.id.detail_overview)
        val imageView: ImageView = findViewById(R.id.detail_image)

        // Set data ke view
        titleView.text = title
        overviewView.text = longDescription
        imageView.setImageResource(imageResId)
    }
}
