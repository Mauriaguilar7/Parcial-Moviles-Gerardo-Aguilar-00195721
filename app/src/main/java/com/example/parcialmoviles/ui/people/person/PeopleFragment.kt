package com.example.parcialmoviles.ui.people.person

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parcialmoviles.R
import com.example.parcialmoviles.data.model.PeopleModel
import com.example.parcialmoviles.databinding.FragmentPeopleBinding
import com.example.parcialmoviles.ui.people.person.recyclerview.PeopleRecyclerViewAdapter
import com.example.parcialmoviles.ui.people.viewmodel.PeopleViewModel


class PeopleFragment : Fragment() {

private val peopleViewModel :PeopleViewModel by activityViewModels {
    PeopleViewModel.Factory
}

    private lateinit var binding : FragmentPeopleBinding
    private lateinit var adapter : PeopleRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPeopleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        binding.addButton.setOnClickListener {
            peopleViewModel.clearData()
            it.findNavController().navigate(R.id.action_peopleFragment_to_newPersonFragment)
        }
    }

    private  fun setRecyclerView (view: View){
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = PeopleRecyclerViewAdapter{ selectedPeople ->
            showSelectedItem(selectedPeople)
        }

        binding.recyclerView.adapter = adapter
        displayPeoples()

    }


    private fun displayPeoples(){
        adapter.setPeople(peopleViewModel.getPeople())
        adapter.notifyDataSetChanged()
    }

    private fun showSelectedItem(people : PeopleModel){
        peopleViewModel.setSelectedPeople(people)
        findNavController().navigate(R.id.action_peopleFragment_to_personFragment)

    }


}