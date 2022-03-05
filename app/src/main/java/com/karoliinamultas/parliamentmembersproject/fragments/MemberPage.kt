package com.karoliinamultas.parliamentmembersproject.fragments

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.karoliinamultas.parliamentmembersproject.MembersOfPartyFragmentArgs
import com.karoliinamultas.parliamentmembersproject.R
import com.karoliinamultas.parliamentmembersproject.data.*
import com.karoliinamultas.parliamentmembersproject.databinding.FragmentMemberPageBinding
import com.karoliinamultas.parliamentmembersproject.viewModels.ImageViewModel
import com.karoliinamultas.parliamentmembersproject.viewModels.MemberPageViewModel
import com.karoliinamultas.parliamentmembersproject.viewModels.MembersViewModel
import kotlinx.coroutines.*
import kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy

class MemberPage : Fragment() {
    private lateinit var commentList: MutableList<String>
    private lateinit var memberPageViewModel: MemberPageViewModel
    private lateinit var imageViewModel: ImageViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentMemberPageBinding>(
            inflater,
            R.layout.fragment_member_page, container, false
        )
        //ViewModel
        memberPageViewModel = ViewModelProvider(this).get(MemberPageViewModel::class.java)
        imageViewModel = ViewModelProvider(this).get(ImageViewModel::class.java)

        //Safe args
        val args = MemberPageArgs.fromBundle(requireArguments())
        val memberName = args.memberName

        binding.nameText.text = memberName
        memberPageViewModel.members.observe(viewLifecycleOwner, Observer {
            binding.infoText.text = memberPageViewModel.extractInfo(it, memberName)


        })
        //User input

        binding.button.setOnClickListener{
            val userInput = binding.userInput.text.toString()
            binding.comment.text = userInput
            Toast.makeText(requireContext(), "Comment saved!", Toast.LENGTH_SHORT).show()
        }
        imageViewModel.pictureUrl.observe(viewLifecycleOwner, Observer {
            val pictureUrl = imageViewModel.extractPictureUrl(it, memberName)
            println(pictureUrl)
            Glide.with(this).load("https://avoindata.eduskunta.fi/${pictureUrl}").into(binding.imageView)

        })






        //Image

//
//        commentList = mutableListOf()
//        val userInput = binding.userInput.text.toString()
//
//
//


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
