package com.example.parcialmoviles.ui.people.person.recyclerview


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialmoviles.data.model.PeopleModel
import com.example.parcialmoviles.databinding.PersonItemBinding


class PeopleRecyclerViewAdapter(
    private val clickListener: (PeopleModel) -> Unit
    ) : RecyclerView.Adapter<PeopleRecyclerViewHolder>(){
    private val peoples= ArrayList<PeopleModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleRecyclerViewHolder {
        val binding = PersonItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PeopleRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int{
        return peoples.size
    }
    override fun onBindViewHolder(holder: PeopleRecyclerViewHolder, position: Int){
        val people = peoples[position]
        holder.bind(people,clickListener)
    }

    fun setPeople(peopleList: List<PeopleModel>){
    peoples.clear()
    peoples.addAll(peopleList)
    }


}









