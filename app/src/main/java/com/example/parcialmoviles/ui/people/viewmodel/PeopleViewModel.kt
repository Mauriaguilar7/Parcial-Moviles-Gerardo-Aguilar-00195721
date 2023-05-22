package com.example.parcialmoviles.ui.people.viewmodel

import android.provider.Contacts
import android.text.Spannable.Factory
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.parcialmoviles.data.model.PeopleModel
import com.example.parcialmoviles.repositories.PeopleRepository

class PeopleViewModel (private val repository : PeopleRepository) : ViewModel() {

    var name = MutableLiveData("")
    var lastname = MutableLiveData("")
    var status = MutableLiveData("")

    fun  getPeople() = repository.getPeople()
    fun addPeople(people : PeopleModel) = repository.addPeople(people)


    fun setSelectedPeople(people : PeopleModel){
        name.value = people.name
        lastname.value = people.lastname
    }

    fun createPerson(){
        if (!validateData()){
            status.value = WRONG_INFORMATION
            return
        }
        val people = PeopleModel(
            name.value!!,
            lastname.value!!
        )

        addPeople(people)
        clearData()

        status.value = PERSON_CREATED
    }

    fun clearStatus(){
        status.value = INACTIVE
    }

    fun clearData(){
        name.value = ""
        lastname.value = ""
    }

    private fun validateData(): Boolean{
        when{
            name.value.isNullOrBlank() -> return false
            lastname.value.isNullOrBlank() -> return false
        }
        return true
    }

    companion object {
        val Factory = viewModelFactory {

        }

        const val PERSON_CREATED = "Person created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""

    }

}