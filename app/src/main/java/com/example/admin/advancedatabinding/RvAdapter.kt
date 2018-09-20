package com.example.admin.advancedatabinding

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import java.util.*


/**
 * Created by zjw on 2018/8/16.
 */
class RvAdapter( private val context:Context) : RecyclerView.Adapter<RvAdapter.RvHolder<ViewDataBinding>>() {

    private var user:MutableList<User> = mutableListOf()
    private val random:Random=Random()
    private val TYPE_SHOW=0xa0
    private val TYPE_HIDE=0xa1
    override fun onBindViewHolder(holder: RvHolder<ViewDataBinding>?, position: Int) {
        holder?.setData(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RvHolder<ViewDataBinding> {

        return if (viewType==TYPE_SHOW){
             RvHolder(DataBindingUtil.inflate(LayoutInflater.from(context),R.layout.rv_item,parent,false))
        }else{
             RvHolder(DataBindingUtil.inflate(LayoutInflater.from(context),R.layout.rv_item_hide,parent,false))
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (user.size>0){

            return if (user[position].isShow){
                TYPE_SHOW
            }else{
                TYPE_HIDE
            }
        }

        return 0
    }

    override fun getItemCount(): Int {
        return user.size
    }

    inner class RvHolder< T : ViewDataBinding>(private val binding: T) : RecyclerView.ViewHolder(binding.root) {
        fun setData(position: Int) {
            if (user.size>0){
                binding.setVariable(BR.item, user[position])
                binding.executePendingBindings()
            }
        }
    }

    fun addAll(list: List<User>){
        user.addAll(list)
        notifyDataSetChanged()
    }

    fun add(){
        var  int = 0
        if (user.size>1) int = random.nextInt(user.size - 1)
        user.add(int, User("fff",12,false))
        notifyItemInserted(int)
    }
    
    fun remove(){
        if (user.size==0)return
        var  int = 0
        if (user.size>1){
            int = random.nextInt(user.size - 1)
        }
        user.removeAt(int)
        notifyItemRemoved(int)
    }


}

