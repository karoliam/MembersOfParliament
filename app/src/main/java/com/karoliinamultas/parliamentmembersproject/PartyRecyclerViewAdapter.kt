package com.karoliinamultas.parliamentmembersproject

import android.app.Application
import android.content.Context
import android.util.Log
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
import com.karoliinamultas.parliamentmembersproject.data.PoliticianApi
import com.karoliinamultas.parliamentmembersproject.data.PoliticianDB
import com.karoliinamultas.parliamentmembersproject.data.PoliticianRepository
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.StringBuilder

//
//class PartyRecyclerViewAdapter() : RecyclerView.Adapter<TextItemViewHolder>() {
//
//    val viewModel = PartyViewModel(Application())
//    val parties = viewModel.parties
//
//
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
//        val layoutInflater = LayoutInflater.from(parent.context)
//        val view = layoutInflater
//            .inflate(R.layout.text_item_view, parent, false) as TextView
//        return TextItemViewHolder(view)
//    }
//
//
//    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
//        (holder.itemView as TextView).apply {
//            text = parties.value?.get(position) ?: "empty"
//            setOnClickListener {
//                val action =
//                    PartiesFragmentDirections.actionPartiesFragmentToMembersOfPartyFragment()
//                it.findNavController().navigate(action)
//            }
//        }
//    }
//    override fun getItemCount(): Int {
//        return parties.value?.size ?: 0
//    }
//}

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
            val action = PartiesFragmentDirections.actionPartiesFragmentToMembersOfPartyFragment()
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