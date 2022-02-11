package com.example.messenger_app_kotlin.model


    class Stories {
        var story: Int = 0
        var fullname: String? = null
        var profile: Int = 0

        constructor(profile: Int, fullname: String, story: Int, count: Int){
            this.profile = profile
            this.fullname = fullname
            this.story = story
        }

        constructor(profile: Int, fullname: String){
            this.profile = profile
            this.fullname = fullname
        }

        constructor()
    }
