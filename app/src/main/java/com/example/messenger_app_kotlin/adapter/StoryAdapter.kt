package com.example.messenger_app_kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.messenger_app_kotlin.R
import com.example.messenger_app_kotlin.model.Room
import com.example.messenger_app_kotlin.model.Stories
import com.google.android.material.imageview.ShapeableImageView

class StoryAdapter(var context: Context, var items: ArrayList<Stories>) :RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    val STORY_ITEM_TYPE_FIRST = 0
    val STORY_ITEM_TYPE = 1

    override fun getItemViewType(position: Int): Int {
        if(position == 0) return STORY_ITEM_TYPE_FIRST
        return STORY_ITEM_TYPE
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == STORY_ITEM_TYPE_FIRST){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_story_layout_first,parent,false)
            return FirstStoryViewHolder(view)
        }
          val view = LayoutInflater.from(parent.context).inflate(R.layout.item_story_layout,parent,false)
        return StoryItemViewHolder(view)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        var story = items[position]

        if(holder is StoryItemViewHolder){
            var tv_story = holder.tv_story
            var iv_profile_story = holder.iv_profile_story
            var iv_profile_story_online = holder.iv_profile_story_online

           tv_story.text = story.fullname
            iv_profile_story.setImageResource(story.profile)
            iv_profile_story_online.setImageResource(story.profile)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

}

class StoryItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var tv_story:TextView
    var iv_profile_story:ShapeableImageView
    var iv_profile_story_online:ShapeableImageView

    init {
        tv_story = view.findViewById(R.id.tv_fullname_story)
        iv_profile_story_online = view.findViewById(R.id.iv_profile_story_online)
        iv_profile_story = view.findViewById(R.id.iv_profile_stroy)
    }

}

class FirstStoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {}
