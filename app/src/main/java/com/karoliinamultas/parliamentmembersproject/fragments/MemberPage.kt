package com.karoliinamultas.parliamentmembersproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.karoliinamultas.parliamentmembersproject.R
import com.karoliinamultas.parliamentmembersproject.data.PoliticianDB
import com.karoliinamultas.parliamentmembersproject.databinding.FragmentMemberPageBinding
import com.karoliinamultas.parliamentmembersproject.viewModels.MemberPageViewModel
import com.karoliinamultas.parliamentmembersproject.viewModels.MembersViewModel
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MemberPage : Fragment() {
    private lateinit var membersViewModel: MembersViewModel
    private lateinit var commentList: MutableList<String>
    private lateinit var memberPageViewModel: MemberPageViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentMemberPageBinding>(
            inflater,
            R.layout.fragment_member_page, container, false
        )
        membersViewModel = ViewModelProvider(this).get(MembersViewModel::class.java)
        memberPageViewModel = ViewModelProvider(this).get(MemberPageViewModel::class.java)
        binding.nameText.text = "Fix this later"
        commentList = mutableListOf()
        val userInput = binding.userInput.text.toString()



        binding.thumbUpButton.setOnClickListener{
            memberPageViewModel.plus()
            binding.upCountText.text = memberPageViewModel.i.toString()
        }

                //kysy apua
//        fun addComment() {
//            GlobalScope.launch(
//                Dispatchers.IO,
//                CoroutineStart.DEFAULT
//            ) {
//                try {
//                    commentList.forEach {
//                        PoliticianDB.getDatabase(requireContext()).politicianDao()
//                            .addComment(it)
//                    }
//                }
//             catch (e: Exception) {
//                println("Failure: ${e.message}")
//            }
//
//        }
//
//    }
//        binding.button.setOnClickListener {
//            commentList.add(userInput)
//            addComment()
//            Toast.makeText(requireContext(), "Comment saved!", Toast.LENGTH_SHORT).show()
//        }
        return binding.root
    }

}
