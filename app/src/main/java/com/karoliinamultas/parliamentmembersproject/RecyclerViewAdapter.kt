package com.karoliinamultas.parliamentmembersproject

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.karoliinamultas.parliamentmembersproject.ParliamentMembersData.members


class RecyclerViewAdapter() : RecyclerView.Adapter<TextItemViewHolder>() {

    var data = listOf<MemberOfParliament>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    val parties = members.map { it.party }.toSet().sorted()
    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
            val item = parties[position]
            holder.textView.text = item
            holder.textView.setOnClickListener {
                val action =
                    PartiesFragmentDirections.actionPartiesFragmentToMembersOfPartyFragment()
                it.findNavController().navigate(action)
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.text_item_view, parent, false) as TextView
        return TextItemViewHolder(view)
    }



}

//class PartyListListener(val clickListener: (sleepId: Long) -> Unit) {
//        fun onClick(parties: Parties) = clickListener(parties.id)
//}
