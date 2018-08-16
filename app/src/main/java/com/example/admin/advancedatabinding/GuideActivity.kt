package com.example.admin.advancedatabinding

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class GuideActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide)
    }

    fun clickRecycleView(view: View){
        startActivity(Intent(this,MainActivity::class.java))
    }

    fun clickExpressionActivity(view: View){
        startActivity(Intent(this,MainActivity::class.java))
    }
}
