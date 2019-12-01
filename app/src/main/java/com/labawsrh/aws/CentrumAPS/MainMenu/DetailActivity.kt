package com.haerul.swipeviewpager

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.labawsrh.aws.CentrumAPS.R

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val textView = findViewById<TextView>(R.id.textView)
        textView.text = intent.getStringExtra("param")
    }
}
