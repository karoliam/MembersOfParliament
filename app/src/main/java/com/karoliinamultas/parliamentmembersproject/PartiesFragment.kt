package com.karoliinamultas.parliamentmembersproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.karoliinamultas.parliamentmembersproject.data.Politician
import com.karoliinamultas.parliamentmembersproject.databinding.FragmentPartiesBinding


class PartiesFragment : Fragment() {
    private lateinit var partyViewModel: PartyViewModel
    private lateinit var adapter: PartyRecyclerViewAdapter

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentPartiesBinding>(
            inflater,
            R.layout.fragment_parties, container, false
        )
        partyViewModel = ViewModelProvider(this).get(PartyViewModel::class.java)
        adapter = PartyRecyclerViewAdapter(requireContext(), partyViewModel.parties)
        binding.partyList.layoutManager = LinearLayoutManager(requireContext())



        partyViewModel.parties.observe(this) {
            adapter.submitList(it)
        }

        return binding.root

    }



    }

