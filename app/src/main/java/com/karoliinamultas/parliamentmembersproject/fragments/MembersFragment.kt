package com.karoliinamultas.parliamentmembersproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.karoliinamultas.parliamentmembersproject.adapters.MemberRecyclerViewAdapter
import com.karoliinamultas.parliamentmembersproject.viewModels.PoliticianViewModel
import com.karoliinamultas.parliamentmembersproject.databinding.FragmentMembersOfPartyBinding
import com.karoliinamultas.parliamentmembersproject.viewModels.MembersViewModel


class MembersOfPartyFragment : Fragment() {
    private lateinit var memberViewModel: MembersViewModel
    private lateinit var adapter: MemberRecyclerViewAdapter
    private lateinit var politicianViewModel: PoliticianViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentMembersOfPartyBinding>(
            inflater,
            R.layout.fragment_members_of_party, container, false
        )
        memberViewModel = ViewModelProvider(this).get(MembersViewModel::class.java)
        politicianViewModel = ViewModelProvider(this).get(PoliticianViewModel::class.java)

        val args = MembersOfPartyFragmentArgs.fromBundle(requireArguments())
        val partyName = args.partyName
        println(partyName)
        println("HELLO HERE")
        adapter = MemberRecyclerViewAdapter(requireContext(), memberViewModel.members)
        memberViewModel.members.observe(viewLifecycleOwner, Observer {
            (binding.membersList.adapter as MemberRecyclerViewAdapter).notifyDataSetChanged()
        })
        binding.membersList.layoutManager = LinearLayoutManager(activity)
        binding.membersList.adapter =
            activity?.let {
                MemberRecyclerViewAdapter(it,
                    memberViewModel.members)
            }


        return binding.root
    }

}