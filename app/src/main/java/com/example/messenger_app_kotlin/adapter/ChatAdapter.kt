package com.example.messenger_app_kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.messenger_app_kotlin.R
import com.example.messenger_app_kotlin.model.Chat
import com.example.messenger_app_kotlin.model.Room
import com.google.android.material.imageview.ShapeableImageView

class ChatAdapter(val context: Context,val items:ArrayList<Chat>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var TYPE_ROOM_LIST = 0
    var TYPE_MESSAGE = 1

    override fun getItemViewType(position: Int): Int {
        var chat = items[position]
        if (chat.rooms.size>0) return TYPE_ROOM_LIST
        return TYPE_MESSAGE
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == TYPE_ROOM_LIST){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat_room,parent,false)
            return RoomViewHolder(view)
        }
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat_message,parent,false)
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var chat = items[position]

        if(holder is MessageViewHolder){
            var iv_profile_message = holder.iv_profile_message
            var tv_fullname = holder.tv_fullname
            var is_online = holder.is_online

            iv_profile_message.setImageResource(chat.message!!.profile)
            if (chat.message!!.isOnline){
                is_online.visibility = View.VISIBLE
            }else{
                is_online.visibility = View.GONE
            }
            tv_fullname.text = chat.message!!.fullname
        }

        if (holder is RoomViewHolder){
            var recyclerView_room = holder.recyclerView

            recyclerView_room.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)

            refreshRoomAdapter(chat.rooms,recyclerView_room)

        }
    }

    private fun refreshRoomAdapter(rooms: ArrayList<Room>, recyclerviewRoom: RecyclerView) {
        val adapter = RoomAdapter(context,rooms)
        recyclerviewRoom.adapter = adapter

    }

    override fun getItemCount(): Int {
       return items.size
    }
}

class MessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var iv_profile_message:ShapeableImageView
    var tv_fullname:TextView
    var is_online: LinearLayout

    init {
        iv_profile_message = view.findViewById(R.id.iv_profile)
        tv_fullname = view.findViewById(R.id.tv_fullname)
        is_online = view.findViewById(R.id.is_online)
    }


}

class RoomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var recyclerView:RecyclerView

    init {
        recyclerView = view.findViewById(R.id.recycler_view_room)
    }

}
