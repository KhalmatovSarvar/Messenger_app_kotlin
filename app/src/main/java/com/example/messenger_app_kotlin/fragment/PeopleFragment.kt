package com.example.messenger_app_kotlin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.messenger_app_kotlin.R
import com.example.messenger_app_kotlin.adapter.StoryAdapter
import com.example.messenger_app_kotlin.model.Chat
import com.example.messenger_app_kotlin.model.Stories

class PeopleFragment:Fragment() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_people,container,false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {

        recyclerView = view.findViewById(R.id.recycler_view_stories)
        recyclerView.layoutManager = GridLayoutManager(requireContext(),2)

        refreshStories(getStories())


    }

    private fun refreshStories(stories: ArrayList<Stories>) {
            val adapter = StoryAdapter(requireContext(),stories)
        recyclerView.adapter = adapter
    }

    private fun getStories(): ArrayList<Stories> {

        val stories:ArrayList<Stories> = ArrayList()


        for(i in 0..10){
            stories.add(Stories(R.drawable.sarvar,"Sarvar Khalmatov",R.drawable.earth,2))
        }
        return stories

    }
}