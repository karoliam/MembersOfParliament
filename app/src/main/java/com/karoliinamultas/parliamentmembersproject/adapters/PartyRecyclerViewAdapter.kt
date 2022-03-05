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
import com.karoliinamultas.parliamentmembersproject.R
import com.karoliinamultas.parliamentmembersproject.fragments.PartiesFragmentDirections


class PartyRecyclerViewAdapter(private val context: Context, var parties: LiveData<List<String>>) :
    ListAdapter<String, PartyViewHolder>(PartyDiffCallback()) {

    override fun getItemCount(): Int {
        return parties.value?.size ?: 0
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.text_item_view, parent, false)
        return PartyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: PartyViewHolder, position: Int) {
        (holder.itemView as TextView).apply {
        text = parties.value?.get(position) ?: "empty"
        setOnClickListener {
            val action = PartiesFragmentDirections.actionPartiesFragmentToMembersOfPartyFragment((holder.itemView.text.toString()))
            it.findNavController().navigate(action)
        }

        }
    }

}

class PartyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

class PartyDiffCallback : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
}