package com.example.parcialmoviles.ui.people.person

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.parcialmoviles.R
import com.example.parcialmoviles.databinding.FragmentPeopleBinding
import com.example.parcialmoviles.ui.people.viewmodel.PeopleViewModel


class PeopleFragment : Fragment() {

private val peopleViewModel :PeopleViewModel by activityViewModels {
    PeopleViewModel.Factory
}
    private lateinit var binding : FragmentPeopleBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPeopleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.actionButton.setOnClickListener {
            peopleViewModel.clearData()
            it.findNavController().navigate(R.id.action_peopleFragment_to_newPersonFragment)
        }
    }

    companion object {


    }
}