package com.karoliinamultas.parliamentmembersproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.karoliinamultas.parliamentmembersproject.adapters.PartyRecyclerViewAdapter
import com.karoliinamultas.parliamentmembersproject.R
import com.karoliinamultas.parliamentmembersproject.databinding.FragmentPartiesBinding
import com.karoliinamultas.parliamentmembersproject.viewModels.PartyViewModel


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
        //ViewModel
        partyViewModel = ViewModelProvider(this).get(PartyViewModel::class.java)

        adapter = PartyRecyclerViewAdapter(requireContext(), partyViewModel.parties)

        //Adding party names to recyclerview
        partyViewModel.parties.observe(viewLifecycleOwner, Observer {
            (binding.partyList.adapter as PartyRecyclerViewAdapter).notifyDataSetChanged()
        })
        binding.partyList.layoutManager = LinearLayoutManager(activity)
        binding.partyList.adapter =
            activity?.let {
                PartyRecyclerViewAdapter(it,
                partyViewModel.parties)
            }

        return binding.root

    }
    }

