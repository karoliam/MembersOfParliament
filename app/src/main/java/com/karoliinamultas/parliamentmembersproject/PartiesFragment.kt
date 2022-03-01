package com.karoliinamultas.parliamentmembersproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.karoliinamultas.parliamentmembersproject.ParliamentMembersData.members
import com.karoliinamultas.parliamentmembersproject.data.PoliticianViewModel
import com.karoliinamultas.parliamentmembersproject.databinding.FragmentPartiesBinding
import com.karoliinamultas.parliamentmembersproject.databinding.FragmentStartScreenBinding

class PartiesFragment : Fragment() {
    private lateinit var mPoliticianViewModel: PoliticianViewModel

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentPartiesBinding>(
            inflater,
            R.layout.fragment_parties, container, false
        )
        mPoliticianViewModel = ViewModelProvider(this).get(PoliticianViewModel::class.java)
        val adapter = RecyclerViewAdapter()

        binding.partyList.adapter = adapter
        binding.partyList.layoutManager = LinearLayoutManager(requireContext())
        mPoliticianViewModel.politicians.observe(this) {
            adapter.data = it
        }

        binding.partyList.apply {
            adapter.data
        }


        return binding.root

    }



    }

