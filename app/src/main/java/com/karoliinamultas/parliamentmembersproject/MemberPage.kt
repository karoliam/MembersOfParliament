package com.karoliinamultas.parliamentmembersproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.karoliinamultas.parliamentmembersproject.data.PoliticianViewModel
import com.karoliinamultas.parliamentmembersproject.databinding.FragmentMemberPageBinding

class MemberPage : Fragment() {
    private lateinit var mPoliticianViewModel: PoliticianViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentMemberPageBinding>(
            inflater,
            R.layout.fragment_member_page, container, false
        )
        mPoliticianViewModel = ViewModelProvider(this).get(PoliticianViewModel::class.java)

        val name = mPoliticianViewModel.politicians.value?.map { it.first }
        var i = 0
        if (name != null) {
            while(i < name.size)
                i++
        }
        binding.nameText.text = name?.get(i)

        return binding.root
    }
}