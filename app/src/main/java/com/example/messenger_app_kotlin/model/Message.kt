package com.example.messenger_app_kotlin.model

data class Message(var profile: Int, var fullname:String, var isOnline:Boolean = false) {
}