package com.example.parcialmoviles.ui.people.person.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.parcialmoviles.data.model.PeopleModel
import com.example.parcialmoviles.databinding.PersonItemBinding

class PeopleRecyclerViewHolder (private val binding: PersonItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind (people: PeopleModel, clickListener: (PeopleModel) -> Unit) {

        binding.nameTextView.text = people.name
        binding.lastnameTextView.text = people.lastname

        binding.personItemCardView.setOnClickListener {
            clickListener(people)
        }
    }

}