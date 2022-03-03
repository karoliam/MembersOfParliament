package com.karoliinamultas.parliamentmembersproject

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.karoliinamultas.parliamentmembersproject.data.Politician


class MemberRecyclerViewAdapter() : RecyclerView.Adapter<TextItemViewHolder>() {

    var data = listOf<Politician>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
            val names = data.map { it.first + " " + it.last }.toSet().sorted()
            val item = names[position]
            holder.textView.text = item

            holder.textView.setOnClickListener {
                val action =
                    MembersOfPartyFragmentDirections.actionMembersOfPartyFragmentToMemberPage()
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
