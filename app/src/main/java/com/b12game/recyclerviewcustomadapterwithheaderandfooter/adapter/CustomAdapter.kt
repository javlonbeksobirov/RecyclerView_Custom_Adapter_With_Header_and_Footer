package com.b12game.recyclerviewcustomadapterwithheaderandfooter.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.b12game.recyclerviewcustomadapterwithheaderandfooter.R
import com.b12game.recyclerviewcustomadapterwithheaderandfooter.model.Member

class CustomAdapter(var members: ArrayList<Member>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_ITEM_HEADER = 0
    private val TYPE_ITEM_YES_VIEW = 1
    private val TYPE_ITEM_NOT_VIEW = 2
    private val TYPE_ITEM_FOOTER = 3


    override fun getItemViewType(position: Int): Int {
        if(isHeader(position)) return TYPE_ITEM_HEADER
        if(isFooter(position)) return TYPE_ITEM_FOOTER

        var member = members[position]
        return if(member.available) TYPE_ITEM_YES_VIEW else TYPE_ITEM_NOT_VIEW
    }

    fun isHeader(position: Int): Boolean{
        return position == 0
    }

    fun isFooter(position: Int): Boolean{
        return position == members.size - 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == TYPE_ITEM_HEADER){
            val heaader = LayoutInflater.from(parent.context).inflate(R.layout.item_custom_header,parent,false)
            return CustomViewHeaderHolder(heaader)
        }else if(viewType == TYPE_ITEM_YES_VIEW){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_custom_layout_yes,parent,false)
            return CustomViewYesHolder(view)
        }else if(viewType == TYPE_ITEM_NOT_VIEW){
           val view = LayoutInflater.from(parent.context).inflate(R.layout.item_custom_layout_not,parent,false)
           return CustomViewNotHolder(view)
        }
        val footer = LayoutInflater.from(parent.context).inflate(R.layout.item_custom_footer,parent,false)
        return CustomViewFooterHolder(footer)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val member = members.get(position)

        if(holder is CustomViewYesHolder){
            holder.first_name.setText(member.firstName)
            holder.last_name.setText(member.lastName)
        }

        if(holder is CustomViewNotHolder){
            holder.first_name.setText(member.firstName)
            holder.last_name.setText("This is not available text")
        }
    }

    override fun getItemCount(): Int {
        return members.size
    }

    class CustomViewHeaderHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    class CustomViewYesHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val first_name = itemView.findViewById<TextView>(R.id.tv_first_name)
        val last_name = itemView.findViewById<TextView>(R.id.tv_last_name)
    }

    class CustomViewNotHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val first_name = itemView.findViewById<TextView>(R.id.tv_first_name)
        val last_name = itemView.findViewById<TextView>(R.id.tv_last_name)
    }

    class CustomViewFooterHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }
}