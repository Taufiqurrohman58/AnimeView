package com.barengsaya.animeview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimaryDark)
        // Mengatur toolbar
        supportActionBar?.title = "About AnimeView"
    }
}
