package com.example.messenger_app_kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.messenger_app_kotlin.R
import com.example.messenger_app_kotlin.model.Room
import com.google.android.material.imageview.ShapeableImageView

class RoomAdapter(var context: Context, var items: ArrayList<Room>) :RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    val ROOM_ITEM_TYPE_FIRST = 0
    val ROOM_ITEM_TYPE = 1

    override fun getItemViewType(position: Int): Int {
        if(position == 0) return ROOM_ITEM_TYPE_FIRST
        return ROOM_ITEM_TYPE
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == ROOM_ITEM_TYPE_FIRST){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_room_view_first,parent,false)
            return FirstRoomItemViewHolder(view)
        }
          val view = LayoutInflater.from(parent.context).inflate(R.layout.item_room_view,parent,false)
        return RoomItemViewHolder(view)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        var room = items[position]

        if(holder is RoomItemViewHolder){
            var tv_fullname_room = holder.tv_name_room
            var iv_profile_room = holder.iv_profile_room

            tv_fullname_room.text = room.fullname
            iv_profile_room.setImageResource(room.profile)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

}

class RoomItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var tv_name_room:TextView
    var iv_profile_room:ShapeableImageView

    init {
        tv_name_room = view.findViewById(R.id.tv_fullname_room)
        iv_profile_room = view.findViewById(R.id.iv_profile_room)
    }

}

class FirstRoomItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {}
