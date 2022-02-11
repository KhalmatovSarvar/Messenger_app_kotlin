package com.example.messenger_app_kotlin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.messenger_app_kotlin.R
import com.example.messenger_app_kotlin.adapter.ChatAdapter
import com.example.messenger_app_kotlin.model.Chat
import com.example.messenger_app_kotlin.model.Message
import com.example.messenger_app_kotlin.model.Room

class ChatsFragment :Fragment() {

    private  lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_chats,container,false)
        initViews(view)
        return view

    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        
        refreshAdapter(getAllChats())
    }

    private fun refreshAdapter(chats: ArrayList<Chat>) {
        val adapter = ChatAdapter(requireContext(),chats)
        recyclerView.adapter = adapter

    }

    private fun getAllChats(): ArrayList<Chat>{
        val stories = ArrayList<Room>()
        stories.add(Room())
        stories.add(Room(R.drawable.sarvar, "Khalmatov Sarvar"))
        stories.add(Room(R.drawable.sarvar, "Isroilov Abbos"))
        stories.add(Room(R.drawable.sarvar, "Rahmatullayev Tohir"))
        stories.add(Room(R.drawable.sarvar, "Jo`rabekov Sherzod"))
        stories.add(Room(R.drawable.sarvar, "Khalmatov Sarvar"))
        stories.add(Room(R.drawable.sarvar, "Sheronov Azizjon"))
        stories.add(Room(R.drawable.sarvar, "Isroilov Abbos"))
        stories.add(Room(R.drawable.sarvar, "Rahmatullayev Tohir"))
        stories.add(Room(R.drawable.sarvar, "Jo`rabekov Sherzod"))
        stories.add(Room(R.drawable.sarvar, "Khalmatov Sarvar"))

        val chats = ArrayList<Chat>()
        // Room
        chats.add(Chat(stories))
        // Message
        chats.add(Chat(Message(R.drawable.sarvar,"Sarvar", false)))
        chats.add(Chat(Message(R.drawable.sarvar,"Aziz", false)))
        chats.add(Chat(Message(R.drawable.sarvar,"Abbos", true)))
        chats.add(Chat(Message(R.drawable.sarvar,"Sherzod", false)))
        chats.add(Chat(Message(R.drawable.sarvar,"Javohir", true)))
        chats.add(Chat(Message(R.drawable.sarvar,"Uchqun", true)))
        chats.add(Chat(Message(R.drawable.sarvar,"Abbos", false)))
        chats.add(Chat(Message(R.drawable.sarvar,"Tohir", false)))
        chats.add(Chat(Message(R.drawable.sarvar,"Javohir", true)))
        chats.add(Chat(Message(R.drawable.sarvar,"Behruz", true)))


        return chats
    }

    }


