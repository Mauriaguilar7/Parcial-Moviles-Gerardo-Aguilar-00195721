package com.example.parcialmoviles.ui.people

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.parcialmoviles.R
import com.example.parcialmoviles.databinding.FragmentPersonBinding
import com.example.parcialmoviles.ui.people.viewmodel.PeopleViewModel


class PersonFragment : Fragment() {

    private val peopleViewModel : PeopleViewModel by activityViewModels {
        PeopleViewModel.Factory
    }

   private lateinit var binding : FragmentPersonBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPersonBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewmodel = peopleViewModel
        binding.lifecycleOwner = viewLifecycleOwner

    }

}