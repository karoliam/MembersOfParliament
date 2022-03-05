package com.karoliinamultas.parliamentmembersproject.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.karoliinamultas.parliamentmembersproject.MembersOfPartyFragmentDirections
import com.karoliinamultas.parliamentmembersproject.R


class MemberRecyclerViewAdapter(private val context: Context, var members: List<String>) :
    ListAdapter<String, MemberViewHolder>(MemberDiffCallback()) {

    override fun getItemCount(): Int {
        return members.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.text_item_view, parent, false)
        return MemberViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MemberViewHolder, position: Int) {
        (holder.itemView as TextView).apply {
            text = members.get(position)
            setOnClickListener {
                val action = MembersOfPartyFragmentDirections.actionMembersOfPartyFragmentToMemberPage(holder.itemView.text.toString())
                it.findNavController().navigate(action)
            }

        }
    }

}

class MemberViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

class MemberDiffCallback : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
}