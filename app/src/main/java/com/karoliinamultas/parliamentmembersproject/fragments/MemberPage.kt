package com.karoliinamultas.parliamentmembersproject.fragments

//date: 6.3.2022
//name: Karoliina Multas
//student id: 2101425
//MemberPage is an info page for one selected member. It's displaying the image(Glide library does image caching automatically),
//information about the politician, comment section where user can add comments (which are displayed underneath) and thumbs up and down buttons
//for grading the politician.

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
import com.karoliinamultas.parliamentmembersproject.MainActivity
import com.karoliinamultas.parliamentmembersproject.R
import com.karoliinamultas.parliamentmembersproject.databinding.FragmentMemberPageBinding
import com.karoliinamultas.parliamentmembersproject.viewModels.ImageViewModel
import com.karoliinamultas.parliamentmembersproject.viewModels.MemberPageViewModel

class MemberPage : Fragment() {
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
        (activity as MainActivity).actionBar?.title = "Members of Parliament"

        //ViewModels
        memberPageViewModel = ViewModelProvider(this).get(MemberPageViewModel::class.java)
        imageViewModel = ViewModelProvider(this).get(ImageViewModel::class.java)

        //Safe args
        val args = MemberPageArgs.fromBundle(requireArguments())
        val memberName = args.memberName
        binding.nameText.text = memberName

        //Members observing
        memberPageViewModel.members.observe(viewLifecycleOwner, Observer {
            binding.infoText.text = memberPageViewModel.extractInfo(it, memberName)
            val personNumber = memberPageViewModel.extractPersonNumber(it, memberName)
            memberPageViewModel.comments.observe(viewLifecycleOwner, Observer {
                binding.comment.text = memberPageViewModel.extractComment(it, personNumber)
            })

            //Save-button
            binding.button.setOnClickListener{
                memberPageViewModel.addComment(binding.userInput.text.toString(), personNumber)
                Toast.makeText(requireContext(), "Comment saved!", Toast.LENGTH_SHORT).show()
            }

            //Thumb up-button
            binding.thumbUpButton.setOnClickListener{
                memberPageViewModel.addThumbsUp(1,personNumber)
            }
            memberPageViewModel.thumbsUp.observe(viewLifecycleOwner, Observer {
                binding.upCountText.text = memberPageViewModel.extractThumbsUp(it,personNumber).sum().toString()
            })

            //Thumb down-button
            binding.thumbDownButton.setOnClickListener {
                memberPageViewModel.addThumbsDown(1,personNumber)
            }
            memberPageViewModel.thumbsDown.observe(viewLifecycleOwner, Observer {
                binding.downCountText.text = memberPageViewModel.extractThumbsDown(it, personNumber).sum().toString()
            })


        })

        //Image
        imageViewModel.pictureUrl.observe(viewLifecycleOwner, Observer {
            val pictureUrl = imageViewModel.extractPictureUrl(it, memberName)
            Glide.with(this).load("https://avoindata.eduskunta.fi/${pictureUrl}").into(binding.imageView)
        })

        return binding.root
    }
}
