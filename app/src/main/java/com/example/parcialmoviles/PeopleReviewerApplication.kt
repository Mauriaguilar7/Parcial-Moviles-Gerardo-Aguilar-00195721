package com.example.parcialmoviles

import android.app.Application
import com.example.parcialmoviles.data.peoples
import com.example.parcialmoviles.repositories.PeopleRepository

class PeopleReviewerApplication : Application() {
    val peopleRepository : PeopleRepository by lazy {
        PeopleRepository(peoples)
    }
}