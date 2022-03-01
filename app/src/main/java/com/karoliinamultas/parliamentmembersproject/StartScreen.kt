package com.karoliinamultas.parliamentmembersproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.karoliinamultas.parliamentmembersproject.databinding.FragmentStartScreenBinding

class StartScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentStartScreenBinding>(
            inflater,
            R.layout.fragment_start_screen, container, false
        )
        binding.partyButton.setOnClickListener{
            val action =
                StartScreenDirections.actionStartScreenToPartiesFragment()
            findNavController().navigate(action)
        }


        return binding.root
    }
}