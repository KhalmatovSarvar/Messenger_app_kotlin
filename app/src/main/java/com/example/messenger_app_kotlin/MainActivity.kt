package com.example.messenger_app_kotlin

import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.messenger_app_kotlin.fragment.ChatsFragment
import com.example.messenger_app_kotlin.fragment.PeopleFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

        private lateinit var bottomNavigationView: BottomNavigationView

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            initViews()
        }

        private fun initViews(){
            bottomNavigationView = findViewById(R.id.bottom_navigation_view)
            bottomNavigationView.setOnClickListener {

            }

            replaceFragment(ChatsFragment())
            bottomNavigationView.setOnNavigationItemSelectedListener {
                when(it.itemId){
                    R.id.ic_chats -> replaceFragment(ChatsFragment())
                    R.id.ic_people -> replaceFragment(PeopleFragment())
                }
                true
            }
        }

        private fun replaceFragment(fragment: Fragment){
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.container, fragment)
                commit()
            }
        }


}