package com.karoliinamultas.parliamentmembersproject

import android.app.Application
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
import com.karoliinamultas.parliamentmembersproject.data.Politician
import com.karoliinamultas.parliamentmembersproject.data.PoliticianRepository


class PartyRecyclerViewAdapter(private val context: Context, val parties: LiveData<List<String>>): ListAdapter<Politician, PartyViewHolder>(PartyDiffCallback()){

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartyViewHolder {
            val itemView = LayoutInflater.from(context).inflate(R.layout.text_item_view, parent, false)
            return PartyViewHolder(itemView)

        }


        override fun onBindViewHolder(holder: PartyViewHolder, position: Int) {

            holder.itemView.findViewById<TextView>(R.id.party_name).text = parties.value?.get(position)
            holder.itemView.setOnClickListener {
                    val action =
                        PartiesFragmentDirections.actionPartiesFragmentToMembersOfPartyFragment()
                            it.findNavController().navigate(action)
                }
        }

    override fun getItemCount(): Int {
        return parties.value?.size ?: 0
    }


}


class PartyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

class PartyDiffCallback: DiffUtil.ItemCallback<Politician>() {
    override fun areItemsTheSame(oldItem: Politician, newItem: Politician): Boolean {
        return oldItem.personNumber == newItem.personNumber
    }
    override fun areContentsTheSame(oldItem: Politician, newItem: Politician): Boolean {
        return oldItem.first == newItem.first && oldItem.last == newItem.last
    }
}