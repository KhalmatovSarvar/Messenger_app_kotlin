 package com.example.messenger_app_kotlin.model

 class Room {
     var profile: Int = 0
     var fullname: String? = null

     constructor(profile: Int, fullname: String){
         this.profile = profile
         this.fullname = fullname
     }

     constructor(){}
 }