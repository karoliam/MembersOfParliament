package com.karoliinamultas.parliamentmembersproject.fragments
//date: 6.3.2022
//name: Karoliina Multas
//student id: 2101425
//StartScreen is the first view of the application. It is displaying the title and a button which navigates to the PartyFragment.

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.karoliinamultas.parliamentmembersproject.R
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


        return binding.root
    }
}