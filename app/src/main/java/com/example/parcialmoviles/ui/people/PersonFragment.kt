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



    companion object {
        const val TAG ="TAG"
    }
}