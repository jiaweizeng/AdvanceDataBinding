package com.example.admin.advancedatabinding

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.admin.advancedatabinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainActivity: ActivityMainBinding
    private lateinit var rvAdapter:RvAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity=DataBindingUtil.setContentView(this,R.layout.activity_main)
        mainActivity.rvAdvance.setHasFixedSize(true)
        mainActivity.rvAdvance.layoutManager=LinearLayoutManager(this)
        rvAdapter=RvAdapter(this)
        mainActivity.rvAdvance.adapter=rvAdapter
        val list = mutableListOf<User>()
        list.add(User("fdaa",11,true))
        list.add(User("we",15,true))
        list.add(User("df",156,false))
        list.add(User("vb",14,true))
        list.add(User("d",861,false))
        rvAdapter.addAll(list)

        mainActivity.setVariable(BR.presenter,Presenter())

    }

    open inner class Presenter{
        fun addClick(view: View){
            rvAdapter.add()

        }
        fun delClick(view: View){
            rvAdapter.remove()
        }

    }
}
