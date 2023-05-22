package com.example.parcialmoviles.ui.people.newperson

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.parcialmoviles.R
import com.example.parcialmoviles.databinding.FragmentNewPersonBinding
import com.example.parcialmoviles.databinding.FragmentPersonBinding
import com.example.parcialmoviles.ui.people.viewmodel.PeopleViewModel


class newPersonFragment : Fragment() {

    private val peopleViewModel : PeopleViewModel by activityViewModels {
        PeopleViewModel.Factory
    }

private lateinit var binding: FragmentNewPersonBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewPersonBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        observeStatus()
    }

    private fun observeStatus(){
        peopleViewModel.status.observe(viewLifecycleOwner){status ->
            when {
                status.equals(PeopleViewModel.PERSON_CREATED) ->{
                    Log.d(TAG, status)
                    Log.d(TAG, peopleViewModel.getPeople().toString())
                    peopleViewModel.clearStatus()
                    findNavController().popBackStack()
                }

                status.equals(PeopleViewModel.WRONG_INFORMATION) ->{
                    Log.d(TAG, status)
                }
            }
        }
    }


    private fun setViewModel(){
        binding.viewmodel = peopleViewModel
    }

    companion object {
        const val TAG ="TAG"
    }
}