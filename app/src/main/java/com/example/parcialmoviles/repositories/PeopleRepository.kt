package com.example.parcialmoviles.repositories

import com.example.parcialmoviles.data.model.PeopleModel

class PeopleRepository (private val peoples : MutableList<PeopleModel>){

    fun getPeople() = peoples

    fun addPeople(people : PeopleModel) = peoples.add(people)
}