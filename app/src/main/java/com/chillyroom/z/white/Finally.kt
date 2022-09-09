package com.chillyroom.z.white

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chillyroom.z.R
import kotlinx.android.synthetic.main.activity_finally.*

class Finally : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finally)
        btn_again.setOnClickListener{
            startActivity(Intent(this, Gaming::class.java))
        }
    }
}